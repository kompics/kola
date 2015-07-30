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

import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JType;
import com.sun.codemodel.JVar;
import se.sics.kola.node.AAbstractMethodDeclaration;
import se.sics.kola.node.AClassInterfaceMemberDeclaration;
import se.sics.kola.node.AConstantDeclaration;
import se.sics.kola.node.AInterfaceInterfaceMemberDeclaration;
import se.sics.kola.node.PModifier;
import se.sics.kola.node.PTypeParameter;
import se.sics.kola.node.PVariableDeclarator;

/**
 *
 * @author lkroll
 */
public class InterfaceBodyAdapter extends BodyAdapter {

    protected final JDefinedClass ifc;
    protected final TypeDeclarationAdapter.TypeParent cparent = new TypeDeclarationAdapter.TypeParent() {

        @Override
        public JDefinedClass _class(int mods, String name, ClassType classTypeVal) throws JClassAlreadyExistsException {
            return ifc._class(mods, name, classTypeVal);
        }
    };

    InterfaceBodyAdapter(ResolutionContext context, JDefinedClass ifc) {
        super(context);
        this.ifc = ifc;
    }
    
    @Override
    public void caseAAbstractMethodDeclaration(AAbstractMethodDeclaration header) {
        MethodModifierAdapter modap = new MethodModifierAdapter();
        for (PModifier m : header.getModifier()) {
            m.apply(modap);
        }
        int mods = modap.getMods();
        ResultAdapter ra = new ResultAdapter();
        header.apply(ra);
        MethodDeclaratorAdapter da = new MethodDeclaratorAdapter();
        header.apply(da);
        JMethod method = ifc.method(mods, ra.resultType, da.name);
        for (PModifier m : header.getModifier()) {
            AnnotationAdapter annap = new AnnotationAdapter(new MethodAnnotatable(method), context);
            m.apply(annap);
        }
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
    }

    @Override
    public void caseAConstantDeclaration(AConstantDeclaration node) {
        final FieldModifierAdapter fma = new FieldModifierAdapter();
        for (PModifier mod : node.getModifier()) {
            mod.apply(fma);
        }
        final TypeAdapter ta = new TypeAdapter(context);
        node.getType().apply(ta);
        VarDeclAdapter vda = new VarDeclAdapter(ta.type, context, new VarDeclAdapter.Scope() {

            @Override
            public JVar declare(JType type, String name, JExpression init) {
                return ifc.field(fma.getMods(), type, name, init);
            }

        });
        for (PVariableDeclarator decl : node.getVariableDeclarator()) {
            decl.apply(vda);
        }
    }

    @Override
    public void caseAClassInterfaceMemberDeclaration(AClassInterfaceMemberDeclaration node) {
        TypeDeclarationAdapter ca = new TypeDeclarationAdapter(context, cparent);
        node.apply(ca);
    }

    @Override
    public void caseAInterfaceInterfaceMemberDeclaration(AInterfaceInterfaceMemberDeclaration node) {
        TypeDeclarationAdapter ca = new TypeDeclarationAdapter(context, cparent);
        node.apply(ca);
    }
}
