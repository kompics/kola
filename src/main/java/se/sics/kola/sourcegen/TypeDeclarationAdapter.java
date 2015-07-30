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
import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import se.sics.kola.Logger;
import se.sics.kola.PrintAdapter;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AAnnotationTypeDeclaration;
import se.sics.kola.node.AEnumDeclaration;
import se.sics.kola.node.ANormalClassDeclaration;
import se.sics.kola.node.ANormalInterfaceDeclaration;
import se.sics.kola.node.PInterfaceType;
import se.sics.kola.node.PModifier;
import se.sics.kola.node.PTypeParameter;
import se.sics.kola.sourcegen.AnnotationAdapter.Annotatable;

/**
 *
 * @author lkroll
 */
public class TypeDeclarationAdapter extends DepthFirstAdapter {

    private final TypeParent parent;
    private final ResolutionContext context;

    TypeDeclarationAdapter(ResolutionContext context, TypeParent parent) {
        this.context = context;
        this.parent = parent;
    }

    @Override
    public void caseANormalClassDeclaration(ANormalClassDeclaration node) {

        context.pushLevel();
        try {
            TypeModifierAdapter modap = new TypeModifierAdapter();
            for (PModifier m : node.getModifier()) {
                m.apply(modap);
            }
            int mods = modap.getMods();
            JDefinedClass c = parent._class(mods, node.getIdentifier().getText(), ClassType.CLASS);
            context.declaredClasses.put(node.getIdentifier().getText(), c);
            for (PModifier m : node.getModifier()) {
                AnnotationAdapter annap = new AnnotationAdapter(new ClassAnnotatable(c), context);
                m.apply(annap);
            }
            for (PTypeParameter ptp : node.getTypeParameter()) {
                TypeParameterAdapter tpa = new TypeParameterAdapter(context);
                ptp.apply(tpa);
                if (tpa.bounds.isEmpty()) {
                    c.generify(tpa.name);
                } else {
                    for (JClass bound : tpa.bounds) {
                        c.generify(tpa.name, bound);
                    }
                }
                context.addGeneric(tpa.name);
            }
            if (node.getParent() != null) {
                TypeAdapter ta = new TypeAdapter(context);
                node.getParent().apply(ta);
                if (ta.type == null) {
                    PrintAdapter pa = new PrintAdapter();
                    node.getParent().apply(pa);
                    Logger.error("Could not find type for subtree: \n" + pa.toString());

                }
                c._extends(ta.type.boxify());
            }
            for (PInterfaceType ift : node.getInterfaceType()) {
                TypeAdapter ta = new TypeAdapter(context);
                ift.apply(ta);
                c._implements(ta.type.boxify());
            }
            System.out.println("Creating class: " + c.fullName());
            ClassBodyAdapter cba = new ClassBodyAdapter(context, c);
            node.getClassBody().apply(cba);
        } catch (JClassAlreadyExistsException ex) {
            throw new RuntimeException(ex);
        } finally {
            context.popLevel();
        }
    }

    @Override
    public void caseAEnumDeclaration(AEnumDeclaration node) {

        context.pushLevel();
        try {
            TypeModifierAdapter modap = new TypeModifierAdapter();
            for (PModifier m : node.getModifier()) {
                m.apply(modap);
            }
            int mods = modap.getMods();
            JDefinedClass c = parent._class(mods, node.getIdentifier().getText(), ClassType.ENUM);
            context.declaredClasses.put(node.getIdentifier().getText(), c);
            for (PModifier m : node.getModifier()) {
                AnnotationAdapter annap = new AnnotationAdapter(new ClassAnnotatable(c), context);
                m.apply(annap);
            }

            for (PInterfaceType ift : node.getInterfaceType()) {
                TypeAdapter ta = new TypeAdapter(context);
                ift.apply(ta);
                c._implements(ta.type.boxify());
            }
            System.out.println("Creating enum: " + c.fullName());
            EnumBodyAdapter eba = new EnumBodyAdapter(context, c);
            node.getEnumBody().apply(eba);
        } catch (JClassAlreadyExistsException ex) {
            throw new RuntimeException(ex);
        } finally {
            context.popLevel();
        }
    }

    @Override
    public void caseANormalInterfaceDeclaration(ANormalInterfaceDeclaration node) {

        context.pushLevel();
        try {
            TypeModifierAdapter modap = new TypeModifierAdapter();
            for (PModifier m : node.getModifier()) {
                m.apply(modap);
            }
            int mods = modap.getMods();
            JDefinedClass c = parent._class(mods, node.getIdentifier().getText(), ClassType.INTERFACE);
            context.declaredClasses.put(node.getIdentifier().getText(), c);
            for (PModifier m : node.getModifier()) {
                AnnotationAdapter annap = new AnnotationAdapter(new ClassAnnotatable(c), context);
                m.apply(annap);
            }
            for (PTypeParameter ptp : node.getTypeParameter()) {
                TypeParameterAdapter tpa = new TypeParameterAdapter(context);
                ptp.apply(tpa);
                if (tpa.bounds.isEmpty()) {
                    c.generify(tpa.name);
                } else {
                    for (JClass bound : tpa.bounds) {
                        c.generify(tpa.name, bound);
                    }
                }
                context.addGeneric(tpa.name);
            }
            for (PInterfaceType ift : node.getExtendsInterfaces()) {
                TypeAdapter ta = new TypeAdapter(context);
                ift.apply(ta);
                c._implements(ta.type.boxify());
            }
            System.out.println("Creating interface: " + c.fullName());
            InterfaceBodyAdapter iba = new InterfaceBodyAdapter(context, c);
            node.getInterfaceBody().apply(iba);
        } catch (JClassAlreadyExistsException ex) {
            throw new RuntimeException(ex);
        } finally {
            context.popLevel();
        }
    }

    @Override
    public void caseAAnnotationTypeDeclaration(AAnnotationTypeDeclaration node) {

        context.pushLevel();
        try {
            TypeModifierAdapter modap = new TypeModifierAdapter();
            for (PModifier m : node.getModifier()) {
                m.apply(modap);
            }
            int mods = modap.getMods();
            JDefinedClass c = parent._class(mods, node.getIdentifier().getText(), ClassType.ANNOTATION_TYPE_DECL);
            context.declaredClasses.put(node.getIdentifier().getText(), c);
            for (PModifier m : node.getModifier()) {
                AnnotationAdapter annap = new AnnotationAdapter(new ClassAnnotatable(c), context);
                m.apply(annap);
            }

            System.out.println("Creating annotation: " + c.fullName());
            AnnotationBodyAdapter aba = new AnnotationBodyAdapter(context, c);
            node.getAnnotationTypeBody().apply(aba);
        } catch (JClassAlreadyExistsException ex) {
            throw new RuntimeException(ex);
        } finally {
            context.popLevel();
        }
    }

    static class ClassAnnotatable implements Annotatable {

        private final JDefinedClass clazz;

        ClassAnnotatable(JDefinedClass clazz) {
            this.clazz = clazz;
        }

        @Override
        public JAnnotationUse annotate(JClass atype) {
            return clazz.annotate(atype);
        }

    }

    public static interface TypeParent {

        public JDefinedClass _class(int mods, String name, ClassType classTypeVal) throws JClassAlreadyExistsException;
    }
}
