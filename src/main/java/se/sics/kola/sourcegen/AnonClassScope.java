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

import com.google.common.base.Optional;
import com.google.common.collect.HashMultimap;
import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JLabel;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JType;
import com.sun.codemodel.JTypeVar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import se.sics.kola.node.TIdentifier;

/**
 *
 * @author lkroll
 */
class AnonClassScope extends NamedScope implements Scope.Fieldy, Scope.Generic, Scope.Methody, Scope.Typey {

    private final JDefinedClass type;
    private final HashMap<String, Type> types = new HashMap<>();
    private final HashMap<String, Field> fields = new HashMap<>();
    private final Map<String, JTypeVar> generics = new HashMap<>();
    private final HashMultimap<String, Method> methods = HashMultimap.create();
    private final LinkedList<Method> constructors = new LinkedList<>();

    AnonClassScope(JDefinedClass type, Scope parent) {
        super(type.binaryName(), parent);
        this.type = type;
    }

    @Override
    public void addField(String name, Field f) {
        fields.put(name, f);
    }

    @Override
    public void addGeneric(String g, JTypeVar var) {
        generics.put(g, var);
    }

    @Override
    public JClass resolveType(String shortName) {
        Type t = types.get(shortName);
        if (t != null) {
            return t.definition;
        }
        JTypeVar jtv = generics.get(shortName);
        if (jtv != null) {
            return jtv;
        }
        return parent().resolveType(shortName);
    }

    @Override
    public String getFile() {
        return parent().getFile();
    }

    @Override
    public JLabel resolveLabel(String name) {
        return null;
    }

    @Override
    public Field resolveField(String name) {
        Field f = fields.get(name);
        if (f != null) {
            return f;
        } else {
            return parent().resolveField(name);
        }
    }

    @Override
    public Method method(int mods, TIdentifier identifier, JType resultType, Optional<String> name) {
        String methodName;
        if (name.isPresent()) {
            methodName = name.get();
        } else {
            methodName = identifier.getText();
        }
        JMethod method = type.method(mods, resultType, methodName);
        Method m = new Method(this, new MethodScope(method, this), method, identifier);
        m.scope.setMethod(m);
        methods.put(methodName, m);
        return m;
    }

    @Override
    public Method constructor(int mods) {
        JMethod method = type.constructor(mods);
        Method m = new Method(this, new MethodScope(method, this), method, null);
        m.scope.setMethod(m);
        constructors.add(m);
        return m;
    }

    @Override
    public Type declare(int mods, TIdentifier identifier, ClassType ctype, Optional<String> name) throws JClassAlreadyExistsException {
        String className;
        if (name.isPresent()) {
            className = name.get();
        } else {
            className = identifier.getText();
        }
        JDefinedClass child = type._class(mods, className, ctype);
        Type childT = new Type(this, new TypeScope(child, this), child, identifier);
        types.put(className, childT);
        return childT;
    }

}
