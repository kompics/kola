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
package se.sics.kola;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JType;
import java.util.LinkedList;
import java.util.List;
import static se.sics.kola.Util.nameToString;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AFormalParameter;
import se.sics.kola.node.AMethodDeclaration;
import se.sics.kola.node.AMethodDeclarator;
import se.sics.kola.node.AMethodHeader;
import se.sics.kola.node.AName;
import se.sics.kola.node.ATypeResult;
import se.sics.kola.node.AVariableDeclaratorId;
import se.sics.kola.node.AVariableLastFormalParameter;
import se.sics.kola.node.AVoidResult;
import se.sics.kola.node.PModifier;
import se.sics.kola.node.PTypeParameter;

/**
 *
 * @author lkroll
 */
class ClassBodyAdapter extends DepthFirstAdapter {

    private final ResolutionContext context;
    private final JDefinedClass clazz;

    ClassBodyAdapter(ResolutionContext context, JDefinedClass clazz) {
        this.context = context;
        this.clazz = clazz;
    }

    @Override
    public void caseAMethodDeclaration(AMethodDeclaration node) {
        AMethodHeader header = (AMethodHeader) node.getMethodHeader();
        MethodModifierAdapter modap = new MethodModifierAdapter();
        for (PModifier m : header.getModifier()) {
            m.apply(modap);
        }
        int mods = modap.getMods();
        ResultAdapter ra = new ResultAdapter();
        node.getMethodHeader().apply(ra);
        MethodDeclaratorAdapter da = new MethodDeclaratorAdapter();
        node.getMethodHeader().apply(da);
        JMethod method = clazz.method(mods, ra.resultType, da.name);
        for (PTypeParameter tparam : header.getTypeParameter()) {
            TypeParameterAdapter tpa = new TypeParameterAdapter(context);
            tparam.apply(tpa);
            if (tpa.bounds.isEmpty()) {
                method.generify(tpa.name);
            } else {
                for (JClass bound : tpa.bounds) {
                    method.generify(tpa.name, bound);
                }
            }
        }
        for (FormalParameter param : da.params) {
            param.apply(method);
        }
        if (header.getThrows() != null) {
            ThrowsAdapter ta = new ThrowsAdapter(method);
            header.getThrows().apply(ta);
        }
        BlockStatementAdapter bsa = new BlockStatementAdapter(context, method.body());
        node.getMethodBody().apply(bsa);
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
                JClass c = context.resolve(name);
                method._throws(c);
            } catch (ClassNotFoundException ex) {
                Logger.error(aname.getIdentifier().getFirst(), "Could not resolve type: " + name);
            }
        }
    }

    class ResultAdapter extends DepthFirstAdapter {

        private JType resultType;

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

        private String name;
        private List<FormalParameter> params = new LinkedList<>();

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

    class FormalParameter {

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
