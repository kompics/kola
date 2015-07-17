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
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldRef;
import com.sun.codemodel.JInvocation;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import se.sics.kola.ExpressionAdapter.ExpressionParent;
import static se.sics.kola.Util.nameToString;
import se.sics.kola.node.AName;
import se.sics.kola.node.TIdentifier;

/**
 *
 * @author lkroll
 */
class ResolutionContext {

    JCodeModel unit;
    Map<String, JClass> imports = new HashMap<>();

    JClass resolve(String name) throws ClassNotFoundException {
        JClass jc = imports.get(name);
        if (jc == null) {
            jc = unit.ref(name);
        }
        return jc;
    }

    
    //TODO rewrite this as a recursive function that allows JClass or JFieldRef at every step
    JInvocation resolveInvocation(AName name, ExpressionParent parent) {
        if (name.getIdentifier().size() == 1) {
            return parent.invoke(nameToString(name));
        } else {
            LinkedList<TIdentifier> ids = name.getIdentifier();
            TIdentifier firstId = ids.pollFirst();
            JFieldRef field = null;
            try {
                JClass jc = resolve(firstId.getText());
                TIdentifier secondId = ids.pollFirst();
                if (ids.isEmpty()) {
                    JInvocation ji = jc.staticInvoke(secondId.getText());
                    parent.addInvocation(ji);
                    return ji;
                } else {
                    field = jc.staticRef(secondId.getText());
                }
            } catch (ClassNotFoundException ex) {
                field = JExpr.ref(firstId.getText());
            }
            while (!ids.isEmpty()) {
                TIdentifier id = ids.pollFirst();
                if (ids.isEmpty()) {
                    JInvocation ji = field.invoke(id.getText());
                    parent.addInvocation(ji);
                    return ji;
                } else {
                    field = field.ref(id.getText());
                }
            }
        }
        return null;
    }
}
