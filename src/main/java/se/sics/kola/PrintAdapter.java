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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AName;
import se.sics.kola.node.Node;
import se.sics.kola.node.TIdentifier;
import se.sics.kola.node.Token;
import static se.sics.kola.sourcegen.Util.nameToString;

/**
 *
 * @author lkroll
 */
public class PrintAdapter extends DepthFirstAdapter {

    private int depth = 0;
    StringBuilder sb = new StringBuilder();

    @Override
    public void defaultIn(Node node) {
        space();
        sb.append(node.getClass().getName());
        sb.append('(');
        sb.append('\n');
        depth++;
        for (Token t : findTokenChildren(node)) {
            space();
            sb.append(t.getText());
            sb.append("@[");
            sb.append(t.getLine());
            sb.append(',');
            sb.append(t.getPos());
            sb.append("]");

            sb.append('\n');
        }
        if (node instanceof AName) {
            space();
            AName name = (AName) node;
            TIdentifier t = name.getIdentifier().getFirst();
            String nameStr = nameToString(name);
            sb.append(nameStr);
            sb.append("@[");
            sb.append(t.getLine());
            sb.append(',');
            sb.append(t.getPos());
            sb.append("]");
            sb.append('\n');
        }
    }

    @Override
    public void defaultOut(Node node) {
        space();
        sb.append(')');
        sb.append('\n');
        depth--;
    }

    public void print() {
        System.out.println(sb);
    }

    @Override
    public String toString() {
        return this.sb.toString();
    }

    private void space() {
        for (int i = 0; i < depth; i++) {
            sb.append(' ');
        }
    }

    private List<Token> findTokenChildren(Node node) {
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
