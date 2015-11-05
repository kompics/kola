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
import com.sun.codemodel.ClassType;
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
import com.sun.codemodel.JVar;
import java.util.LinkedList;
import java.util.List;
import se.sics.kola.Logger;
import se.sics.kola.node.AChildDeclaration;
import se.sics.kola.node.AHandleDeclaration;
import se.sics.kola.node.AHandlerDeclaration;
import se.sics.kola.node.AHandlingComponentBodyDeclaration;
import se.sics.kola.node.AInitDeclaration;
import se.sics.kola.node.AProvidesPortFieldDeclaration;
import se.sics.kola.node.ARequiresPortFieldDeclaration;
import se.sics.kola.node.PBlock;
import se.sics.kola.node.PModifier;
import se.sics.kola.node.TIdentifier;
import se.sics.kola.sourcegen.ArgumentAdapter.Argumentable;
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
    public void caseARequiresPortFieldDeclaration(ARequiresPortFieldDeclaration node) {
        String portId = node.getIdentifier().getText();
        TypeAdapter ta = new TypeAdapter(context);
        node.getClassType().apply(ta);
        JClass specificType = posPortType.narrow(ta.type);
        JInvocation inv = JExpr.invoke("requires");
        inv.arg(JExpr.dotclass((JClass) ta.type));
        JFieldVar portField = clazz.field(JMod.PROTECTED | JMod.FINAL, specificType, portId, inv);
        context.addField(portId, portField, Field.Type.POSITIVE_PORT);
    }

    @Override
    public void caseAProvidesPortFieldDeclaration(AProvidesPortFieldDeclaration node) {
        String portId = node.getIdentifier().getText();
        TypeAdapter ta = new TypeAdapter(context);
        node.getClassType().apply(ta);
        if (ta.type == null) {
            Logger.error(context.getFile(), node.getIdentifier(), "Couldn't resolve type for port!");
        }
        JClass specificType = negPortType.narrow(ta.type);
        JInvocation inv = JExpr.invoke("provides");
        inv.arg(JExpr.dotclass((JClass) ta.type));
        JFieldVar portField = clazz.field(JMod.PROTECTED | JMod.FINAL, specificType, portId, inv);
        context.addField(portId, portField, Field.Type.NEGATIVE_PORT);
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
            ArgumentCollector ac = new ArgumentCollector();
            ArgumentAdapter aa = new ArgumentAdapter(ac, context);
            node.getComponentInitialization().apply(aa);
            if (ac.args.isEmpty()) {
                inv.arg(initType.staticRef("NONE"));
            } else if (ac.args.size() == 1) { // assume it's an Init
                inv.arg(ac.args.get(0));
            } else {
                // autowire
                JClass initT = ((JClass) ta.type).inner("AutowireInit" + ac.args.size());
                JInvocation initInv = JExpr._new(initT);
                for (JExpression arg : ac.args) {
                    initInv.arg(arg);
                }
                inv.arg(initInv);
            }
            field = clazz.field(JMod.PROTECTED | JMod.FINAL, componentType, childId, inv);
        } else {
            field = clazz.field(JMod.PROTECTED, componentType, childId);
        }
        context.addField(childId, field, Field.Type.COMPONENT);
    }

    @Override
    public void inAHandlingComponentBodyDeclaration(AHandlingComponentBodyDeclaration node) {
        KolaStatementAdapter ksa = new KolaStatementAdapter(context, new JBlockParent(initBlock, context));
        node.apply(ksa);
    }

    @Override
    public void caseAHandleDeclaration(AHandleDeclaration node) {
        String handlerId = node.getHandlerId().getText();
        String portId = node.getPortId().getText();
        String eventId = node.getEventId().getText();
        TypeAdapter ta = new TypeAdapter(context);
        node.getClassType().apply(ta);
        JFieldRef handlerField = createHandler(node.getHandlerId(), ta.type, eventId, node.getBlock());
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
        JFieldRef handlerField = createHandler(node.getHandlerId(), ta.type, eventId, node.getBlock());
    }

    @Override
    public void caseAInitDeclaration(AInitDeclaration node) {
        MethodModifierAdapter modap = new MethodModifierAdapter(context);
        for (PModifier m : node.getModifier()) {
            m.apply(modap);
        }
        int mods = modap.getMods();

        JMethod method = context.constructor(mods);
        TypeDeclarationAdapter.FormalParameterAdapter fpa;
        boolean generateAutowire = false;
        try {
            ConstructorDeclaratorAdapter da = new ConstructorDeclaratorAdapter(method);
            fpa = new TypeDeclarationAdapter.FormalParameterAdapter(context);
            node.getHeaderFields().apply(fpa);

            for (TypeDeclarationAdapter.FormalParameter fp : fpa.params) {
                fp.apply(method, context);
            }

            generateAutowire = !fpa.params.isEmpty();

            for (PModifier m : node.getModifier()) {
                AnnotationAdapter annap = new AnnotationAdapter(new MethodAnnotatable(method), context);
                m.apply(annap);
            }
            context.pushStatementScope();
            try {
//                if (generateAutowire) {
//                    for (TypeDeclarationAdapter.FormalParameter fp : fpa.params) {
//                        fp.apply(method);
//                        method.body().assign(JExpr.refthis(fp.id), JExpr.ref(fp.id));
//                    }
//                }
                ConstructorBodyAdapter cba = new ConstructorBodyAdapter(context, method.body());
                node.getConstructorBody().apply(cba);
            } finally {
                context.popScope();
            }
        } finally {
            context.popScope();
        }

        if (generateAutowire) {
//            // Add fields to the class
//            for (TypeDeclarationAdapter.FormalParameter fp : fpa.params) {
//                int fmods = fp.mods == 0 ? (JMod.PUBLIC | JMod.FINAL) : fp.mods;
//                JVar field = clazz.field(fmods, fp.typeWithDim(), fp.id);
//                context.addField(fp.id, field, Field.Type.NORMAL);
//            }
            // Add the AutowireInit class
            JDefinedClass autowireInit = context.declare(JMod.STATIC | JMod.PUBLIC, fpa.params.get(0).identifier, ClassType.CLASS, Optional.of("AutowireInit" + fpa.params.size()));
            try {
                JClass specificInitType = initType.narrow(clazz);
                autowireInit._extends(specificInitType);
                JMethod initConstr = context.constructor(JMod.PUBLIC);
                try {
                    context.pushStatementScope();
                    try {
                        JBlock constrBody = initConstr.body();
                        for (TypeDeclarationAdapter.FormalParameter fp : fpa.params) {
                            int fmods = fp.mods == 0 ? JMod.FINAL : fp.mods;
                            constrBody.assign(JExpr.refthis(fp.id), JExpr.ref(fp.id));
                            fp.apply(initConstr, context);
                        }
                    } finally {
                        context.popScope();
                    }
                } finally {
                    context.popScope(); // initConstr;
                }

                if (fpa.params.size() == 1) {
                    Logger.error("Lacking type information for single value autowire Init at the moment. \n"
                            + "AutowireInit1 will be generated but it has to be called manually when creating the component.\n"
                            + "This will be fixed in a future release.");
                }
                for (TypeDeclarationAdapter.FormalParameter fp : fpa.params) {
                    int fmods = fp.mods == 0 ? (JMod.PUBLIC | JMod.FINAL) : fp.mods;
                    JFieldVar v = autowireInit.field(fmods, fp.typeWithDim(), fp.id);

                }
            } finally {
                context.popScope();
            }

            JMethod autowireConstr = context.constructor(JMod.PUBLIC);
            try {
                JVar acparam = autowireConstr.param(JMod.FINAL, autowireInit, "autowireInit");
                context.addField("autowireInit", acparam, Field.Type.NORMAL);
                JInvocation autowireInv = autowireConstr.body().invoke("this");
                for (TypeDeclarationAdapter.FormalParameter fp : fpa.params) {
                    autowireInv.arg(JExpr.ref("autowireInit").ref(fp.id));
                }
            } finally {
                context.popScope();
            }
        }
    }

    private JFieldRef createHandler(TIdentifier handlerIdentifier, JType eventType, String eventId, PBlock block) {
        String handlerId = handlerIdentifier.getText();
        JMethod handlerMethod = context.method(JMod.PRIVATE | JMod.FINAL, handlerIdentifier, context.unit.VOID, Optional.of(handlerId + "Method"));
        try {
            JVar eVar = handlerMethod.param(eventType, eventId);
            context.addField(eventId, eVar, Field.Type.NORMAL);
            context.pushStatementScope();
            try {
                BlockStatementAdapter bsa = new BlockStatementAdapter(context, handlerMethod.body());
                block.apply(bsa);
            } finally {
                context.popScope();
            }
        } finally {
            context.popScope();
        }
        JClass specificHType = handlerType.narrow(eventType);
        JDefinedClass anonHandler = context.anonymousClass(specificHType);
        try {
            JMethod anonMethod = context.method(JMod.PUBLIC, handlerIdentifier, context.unit.VOID, Optional.of("handle"));
            try {
                JVar amp = anonMethod.param(eventType, eventId);
                context.addField(eventId, amp, Field.Type.NORMAL);
                JInvocation handlerMethodInv = anonMethod.body().invoke(handlerMethod);
                handlerMethodInv.arg(JExpr.ref(eventId));
            } finally {
                context.popScope();
            }
        } finally {
            context.popScope();
        }
        JFieldVar handlerField = clazz.field(JMod.PROTECTED | JMod.FINAL, specificHType, handlerId, JExpr._new(anonHandler));
        context.addField(handlerId, handlerField, Field.Type.HANDLER);
        return JExpr.ref(handlerId);
    }

    static class ArgumentCollector implements Argumentable {

        private final List<JExpression> args = new LinkedList<>();

        @Override
        public Argumentable arg(JExpression expr) {
            args.add(expr);
            return this;
        }

    }
}
