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

import com.google.common.base.Optional;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JCase;
import com.sun.codemodel.JConditional;
import com.sun.codemodel.JDoLoop;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JForEach;
import com.sun.codemodel.JForLoop;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JLabel;
import com.sun.codemodel.JStatement;
import com.sun.codemodel.JSwitch;
import com.sun.codemodel.JSynchronized;
import com.sun.codemodel.JTryBlock;
import com.sun.codemodel.JType;
import com.sun.codemodel.JWhileLoop;
import java.util.LinkedList;
import se.sics.kola.Logger;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.ABlockStatementWithoutTrailingSubstatement;
import se.sics.kola.node.ABreakStatement;
import se.sics.kola.node.ACatchTryStatement;
import se.sics.kola.node.AConnectStatement;
import se.sics.kola.node.AContinueStatement;
import se.sics.kola.node.ADisconnectStatement;
import se.sics.kola.node.ADoStatement;
import se.sics.kola.node.AEnhancedForStatement;
import se.sics.kola.node.AExpressionBasicForStatement;
import se.sics.kola.node.AExpressionReturnStatement;
import se.sics.kola.node.AFinallyTryStatement;
import se.sics.kola.node.AFormalParameter;
import se.sics.kola.node.AIfThenElseStatement;
import se.sics.kola.node.AIfThenStatement;
import se.sics.kola.node.ALabeledStatement;
import se.sics.kola.node.ANameBasicForStatement;
import se.sics.kola.node.AResourceSpecification;
import se.sics.kola.node.AResourcesTryStatement;
import se.sics.kola.node.AStatementExpression;
import se.sics.kola.node.ASubscribeStatement;
import se.sics.kola.node.ASwitchBlock;
import se.sics.kola.node.ASwitchBlockStatementGroup;
import se.sics.kola.node.ASwitchStatement;
import se.sics.kola.node.ASynchronizedStatement;
import se.sics.kola.node.AThrowStatement;
import se.sics.kola.node.ATriggerStatement;
import se.sics.kola.node.ATryWithResourcesStatement;
import se.sics.kola.node.AUnsubscribeStatement;
import se.sics.kola.node.AVariableDeclaratorId;
import se.sics.kola.node.AVoidReturnStatement;
import se.sics.kola.node.AWhileStatement;
import se.sics.kola.node.Node;
import se.sics.kola.node.PBlock;
import se.sics.kola.node.PBlockStatement;
import se.sics.kola.node.PCatchClause;
import se.sics.kola.node.PFinally;
import se.sics.kola.node.PForInit;
import se.sics.kola.node.PForUpdate;
import se.sics.kola.node.PResource;
import se.sics.kola.node.PResourceSpecification;
import se.sics.kola.node.PStatement;
import se.sics.kola.node.PSwitchBlockStatementGroup;
import se.sics.kola.node.PSwitchLabel;
import se.sics.kola.sourcegen.ExpressionAdapter.ExpressionParent;
import se.sics.kola.sourcegen.ExpressionAdapter.JExprParent;
import se.sics.kola.sourcegen.TypeDeclarationAdapter.FormalParameter;

/**
 *
 * @author lkroll
 */
public class StatementAdapter extends DepthFirstAdapter {

    private final StatementParent parent;
    private final ResolutionContext context;

    StatementAdapter(StatementParent parent, ResolutionContext context) {
        this.parent = parent;
        this.context = context;
    }

    @Override
    public void caseAStatementExpression(AStatementExpression node) {
        ExpressionAdapter ea = new ExpressionAdapter(parent, context);
        node.getExpressionNoName().apply(ea);
    }

    @Override
    public void caseAExpressionReturnStatement(AExpressionReturnStatement node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getReturnValue().apply(ea);
        parent._return(ea.expr);
    }

    @Override
    public void caseAVoidReturnStatement(AVoidReturnStatement node) {
        parent._return();
    }

    @Override
    public void caseABlockStatementWithoutTrailingSubstatement(ABlockStatementWithoutTrailingSubstatement node) {
        JBlock block = parent.addSubBlock();
        context.pushStatementScope();
        try {
            BlockStatementAdapter bsa = new BlockStatementAdapter(context, block);
            node.apply(bsa);
        } finally {
            context.popScope();
        }
    }

    @Override
    public void caseALabeledStatement(ALabeledStatement node) {
        String labelName = node.getIdentifier().getText();
        JLabel label = parent.createLabel(labelName);
        context.pushStatementScope();
        try {
            context.addLabel(labelName, label);
            StatementAdapter sa = new StatementAdapter(parent, context);
            node.getStatement().apply(sa);
        } finally {
            context.popScope();
        }
    }

    @Override
    public void caseAIfThenStatement(AIfThenStatement node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getCond().apply(ea);
        JConditional cond = parent._if(ea.expr);
        JBlock tmpBlock = new JBlock();
        StatementAdapter sa = new StatementAdapter(new JBlockParent(tmpBlock, context), context);
        node.getThen().apply(sa);
        JStatement stmt = (JStatement) tmpBlock.getContents().get(0);
        if (stmt instanceof JBlock) {
            JBlock stmtBlock = (JBlock) stmt;
            stmtBlock.setNewlineRequired(false);
        }
        cond.setThen(stmt);
    }

    @Override
    public void caseAIfThenElseStatement(AIfThenElseStatement node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getCond().apply(ea);
        JConditional cond = parent._if(ea.expr);

        // THEN
        JBlock tmpBlock = new JBlock();
        StatementAdapter sa = new StatementAdapter(new JBlockParent(tmpBlock, context), context);
        node.getThen().apply(sa);
        JStatement stmt = (JStatement) tmpBlock.getContents().get(0);
        if (stmt instanceof JBlock) {
            JBlock stmtBlock = (JBlock) stmt;
            stmtBlock.setNewlineRequired(false);
        }
        cond.setThen(stmt);

        // ELSE
        tmpBlock = new JBlock();
        sa = new StatementAdapter(new JBlockParent(tmpBlock, context), context);
        node.getElse().apply(sa);
        stmt = (JStatement) tmpBlock.getContents().get(0);
        if (stmt instanceof JBlock) {
            JBlock stmtBlock = (JBlock) stmt;
            stmtBlock.setNewlineRequired(false);
        }
        cond.setElse(stmt);
    }

    @Override
    public void caseAWhileStatement(AWhileStatement node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getCond().apply(ea);
        JWhileLoop wl = parent._while(ea.expr);
        JBlock tmpBlock = new JBlock();
        StatementAdapter sa = new StatementAdapter(new JBlockParent(tmpBlock, context), context);
        node.getDo().apply(sa);
        JStatement stmt = (JStatement) tmpBlock.getContents().get(0);
        wl.setBody(stmt);
    }

    @Override
    public void caseADoStatement(ADoStatement node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getCond().apply(ea);
        JDoLoop wl = parent._do(ea.expr);
        JBlock tmpBlock = new JBlock();
        StatementAdapter sa = new StatementAdapter(new JBlockParent(tmpBlock, context), context);
        node.getDo().apply(sa);
        JStatement stmt = (JStatement) tmpBlock.getContents().get(0);
        if (stmt instanceof JBlock) {
            JBlock stmtBlock = (JBlock) stmt;
            stmtBlock.setNewlineRequired(false);
        }
        wl.setBody(stmt);
    }

    @Override
    public void caseAExpressionBasicForStatement(AExpressionBasicForStatement node) {
        basicForStatement(node.getInit(), node.getCond(), node.getUpdate(), node.getDo());
    }

    @Override
    public void caseANameBasicForStatement(ANameBasicForStatement node) {
        basicForStatement(node.getInit(), node.getCond(), node.getUpdate(), node.getDo());
    }

    private void basicForStatement(PForInit init, Node cond, PForUpdate update, PStatement _do) {
        context.pushStatementScope();
        try {
            JForLoop loop = parent._for();
            if (init != null) {
                ForInitAdapter fia = new ForInitAdapter(loop, context);
                init.apply(fia);
            }
            if (update != null) {
                ForUpdateAdapter fua = new ForUpdateAdapter(loop, context);
                update.apply(fua);
            }
            if (cond != null) {
                ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
                cond.apply(ea);
                loop.test(ea.expr);
            }
            JBlock tmpBlock = new JBlock();
            StatementAdapter sa = new StatementAdapter(new JBlockParent(tmpBlock, context), context);
            _do.apply(sa);
            JStatement stmt = (JStatement) tmpBlock.getContents().get(0);
            if (stmt instanceof JBlock) {
                JBlock stmtBlock = (JBlock) stmt;
                stmtBlock.setNewlineRequired(false);
            }
            loop.setBody(stmt);
        } finally {
            context.popScope();
        }
    }

    @Override
    public void caseAEnhancedForStatement(AEnhancedForStatement node) {
        context.pushStatementScope();
        try {
            // Formal Parameter
            AFormalParameter paramNode = (AFormalParameter) node.getVariable();
            FormalParameter param = new FormalParameter();
            FieldModifierAdapter fma = new FieldModifierAdapter(context);
            paramNode.apply(fma);
            param.mods = fma.getMods();
            TypeAdapter ta = new TypeAdapter(context);
            paramNode.getType().apply(ta);
            param.type = ta.type;
            AVariableDeclaratorId avdid = (AVariableDeclaratorId) paramNode.getVariableDeclaratorId();
            param.id = avdid.getIdentifier().getText();
            param.dim = avdid.getDim().size();
            

            // Iterable
            ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
            node.getIterable().apply(ea);
            
            JForEach loop = parent.forEach(param.type, param.id, ea.expr);
            context.addField(param.id, loop.var(), Field.Type.NORMAL);

            // Do
            JBlock tmpBlock = new JBlock();
            StatementAdapter sa = new StatementAdapter(new JBlockParent(tmpBlock, context), context);
            node.getDo().apply(sa);
            JStatement stmt = (JStatement) tmpBlock.getContents().get(0);
//        if (stmt instanceof JBlock) {
//            JBlock stmtBlock = (JBlock) stmt;
//            stmtBlock.setNewlineRequired(false);
//        }
            loop.setBody(stmt);
        } finally {
            context.popScope();
        }
    }

    @Override
    public void caseASwitchStatement(ASwitchStatement node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getTarget().apply(ea);
        JSwitch sw = parent._switch(ea.expr);

        ASwitchBlock sblock = (ASwitchBlock) node.getSwitchBlock();
        for (PSwitchBlockStatementGroup pgroup : sblock.getSwitchBlockStatementGroup()) {
            ASwitchBlockStatementGroup agroup = (ASwitchBlockStatementGroup) pgroup;
            JCase lastCase = null;
            for (PSwitchLabel plabel : agroup.getSwitchLabel()) {
                SwitchLabelAdapter sla = new SwitchLabelAdapter(sw, context);
                plabel.apply(sla);
                lastCase = sla._case;
            }
            if (lastCase != null) {
                for (PBlockStatement stmt : agroup.getBlockStatement()) {
                    BlockStatementAdapter bsa = new BlockStatementAdapter(context, lastCase.body());
                    stmt.apply(bsa);
                }
            }
        }
        for (PSwitchLabel plabel : sblock.getSwitchLabel()) {
            SwitchLabelAdapter sla = new SwitchLabelAdapter(sw, context);
            plabel.apply(sla);
        }
    }

    @Override
    public void caseABreakStatement(ABreakStatement node) {
        if (node.getIdentifier() != null) {
            String id = node.getIdentifier().getText();
            Optional<JLabel> olabel = context.resolveLabel(id);
            if (olabel.isPresent()) {
                parent._break(olabel.get());
            } else {
                Logger.error(context.getFile(), node.getIdentifier(), "Couldn't find label for id. Skipping break target.");
                parent._break();
            }
        } else {
            parent._break();
        }
    }

    @Override
    public void caseAContinueStatement(AContinueStatement node) {
        if (node.getIdentifier() != null) {
            String id = node.getIdentifier().getText();
            Optional<JLabel> olabel = context.resolveLabel(id);
            if (olabel.isPresent()) {
                parent._continue(olabel.get());
            } else {
                Logger.error(context.getFile(), node.getIdentifier(), "Couldn't find label for id. Skipping continue target.");
                parent._continue();
            }
        } else {
            parent._continue();
        }
    }

    @Override
    public void caseASynchronizedStatement(ASynchronizedStatement node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getLock().apply(ea);
        JSynchronized syn = parent._synchronized(ea.expr);
        BlockStatementAdapter bsa = new BlockStatementAdapter(context, syn.body());
        node.getBlock().apply(bsa);
    }

    @Override
    public void caseACatchTryStatement(ACatchTryStatement node) {
        tryCatchFinallyStatement(null, node.getBlock(), node.getCatchClause(), null);
    }

    @Override
    public void caseAFinallyTryStatement(AFinallyTryStatement node) {
        tryCatchFinallyStatement(null, node.getBlock(), node.getCatchClause(), node.getFinally());
    }

    private void tryCatchFinallyStatement(PResourceSpecification res, PBlock pblock, LinkedList<PCatchClause> catchClauses, PFinally pFinally) {
        JTryBlock tryBlock = parent._try();
        // Resources
        context.pushStatementScope();
        try {
            if (res != null) {
                AResourceSpecification ares = (AResourceSpecification) res;
                for (PResource r : ares.getResource()) {
                    ResourceAdapter ra = new ResourceAdapter(tryBlock, context);
                    r.apply(ra);
                }
            }
            // TryBlock
            BlockStatementAdapter bsa = new BlockStatementAdapter(context, tryBlock.body());
            pblock.apply(bsa);
            // CatchBlocks
            for (PCatchClause catchClause : catchClauses) {
                CatchClauseAdapter cca = new CatchClauseAdapter(tryBlock, context);
                catchClause.apply(cca);
            }
            if (pFinally != null) {
                BlockStatementAdapter bsaf = new BlockStatementAdapter(context, tryBlock._finally());
                pFinally.apply(bsaf);
            }
        } finally {
            context.popScope();
        }
    }

    @Override
    public void caseAThrowStatement(AThrowStatement node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getThrowable().apply(ea);
        parent._throw(ea.expr);
    }

    @Override
    public void caseAResourcesTryStatement(AResourcesTryStatement node) {
        ATryWithResourcesStatement twrs = (ATryWithResourcesStatement) node.getTryWithResourcesStatement();
        tryCatchFinallyStatement(twrs.getResourceSpecification(), twrs.getBlock(), twrs.getCatchClause(), twrs.getFinally());
    }

    // KOLA
    @Override
    public void caseAConnectStatement(AConnectStatement node) {
        KolaStatementAdapter ksa = new KolaStatementAdapter(context, parent);
        node.apply(ksa);
    }

    @Override
    public void caseADisconnectStatement(ADisconnectStatement node) {
        KolaStatementAdapter ksa = new KolaStatementAdapter(context, parent);
        node.apply(ksa);
    }

    @Override
    public void caseASubscribeStatement(ASubscribeStatement node) {
        KolaStatementAdapter ksa = new KolaStatementAdapter(context, parent);
        node.apply(ksa);
    }

    @Override
    public void caseAUnsubscribeStatement(AUnsubscribeStatement node) {
        KolaStatementAdapter ksa = new KolaStatementAdapter(context, parent);
        node.apply(ksa);
    }

    @Override
    public void caseATriggerStatement(ATriggerStatement node) {
        ExpressionAdapter eaEvent = new ExpressionAdapter(new JExprParent(), context);
        node.getEvent().apply(eaEvent);
        ExpressionAdapter eaPort = new ExpressionAdapter(new JExprParent(), context);
        node.getPort().apply(eaPort);
        JInvocation inv = parent.invoke("trigger");
        inv.arg(eaEvent.expr);
        inv.arg(eaPort.expr);
    }

    public static interface StatementParent extends ExpressionParent {

        public void _return();

        public void _return(JExpression expr);

        public JBlock addSubBlock();

        public JLabel createLabel(String name);

        public JConditional _if(JExpression exp);

        public JWhileLoop _while(JExpression exp);

        public JDoLoop _do(JExpression exp);

        public JForLoop _for();

        public JForEach forEach(JType type, String id, JExpression iterable);

        public JSwitch _switch(JExpression test);

        public void _break();

        public void _break(JLabel label);

        public void _continue();

        public void _continue(JLabel label);

        public JSynchronized _synchronized(JExpression expr);

        public JTryBlock _try();

        public void _throw(JExpression exp);
    }
}
