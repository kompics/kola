/*
 * This file is part of the Kompics component model runtime.
 *
 * Copyright (C) 2009 Swedish Institute of Computer Science (SICS) 
 * Copyright (C) 2009 Royal Institute of Technology (KTH)
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package se.sics.kola.sourcegen;

import com.google.common.base.Optional;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JFieldRef;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JType;
import se.sics.kola.Logger;
import se.sics.kola.node.AChildDeclaration;
import se.sics.kola.node.AConnectStatement;
import se.sics.kola.node.AHandleDeclaration;
import se.sics.kola.node.AHandlerDeclaration;
import se.sics.kola.node.AProvidesPortFieldDeclaration;
import se.sics.kola.node.ARequiresPortFieldDeclaration;
import se.sics.kola.node.ASubscribeStatement;
import se.sics.kola.node.AUnsubscribeStatement;
import se.sics.kola.node.PBlock;
import se.sics.kola.sourcegen.ResolutionContext.FieldObject;
import static se.sics.kola.sourcegen.Util.nameToString;
import se.sics.kompics.Component;
import se.sics.kompics.Handler;
import se.sics.kompics.Init;
import se.sics.kompics.Negative;
import se.sics.kompics.Positive;

/**
 *
 * @author lkroll
 */
class ComponentBodyAdapter extends ClassBodyAdapter {

    private final JBlock initBlock;
    private final JClass handlerType;
    private final JClass posPortType;
    private final JClass negPortType;
    private final JClass componentType;
    private final JClass initType;

    ComponentBodyAdapter(ResolutionContext context, JDefinedClass clazz) {
        super(context, clazz);
        initBlock = clazz.instanceInit();
        handlerType = (JClass) context.unit._ref(Handler.class);
        posPortType = (JClass) context.unit._ref(Positive.class);
        negPortType = (JClass) context.unit._ref(Negative.class);
        componentType = (JClass) context.unit._ref(Component.class);
        initType = (JClass) context.unit._ref(Init.class);
    }

    @Override
    public void caseAHandleDeclaration(AHandleDeclaration node) {
        String handlerId = node.getHandlerId().getText();
        String portId = node.getPortId().getText();
        String eventId = node.getEventId().getText();
        TypeAdapter ta = new TypeAdapter(context);
        node.getClassType().apply(ta);
        JFieldRef handlerField = createHandler(handlerId, ta.type, eventId, node.getBlock());
        JInvocation sub = initBlock.invoke("subscribe");
        sub.arg(handlerField);
        sub.arg(JExpr.ref(portId));
    }

    @Override
    public void caseAHandlerDeclaration(AHandlerDeclaration node) {
        String handlerId = node.getHandlerId().getText();
        String eventId = node.getEventId().getText();
        TypeAdapter ta = new TypeAdapter(context);
        node.getClassType().apply(ta);
        JFieldRef handlerField = createHandler(handlerId, ta.type, eventId, node.getBlock());
    }

    @Override
    public void caseASubscribeStatement(ASubscribeStatement node) {
        JInvocation sub = initBlock.invoke("subscribe");
        sub.arg(JExpr.ref(nameToString(node.getHandlerId())));
        sub.arg(JExpr.ref(nameToString(node.getPortId())));
    }

    @Override
    public void caseAUnsubscribeStatement(AUnsubscribeStatement node) {
        JInvocation sub = initBlock.invoke("unsubscribe");
        sub.arg(JExpr.ref(nameToString(node.getHandlerId())));
        sub.arg(JExpr.ref(nameToString(node.getPortId())));
    }

    @Override
    public void caseARequiresPortFieldDeclaration(ARequiresPortFieldDeclaration node) {
        String portId = node.getIdentifier().getText();
        TypeAdapter ta = new TypeAdapter(context);
        node.getClassType().apply(ta);
        JClass specificType = posPortType.narrow(ta.type);
        JInvocation inv = JExpr.invoke("requires");
        inv.arg(JExpr.dotclass((JClass) ta.type));
        JFieldVar portField = clazz.field(JMod.PROTECTED | JMod.FINAL, specificType, portId, inv);
        context.addField(portId, portField, ResolutionContext.FieldType.POSITIVE_PORT);
    }

    @Override
    public void caseAProvidesPortFieldDeclaration(AProvidesPortFieldDeclaration node) {
        String portId = node.getIdentifier().getText();
        TypeAdapter ta = new TypeAdapter(context);
        node.getClassType().apply(ta);
        JClass specificType = negPortType.narrow(ta.type);
        JInvocation inv = JExpr.invoke("provides");
        inv.arg(JExpr.dotclass((JClass) ta.type));
        JFieldVar portField = clazz.field(JMod.PROTECTED | JMod.FINAL, specificType, portId, inv);
        context.addField(portId, portField, ResolutionContext.FieldType.NEGATIVE_PORT);
    }

    @Override
    public void caseAChildDeclaration(AChildDeclaration node) {
        TypeAdapter ta = new TypeAdapter(context);
        node.getClassType().apply(ta);
        String childId = node.getIdentifier().getText();
        JFieldVar field;
        if (node.getComponentInitialization() != null) {
            JInvocation inv = JExpr.invoke("create");
            inv.arg(JExpr.dotclass((JClass) ta.type));
            inv.arg(initType.staticRef("NONE"));
//            if ()
//            ArgumentAdapter aa = new ArgumentAdapter(new InvocationArgumentable(inv), context);
//            node.getComponentInitialization().apply(aa);
            field = clazz.field(JMod.PROTECTED | JMod.FINAL, componentType, childId, inv);
        } else {
            field = clazz.field(JMod.PROTECTED, componentType, childId);
        }
        context.addField(childId, field, ResolutionContext.FieldType.COMPONENT);
    }

    @Override
    public void caseAConnectStatement(AConnectStatement node) {
        TypeAdapter ta = new TypeAdapter(context);
        node.getClassType().apply(ta);
        // Provider
        String providerS = nameToString(node.getProvidedId());
        Optional<FieldObject> providerFOO = context.findField(providerS);
        JExpression provider;
        if (providerFOO.isPresent()) {
            FieldObject providerFO = providerFOO.get();
            switch (providerFO.type) {
                case POSITIVE_PORT:
                    provider = JExpr.ref(JExpr._this(), providerFO.var);
                    break;
                case NEGATIVE_PORT:
                    provider = JExpr.ref(JExpr._this(), providerFO.var).invoke("getPair");
                    break;
                case HANDLER:
                    Logger.error(node.getProvidedId(), "Handler reference not allowed here!");
                    return;
                default:
                    JInvocation providerPort = providerFO.var.invoke("getPositive");
                    providerPort.arg(JExpr.dotclass((JClass) ta.type));
                    provider = providerPort;
            }
        } else {
            JExpression providerC = JExpr.direct(providerS);
            JInvocation providerPort = providerC.invoke("getPositive");
            providerPort.arg(JExpr.dotclass((JClass) ta.type));
            provider = providerPort;
        }
        // Client
        String clientS = nameToString(node.getRequiredId());
        Optional<FieldObject> clientFOO = context.findField(clientS);
        JExpression client;
        if (clientFOO.isPresent()) {
            FieldObject clientFO = clientFOO.get();
            switch (clientFO.type) {
                case POSITIVE_PORT:
                    client = JExpr.ref(JExpr._this(), clientFO.var).invoke("getPair");
                    break;
                case NEGATIVE_PORT:
                    client = JExpr.ref(JExpr._this(), clientFO.var);
                    break;
                case HANDLER:
                    Logger.error(node.getRequiredId(), "Handler reference not allowed here!");
                    return;
                default:
                    JInvocation clientPort = clientFO.var.invoke("getNegative");
                    clientPort.arg(JExpr.dotclass((JClass) ta.type));
                    client = clientPort;
            }
        } else {
            JExpression clientC = JExpr.direct(clientS);
            JInvocation clientPort = clientC.invoke("getNegative");
            clientPort.arg(JExpr.dotclass((JClass) ta.type));
            client = clientPort;
        }

        JInvocation inv = initBlock.invoke("connect");
        inv.arg(provider);
        inv.arg(client);
    }

    private JFieldRef createHandler(String handlerId, JType eventType, String eventId, PBlock block) {
        JMethod handlerMethod = clazz.method(JMod.PRIVATE | JMod.FINAL, context.unit.VOID, handlerId + "Method");
        handlerMethod.param(eventType, eventId);
        BlockStatementAdapter bsa = new BlockStatementAdapter(context, handlerMethod.body());
        block.apply(bsa);
        JClass specificHType = handlerType.narrow(eventType);
        JDefinedClass anonHandler = context.unit.anonymousClass(specificHType);
        JMethod anonMethod = anonHandler.method(JMod.PUBLIC, context.unit.VOID, "handle");
        anonMethod.param(eventType, eventId);
        JInvocation handlerMethodInv = anonMethod.body().invoke(handlerMethod);
        handlerMethodInv.arg(JExpr.ref(eventId));
        JFieldVar handlerField = clazz.field(JMod.PROTECTED | JMod.FINAL, specificHType, handlerId, JExpr._new(anonHandler));
        context.addField(handlerId, handlerField, ResolutionContext.FieldType.HANDLER);
        return JExpr.ref(handlerId);
    }
}