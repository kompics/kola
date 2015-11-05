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
import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JLabel;
import com.sun.codemodel.JType;
import com.sun.codemodel.JTypeVar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import se.sics.kola.node.TIdentifier;

/**
 *
 * @author lkroll
 */
abstract class Scope {
    
    private final Scope parent;
    private LinkedList<Scope> children;
    
    Scope(Scope parent) {
        this.parent = parent;
    }
    
    public Scope parent() {
        return parent;
    }
    public List<Scope> children() {
        if (children == null) {
            return Collections.EMPTY_LIST;
        } else {
            return children;
        }
    }
    
    void addChild(Scope s) {
        if (children == null) {
            children = new LinkedList<>();
        }
        children.add(s);
    }
    
    public abstract JClass resolveType(String shortName);
    
    public abstract JLabel resolveLabel(String name);
    
    public abstract Field resolveField(String name);
    
    public abstract String getFile();
    
    public static interface Generic {
        public void addGeneric(String g, JTypeVar var);
    }
    
    public static interface Labelled {
        public void addLabel(String name, JLabel label);
    }
    
    public static interface Fieldy {
        public void addField(String name, Field f);
    }
    
    public static interface Typey {
        public Type declare(int mods, TIdentifier identifier, ClassType ctype, Optional<String> name) throws JClassAlreadyExistsException;
    }
    
    public static interface Methody {
        public Method method(int mods, TIdentifier identifier, JType resultType, Optional<String> name);
        public Method constructor(int mods);
    }
}
