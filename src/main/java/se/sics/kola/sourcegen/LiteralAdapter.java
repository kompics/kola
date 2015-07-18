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

import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import se.sics.kola.Logger;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.ABooleanLiteral;
import se.sics.kola.node.AStringLiteral;

/**
 *
 * @author lkroll
 */
public class LiteralAdapter extends DepthFirstAdapter {

    JExpression expr;

    @Override
    public void caseAStringLiteral(AStringLiteral node) {
        String lit = node.getStringLiteral().getText();
        lit = lit.substring(1, lit.length() - 1); // strip quotes
        expr = JExpr.lit(lit);
    }

    @Override
    public void caseABooleanLiteral(ABooleanLiteral node) {
        if (node.getBooleanLiteral().getText().equalsIgnoreCase("true")) {
            expr = JExpr.TRUE;
        } else if (node.getBooleanLiteral().getText().equalsIgnoreCase("false")) {
            expr = JExpr.FALSE;
        } else {
            Logger.error(node.getBooleanLiteral(), "Not a valid boolean literal: " + node.getBooleanLiteral().getText());
        }
    }
}
