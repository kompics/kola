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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.javatuples.Pair;
import se.sics.kola.Logger;
import se.sics.kola.node.AArgsWithName;
import se.sics.kola.node.AName;
import se.sics.kola.node.ATypeDeclSpecifier;
import se.sics.kola.node.Node;
import se.sics.kola.node.PArgsWithName;
import se.sics.kola.node.PKolaKeyword;
import se.sics.kola.node.PName;
import se.sics.kola.node.PTypeArguments;
import se.sics.kola.node.TIdentifier;
import se.sics.kola.node.Token;

/**
 *
 * @author lkroll
 */
public class Util {

    public static String nameToString(PName pname) {
        AName name = (AName) pname;
        return nameToString(name.getIdentifier());
    }
    
    public static String nameToString(LinkedList<TIdentifier> ids) {
        StringBuilder sb = new StringBuilder();

        for (Iterator<TIdentifier> it = ids.iterator(); it.hasNext();) {
            TIdentifier id = it.next();
            sb.append(id.getText());
            if (it.hasNext()) {
                sb.append('.');
            }
        }
        return sb.toString();
    }
    
    public static Pair<String, String> nameToMethod(PName pname) {
        AName name = (AName) pname;
        return nameToMethod(name.getIdentifier());
    }
    
    public static Pair<String, String> nameToMethod(LinkedList<TIdentifier> ids) {
        LinkedList<TIdentifier> idsCopy = new LinkedList<>(ids);
        String methodName = idsCopy.pollLast().getText();
        String prefix = nameToString(idsCopy);
        return Pair.with(prefix, methodName);
    }
    
    public static String kolaKWToString(PKolaKeyword kw) {
        List<Token> tokens = findTokenChildren(kw);
        if (!tokens.isEmpty()) {
            return tokens.get(0).getText();
        } else {
            Logger.error("Expected a token as part of a PKolaKeyword, but found none.");
            return "";
        }
    }

    static LinkedList<IdWithOptArgs> shiftTDS(ATypeDeclSpecifier spec, ResolutionContext context) {
        AName firstName = (AName) spec.getName();

        LinkedList<IdWithOptArgs> list = new LinkedList<>();
        for (TIdentifier id : firstName.getIdentifier()) {
            IdWithOptArgs iwoa = new IdWithOptArgs();
            iwoa.id = id;
            list.add(iwoa);
        }
        IdWithOptArgs lastIwoa = list.getLast();
        for (PArgsWithName pawn : spec.getArgsWithName()) {
            AArgsWithName aawn = (AArgsWithName) pawn;
            if (lastIwoa != null) {
                lastIwoa.args = aawn.getTypeArguments();
            }
            for (TIdentifier id : ((AName) aawn.getName()).getIdentifier()) {
                IdWithOptArgs iwoa = new IdWithOptArgs();
                iwoa.id = id;
                list.add(iwoa);
            }
            lastIwoa = list.getLast();
        }
        return list;
    }

    static class IdWithOptArgs {

        TIdentifier id;
        PTypeArguments args;
    }

    
    public static List<Token> findTokenChildren(Node node) {
        List<Token> list = new LinkedList<>();
        Class c = node.getClass();
        Method[] methods = c.getMethods();
        for (Method m : methods) {
            Class t = m.getReturnType();
            if (Token.class.isAssignableFrom(t)) {
                try {
                    list.add((Token) m.invoke(node));
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    ex.printStackTrace(System.err);
                    Logger.error("Couldn't get token at node!");
                }
            }
        }
        return list;
    }
    
}
