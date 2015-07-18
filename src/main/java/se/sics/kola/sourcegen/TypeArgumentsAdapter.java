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
import java.util.LinkedList;
import se.sics.kola.Logger;
import se.sics.kola.sourcegen.Util.IdWithOptArgs;
import static se.sics.kola.sourcegen.Util.nameToString;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AGtTypeArguments;
import se.sics.kola.node.AName;
import se.sics.kola.node.AShrTypeArguments;
import se.sics.kola.node.ATypeDeclSpecifier;
import se.sics.kola.node.AUshrTypeArguments;
import se.sics.kola.node.PTypeArgument;

/**
 *
 * @author lkroll
 */
class TypeArgumentsAdapter extends DepthFirstAdapter {
    private ResolutionContext context;
    private JClass type;
    
    TypeArgumentsAdapter(ResolutionContext context, JClass type) {
        this.context = context;
        this.type = type;
    }
    
    @Override
    public void caseAGtTypeArguments(AGtTypeArguments node) {
        for (PTypeArgument arg : node.getTypeArgument()) {
            TypeArgumentAdapter taa = new TypeArgumentAdapter(context, type);
            arg.apply(taa);
        }
    }
    
    @Override
    public void caseAShrTypeArguments(AShrTypeArguments node) {
        // TA1s
        for (PTypeArgument arg : node.getTa1s()) {
            TypeArgumentAdapter taa = new TypeArgumentAdapter(context, type);
            arg.apply(taa);
        }
        // TypeDecSpec
        ATypeDeclSpecifier spec = (ATypeDeclSpecifier) node.getTypeDeclSpecifier();
        AName firstName = (AName) spec.getName();
        JClass ctype;
        try {
            ctype = context.resolve(nameToString(firstName));
        } catch (ClassNotFoundException ex) {
            Logger.error(firstName.getIdentifier().getLast(), "Could not resolve type!");
            return;
        }
        LinkedList<IdWithOptArgs> list = Util.shiftTDS(spec, context);
        IdWithOptArgs cur = list.pollFirst();
        while ((cur != null) && (cur.args == null)) {
            cur = list.pollFirst();
        }
        if (cur != null) {
            TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context, ctype);
            cur.args.apply(tpa);
        }
        for (IdWithOptArgs iwoa : list) {
            String cname = ctype.fullName() + "." + iwoa.id.getText(); // losing the generics again here...I don't see any way around this
            try {
                ctype = context.resolve(cname);
            } catch (ClassNotFoundException ex) {
                Logger.error("Couldn't resolve type: " + cname);
            }
            if (iwoa.args != null) {
                TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context, ctype);
                iwoa.args.apply(tpa);
            }
        }
        // TA2s
        for (PTypeArgument arg : node.getTa2s()) {
            TypeArgumentAdapter taa = new TypeArgumentAdapter(context, ctype);
            arg.apply(taa);
        }
        type = type.narrow(ctype);
    }
    
    @Override
    public void caseAUshrTypeArguments(AUshrTypeArguments node) {
        // TA1s
        for (PTypeArgument arg : node.getTa1s()) {
            TypeArgumentAdapter taa = new TypeArgumentAdapter(context, type);
            arg.apply(taa);
        }
        // Spec1
        ATypeDeclSpecifier spec1 = (ATypeDeclSpecifier) node.getSpecifier1();
        AName firstName1 = (AName) spec1.getName();
        JClass ctype1, ctype2;
        try {
            ctype1 = context.resolve(nameToString(firstName1));
        } catch (ClassNotFoundException ex) {
            Logger.error(firstName1.getIdentifier().getLast(), "Could not resolve type!");
            return;
        }
        LinkedList<IdWithOptArgs> list1 = Util.shiftTDS(spec1, context);
        IdWithOptArgs cur = list1.pollFirst();
        while ((cur != null) && (cur.args == null)) {
            cur = list1.pollFirst();
        }
        if (cur != null) {
            TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context, ctype1);
            cur.args.apply(tpa);
        }
        for (IdWithOptArgs iwoa : list1) {
            String cname = ctype1.fullName() + "." + iwoa.id.getText(); // losing the generics again here...I don't see any way around this
            try {
                ctype1 = context.resolve(cname);
            } catch (ClassNotFoundException ex) {
                Logger.error("Couldn't resolve type: " + cname);
            }
            if (iwoa.args != null) {
                TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context, ctype1);
                iwoa.args.apply(tpa);
            }
        }
        // TA2s
        for (PTypeArgument arg : node.getTa2s()) {
            TypeArgumentAdapter taa = new TypeArgumentAdapter(context, ctype1);
            arg.apply(taa);
        }
        // Spec2
        ATypeDeclSpecifier spec2 = (ATypeDeclSpecifier) node.getSpecifier2();
        AName firstName2 = (AName) spec2.getName();
        try {
            ctype2 = context.resolve(nameToString(firstName2));
        } catch (ClassNotFoundException ex) {
            Logger.error(firstName2.getIdentifier().getLast(), "Could not resolve type!");
            return;
        }
        LinkedList<IdWithOptArgs> list2 = Util.shiftTDS(spec2, context);
        cur = list2.pollFirst();
        while ((cur != null) && (cur.args == null)) {
            cur = list2.pollFirst();
        }
        if (cur != null) {
            TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context, ctype2);
            cur.args.apply(tpa);
        }
        for (IdWithOptArgs iwoa : list2) {
            String cname = ctype2.fullName() + "." + iwoa.id.getText(); // losing the generics again here...I don't see any way around this
            try {
                ctype2 = context.resolve(cname);
            } catch (ClassNotFoundException ex) {
                Logger.error("Couldn't resolve type: " + cname);
            }
            if (iwoa.args != null) {
                TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context, ctype2);
                iwoa.args.apply(tpa);
            }
        }
        ctype1 = ctype1.narrow(ctype2);
        type = type.narrow(ctype1);
    }
}
