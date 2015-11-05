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

import com.sun.codemodel.JClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JField;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JVar;
import se.sics.kola.Logger;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AConnectStatement;
import se.sics.kola.node.ADisconnectStatement;
import se.sics.kola.node.AName;
import se.sics.kola.node.ANameExpression;
import se.sics.kola.node.ASubscribeStatement;
import se.sics.kola.node.AUnsubscribeStatement;
import se.sics.kola.node.PExpression;
import se.sics.kola.sourcegen.ExpressionAdapter.JExprParent;
import se.sics.kola.sourcegen.ResolutionContext.AmbiguousExpressionMapper;
import se.sics.kola.sourcegen.StatementAdapter.StatementParent;

/**
 *
 * @author lkroll
 */
class KolaStatementAdapter extends DepthFirstAdapter {

    private final ResolutionContext context;
    private final StatementParent parent;

    KolaStatementAdapter(ResolutionContext context, StatementParent parent) {
        this.context = context;
        this.parent = parent;
    }

    @Override
    public void caseAConnectStatement(AConnectStatement node) {
        TypeAdapter ta = new TypeAdapter(context);
        node.getClassType().apply(ta);
        // Provider
        JExpression provider = portExpression(node.getProvidedId(), true, (JClass) ta.type);
        // Client
        JExpression client = portExpression(node.getRequiredId(), false, (JClass) ta.type);

        JInvocation inv = parent.invoke("connect");
        inv.arg(provider);
        inv.arg(client);
    }

    @Override
    public void caseADisconnectStatement(ADisconnectStatement node) {
        TypeAdapter ta = new TypeAdapter(context);
        node.getClassType().apply(ta);
        // Provider
        JExpression provider = portExpression(node.getProvidedId(), true, (JClass) ta.type);
        // Client
        JExpression client = portExpression(node.getRequiredId(), false, (JClass) ta.type);

        JInvocation inv = parent.invoke("disconnect");
        inv.arg(provider);
        inv.arg(client);
    }

    private JExpression portExpression(final PExpression expr, final boolean positivePort, final JClass type) {
        if (expr instanceof ANameExpression) {
            ANameExpression portNameExpr = (ANameExpression) expr;
            final AName portName = (AName) portNameExpr.getName();
            return context.resolveAmbiguous(portName, new AmbiguousExpressionMapper() {

                @Override
                public JExpression map(JField f) {
                    JInvocation portInvoc;
                    if (positivePort) {
                        Logger.warn(context.getFile(), portName, "Could not identify type of the port. Assuming positive.");
                        portInvoc = f.invoke("getPositive");
                    } else {
                        Logger.warn(context.getFile(), portName, "Could not identify type of the port. Assuming negative.");
                        portInvoc = f.invoke("getNegative");
                    }
                    return portInvoc.arg(JExpr.dotclass(type));
                }

                @Override
                public JExpression map(Field providerF) {
                    switch (providerF.type) {
                        case POSITIVE_PORT:
                            if (positivePort) {
                                return JExpr.ref(JExpr._this(), (JVar) providerF.var);
                            } else {
                                return JExpr.ref(JExpr._this(), (JVar) providerF.var).invoke("getPair");
                            }
                        case NEGATIVE_PORT:
                            if (positivePort) {
                                return JExpr.ref(JExpr._this(), (JVar) providerF.var).invoke("getPair");
                            } else {
                                return JExpr.ref(JExpr._this(), (JVar) providerF.var);
                            }
                        case HANDLER:
                            Logger.error(context.getFile(), portName, "Handler reference not allowed here!");
                            return null;
                        default:
                            JInvocation portInvoc;
                            if (positivePort) {
                                Logger.warn(context.getFile(), portName, "Couldn't identify type of the port. Assuming positive.");
                                portInvoc = providerF.var.invoke("getPositive");
                            } else {
                                Logger.warn(context.getFile(), portName, "Couldn't identify type of the port. Assuming negative.");
                                portInvoc = providerF.var.invoke("getNegative");
                            }
                            return portInvoc.arg(JExpr.dotclass(type));
                    }
                }

                @Override
                public JExpression map(JClass jc) {
                    Logger.warn(context.getFile(), portName, "Found class type instead of field for the port. Assuming static methods requested.");
                    JInvocation portInvoc;
                    if (positivePort) {
                        portInvoc = jc.staticInvoke("getPositive");
                    } else {
                        portInvoc = jc.staticInvoke("getNegative");
                    }
                    return portInvoc.arg(JExpr.dotclass(type));
                }
            });
//            } else {
//
//                JExpression portC = JExpr.direct(nameToString(portName));
//                JInvocation portInvoc;
//                if (positivePort) {
//                    portInvoc = portC.invoke("getPositive");
//                } else {
//                    portInvoc = portC.invoke("getNegative");
//                }
//                return portInvoc.arg(JExpr.dotclass(type));
//            }
        } else {
            ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
            expr.apply(ea);
            JInvocation portInvoc;
            if (positivePort) {
                portInvoc = ea.expr.invoke("getPositive");
            } else {
                portInvoc = ea.expr.invoke("getNegative");
            }
            return portInvoc.arg(JExpr.dotclass(type));
        }
    }

    @Override
    public void caseASubscribeStatement(ASubscribeStatement node) {
        JInvocation sub = parent.invoke("subscribe");
        ExpressionAdapter handlerEA, portEA;
        handlerEA = new ExpressionAdapter(parent, context);
        node.getHandlerId().apply(handlerEA);
        portEA = new ExpressionAdapter(parent, context);
        node.getPortId().apply(portEA);
        sub.arg(handlerEA.expr);
        sub.arg(portEA.expr);
    }

    @Override
    public void caseAUnsubscribeStatement(AUnsubscribeStatement node) {
        JInvocation sub = parent.invoke("unsubscribe");
        ExpressionAdapter handlerEA, portEA;
        handlerEA = new ExpressionAdapter(parent, context);
        node.getHandlerId().apply(handlerEA);
        portEA = new ExpressionAdapter(parent, context);
        node.getPortId().apply(portEA);
        sub.arg(handlerEA.expr);
        sub.arg(portEA.expr);
    }
}
