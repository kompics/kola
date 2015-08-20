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

import com.sun.codemodel.JAssignmentTarget;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JExpressionStatement;
import com.sun.codemodel.JForLoop;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JType;
import com.sun.codemodel.JVar;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.ALocalForInit;
import se.sics.kola.node.ALocalVariableDeclaration;
import se.sics.kola.node.AStatementForInit;
import se.sics.kola.node.PExpressionNoName;
import se.sics.kola.node.PModifier;
import se.sics.kola.node.PVariableDeclarator;
import se.sics.kola.sourcegen.ExpressionAdapter.ExpressionParent;

/**
 *
 * @author lkroll
 */
class ForInitAdapter extends DepthFirstAdapter {
    private final ResolutionContext context;
    private final JForLoop loop;
    
    ForInitAdapter(JForLoop loop, ResolutionContext context) {
        this.context = context;
        this.loop = loop;
    }
    
    @Override
    public void caseAStatementForInit(AStatementForInit node) {
        for (PExpressionNoName expr : node.getExpressionNoName()) {
            ExpressionAdapter ea = new ExpressionAdapter(new ForInitParent(), context);
            expr.apply(ea);
        }
    }
    
    @Override
    public void caseALocalForInit(ALocalForInit node) {
        ALocalVariableDeclaration decl = (ALocalVariableDeclaration) node.getLocalVariableDeclaration();
        final FieldModifierAdapter fma = new FieldModifierAdapter();
        for (PModifier mod : decl.getModifier()) {
            mod.apply(fma);
        }
        final TypeAdapter ta = new TypeAdapter(context);
        decl.getType().apply(ta);
        VarDeclAdapter vda = new VarDeclAdapter(ta.type, context, new VarDeclAdapter.Scope() {

            @Override
            public JVar declare(JType type, String name, JExpression init) {
                return loop.init(fma.getMods(), type, name, init);
            }

        });
        for (PVariableDeclarator declor : decl.getVariableDeclarator()) {
            declor.apply(vda);
        }
    }
    
    class ForInitParent implements ExpressionParent {

        @Override
        public JInvocation invoke(JExpression lhs, String method) {
            JInvocation inv = JExpr.invoke(lhs, method);
            loop.init(inv);
            return inv;
        }

        @Override
        public JInvocation invoke(String method) {
             JInvocation inv = JExpr.invoke(method);
            loop.init(inv);
            return inv;
        }

        @Override
        public void addInvocation(JInvocation inv) {
            loop.init(inv);
        }

        @Override
        public void addStatement(JExpressionStatement stmt) {
            loop.init(stmt);
        }

        @Override
        public JExpressionStatement assign(JAssignmentTarget lhs, JExpression rhs) {
            JExpressionStatement expr = JExpr.assign(lhs, rhs);
            loop.init(expr);
            return expr;
        }
        
    }
}
