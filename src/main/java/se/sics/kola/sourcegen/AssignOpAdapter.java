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

import com.sun.codemodel.JAssignmentTarget;
import com.sun.codemodel.JExpression;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AAssignAssignmentOperator;
import se.sics.kola.sourcegen.ExpressionAdapter.ExpressionParent;

/**
 *
 * @author lkroll
 */
public class AssignOpAdapter extends DepthFirstAdapter {
    
    private final ExpressionParent parent;
    private final ResolutionContext context;
    private final JAssignmentTarget lhs;
    private final JExpression rhs;
    JExpression expr;
    
    AssignOpAdapter(ExpressionParent parent, ResolutionContext context, JAssignmentTarget lhs, JExpression rhs) {
        this.parent = parent;
        this.context = context;
        this.lhs = lhs;
        this.rhs = rhs;
    }
    
    @Override
    public void caseAAssignAssignmentOperator(AAssignAssignmentOperator node) {
        expr = parent.assign(lhs, rhs);
    }
}
