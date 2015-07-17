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

import com.sun.codemodel.JInvocation;
import se.sics.kola.ExpressionAdapter.JExprParent;
import static se.sics.kola.Util.nameToString;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AExpressionArgument;
import se.sics.kola.node.ANameArgument;

/**
 *
 * @author lkroll
 */
public class ArgumentAdapter extends DepthFirstAdapter {

    private final JInvocation invocation;
    private final ResolutionContext context;

    ArgumentAdapter(JInvocation invocation, ResolutionContext context) {
        this.invocation = invocation;
        this.context = context;
    }
    
    @Override
    public void caseANameArgument(ANameArgument node) {
        String name = nameToString(node.getName());
        invocation.arg(name);
    }
    
    @Override
    public void caseAExpressionArgument(AExpressionArgument node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getExpressionNoName().apply(ea);
        System.out.println("Error here: " + node.toString());
        invocation.arg(ea.expr);
    }
}
