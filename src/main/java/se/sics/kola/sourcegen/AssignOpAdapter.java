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
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JExpressionStatement;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AAmpAssignAssignmentOperator;
import se.sics.kola.node.AAssignAssignmentOperator;
import se.sics.kola.node.ABarAssignAssignmentOperator;
import se.sics.kola.node.ACaretAssignAssignmentOperator;
import se.sics.kola.node.AMinusAssignAssignmentOperator;
import se.sics.kola.node.APercentAssignAssignmentOperator;
import se.sics.kola.node.APlusAssignAssignmentOperator;
import se.sics.kola.node.AShlAssignAssignmentOperator;
import se.sics.kola.node.AShrAssignAssignmentOperator;
import se.sics.kola.node.ASlashAssignAssignmentOperator;
import se.sics.kola.node.AStarAssignAssignmentOperator;
import se.sics.kola.node.AUshrAssignAssignmentOperator;
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
    JExpressionStatement expr;

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

    @Override
    public void caseAStarAssignAssignmentOperator(AStarAssignAssignmentOperator node) {
        expr = JExpr.assignTimes(lhs, rhs);
        parent.addStatement(expr);
    }

    @Override
    public void caseASlashAssignAssignmentOperator(ASlashAssignAssignmentOperator node) {
        expr = JExpr.assignDivide(lhs, rhs);
        parent.addStatement(expr);
    }

    @Override
    public void caseAPercentAssignAssignmentOperator(APercentAssignAssignmentOperator node) {
        expr = JExpr.assignMod(lhs, rhs);
        parent.addStatement(expr);
    }

    @Override
    public void caseAPlusAssignAssignmentOperator(APlusAssignAssignmentOperator node) {
        expr = JExpr.assignPlus(lhs, rhs);
        parent.addStatement(expr);
    }

    @Override
    public void caseAMinusAssignAssignmentOperator(AMinusAssignAssignmentOperator node) {
        expr = JExpr.assignMinus(lhs, rhs);
        parent.addStatement(expr);
    }

    @Override
    public void caseAShlAssignAssignmentOperator(AShlAssignAssignmentOperator node) {
        expr = JExpr.assignShl(lhs, rhs);
        parent.addStatement(expr);
    }

    @Override
    public void caseAShrAssignAssignmentOperator(AShrAssignAssignmentOperator node) {
        expr = JExpr.assignShr(lhs, rhs);
        parent.addStatement(expr);
    }

    @Override
    public void caseAUshrAssignAssignmentOperator(AUshrAssignAssignmentOperator node) {
        expr = JExpr.assignUshr(lhs, rhs);
        parent.addStatement(expr);
    }

    @Override
    public void caseAAmpAssignAssignmentOperator(AAmpAssignAssignmentOperator node) {
        expr = JExpr.assignAnd(lhs, rhs);
        parent.addStatement(expr);
    }

    @Override
    public void caseACaretAssignAssignmentOperator(ACaretAssignAssignmentOperator node) {
        expr = JExpr.assignXor(lhs, rhs);
        parent.addStatement(expr);
    }

    @Override
    public void caseABarAssignAssignmentOperator(ABarAssignAssignmentOperator node) {
        expr = JExpr.assignOr(lhs, rhs);
        parent.addStatement(expr);
    }
}
