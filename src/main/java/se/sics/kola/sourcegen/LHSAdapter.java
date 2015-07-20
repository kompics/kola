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
import com.sun.codemodel.JClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldRef;
import se.sics.kola.Logger;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AArrayAccess;
import se.sics.kola.node.AClassFieldAccess;
import se.sics.kola.node.AClassName;
import se.sics.kola.node.AExpressionLeftHandSide;
import se.sics.kola.node.AName;
import se.sics.kola.node.APrimaryFieldAccess;
import se.sics.kola.node.ASuperFieldAccess;
import se.sics.kola.sourcegen.ExpressionAdapter.JExprParent;
import static se.sics.kola.sourcegen.Util.nameToString;

/**
 *
 * @author lkroll
 */
public class LHSAdapter extends DepthFirstAdapter {

    private final ResolutionContext context;
    JAssignmentTarget expr;

    LHSAdapter(ResolutionContext context) {
        this.context = context;
    }

    @Override
    public void caseAExpressionLeftHandSide(AExpressionLeftHandSide node) {
        JFieldRef field = context.resolveField((AName) node.getName());
        expr = field;
    }

    @Override
    public void caseAPrimaryFieldAccess(APrimaryFieldAccess node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getExpressionNoName().apply(ea);
        JFieldRef field = ea.expr.ref(node.getIdentifier().getText());
        expr = field;
    }

    @Override
    public void caseASuperFieldAccess(ASuperFieldAccess node) {
        expr = JExpr._super().ref(node.getIdentifier().getText());
    }

    @Override
    public void caseAClassFieldAccess(AClassFieldAccess node) {
        AClassName cn = (AClassName) node.getClassName();
        AName name = (AName) cn.getName();
        String typeName = nameToString(cn.getName());
        try {
            JClass jc = context.resolveType(typeName);
            expr = jc.staticRef(node.getIdentifier().getText());
        } catch (ClassNotFoundException ex) {
            Logger.error(name.getIdentifier().peekFirst(), "Couldn't find type: " + typeName);
        }
    }
    
    @Override
    public void caseAArrayAccess(AArrayAccess node) {
        ExpressionAdapter eaArray = new ExpressionAdapter(new JExprParent(), context);
        node.getArray().apply(eaArray);
        ExpressionAdapter eaField = new ExpressionAdapter(new JExprParent(), context);
        node.getField().apply(eaField);
        expr = JExpr.component(eaArray.expr, eaField.expr);
    }
}
