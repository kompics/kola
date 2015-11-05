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

import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AClassTypeDeclaration;
import se.sics.kola.node.AComponentTypeDeclaration;
import se.sics.kola.node.ADemandImportDeclaration;
import se.sics.kola.node.AEventTypeDeclaration;
import se.sics.kola.node.AInterfaceTypeDeclaration;
import se.sics.kola.node.AJavaCompilationUnit;
import se.sics.kola.node.APackageDeclaration;
import se.sics.kola.node.APortTypeDeclaration;
import se.sics.kola.node.ASingleImportDeclaration;
import se.sics.kola.node.AStaticImportDeclaration;
import se.sics.kola.node.ATypeImportDeclaration;
import se.sics.kola.node.Start;
import static se.sics.kola.sourcegen.Util.nameToString;

/**
 *
 * @author lkroll
 */
public class JavaSourceGenerator extends DepthFirstAdapter {

    ResolutionContext context;
    
    public JavaSourceGenerator(ResolutionContext rc) {
        context = rc;
    }


    @Override
    public void inStart(Start node) {
        System.out.println("Generating Java model for " + context.getFile());
    }

    @Override
    public void outStart(Start node) {
        System.out.println("Done generating Java model for " + context.getFile());
    }

    @Override
    public void inAJavaCompilationUnit(AJavaCompilationUnit node) {
        // pushing on package declaration instead
    }

    @Override
    public void outAJavaCompilationUnit(AJavaCompilationUnit node) {
        context.popPackage();
    }

    @Override
    public void caseAPackageDeclaration(APackageDeclaration node) {
        String packageName = nameToString(node.getName());
        System.out.println("Using package: " + packageName);
        context.pushPackage(packageName);
    }

    @Override
    public void caseASingleImportDeclaration(ASingleImportDeclaration node) {
        String c = nameToString(node.getName());
        System.out.println("Importing type: " + c);
        context.importType(c);
    }
    
    @Override
    public void caseATypeImportDeclaration(ATypeImportDeclaration node) {
        String c = nameToString(node.getName());
        System.out.println("Importing all types in: " + c);
        context.importOnDemand(c);
    }
    
    @Override
    public void caseAStaticImportDeclaration(AStaticImportDeclaration node) {
        String c = nameToString(node.getName());
        System.out.println("Importing static member: " + c);
        context.importStatic(c);
    }
    
    @Override
    public void caseADemandImportDeclaration(ADemandImportDeclaration node) {
        String c = nameToString(node.getName());
        System.out.println("Importing all static members from: " + c);
        context.importStaticOnDemand(c);
    }

    @Override
    public void caseAClassTypeDeclaration(AClassTypeDeclaration node) {
        TypeDeclarationAdapter ca = new TypeDeclarationAdapter(context);
        node.apply(ca);
    }

    @Override
    public void caseAInterfaceTypeDeclaration(AInterfaceTypeDeclaration node) {
        TypeDeclarationAdapter ca = new TypeDeclarationAdapter(context);
        node.apply(ca);
    }
    
    @Override
    public void caseAPortTypeDeclaration(APortTypeDeclaration node) {
        TypeDeclarationAdapter ca = new TypeDeclarationAdapter(context);
        node.apply(ca);
    }
    
    @Override
    public void caseAEventTypeDeclaration(AEventTypeDeclaration node) {
        TypeDeclarationAdapter ca = new TypeDeclarationAdapter(context);
        node.apply(ca);
    }
    
    @Override
    public void caseAComponentTypeDeclaration(AComponentTypeDeclaration node) {
        TypeDeclarationAdapter ca = new TypeDeclarationAdapter(context);
        node.apply(ca);
    }
}
