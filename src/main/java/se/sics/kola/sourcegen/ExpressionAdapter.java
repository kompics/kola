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
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JType;
import java.util.LinkedList;
import se.sics.kola.Logger;
import static se.sics.kola.sourcegen.Util.nameToString;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AArrayInitializer;
import se.sics.kola.node.AClassInitializerArrayCreationExpression;
import se.sics.kola.node.ADiamondTypeArgumentsOrDiamond;
import se.sics.kola.node.ALiteralExpressionNoName;
import se.sics.kola.node.AMethodMethodInvocation;
import se.sics.kola.node.AName;
import se.sics.kola.node.ANewClassInstanceCreationExpression;
import se.sics.kola.node.APrimaryMethodInvocation;
import se.sics.kola.node.ATypeArgumentsTypeArgumentsOrDiamond;
import se.sics.kola.node.ATypeDeclSpecifier;
import se.sics.kola.node.PArgument;
import se.sics.kola.node.PVariableInitializer;

/**
 *
 * @author lkroll
 */
public class ExpressionAdapter extends DepthFirstAdapter {

    private final ExpressionParent parent;
    private final ResolutionContext context;
    JExpression expr;

    ExpressionAdapter(ExpressionParent parent, ResolutionContext context) {
        this.parent = parent;
        this.context = context;
    }

    @Override
    public void caseAMethodMethodInvocation(AMethodMethodInvocation node) {
        String name = nameToString(node.getName());
        JInvocation inv = context.resolveInvocation((AName) node.getName(), parent);
        expr = inv;
        for (PArgument arg : node.getArgument()) {
            ArgumentAdapter aa = new ArgumentAdapter(inv, context);
            arg.apply(aa);
        }
    }

    @Override
    public void caseAPrimaryMethodInvocation(APrimaryMethodInvocation node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getExpressionNoName().apply(ea);
        JExpression lhs = ea.expr;
        JInvocation inv = parent.invoke(lhs, node.getIdentifier().getText());
        if (node.getNonWildTypeArguments().size() != 0) {
            Logger.error(node.getIdentifier(), "CodeModel does not support type arguments for methods, yet. Ignoring...");
        }
        for (PArgument arg : node.getArgument()) {
            ArgumentAdapter aa = new ArgumentAdapter(inv, context);
            arg.apply(aa);
        }
        expr = inv;
    }

    @Override
    public void caseANewClassInstanceCreationExpression(ANewClassInstanceCreationExpression node) {
        // ****** BEGIN SPEC *******
        ATypeDeclSpecifier spec = (ATypeDeclSpecifier) node.getTypeDeclSpecifier();
        AName firstName = (AName) spec.getName();
        JClass ctype;
        try {
            ctype = context.resolve(nameToString(firstName));
        } catch (ClassNotFoundException ex) {
            Logger.error(firstName.getIdentifier().getLast(), "Could not resolve type!");
            return;
        }
        LinkedList<Util.IdWithOptArgs> list = Util.shiftTDS(spec, context);
        Util.IdWithOptArgs cur = list.pollFirst();
        while ((cur != null) && (cur.args == null)) {
            cur = list.pollFirst();
        }
        if (cur != null) {
            TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context, ctype);
            cur.args.apply(tpa);
        }
        for (Util.IdWithOptArgs iwoa : list) {
            String cname = ctype.fullName() + "." + iwoa.id.getText(); // losing the generics again here...I don't see any way around this
            try {
                ctype = context.resolve(cname);
            } catch (ClassNotFoundException ex) {
                Logger.error("Couldn't resolve type: " + cname);
            }
            if (iwoa.args != null) {
                TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context, ctype);
                iwoa.args.apply(tpa);
            }
        }
        // ****** END SPEC *******
        if (node.getTypeArgumentsOrDiamond() != null) {
            TypeDiamondAdapter tda = new TypeDiamondAdapter(ctype);
            node.getTypeArgumentsOrDiamond().apply(tda);
            ctype = tda.ctype;
        }
        // ***** ANON *****
        if (node.getClassBody() != null) {
            JDefinedClass jdclass = context.unit.anonymousClass(ctype);
            ClassBodyAdapter cba = new ClassBodyAdapter(context, jdclass);
            node.getClassBody().apply(cba);
            ctype = jdclass;
        }
        // ***** ARGS *******
        JInvocation inv = JExpr._new(ctype);
        expr = inv;
        for (PArgument arg : node.getArgument()) {
            ArgumentAdapter aa = new ArgumentAdapter(inv, context);
            arg.apply(aa);
        }
    }

    @Override
    public void caseAClassInitializerArrayCreationExpression(AClassInitializerArrayCreationExpression node) {
        TypeAdapter ta = new TypeAdapter(context);
        node.getClassOrInterfaceType().apply(ta);
        int dim = node.getDim().size();
        JType type = ta.type;
        for (int i = 0; i < dim; i++) {
            type = type.array();
        }
        JInvocation inv = JExpr._new(type);
        AArrayInitializer inits = (AArrayInitializer) node.getArrayInitializer();
        for (PVariableInitializer init : inits.getVariableInitializer()) {
            VarInitAdapter via = new VarInitAdapter(context);
            init.apply(via);
            inv.arg(via.expr);
        }
        expr = inv;
    }
    
    @Override
    public void caseALiteralExpressionNoName(ALiteralExpressionNoName node) {
        LiteralAdapter la = new LiteralAdapter();
        node.getLiteral().apply(la);
        expr = la.expr;
    }

    private class TypeDiamondAdapter extends DepthFirstAdapter {

        JClass ctype;

        TypeDiamondAdapter(JClass ctype) {
            this.ctype = ctype;
        }

        @Override
        public void caseATypeArgumentsTypeArgumentsOrDiamond(ATypeArgumentsTypeArgumentsOrDiamond node) {
            TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context, ctype);
            node.getTypeArguments().apply(tpa);
        }

        @Override
        public void caseADiamondTypeArgumentsOrDiamond(ADiamondTypeArgumentsOrDiamond node) {
            Logger.error("Diamond operator not yet supported by CodeModel. Ignoring...");
        }
    }

    public static interface ExpressionParent {

        public JInvocation invoke(JExpression lhs, String method);

        public JInvocation invoke(String method);

        public void addInvocation(JInvocation invoc);
    }

    public static class JExprParent implements ExpressionParent {

        @Override
        public JInvocation invoke(String method) {
            return JExpr.invoke(method);
        }

        @Override
        public JInvocation invoke(JExpression lhs, String method) {
            return JExpr.invoke(lhs, method);
        }

        @Override
        public void addInvocation(JInvocation invoc) {
            // ignore
        }

    }
}
