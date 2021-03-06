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
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AElementValuePair;
import se.sics.kola.node.AMarkerAnnotation;
import se.sics.kola.node.ANormalAnnotation;
import se.sics.kola.node.ASingleElementAnnotation;
import se.sics.kola.node.PElementValuePair;

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

        JClass atype = context.resolveType(node.getName());
        ann = anno.annotate(atype);
        //System.out.println("Param:" + node.getElementValuePair().toString());
        for (PElementValuePair pevp : node.getElementValuePair()) {
            AElementValuePair aevp = (AElementValuePair) pevp;
            String id = aevp.getIdentifier() != null ? aevp.getIdentifier().getText() : "value";
            AnnotationParameterAdapter apa = new AnnotationParameterAdapter(id, ann, context);
            aevp.getElementValue().apply(apa);
        }
    }

    @Override
    public void inASingleElementAnnotation(ASingleElementAnnotation node) {

        JClass atype = context.resolveType(node.getIdentifier());
        ann = anno.annotate(atype);
        //System.out.println("Param:" + node.getElementValue().toString());
        AnnotationParameterAdapter apa = new AnnotationParameterAdapter("value", ann, context);
        node.getElementValue().apply(apa);

    }

    @Override
    public void inAMarkerAnnotation(AMarkerAnnotation node) {

        JClass atype = context.resolveType(node.getIdentifier());
        ann = anno.annotate(atype);

    }

    public static interface Annotatable {

        public JAnnotationUse annotate(JClass atype);
    }
}
