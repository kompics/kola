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

import com.sun.codemodel.JCase;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JSwitch;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AConstantNameSwitchLabel;
import se.sics.kola.node.AConstantSwitchLabel;
import se.sics.kola.node.ADefaultSwitchLabel;
import se.sics.kola.node.AName;
import se.sics.kola.sourcegen.ExpressionAdapter.JExprParent;
import static se.sics.kola.sourcegen.Util.nameToString;

/**
 *
 * @author lkroll
 */
class SwitchLabelAdapter extends DepthFirstAdapter {

    private final ResolutionContext context;
    private final JSwitch _switch;

    JCase _case;

    SwitchLabelAdapter(JSwitch _switch, ResolutionContext context) {
        this.context = context;
        this._switch = _switch;
    }

    @Override
    public void caseAConstantSwitchLabel(AConstantSwitchLabel node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getCase().apply(ea);
        _case = _switch._case(ea.expr);
    }

    @Override
    public void caseAConstantNameSwitchLabel(AConstantNameSwitchLabel node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getCase().apply(ea);
        if (ea.expr == null) { // if it couldn't resolve it, it's probably an enum field
            AName aname = (AName) node.getCase();
            _case = _switch._case(JExpr.ref(nameToString(aname)));
        } else {
            _case = _switch._case(ea.expr);
        }
    }

    @Override
    public void caseADefaultSwitchLabel(ADefaultSwitchLabel node) {
        _case = _switch._default();
    }
}
