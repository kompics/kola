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
import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JLabel;
import com.sun.codemodel.JPackage;
import java.util.HashMap;
import java.util.LinkedList;
import se.sics.kola.Logger;

/**
 *
 * @author lkroll
 */
class GlobalScope extends NamedScope {

    private static final LinkedList<String> permaScopePackages = new LinkedList<>();

    static {
        permaScopePackages.add("se.sics.kompics");
        permaScopePackages.add("java.lang");
    }

    private final HashMap<String, Type> qualifiedTypes = new HashMap<>();
    private final HashMap<String, PackageScope> packages = new HashMap<>();

    public final JCodeModel unit;

    GlobalScope(JCodeModel unit) {
        super("", null);
        this.unit = unit;
    }

    PackageScope addPackage(JPackage pack) {
        if (!packages.containsKey(pack.name())) {
            PackageScope ps = new PackageScope(pack, this);
            this.packages.put(pack.name(), ps);
            return ps;
        } else {
            return packages.get(pack.name());
        }
    }

    public PackageScope getPackage(String name) {
        return this.packages.get(name);
    }

    public Optional<JClass> resolveQualified(String qualifiedName) {
        // self declared
        if (qualifiedTypes.containsKey(qualifiedName)) {
            return Optional.of((JClass) qualifiedTypes.get(qualifiedName).definition);
        }
        // in the class path
        try {
            Class c = Thread.currentThread().getContextClassLoader().loadClass(qualifiedName);
            return Optional.of(unit.ref(c));
        } catch (ClassNotFoundException ex) {
            // ignore
        }
        return Optional.absent();

    }

    @Override
    public JClass resolveType(String shortName) {
        // global scope (no name package)
        try {
            Class c = Thread.currentThread().getContextClassLoader().loadClass(shortName);
            return unit.ref(c);
        } catch (ClassNotFoundException ex) {
            // ignore
        }
        // perma in scope
        for (String packS : permaScopePackages) {
            try {
                Class c = Thread.currentThread().getContextClassLoader().loadClass(packS + "." + shortName);
                return unit.ref(c);
            } catch (ClassNotFoundException ex) {
                // ignore
            }
        }
        Logger.error("Could not resolve type at any scope: " + shortName);
        return null;
    }

    @Override
    public String getFile() {
        return null;
    }

    void addType(Type t) {
        qualifiedTypes.put(t.definition.fullName(), t);
    }

    @Override
    public JLabel resolveLabel(String name) {
        return null;
    }

    @Override
    public Field resolveField(String name) {
        return null;
    }

    void printDeclaredTypes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Declared Types: \n");
        for (Type t : qualifiedTypes.values()) {
            sb.append("      ");
            sb.append(t.definition.fullName());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }


}
