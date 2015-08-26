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

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldRef;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JType;
import se.sics.kola.node.AHandleDeclaration;
import se.sics.kola.node.PBlock;
import se.sics.kompics.Handler;

/**
 *
 * @author lkroll
 */
class ComponentBodyAdapter extends ClassBodyAdapter {

    private final JBlock initBlock;
    private final JClass handlerType;
    
    ComponentBodyAdapter(ResolutionContext context, JDefinedClass clazz) {
        super(context, clazz);
        initBlock = clazz.instanceInit();
        handlerType = (JClass) context.unit._ref(Handler.class);
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
    
    private JFieldRef createHandler(String handlerId, JType eventType, String eventId, PBlock block) {
        JMethod handlerMethod = clazz.method(JMod.PRIVATE | JMod.FINAL, context.unit.VOID, handlerId+"Method");
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
        return JExpr.ref(handlerId);
    }
}
