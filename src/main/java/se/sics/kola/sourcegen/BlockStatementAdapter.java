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

import com.sun.codemodel.ClassType;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JType;
import com.sun.codemodel.JVar;
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

    private final ResolutionContext context;
    private final JBlock block;

    BlockStatementAdapter(ResolutionContext context, JBlock block) {
        this.context = context;
        this.block = block;
    }

    @Override
    public void caseAStatementBlockStatement(AStatementBlockStatement node) {
        StatementAdapter sa = new StatementAdapter(new JBlockParent(block), context);
        node.getStatement().apply(sa);
    }

    @Override
    public void caseAVariableBlockStatement(AVariableBlockStatement node) {
        ALocalVariableDeclaration decl = (ALocalVariableDeclaration) node.getLocalVariableDeclaration();
        final FieldModifierAdapter fma = new FieldModifierAdapter();
        for (PModifier mod : decl.getModifier()) {
            mod.apply(fma);
        }
        final TypeAdapter ta = new TypeAdapter(context);
        decl.getType().apply(ta);
        VarDeclAdapter vda = new VarDeclAdapter(ta.type, context, new VarDeclAdapter.Scope() {

            @Override
            public JVar declare(JType type, String name, JExpression init) {
                return block.decl(fma.getMods(), type, name, init);
            }

        });
        for (PVariableDeclarator declor : decl.getVariableDeclarator()) {
            declor.apply(vda);
        }
    }

    @Override
    public void caseAClassBlockStatement(AClassBlockStatement node) {
        ClassAdapter ca = new ClassAdapter(context, new ClassAdapter.ClassParent() {

            @Override
            public JDefinedClass _class(int mods, String name, ClassType classTypeVal) throws JClassAlreadyExistsException {
                Logger.error("CodeModel does not support local class declaration in blocks, yet.");
                return null;
            }
        });
        node.apply(ca);
    }
}
