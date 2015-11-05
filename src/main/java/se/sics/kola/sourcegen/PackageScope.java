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
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JLabel;
import com.sun.codemodel.JPackage;
import java.util.HashMap;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import se.sics.kola.node.TIdentifier;

/**
 *
 * @author lkroll
 */
class PackageScope extends NamedScope implements Scope.Typey {

    private final HashMap<String, Type> types = new HashMap<>();
    private final HashMap<String, Optional<JClass>> externalTypes = new HashMap<>();
    private final JPackage pack;

    PackageScope(JPackage pack, GlobalScope parent) {
        super(pack.name(), parent);
        this.pack = pack;

        Reflections reflections = new Reflections(name(), new SubTypesScanner(false));
        for (String s : reflections.getAllTypes()) {
            Optional<JClass> ojc = Optional.absent();
            externalTypes.put(s, ojc);
        }
    }

    @Override
    public GlobalScope parent() {
        return (GlobalScope) super.parent();
    }

    @Override
    public JClass resolveType(String shortName) {
        // internal
        Type t = types.get(shortName);
        if (t != null) {
            return t.definition;
        }
        // external
        String qualifiedName = name() + "." + shortName;
        Optional<JClass> ojc = externalTypes.get(qualifiedName);
        if (ojc != null) {
            if (ojc.isPresent()) {
                return ojc.get();
            } else {
                JClass jc = parent().unit.ref(qualifiedName);
                ojc = Optional.of(jc);
                externalTypes.put(qualifiedName, ojc);
                return jc;
            }
        }
        return parent().resolveType(shortName);
    }

    @Override
    public String getFile() {
        return null;
    }

    @Override
    public Type declare(int mods, TIdentifier identifier, ClassType ctype, Optional<String> name) throws JClassAlreadyExistsException {
        String className;
        if (name.isPresent()) {
            className = name.get();
        } else {
            className = identifier.getText();
        }
        JDefinedClass child = pack._class(mods, className, ctype);
        Type childT = new Type(this, new TypeScope(child, this), child, identifier);
        types.put(className, childT);
        return childT;
    }

    public Type declare(int mods, TIdentifier identifier, ClassType ctype, Optional<String> name, FileScope directParent) throws JClassAlreadyExistsException {
        String className;
        if (name.isPresent()) {
            className = name.get();
        } else {
            className = identifier.getText();
        }
        JDefinedClass child = pack._class(mods, className, ctype);
        Type childT = new Type(this, new TypeScope(child, directParent), child, identifier);
        types.put(className, childT);
        return childT;
    }

    
    @Override
    public JLabel resolveLabel(String name) {
        return null;
    }

    @Override
    public Field resolveField(String name) {
        return null;
    }

}
