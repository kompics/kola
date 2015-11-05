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
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.ABooleanPrimitiveType;
import se.sics.kola.node.AByteIntegralType;
import se.sics.kola.node.ACharIntegralType;
import se.sics.kola.node.AClassArrayType;
import se.sics.kola.node.AClassArrayTypeNoArguments;
import se.sics.kola.node.AClassOrInterfaceType;
import se.sics.kola.node.AClassOrInterfaceTypeNoArguments;
import se.sics.kola.node.AClassType;
import se.sics.kola.node.ADoubleFloatingPointType;
import se.sics.kola.node.AFloatFloatingPointType;
import se.sics.kola.node.AIntIntegralType;
import se.sics.kola.node.AInterfaceType;
import se.sics.kola.node.ALongIntegralType;
import se.sics.kola.node.AName;
import se.sics.kola.node.APrimitiveArrayType;
import se.sics.kola.node.APrimitiveArrayTypeNoArguments;
import se.sics.kola.node.AShortIntegralType;
import se.sics.kola.node.ATypeDeclSpecifier;
import se.sics.kola.node.PTypeArguments;
import se.sics.kola.sourcegen.Util.IdWithOptArgs;

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
    public void caseABooleanPrimitiveType(ABooleanPrimitiveType node) {
        type = context.unit.BOOLEAN;
    }

    @Override
    public void caseAByteIntegralType(AByteIntegralType node) {
        type = context.unit.BYTE;
    }

    @Override
    public void caseAShortIntegralType(AShortIntegralType node) {
        type = context.unit.SHORT;
    }

    @Override
    public void caseAIntIntegralType(AIntIntegralType node) {
        type = context.unit.INT;
    }

    @Override
    public void caseALongIntegralType(ALongIntegralType node) {
        type = context.unit.LONG;
    }

    @Override
    public void caseACharIntegralType(ACharIntegralType node) {
        type = context.unit.CHAR;
    }

    @Override
    public void caseAFloatFloatingPointType(AFloatFloatingPointType node) {
        type = context.unit.FLOAT;
    }

    @Override
    public void caseADoubleFloatingPointType(ADoubleFloatingPointType node) {
        type = context.unit.DOUBLE;
    }

    @Override
    public void caseAClassOrInterfaceTypeNoArguments(AClassOrInterfaceTypeNoArguments node) {

        type = context.resolveType(node.getName());

    }

    @Override
    public void caseAClassOrInterfaceType(AClassOrInterfaceType node) {
        ATypeDeclSpecifier spec = (ATypeDeclSpecifier) node.getTypeDeclSpecifier();
        AName firstName = (AName) spec.getName();
        PTypeArguments lastArgsMaybe = node.getTypeArguments();
        JClass ctype;
        ctype = context.resolveType(firstName);

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
        type = ctype;
    }

    @Override
    public void caseAInterfaceType(AInterfaceType node) {
        ATypeDeclSpecifier spec = (ATypeDeclSpecifier) node.getTypeDeclSpecifier();
        AName firstName = (AName) spec.getName();
        PTypeArguments lastArgsMaybe = node.getTypeArguments();
        JClass ctype = context.resolveType(firstName);

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
        type = ctype;
    }

    @Override
    public void caseAClassType(AClassType node) {
        ATypeDeclSpecifier spec = (ATypeDeclSpecifier) node.getTypeDeclSpecifier();
        AName firstName = (AName) spec.getName();
        PTypeArguments lastArgsMaybe = node.getTypeArguments();
        JClass ctype = context.resolveType(firstName);

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
