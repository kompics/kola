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

import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.writer.SingleStreamCodeWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import static se.sics.kola.Util.nameToString;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AClassTypeDeclaration;
import se.sics.kola.node.AJavaCompilationUnit;
import se.sics.kola.node.APackageDeclaration;
import se.sics.kola.node.ASingleImportDeclaration;
import se.sics.kola.node.Start;

/**
 *
 * @author lkroll
 */
public class JavaSourceGenerator extends DepthFirstAdapter {

    JCodeModel unit;
    JPackage pack;
    //Map<String, JClass> imports = new HashMap<>();
    ResolutionContext context;

    @Override
    public void inStart(Start node) {
        System.out.println("Generating output...");
    }

    @Override
    public void outStart(Start node) {
        System.out.println("Done generating output.");
    }

    @Override
    public void inAJavaCompilationUnit(AJavaCompilationUnit node) {
        unit = new JCodeModel();
        context = new ResolutionContext();
        context.unit = unit;
        context.imports = new HashMap<>();
    }

    @Override
    public void outAJavaCompilationUnit(AJavaCompilationUnit node) {
        try {
            System.out.println("DONE with compilation unit. Generated Code: ");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            unit.build(new SingleStreamCodeWriter(out));
            out.writeTo(System.out);
            unit = null;
            context = null;
            pack = null;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void caseAPackageDeclaration(APackageDeclaration node) {
        pack = unit._package(nameToString(node.getName()));
        System.out.println("Creating package: " + pack.name());
    }

    @Override
    public void caseASingleImportDeclaration(ASingleImportDeclaration node) {
        JClass c = unit.ref(nameToString(node.getName()));
        System.out.println("Importing class: " + c.fullName());
        context.imports.put(c.name(), c);
    }

    @Override
    public void caseAClassTypeDeclaration(AClassTypeDeclaration node) {
        ClassAdapter ca = new ClassAdapter(context, new ClassAdapter.ClassParent() {

            @Override
            public JDefinedClass _class(int mods, String name, ClassType classTypeVal) throws JClassAlreadyExistsException {
                return pack._class(mods, name, classTypeVal);
            }
        });
        node.apply(ca);
    }
}
