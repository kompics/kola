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
import static se.sics.kola.sourcegen.Util.nameToString;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AElementValuePair;
import se.sics.kola.node.AMarkerAnnotation;
import se.sics.kola.node.ANormalAnnotation;
import se.sics.kola.node.ANormalClassDeclaration;
import se.sics.kola.node.ASingleElementAnnotation;
import se.sics.kola.node.PElementValuePair;
import se.sics.kola.node.PModifier;

/**
 *
 * @author lkroll
 */
public class ClassAdapter extends DepthFirstAdapter {
    
    private final ClassParent parent;
    private final ResolutionContext context;
    
    ClassAdapter(ResolutionContext context, ClassParent parent) {
        this.context = context;
        this.parent = parent;
    }
    
    @Override
    public void caseANormalClassDeclaration(ANormalClassDeclaration node) {
        try {
            ClassModifierAdapter modap = new ClassModifierAdapter();
            for (PModifier m : node.getModifier()) {
                m.apply(modap);
            }
            int mods = modap.getMods();
            JDefinedClass c = parent._class(mods, node.getIdentifier().getText(), ClassType.CLASS);
            for (PModifier m : node.getModifier()) {
                System.out.println("Mod: " + m.toString());
                ClassAnnotationAdapter annap = new ClassAnnotationAdapter(c);
                m.apply(annap);
            }
            System.out.println("Creating class: " + c.fullName());
            ClassBodyAdapter cba = new ClassBodyAdapter(context, c);
            node.getClassBody().apply(cba);
        } catch (JClassAlreadyExistsException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    class ClassAnnotationAdapter extends DepthFirstAdapter {

        private final JDefinedClass clazz;
        private JAnnotationUse ann;

        ClassAnnotationAdapter(JDefinedClass clazz) {
            this.clazz = clazz;
        }

        @Override
        public void inANormalAnnotation(ANormalAnnotation node) {
            String name = nameToString(node.getName());
            JClass atype = context.unit.directClass(name);
            if (atype != null) {
                ann = clazz.annotate(atype);
                //System.out.println("Param:" + node.getElementValuePair().toString());
                for (PElementValuePair pevp : node.getElementValuePair()) {
                    AElementValuePair aevp = (AElementValuePair) pevp;
                    String id = aevp.getIdentifier() != null ? aevp.getIdentifier().getText() : "value";
                    AnnotationParameterAdapter apa = new AnnotationParameterAdapter(id, ann, context);
                    aevp.getElementValue().apply(apa);
                }
            } else {
                Logger.error("Couldn't find annotation type.");
            }
        }

        @Override
        public void inASingleElementAnnotation(ASingleElementAnnotation node) {
            JClass atype = context.imports.get(node.getIdentifier().getText());
            if (atype != null) {
                ann = clazz.annotate(atype);
                //System.out.println("Param:" + node.getElementValue().toString());
                AnnotationParameterAdapter apa = new AnnotationParameterAdapter("value", ann, context);
                node.getElementValue().apply(apa);
            } else {
                Logger.error(node.getIdentifier(), "Couldn't find annotation type.");
            }
        }

        @Override
        public void inAMarkerAnnotation(AMarkerAnnotation node) {
            JClass atype = context.imports.get(node.getIdentifier().getText());
            if (atype != null) {
                ann = clazz.annotate(atype);
            } else {
                Logger.error(node.getIdentifier(), "Couldn't find annotation type.");
            }
        }
    }
    
    public static interface ClassParent {
        public JDefinedClass _class( int mods, String name, ClassType classTypeVal ) throws JClassAlreadyExistsException;
    }
}
