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
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AJavaCompilationUnit;
import se.sics.kola.node.ANormalClassDeclaration;
import se.sics.kola.node.APackageDeclaration;
import se.sics.kola.node.ASingleImportDeclaration;
import se.sics.kola.node.Start;

/**
 *
 * @author lkroll
 */
public class JavaSourceGenerator extends DepthFirstAdapter {

    JCodeModel unit;
    JPackage p;

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
    }

    @Override
    public void outAJavaCompilationUnit(AJavaCompilationUnit node) {
        try {
            System.out.println("DONE with compilation unit. Generated Code: ");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            unit.build(new SingleStreamCodeWriter(out));
            out.writeTo(System.out);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void inAPackageDeclaration(APackageDeclaration node) {
        p = unit._package(node.getName().toString());
        System.out.println("Creating package: " + p.name());
    }
    
    @Override
    public void outASingleImportDeclaration(ASingleImportDeclaration node) {
        JClass c = unit.ref(node.getName().toString());
        System.out.println("Importing class: " + c.fullName());
    }
    
    
    
    @Override
    public void inANormalClassDeclaration(ANormalClassDeclaration node) {
        try {
            JDefinedClass c = unit._class(node.getIdentifier().getText(), ClassType.CLASS);
            System.out.println("Creating class: " + c.fullName());
        } catch (JClassAlreadyExistsException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public class ClassAdapter extends DepthFirstAdapter {
        private final JDefinedClass clazz;
        
        ClassAdapter(JDefinedClass clazz) {
            this.clazz = clazz;
        }
        
        
    }
}
