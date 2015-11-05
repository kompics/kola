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

import com.sun.codemodel.JTryBlock;
import com.sun.codemodel.JVar;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AResource;
import se.sics.kola.node.AVariableDeclaratorId;
import se.sics.kola.sourcegen.ExpressionAdapter.JExprParent;

/**
 *
 * @author lkroll
 */
public class ResourceAdapter extends DepthFirstAdapter {

    private final ResolutionContext context;
    private final JTryBlock _try;

    ResourceAdapter(JTryBlock _try, ResolutionContext context) {
        this._try = _try;
        this.context = context;
    }

    @Override
    public void caseAResource(AResource node) {
        FieldModifierAdapter fma = new FieldModifierAdapter(context);
        node.apply(fma);
        int mods = fma.getMods();
        TypeAdapter ta = new TypeAdapter(context);
        node.apply(ta);

        AVariableDeclaratorId avdid = (AVariableDeclaratorId) node.getVariableDeclaratorId();
        String id = avdid.getIdentifier().getText();
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.apply(ea);
        JVar res = _try.resource(mods, ta.type, id, ea.expr);
        context.addField(id, res, Field.Type.NORMAL);
    }
}
