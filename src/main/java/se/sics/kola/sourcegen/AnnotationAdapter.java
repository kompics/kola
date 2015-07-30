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
import com.sun.codemodel.JClass;
import se.sics.kola.Logger;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AElementValuePair;
import se.sics.kola.node.AMarkerAnnotation;
import se.sics.kola.node.AName;
import se.sics.kola.node.ANormalAnnotation;
import se.sics.kola.node.ASingleElementAnnotation;
import se.sics.kola.node.PElementValuePair;
import static se.sics.kola.sourcegen.Util.nameToString;

/**
 *
 * @author lkroll
 */
class AnnotationAdapter extends DepthFirstAdapter {

    private final Annotatable anno;
    private final ResolutionContext context;
    private JAnnotationUse ann;

    AnnotationAdapter(Annotatable anno, ResolutionContext context) {
        this.anno = anno;
        this.context = context;
    }

    @Override
    public void inANormalAnnotation(ANormalAnnotation node) {
        String name = nameToString(node.getName());
        try {
            JClass atype = context.resolveType(name);
            ann = anno.annotate(atype);
            //System.out.println("Param:" + node.getElementValuePair().toString());
            for (PElementValuePair pevp : node.getElementValuePair()) {
                AElementValuePair aevp = (AElementValuePair) pevp;
                String id = aevp.getIdentifier() != null ? aevp.getIdentifier().getText() : "value";
                AnnotationParameterAdapter apa = new AnnotationParameterAdapter(id, ann, context);
                aevp.getElementValue().apply(apa);
            }
        } catch (ClassNotFoundException ex) {
            AName aname = (AName) node.getName();
            Logger.error(aname.getIdentifier().peekFirst(), "Couldn't find annotation type: " + name);
        }
    }

    @Override
    public void inASingleElementAnnotation(ASingleElementAnnotation node) {
        try {
            JClass atype = context.resolveType(node.getIdentifier().getText());
            ann = anno.annotate(atype);
            //System.out.println("Param:" + node.getElementValue().toString());
            AnnotationParameterAdapter apa = new AnnotationParameterAdapter("value", ann, context);
            node.getElementValue().apply(apa);
        } catch (ClassNotFoundException ex) {
            Logger.error(node.getIdentifier(), "Couldn't find annotation type: " + node.getIdentifier().getText());
        }
    }

    @Override
    public void inAMarkerAnnotation(AMarkerAnnotation node) {
        try {
            JClass atype = context.resolveType(node.getIdentifier().getText());
            ann = anno.annotate(atype);
        } catch (ClassNotFoundException ex) {
            Logger.error(node.getIdentifier(), "Couldn't find annotation type: " + node.getIdentifier().getText());
        }
    }

    public static interface Annotatable {

        public JAnnotationUse annotate(JClass atype);
    }
}
