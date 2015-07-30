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

import com.sun.codemodel.JAnnotationArrayMember;
import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JClass;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AAnnotationElementValue;
import se.sics.kola.node.AArrayElementValue;
import se.sics.kola.node.AConditionalElementValue;
import se.sics.kola.node.AElementValueArrayInitializer;
import se.sics.kola.node.PElementValue;

/**
 *
 * @author lkroll
 */
public class AnnotationArrayAdapter extends DepthFirstAdapter {
    private final ResolutionContext context;
    private final JAnnotationArrayMember ann;

    AnnotationArrayAdapter(JAnnotationArrayMember ann, ResolutionContext context) {
        this.ann = ann;
        this.context = context;
    }
    
     @Override
    public void caseAConditionalElementValue(AConditionalElementValue node) {
        ExpressionAdapter ea = new ExpressionAdapter(new ExpressionAdapter.JExprParent(), context);
        node.getExpression().apply(ea);
        ann.param(ea.expr);
    }
    
    @Override
    public void caseAAnnotationElementValue(AAnnotationElementValue node) {
        AnnotationAdapter aa = new AnnotationAdapter(new AnnotationAdapter.Annotatable(){

            @Override
            public JAnnotationUse annotate(JClass atype) {
                return ann.annotate(atype);
            }
        }, context);
        node.getAnnotation().apply(aa);
    }
    
    @Override
    public void caseAArrayElementValue(AArrayElementValue node) {
        AnnotationArrayAdapter aaa = new AnnotationArrayAdapter(ann, context); //FIXME note that we are techincally losing a level here...not sure if it matters in practice
        AElementValueArrayInitializer aevi = (AElementValueArrayInitializer) node.getElementValueArrayInitializer();
        for (PElementValue val : aevi.getElementValue()) {
            val.apply(aaa);
        }
    }
}
