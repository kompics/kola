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
import com.sun.codemodel.JType;
import com.sun.codemodel.JVar;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AIdVariableDeclarator;
import se.sics.kola.node.AInitializerVariableDeclarator;
import se.sics.kola.node.AVariableDeclaratorId;

/**
 *
 * @author lkroll
 */
public class VarDeclAdapter extends DepthFirstAdapter {
    private final ResolutionContext context;
    private final VariableScope scope;
    private JType type;
    private final int mods;
    
    VarDeclAdapter(int mods, JType type, ResolutionContext context, VariableScope scope) {
        this.context = context;
        this.scope = scope;
        this.type = type;
        this.mods = mods;
    }
    
    @Override
    public void caseAIdVariableDeclarator(AIdVariableDeclarator node) {
        AVariableDeclaratorId declId = (AVariableDeclaratorId) node.getVariableDeclaratorId();
        String name = declId.getIdentifier().getText();
        for (int i = 0; i < declId.getDim().size(); i++) {
            type = type.array();
        }
        JVar v = scope.declare(mods, type, name, null);
    }
    
    @Override
    public void caseAInitializerVariableDeclarator(AInitializerVariableDeclarator node) {
        AVariableDeclaratorId declId = (AVariableDeclaratorId) node.getVariableDeclaratorId();
        String name = declId.getIdentifier().getText();
        for (int i = 0; i < declId.getDim().size(); i++) {
            type = type.array();
        }
        VarInitAdapter via = new VarInitAdapter(context);
        node.getVariableInitializer().apply(via);
        scope.declare(mods, type, name, via.expr);
    }
    
    public static interface VariableScope {
        JVar declare(int mods, JType type, String name, JExpression init);
    }
}
