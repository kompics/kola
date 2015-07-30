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

import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JType;
import java.util.LinkedList;
import java.util.List;
import se.sics.kola.Logger;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AConstructorDeclarator;
import se.sics.kola.node.AFormalParameter;
import se.sics.kola.node.AMethodDeclarator;
import se.sics.kola.node.AName;
import se.sics.kola.node.APrimaryExplicitConstructorInvocation;
import se.sics.kola.node.ASuperExplicitConstructorInvocation;
import se.sics.kola.node.AThisExplicitConstructorInvocation;
import se.sics.kola.node.ATypeResult;
import se.sics.kola.node.AVariableDeclaratorId;
import se.sics.kola.node.AVariableLastFormalParameter;
import se.sics.kola.node.AVoidResult;
import se.sics.kola.node.PArgument;
import se.sics.kola.node.PTypeParameter;
import se.sics.kola.sourcegen.AnnotationAdapter.Annotatable;
import static se.sics.kola.sourcegen.Util.nameToString;

/**
 *
 * @author lkroll
 */
public abstract class BodyAdapter extends DepthFirstAdapter {

    protected final ResolutionContext context;

    BodyAdapter(ResolutionContext context) {
        this.context = context;
    }

    static class MethodAnnotatable implements Annotatable {

        private final JMethod method;

        MethodAnnotatable(JMethod method) {
            this.method = method;
        }

        @Override
        public JAnnotationUse annotate(JClass atype) {
            return method.annotate(atype);
        }

    }

    class ThrowsAdapter extends DepthFirstAdapter {

        private final JMethod method;

        ThrowsAdapter(JMethod method) {
            this.method = method;
        }

        @Override
        public void caseAName(AName aname) {
            String name = nameToString(aname);
            try {
                JClass c = context.resolveType(name);
                method._throws(c);
            } catch (ClassNotFoundException ex) {
                Logger.error(aname.getIdentifier().getFirst(), "Could not resolve type: " + name);
            }
        }
    }

    class ResultAdapter extends DepthFirstAdapter {

        JType resultType;

        @Override
        public void caseAVoidResult(AVoidResult node) {
            resultType = context.unit.VOID;
        }

        @Override
        public void caseATypeResult(ATypeResult node) {
            TypeAdapter ta = new TypeAdapter(context);
            node.getType().apply(ta);
            resultType = ta.type;
        }

    }

    class MethodDeclaratorAdapter extends DepthFirstAdapter {

        String name;
        List<FormalParameter> params = new LinkedList<>();

        @Override
        public void inAMethodDeclarator(AMethodDeclarator node) {
            name = node.getIdentifier().getText();
        }

        @Override
        public void caseAFormalParameter(AFormalParameter node) {
            FormalParameter param = new FormalParameter();
            param.var = (node.parent() instanceof AVariableLastFormalParameter);
            FieldModifierAdapter fma = new FieldModifierAdapter();
            node.apply(fma);
            param.mods = fma.getMods();
            TypeAdapter ta = new TypeAdapter(context);
            node.getType().apply(ta);
            param.type = ta.type;
            AVariableDeclaratorId avdid = (AVariableDeclaratorId) node.getVariableDeclaratorId();
            param.id = avdid.getIdentifier().getText();
            param.dim = avdid.getDim().size();

            params.add(param);
        }
    }

    class ConstructorDeclaratorAdapter extends DepthFirstAdapter {

        //String name;
        private final JMethod constr;
        //List<FormalParameter> params = new LinkedList<>();

        ConstructorDeclaratorAdapter(JMethod constr) {
            this.constr = constr;
        }

        @Override
        public void inAConstructorDeclarator(AConstructorDeclarator node) {
            //ASimpleTypeName astn = (ASimpleTypeName) node.getSimpleTypeName();
            //name = astn.getIdentifier().getText();
            for (PTypeParameter tparam : node.getTypeParameter()) {
                TypeParameterAdapter tpa = new TypeParameterAdapter(context);
                tparam.apply(tpa);
                if (tpa.bounds.isEmpty()) {
                    constr.generify(tpa.name);
                } else {
                    for (JClass bound : tpa.bounds) {
                        constr.generify(tpa.name, bound);
                    }
                }
            }
        }

        @Override
        public void caseAFormalParameter(AFormalParameter node) {
            FormalParameter param = new FormalParameter();
            param.var = (node.parent() instanceof AVariableLastFormalParameter);
            FieldModifierAdapter fma = new FieldModifierAdapter();
            node.apply(fma);
            param.mods = fma.getMods();
            TypeAdapter ta = new TypeAdapter(context);
            node.getType().apply(ta);
            param.type = ta.type;
            AVariableDeclaratorId avdid = (AVariableDeclaratorId) node.getVariableDeclaratorId();
            param.id = avdid.getIdentifier().getText();
            param.dim = avdid.getDim().size();

            param.apply(constr);
        }
    }

    class ConstructorBodyAdapter extends BlockStatementAdapter {

        public ConstructorBodyAdapter(ResolutionContext context, JBlock block) {
            super(context, block);
        }

        @Override
        public void caseAThisExplicitConstructorInvocation(AThisExplicitConstructorInvocation node) {
            JInvocation inv = block.invoke("this");
            ArgumentAdapter.Argumentable ia = new ExpressionAdapter.InvocationArgumentable(inv);
            if (!node.getNonWildTypeArguments().isEmpty()) {
                Logger.error("CodeModel does not support type arguments for constructors, yet. Ignoring...");
            }
            for (PArgument arg : node.getArgument()) {
                ArgumentAdapter aa = new ArgumentAdapter(ia, context);
                arg.apply(aa);
            }
        }

        @Override
        public void caseASuperExplicitConstructorInvocation(ASuperExplicitConstructorInvocation node) {
            JInvocation inv = block.invoke("super");
            ArgumentAdapter.Argumentable ia = new ExpressionAdapter.InvocationArgumentable(inv);
            if (!node.getNonWildTypeArguments().isEmpty()) {
                Logger.error("CodeModel does not support type arguments for constructors, yet. Ignoring...");
            }
            for (PArgument arg : node.getArgument()) {
                ArgumentAdapter aa = new ArgumentAdapter(ia, context);
                arg.apply(aa);
            }
        }

        @Override
        public void caseAPrimaryExplicitConstructorInvocation(APrimaryExplicitConstructorInvocation node) {
            ExpressionAdapter ea = new ExpressionAdapter(new ExpressionAdapter.JExprParent(), context);
            node.getExpressionNoName().apply(ea);
            JExpression lhs = ea.expr;
            JInvocation inv = block.invoke(lhs, "super");
            if (!node.getNonWildTypeArguments().isEmpty()) {
                Logger.error("CodeModel does not support type arguments for constructors, yet. Ignoring...");
            }
            ArgumentAdapter.Argumentable ia = new ExpressionAdapter.InvocationArgumentable(inv);
            for (PArgument arg : node.getArgument()) {
                ArgumentAdapter aa = new ArgumentAdapter(ia, context);
                arg.apply(aa);
            }
        }
    }

    static class FormalParameter {

        int mods;
        boolean var;
        JType type;
        String id;
        int dim;

        void apply(JMethod method) {
            JType arrayType = type;
            for (int i = 0; i < dim; i++) {
                arrayType = arrayType.array();
            }
            if (var) {
                method.varParam(arrayType, id);
            } else {
                method.param(mods, arrayType, id);
            }
        }
    }
}
