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

import com.sun.codemodel.JCatchBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JMultiCatchBlock;
import com.sun.codemodel.JTryBlock;
import com.sun.codemodel.JType;
import java.util.ArrayList;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.ACatchClause;
import se.sics.kola.node.ACatchFormalParameter;
import se.sics.kola.node.AVariableDeclaratorId;
import se.sics.kola.node.PClassType;

/**
 *
 * @author lkroll
 */
class CatchClauseAdapter extends DepthFirstAdapter {
    private final ResolutionContext context;
    private final JTryBlock _try;
    
    CatchClauseAdapter(JTryBlock _try, ResolutionContext context) {
        this._try = _try;
        this.context = context;
    }
    
    @Override
    public void caseACatchClause(ACatchClause node) {
        // Formal Parameter
        ACatchFormalParameter paramNode = (ACatchFormalParameter) node.getCatchFormalParameter();
        FieldModifierAdapter fma = new FieldModifierAdapter();
        paramNode.apply(fma);
        int mods = fma.getMods();
        ArrayList<JType> catchTypes = new ArrayList<>();
        for (PClassType pType : paramNode.getCatchTypes()) {
            TypeAdapter ta = new TypeAdapter(context);
            pType.apply(ta);
            catchTypes.add(ta.type);
        }
        AVariableDeclaratorId avdid = (AVariableDeclaratorId) paramNode.getVariableDeclaratorId();
        String id = avdid.getIdentifier().getText();
        if (catchTypes.size() == 1) {
            JCatchBlock cClause = _try._catch((JClass) catchTypes.get(0));
            cClause.param(id);
            BlockStatementAdapter bsa = new BlockStatementAdapter(context, cClause.body());
            node.getBlock().apply(bsa);
        } else {
            JClass[] catchClasses = new JClass[catchTypes.size()];
            for (int i = 0; i < catchTypes.size(); i++) {
                catchClasses[i] = (JClass) catchTypes.get(i);
            }
            JMultiCatchBlock cClause = _try._catch(mods, id, catchClasses);
            BlockStatementAdapter bsa = new BlockStatementAdapter(context, cClause.body());
            node.getBlock().apply(bsa);
        }
    }
}
