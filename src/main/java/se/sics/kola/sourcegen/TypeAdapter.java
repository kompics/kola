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
import com.sun.codemodel.JType;
import java.util.LinkedList;
import se.sics.kola.Logger;
import se.sics.kola.sourcegen.Util.IdWithOptArgs;
import static se.sics.kola.sourcegen.Util.nameToString;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AClassArrayType;
import se.sics.kola.node.AClassArrayTypeNoArguments;
import se.sics.kola.node.AClassOrInterfaceType;
import se.sics.kola.node.AClassOrInterfaceTypeNoArguments;
import se.sics.kola.node.AInterfaceType;
import se.sics.kola.node.AName;
import se.sics.kola.node.APrimitiveArrayType;
import se.sics.kola.node.APrimitiveArrayTypeNoArguments;
import se.sics.kola.node.APrimitiveType;
import se.sics.kola.node.ATypeDeclSpecifier;
import se.sics.kola.node.PTypeArguments;

/**
 *
 * @author lkroll
 */
class TypeAdapter extends DepthFirstAdapter {

    private final ResolutionContext context;
    JType type;

    TypeAdapter(ResolutionContext context) {
        this.context = context;
    }

    @Override
    public void caseAPrimitiveType(APrimitiveType node) {
        try {
            type = context.unit.parseType(node.toString());
        } catch (ClassNotFoundException ex) {
            Logger.error("Couldn't find primitive type: " + node.toString());
        }
    }

    @Override
    public void caseAClassOrInterfaceTypeNoArguments(AClassOrInterfaceTypeNoArguments node) {
        String name = nameToString(node.getName());
        try {
            type = context.resolve(name);
        } catch (ClassNotFoundException ex) {
            Logger.error("Couldn't find primitive type: " + name);
        }
    }

    @Override
    public void caseAClassOrInterfaceType(AClassOrInterfaceType node) {
        ATypeDeclSpecifier spec = (ATypeDeclSpecifier) node.getTypeDeclSpecifier();
        AName firstName = (AName) spec.getName();
        PTypeArguments lastArgsMaybe = node.getTypeArguments();
        JClass ctype;
        try {
            ctype = context.resolve(nameToString(firstName));
        } catch (ClassNotFoundException ex) {
            Logger.error(firstName.getIdentifier().getLast(), "Could not resolve type!");
            return;
        }
        LinkedList<IdWithOptArgs> list = Util.shiftTDS(spec, context);
        IdWithOptArgs lastIwoa = list.getLast();
        if (lastIwoa != null) {
            lastIwoa.args = lastArgsMaybe;
        }
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
        type = ctype;
    }
    
    @Override
    public void caseAInterfaceType(AInterfaceType node) {
        ATypeDeclSpecifier spec = (ATypeDeclSpecifier) node.getTypeDeclSpecifier();
        AName firstName = (AName) spec.getName();
        PTypeArguments lastArgsMaybe = node.getTypeArguments();
        JClass ctype;
        try {
            ctype = context.resolve(nameToString(firstName));
        } catch (ClassNotFoundException ex) {
            Logger.error(firstName.getIdentifier().getLast(), "Could not resolve type!");
            return;
        }
        LinkedList<IdWithOptArgs> list = Util.shiftTDS(spec, context);
        IdWithOptArgs lastIwoa = list.getLast();
        if (lastIwoa != null) {
            lastIwoa.args = lastArgsMaybe;
        }
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
        type = ctype;
    }

    @Override
    public void outAClassArrayTypeNoArguments(AClassArrayTypeNoArguments node) {
        arrayfy(node.getDim().size());
    }

    @Override
    public void outAPrimitiveArrayTypeNoArguments(APrimitiveArrayTypeNoArguments node) {
        arrayfy(node.getDim().size());
    }

    @Override
    public void outAClassArrayType(AClassArrayType node) {
        arrayfy(node.getDim().size());
    }

    @Override
    public void outAPrimitiveArrayType(APrimitiveArrayType node) {
        arrayfy(node.getDim().size());
    }

    private void arrayfy(int dims) {
        for (int i = 0; i < dims; i++) {
            type = type.array();
        }
    }

}
