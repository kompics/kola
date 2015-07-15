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

import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.Node;

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
    }
    
    public void defaultOut(Node node) {
        space();
        sb.append(')');
        sb.append('\n');
        depth--;
    }
    
    public void print() {
        System.out.println(sb);
    }
    
    private void space() {
        for (int i = 0; i < depth; i++) {
            sb.append(' ');
        }
    }
}
