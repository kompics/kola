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

import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMethod;
import se.sics.kola.Logger;
import se.sics.kola.node.AAbstractAnnotationTypeElementDeclaration;
import se.sics.kola.node.PModifier;

/**
 *
 * @author lkroll
 */
class AnnotationBodyAdapter extends InterfaceBodyAdapter {

    public AnnotationBodyAdapter(ResolutionContext context, JDefinedClass ifc) {
        super(context, ifc);
    }
    
    @Override
    public void caseAAbstractAnnotationTypeElementDeclaration(AAbstractAnnotationTypeElementDeclaration header) {
        MethodModifierAdapter modap = new MethodModifierAdapter();
        for (PModifier m : header.getModifier()) {
            m.apply(modap);
        }
        int mods = modap.getMods();
        final TypeAdapter ta = new TypeAdapter(context);
        header.getType().apply(ta);
        
        JMethod method = ifc.method(mods, ta.type, header.getIdentifier().getText());
        for (PModifier m : header.getModifier()) {
            AnnotationAdapter annap = new AnnotationAdapter(new MethodAnnotatable(method), context);
            m.apply(annap);
        }
        if (header.getDefaultValue() != null) {
            Logger.error(header.getIdentifier(), "CodeModel doesn't support annotation default values, yet...");
        }
    }

    
}
