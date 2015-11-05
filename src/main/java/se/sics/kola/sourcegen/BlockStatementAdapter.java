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

import com.sun.codemodel.JBlock;
import se.sics.kola.Logger;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AClassBlockStatement;
import se.sics.kola.node.ALocalVariableDeclaration;
import se.sics.kola.node.AStatementBlockStatement;
import se.sics.kola.node.AVariableBlockStatement;
import se.sics.kola.node.PModifier;
import se.sics.kola.node.PVariableDeclarator;

/**
 *
 * @author lkroll
 */
public class BlockStatementAdapter extends DepthFirstAdapter {

    protected final ResolutionContext context;
    protected final JBlock block;
    private final JBlockParent blockParent;

    BlockStatementAdapter(ResolutionContext context, JBlock block) {
        this.context = context;
        this.block = block;
        blockParent = new JBlockParent(block, context);
    }

    @Override
    public void caseAStatementBlockStatement(AStatementBlockStatement node) {
        StatementAdapter sa = new StatementAdapter(blockParent, context);
        node.getStatement().apply(sa);
    }

    @Override
    public void caseAVariableBlockStatement(AVariableBlockStatement node) {
        ALocalVariableDeclaration decl = (ALocalVariableDeclaration) node.getLocalVariableDeclaration();
        final FieldModifierAdapter fma = new FieldModifierAdapter(context);
        for (PModifier mod : decl.getModifier()) {
            mod.apply(fma);
        }
        final TypeAdapter ta = new TypeAdapter(context);
        decl.getType().apply(ta);
        VarDeclAdapter vda = new VarDeclAdapter(fma.getMods(), ta.type, context, blockParent);
        for (PVariableDeclarator declor : decl.getVariableDeclarator()) {
            declor.apply(vda);
        }
    }

    @Override
    public void caseAClassBlockStatement(AClassBlockStatement node) {
        Logger.error("JCodeModel doesn't support block class declarations, yet. Your class will be created in the block's parent class instead.");
        TypeDeclarationAdapter ca = new TypeDeclarationAdapter(context);
        node.apply(ca);
    }
}
