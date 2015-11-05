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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AGtTypeArguments;
import se.sics.kola.node.AName;
import se.sics.kola.node.AShrTypeArguments;
import se.sics.kola.node.ATypeDeclSpecifier;
import se.sics.kola.node.AUshrTypeArguments;
import se.sics.kola.node.PTypeArgument;
import se.sics.kola.sourcegen.Util.IdWithOptArgs;

/**
 *
 * @author lkroll
 */
class TypeArgumentsAdapter extends DepthFirstAdapter {

    private ResolutionContext context;
    //private JClass type;
    List<JClass> narrows = new ArrayList<JClass>();

    TypeArgumentsAdapter(ResolutionContext context) {
        this.context = context;
    }

    @Override
    public void caseAGtTypeArguments(AGtTypeArguments node) {
        for (PTypeArgument arg : node.getTypeArgument()) {
            TypeArgumentAdapter taa = new TypeArgumentAdapter(context);
            arg.apply(taa);
            narrows.add(taa.type);
        }
    }

    @Override
    public void caseAShrTypeArguments(AShrTypeArguments node) {
        // TA1s
        for (PTypeArgument arg : node.getTa1s()) {
            TypeArgumentAdapter taa = new TypeArgumentAdapter(context);
            arg.apply(taa);
            narrows.add(taa.type);
        }
        // TypeDecSpec
        ATypeDeclSpecifier spec = (ATypeDeclSpecifier) node.getTypeDeclSpecifier();
        AName firstName = (AName) spec.getName();
        JClass ctype = context.resolveType(firstName);

        LinkedList<IdWithOptArgs> list = Util.shiftTDS(spec, context);
        IdWithOptArgs cur = list.pollFirst();
        while ((cur != null) && (cur.args == null)) {
            cur = list.pollFirst();
        }
        if (cur != null) {
            TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context);
            cur.args.apply(tpa);
            ctype = ctype.narrow(tpa.narrows);
        }
        for (IdWithOptArgs iwoa : list) {

            ctype = ctype.inner(iwoa.id.getText());

            if (iwoa.args != null) {
                TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context);
                iwoa.args.apply(tpa);
                ctype = ctype.narrow(tpa.narrows);
            }
        }
        // TA2s
        List<JClass> narrows2 = new ArrayList<JClass>();
        for (PTypeArgument arg : node.getTa2s()) {
            TypeArgumentAdapter taa = new TypeArgumentAdapter(context);
            arg.apply(taa);
            narrows2.add(taa.type);
        }
        ctype = ctype.narrow(narrows2);
        narrows.add(ctype);
    }

    @Override
    public void caseAUshrTypeArguments(AUshrTypeArguments node) {
        // TA1s
        for (PTypeArgument arg : node.getTa1s()) {
            TypeArgumentAdapter taa = new TypeArgumentAdapter(context);
            arg.apply(taa);
            narrows.add(taa.type);
        }
        // Spec1
        ATypeDeclSpecifier spec1 = (ATypeDeclSpecifier) node.getSpecifier1();
        AName firstName1 = (AName) spec1.getName();
        JClass ctype1, ctype2;

        ctype1 = context.resolveType(firstName1);

        LinkedList<IdWithOptArgs> list1 = Util.shiftTDS(spec1, context);
        IdWithOptArgs cur = list1.pollFirst();
        while ((cur != null) && (cur.args == null)) {
            cur = list1.pollFirst();
        }
        if (cur != null) {
            TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context);
            cur.args.apply(tpa);
            ctype1 = ctype1.narrow(tpa.narrows);
        }
        for (IdWithOptArgs iwoa : list1) {

            ctype1 = ctype1.inner(iwoa.id.getText());

            if (iwoa.args != null) {
                TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context);
                iwoa.args.apply(tpa);
                ctype1 = ctype1.narrow(tpa.narrows);
            }
        }
        // TA2s
        List<JClass> narrows2 = new ArrayList<JClass>();
        for (PTypeArgument arg : node.getTa2s()) {
            TypeArgumentAdapter taa = new TypeArgumentAdapter(context);
            arg.apply(taa);
            narrows2.add(taa.type);
        }
        // Spec2
        ATypeDeclSpecifier spec2 = (ATypeDeclSpecifier) node.getSpecifier2();
        AName firstName2 = (AName) spec2.getName();

        ctype2 = context.resolveType(firstName2);

        LinkedList<IdWithOptArgs> list2 = Util.shiftTDS(spec2, context);
        cur = list2.pollFirst();
        while ((cur != null) && (cur.args == null)) {
            cur = list2.pollFirst();
        }
        if (cur != null) {
            TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context);
            cur.args.apply(tpa);
            ctype2 = ctype2.narrow(tpa.narrows);
        }
        for (IdWithOptArgs iwoa : list2) {

            ctype2 = ctype2.inner(iwoa.id.getText());

            if (iwoa.args != null) {
                TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context);
                iwoa.args.apply(tpa);
                ctype2 = ctype2.narrow(tpa.narrows);
            }
        }
        narrows2.add(ctype2);
        ctype1 = ctype1.narrow(narrows2);
        narrows.add(ctype1);
    }
}
