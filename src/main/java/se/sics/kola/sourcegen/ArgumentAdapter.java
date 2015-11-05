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

import com.sun.codemodel.JExpression;
import se.sics.kola.Logger;
import se.sics.kola.PrintAdapter;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AExpressionArgument;
import se.sics.kola.node.ANameArgument;
import se.sics.kola.sourcegen.ExpressionAdapter.JExprParent;

/**
 *
 * @author lkroll
 */
public class ArgumentAdapter extends DepthFirstAdapter {

    private final Argumentable invocation;
    private final ResolutionContext context;

    ArgumentAdapter(Argumentable invocation, ResolutionContext context) {
        this.invocation = invocation;
        this.context = context;
    }
    
    @Override
    public void caseANameArgument(ANameArgument node) {
        Field f = context.resolveField(node.getName());
        invocation.arg(f.var);
    }
    
    @Override
    public void caseAExpressionArgument(AExpressionArgument node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getExpressionNoName().apply(ea);
        if (ea.expr == null) {
            PrintAdapter pa = new PrintAdapter();
            node.getExpressionNoName().apply(pa);
            Logger.error("Couldn't generate expression from this subtree:\n"+pa.toString());
            System.exit(1);
        }
        invocation.arg(ea.expr);
    }
    
    static interface Argumentable {
        public Argumentable arg(JExpression expr);
    }
}
