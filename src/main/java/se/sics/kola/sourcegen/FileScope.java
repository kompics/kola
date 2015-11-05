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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import se.sics.kola.Logger;
import se.sics.kola.node.TIdentifier;

/**
 *
 * @author lkroll
 */
class FileScope extends NamedScope implements Scope.Typey {

    private final String fileName;
    private final Map<String, String> typeImports = new HashMap<>();
    private final List<String> typeOnDemand = new LinkedList<>();
    private final Map<String, String> staticImports = new HashMap<>();
    private final List<String> staticTypeOnDemand = new LinkedList<>();

    FileScope(String fileName, PackageScope parent) {
        super(parent.name(), parent);
        this.fileName = fileName;
    }

    @Override
    public String getFile() {
        return fileName;
    }

    void importType(String name) {
        String[] parts = name.split("\\.");
        String shortName = parts[parts.length - 1];
        typeImports.put(shortName, name);
        //System.out.println("Imported type " + shortName + " -> " + name + " in file scope: " + fileName);
    }

    void importTypeOnDemand(String name) {
        typeOnDemand.add(name);
    }

    void importStatic(String name) {
        String[] parts = name.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (parts.length - 1); i++) {
            sb.append(parts[i]);
            if (i < (parts.length - 2)) {
                sb.append('.');
            }
        }
        staticImports.put(parts[parts.length - 1], sb.toString());
    }

    void importStaticOnDemand(String name) {
        staticTypeOnDemand.add(name);
    }

    @Override
    public PackageScope parent() {
        return (PackageScope) super.parent();
    }

    @Override
    public JClass resolveType(String shortName) {
        GlobalScope global = parent().parent();
        // direct import
        String qualifiedName = typeImports.get(shortName);
        if (qualifiedName != null) {
            Optional<JClass> ojc = global.resolveQualified(qualifiedName);
            if (ojc.isPresent()) {
                return ojc.get();
            } else {
                Logger.warn(fileName, (TIdentifier) null, "Couldn't resolve imported type (" + qualifiedName + "). Using direct reference instead.");
                return global.unit.ref(qualifiedName);
            }
        }
        // import on demand
        for (String importName : typeOnDemand) {
            qualifiedName = importName + "." + shortName;
            Optional<JClass> ojc = global.resolveQualified(qualifiedName);
            if (ojc.isPresent()) {
                return ojc.get();
            }
        }

        return parent().resolveType(shortName);
    }

    @Override
    public Type declare(int mods, TIdentifier identifier, ClassType ctype, Optional<String> name) throws JClassAlreadyExistsException {
        return parent().declare(mods, identifier, ctype, name, this); // just forward to parent
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
