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

import com.sun.codemodel.JClass;
import com.sun.codemodel.JLabel;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JTypeVar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lkroll
 */
class MethodScope extends NamedScope implements Scope.Generic, Scope.Fieldy {
    
    private final JMethod method;
    private Method methodMethod;
    private final Map<String, JTypeVar> generics = new HashMap<>();
    private final HashMap<String, Field> variables = new HashMap<>(); // also parameters

    MethodScope(JMethod method, NamedScope parent) {
        super(method.name(), parent);
        this.method = method;
    }
    
    void setMethod(Method m) {
        this.methodMethod = m;
    }

    @Override
    public void addGeneric(String g, JTypeVar var) {
        generics.put(g, var);
    }

    @Override
    public void addField(String name, Field f) {
        variables.put(name, f);
    }

    @Override
    public JClass resolveType(String shortName) {
        return parent().resolveType(shortName);
    }

    @Override
    public String getFile() {
        return parent().getFile();
    }

    @Override
    public JLabel resolveLabel(String name) {
        return null; // no point in resolving labels higher than one StatementScope
    }

    @Override
    public Field resolveField(String name) {
        Field f = variables.get(name);
        if (f != null) {
            return f;
        } else {
            return parent().resolveField(name);
        }
    }
    
}
