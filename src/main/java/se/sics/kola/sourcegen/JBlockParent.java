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
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JExpressionStatement;
import com.sun.codemodel.JInvocation;

/**
 *
 * @author lkroll
 */
class JBlockParent implements StatementAdapter.StatementParent {

    private final JBlock block;

    public JBlockParent(JBlock block) {
        this.block = block;
    }

    @Override
    public JInvocation invoke(String method) {
        return block.invoke(method);
    }

    @Override
    public void addInvocation(JInvocation invoc) {
        block.add(invoc);
    }

    @Override
    public JInvocation invoke(JExpression lhs, String method) {
        return block.invoke(lhs, method);
    }

    @Override
    public void _return() {
        block._return();
    }

    @Override
    public void _return(JExpression expr) {
        block._return(expr);
    }

    @Override
    public JExpressionStatement assign(JAssignmentTarget lhs, JExpression rhs) {
        block.assign(lhs, rhs);
        return null;
    }

    @Override
    public void addStatement(JExpressionStatement stmt) {
        block.add(stmt);
    }

}
