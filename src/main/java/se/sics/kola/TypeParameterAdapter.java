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
import java.util.LinkedList;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.ATypeBound;
import se.sics.kola.node.ATypeParameter;
import se.sics.kola.node.PInterfaceType;

/**
 *
 * @author lkroll
 */
public class TypeParameterAdapter extends DepthFirstAdapter {
    private ResolutionContext context;
    String name;
    LinkedList<JClass> bounds = new LinkedList<>();
    
    TypeParameterAdapter(ResolutionContext context) {
        this.context = context;
    }
    
    @Override
    public void caseATypeParameter(ATypeParameter node) {
        name = node.getIdentifier().getText();
        
        ATypeBound bound = (ATypeBound) node.getTypeBound();
        if (bound != null) {
            for (PInterfaceType type : bound.getInterfaceType()) {
                TypeAdapter ta = new TypeAdapter(context);
                type.apply(ta);
                bounds.add((JClass)ta.type); // cast will work because we only use interface types
            }
        }
    }
}
