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

import com.sun.codemodel.JArray;
import com.sun.codemodel.JAssignmentTarget;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JExpressionStatement;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JOp;
import com.sun.codemodel.JType;
import java.util.LinkedList;
import se.sics.kola.Logger;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AAndExpressionNoName;
import se.sics.kola.node.AArrayAccess;
import se.sics.kola.node.AArrayInitializer;
import se.sics.kola.node.AAssignmentExpressionNoName;
import se.sics.kola.node.ACandExpressionNoName;
import se.sics.kola.node.AClassArrayCreationExpression;
import se.sics.kola.node.AClassExpressionNoName;
import se.sics.kola.node.AClassFieldAccess;
import se.sics.kola.node.AClassInitializerArrayCreationExpression;
import se.sics.kola.node.AClassMethodInvocation;
import se.sics.kola.node.AClassName;
import se.sics.kola.node.ACorExpressionNoName;
import se.sics.kola.node.ADiamondTypeArgumentsOrDiamond;
import se.sics.kola.node.ADivExpressionNoName;
import se.sics.kola.node.AEmarkExpressionNoName;
import se.sics.kola.node.AEorExpressionNoName;
import se.sics.kola.node.AEqExpressionNoName;
import se.sics.kola.node.AGtExpressionNoName;
import se.sics.kola.node.AGteqExpressionNoName;
import se.sics.kola.node.AInstanceofExpressionNoName;
import se.sics.kola.node.AIorExpressionNoName;
import se.sics.kola.node.ALiteralExpressionNoName;
import se.sics.kola.node.ALtExpressionNoName;
import se.sics.kola.node.ALteqExpressionNoName;
import se.sics.kola.node.AMethodMethodInvocation;
import se.sics.kola.node.AMinusExpressionNoName;
import se.sics.kola.node.AModExpressionNoName;
import se.sics.kola.node.AMulExpressionNoName;
import se.sics.kola.node.AName;
import se.sics.kola.node.ANameExpression;
import se.sics.kola.node.ANeqExpressionNoName;
import se.sics.kola.node.ANewClassInstanceCreationExpression;
import se.sics.kola.node.APcastExpressionNoName;
import se.sics.kola.node.APlusExpressionNoName;
import se.sics.kola.node.APostDecrExpressionNoName;
import se.sics.kola.node.APostIncExpressionNoName;
import se.sics.kola.node.APreDecrExpressionNoName;
import se.sics.kola.node.APreIncExpressionNoName;
import se.sics.kola.node.APrimaryFieldAccess;
import se.sics.kola.node.APrimaryMethodInvocation;
import se.sics.kola.node.APrimitiveArrayCreationExpression;
import se.sics.kola.node.APrimitiveInitializerArrayCreationExpression;
import se.sics.kola.node.AQmarkExpressionNoName;
import se.sics.kola.node.ARcastExpressionNoName;
import se.sics.kola.node.AShlExpressionNoName;
import se.sics.kola.node.AShrExpressionNoName;
import se.sics.kola.node.ASuperFieldAccess;
import se.sics.kola.node.ASuperMethodInvocation;
import se.sics.kola.node.AThisExpressionNoName;
import se.sics.kola.node.ATildeExpressionNoName;
import se.sics.kola.node.ATypeArgumentsTypeArgumentsOrDiamond;
import se.sics.kola.node.ATypeDeclSpecifier;
import se.sics.kola.node.AUminusExpressionNoName;
import se.sics.kola.node.AUshrExpressionNoName;
import se.sics.kola.node.AVoidExpressionNoName;
import se.sics.kola.node.PArgument;
import se.sics.kola.node.PDimExpr;
import se.sics.kola.node.PVariableInitializer;
import se.sics.kola.sourcegen.ArgumentAdapter.Argumentable;
import static se.sics.kola.sourcegen.Util.nameToString;

/**
 *
 * @author lkroll
 */
public class ExpressionAdapter extends DepthFirstAdapter {

    private final ExpressionParent parent;
    private final ResolutionContext context;
    JExpression expr;

    ExpressionAdapter(ExpressionParent parent, ResolutionContext context) {
        this.parent = parent;
        this.context = context;
    }

    ////////////////////////// Assignment ///////////////////////////
    @Override
    public void caseAAssignmentExpressionNoName(AAssignmentExpressionNoName node) {
        LHSAdapter lhsa = new LHSAdapter(context);
        node.getLeftHandSide().apply(lhsa);
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getExpression().apply(ea);
        AssignOpAdapter aoa = new AssignOpAdapter(parent, context, lhsa.expr, ea.expr);
        node.getAssignmentOperator().apply(aoa);
        expr = aoa.expr;
    }

    ////////////////////////// Method Invocation ///////////////////////////
    @Override
    public void caseAMethodMethodInvocation(AMethodMethodInvocation node) {
        //String name = nameToString(node.getName());
        JInvocation inv = context.resolveInvocation((AName) node.getName(), parent);
        Argumentable ia = new InvocationArgumentable(inv);
        expr = inv;
        for (PArgument arg : node.getArgument()) {
            ArgumentAdapter aa = new ArgumentAdapter(ia, context);
            arg.apply(aa);
        }
    }

    @Override
    public void caseAPrimaryMethodInvocation(APrimaryMethodInvocation node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getExpressionNoName().apply(ea);
        JExpression lhs = ea.expr;
        JInvocation inv = parent.invoke(lhs, node.getIdentifier().getText());
        if (!node.getNonWildTypeArguments().isEmpty()) {
            Logger.error(node.getIdentifier(), "CodeModel does not support type arguments for methods, yet. Ignoring...");
        }
        Argumentable ia = new InvocationArgumentable(inv);
        for (PArgument arg : node.getArgument()) {
            ArgumentAdapter aa = new ArgumentAdapter(ia, context);
            arg.apply(aa);
        }
        expr = inv;
    }

    @Override
    public void caseASuperMethodInvocation(ASuperMethodInvocation node) {
        JInvocation inv = JExpr._super().invoke(node.getIdentifier().getText());
        if (!node.getNonWildTypeArguments().isEmpty()) {
            Logger.error(node.getIdentifier(), "CodeModel does not support type arguments for methods, yet. Ignoring...");
        }
        Argumentable ia = new InvocationArgumentable(inv);
        for (PArgument arg : node.getArgument()) {
            ArgumentAdapter aa = new ArgumentAdapter(ia, context);
            arg.apply(aa);
        }
        expr = inv;
    }

    @Override
    public void caseAClassMethodInvocation(AClassMethodInvocation node) {
        AClassName acname = (AClassName) node.getClassName();
        String name = nameToString(acname.getName());
        try {
            JClass jc = context.resolveType(name);
            JExpression jcs = JExpr.dotsuper(jc);
            JInvocation inv = jcs.invoke(node.getIdentifier().getText());
            Argumentable ia = new InvocationArgumentable(inv);
            for (PArgument arg : node.getArgument()) {
                ArgumentAdapter aa = new ArgumentAdapter(ia, context);
                arg.apply(aa);
            }
            expr = inv;
        } catch (ClassNotFoundException ex) {
            AName aname = (AName) acname.getName();
            Logger.error(aname.getIdentifier().peekFirst(), "Could not find type: " + name);
        }
    }

    ////////////////////////// Instance Creation ///////////////////////////
    @Override
    public void caseANewClassInstanceCreationExpression(ANewClassInstanceCreationExpression node) {
        // ****** BEGIN SPEC *******
        ATypeDeclSpecifier spec = (ATypeDeclSpecifier) node.getTypeDeclSpecifier();
        AName firstName = (AName) spec.getName();
        JClass ctype;
        try {
            ctype = context.resolveType(nameToString(firstName));
        } catch (ClassNotFoundException ex) {
            Logger.error(firstName.getIdentifier().getLast(), "Could not resolve type!");
            return;
        }
        LinkedList<Util.IdWithOptArgs> list = Util.shiftTDS(spec, context);
        Util.IdWithOptArgs cur = list.pollFirst();
        while ((cur != null) && (cur.args == null)) {
            cur = list.pollFirst();
        }
        if (cur != null) {
            TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context, ctype);
            cur.args.apply(tpa);
        }
        for (Util.IdWithOptArgs iwoa : list) {
            String cname = ctype.fullName() + "." + iwoa.id.getText(); // losing the generics again here...I don't see any way around this
            try {
                ctype = context.resolveType(cname);
            } catch (ClassNotFoundException ex) {
                Logger.error("Couldn't resolve type: " + cname);
            }
            if (iwoa.args != null) {
                TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context, ctype);
                iwoa.args.apply(tpa);
            }
        }
        // ****** END SPEC *******
        if (node.getTypeArgumentsOrDiamond() != null) {
            TypeDiamondAdapter tda = new TypeDiamondAdapter(ctype);
            node.getTypeArgumentsOrDiamond().apply(tda);
            ctype = tda.ctype;
        }
        // ***** ANON *****
        if (node.getClassBody() != null) {
            JDefinedClass jdclass = context.unit.anonymousClass(ctype);
            ClassBodyAdapter cba = new ClassBodyAdapter(context, jdclass);
            node.getClassBody().apply(cba);
            ctype = jdclass;
        }
        // ***** ARGS *******
        JInvocation inv = JExpr._new(ctype);
        Argumentable ia = new InvocationArgumentable(inv);
        expr = inv;
        for (PArgument arg : node.getArgument()) {
            ArgumentAdapter aa = new ArgumentAdapter(ia, context);
            arg.apply(aa);
        }
    }

    @Override
    public void caseAClassInitializerArrayCreationExpression(AClassInitializerArrayCreationExpression node) {
        TypeAdapter ta = new TypeAdapter(context);
        node.getClassOrInterfaceType().apply(ta);
        int dim = node.getDim().size();
        JType type = ta.type;
        for (int i = 0; i < dim; i++) {
            type = type.array();
        }
        JInvocation inv = JExpr._new(type);
        AArrayInitializer inits = (AArrayInitializer) node.getArrayInitializer();
        for (PVariableInitializer init : inits.getVariableInitializer()) {
            VarInitAdapter via = new VarInitAdapter(context);
            init.apply(via);
            inv.arg(via.expr);
        }
        expr = inv;
    }

    @Override
    public void caseAPrimitiveInitializerArrayCreationExpression(APrimitiveInitializerArrayCreationExpression node) {
        TypeAdapter ta = new TypeAdapter(context);
        node.getPrimitiveType().apply(ta);
        int dim = node.getDim().size();
        JType type = ta.type;
        for (int i = 0; i < dim; i++) {
            type = type.array();
        }
        JInvocation inv = JExpr._new(type);
        AArrayInitializer inits = (AArrayInitializer) node.getArrayInitializer();
        for (PVariableInitializer init : inits.getVariableInitializer()) {
            VarInitAdapter via = new VarInitAdapter(context);
            init.apply(via);
            inv.arg(via.expr);
        }
        expr = inv;
    }

    @Override
    public void caseAClassArrayCreationExpression(AClassArrayCreationExpression node) {
        TypeAdapter ta = new TypeAdapter(context);
        node.getClassOrInterfaceType().apply(ta);
        int dim = node.getDim().size();
        JType type = ta.type;
        for (int i = 0; i < dim; i++) {
            type = type.array();
        }
        JArray arr = JExpr.newArray(type);
        for (PDimExpr dexp : node.getDimExpr()) {
            ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
            dexp.apply(ea);
            arr.addSize(ea.expr);
        }
        expr = arr;
    }

    @Override
    public void caseAPrimitiveArrayCreationExpression(APrimitiveArrayCreationExpression node) {
        TypeAdapter ta = new TypeAdapter(context);
        node.getPrimitiveType().apply(ta);
        int dim = node.getDim().size();
        JType type = ta.type;
        for (int i = 0; i < dim; i++) {
            type = type.array();
        }
        JArray arr = JExpr.newArray(type);
        for (PDimExpr dexp : node.getDimExpr()) {
            ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
            dexp.apply(ea);
            arr.addSize(ea.expr);
        }
        expr = arr;
    }

    ////////////////////////// Arithmetics ///////////////////////////
    @Override
    public void caseAUminusExpressionNoName(AUminusExpressionNoName node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getExpression().apply(ea);
        expr = ea.expr.minus();
    }

    @Override
    public void caseAPlusExpressionNoName(APlusExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.plus(eaRight.expr);
    }

    @Override
    public void caseAMinusExpressionNoName(AMinusExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.minus(eaRight.expr);
    }

    @Override
    public void caseAMulExpressionNoName(AMulExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.mul(eaRight.expr);
    }

    @Override
    public void caseADivExpressionNoName(ADivExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.div(eaRight.expr);
    }

    @Override
    public void caseAModExpressionNoName(AModExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.mod(eaRight.expr);
    }

    @Override
    public void caseAPostIncExpressionNoName(APostIncExpressionNoName node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getExpression().apply(ea);
        expr = ea.expr.incr();
    }

    @Override
    public void caseAPostDecrExpressionNoName(APostDecrExpressionNoName node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getExpression().apply(ea);
        expr = ea.expr.decr();
    }

    @Override
    public void caseAPreIncExpressionNoName(APreIncExpressionNoName node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getExpression().apply(ea);
        expr = ea.expr.preincr();
    }

    @Override
    public void caseAPreDecrExpressionNoName(APreDecrExpressionNoName node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getExpression().apply(ea);
        expr = ea.expr.predecr();
    }

    ////////////////////////// Bitwise ///////////////////////////
    @Override
    public void caseAShrExpressionNoName(AShrExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.shr(eaRight.expr);
    }

    @Override
    public void caseAShlExpressionNoName(AShlExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.shl(eaRight.expr);
    }

    @Override
    public void caseAUshrExpressionNoName(AUshrExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.shrz(eaRight.expr);
    }

    @Override
    public void caseATildeExpressionNoName(ATildeExpressionNoName node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getExpression().apply(ea);
        expr = ea.expr.complement();
    }

    @Override
    public void caseAIorExpressionNoName(AIorExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.bor(eaRight.expr);
    }

    @Override
    public void caseAEorExpressionNoName(AEorExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.xor(eaRight.expr);
    }

    @Override
    public void caseAAndExpressionNoName(AAndExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.band(eaRight.expr);
    }

    ////////////////////////// Boolean ///////////////////////////
    @Override
    public void caseAEmarkExpressionNoName(AEmarkExpressionNoName node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getExpression().apply(ea);
        expr = ea.expr.not();
    }

    @Override
    public void caseACandExpressionNoName(ACandExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.cand(eaRight.expr);
    }

    @Override
    public void caseACorExpressionNoName(ACorExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.cor(eaRight.expr);
    }

    @Override
    public void caseAQmarkExpressionNoName(AQmarkExpressionNoName node) {
        ExpressionAdapter eaCond = new ExpressionAdapter(new JExprParent(), context);
        node.getCond().apply(eaCond);
        ExpressionAdapter eaTrue = new ExpressionAdapter(new JExprParent(), context);
        node.getTrue().apply(eaTrue);
        ExpressionAdapter eaFalse = new ExpressionAdapter(new JExprParent(), context);
        node.getFalse().apply(eaFalse);
        expr = JOp.cond(eaCond.expr, eaTrue.expr, eaFalse.expr);
    }

    ////////////////////////// Casts ///////////////////////////
    @Override
    public void caseAPcastExpressionNoName(APcastExpressionNoName node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getExpression().apply(ea);
        TypeAdapter ta = new TypeAdapter(context);
        node.getTarget().apply(ta);
        expr = JExpr.cast(ta.type, ea.expr);
    }

    @Override
    public void caseARcastExpressionNoName(ARcastExpressionNoName node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getExpression().apply(ea);
        TypeAdapter ta = new TypeAdapter(context);
        node.getTarget().apply(ta);
        expr = JExpr.cast(ta.type, ea.expr);
    }

    ////////////////////////// Relations ///////////////////////////
    @Override
    public void caseAEqExpressionNoName(AEqExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.eq(eaRight.expr);
    }

    @Override
    public void caseANeqExpressionNoName(ANeqExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.ne(eaRight.expr);
    }

    @Override
    public void caseALtExpressionNoName(ALtExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.lt(eaRight.expr);
    }

    @Override
    public void caseAGtExpressionNoName(AGtExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.gt(eaRight.expr);
    }

    @Override
    public void caseALteqExpressionNoName(ALteqExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.lte(eaRight.expr);
    }

    @Override
    public void caseAGteqExpressionNoName(AGteqExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        ExpressionAdapter eaRight = new ExpressionAdapter(new JExprParent(), context);
        node.getRight().apply(eaRight);
        expr = eaLeft.expr.gte(eaRight.expr);
    }

    @Override
    public void caseAInstanceofExpressionNoName(AInstanceofExpressionNoName node) {
        ExpressionAdapter eaLeft = new ExpressionAdapter(new JExprParent(), context);
        node.getLeft().apply(eaLeft);
        TypeAdapter ta = new TypeAdapter(context);
        node.getRight().apply(ta);
        expr = eaLeft.expr._instanceof(ta.type);
    }

    ////////////////////////// Expression ///////////////////////////
    @Override
    public void caseANameExpression(ANameExpression node) {
        expr = context.resolveField((AName) node.getName());
    }

    ////////////////////////// Literal ///////////////////////////
    @Override
    public void caseALiteralExpressionNoName(ALiteralExpressionNoName node) {
        LiteralAdapter la = new LiteralAdapter();
        node.getLiteral().apply(la);
        expr = la.expr;
    }

    ////////////////////////// Access ///////////////////////////
    @Override
    public void caseAThisExpressionNoName(AThisExpressionNoName node) {
        expr = JExpr._this();
    }

    @Override
    public void caseAClassExpressionNoName(AClassExpressionNoName node) {
        AClassName acn = (AClassName) node.getClassName();
        AName aname = (AName) acn.getName();
        String cname = nameToString(aname);
        try {
            JClass jc = context.resolveType(cname);
            expr = JExpr.dotthis(jc);
        } catch (ClassNotFoundException ex) {
            Logger.error(aname.getIdentifier().getFirst(), "Could not resolve type: " + cname);
        }
    }

    @Override
    public void caseAVoidExpressionNoName(AVoidExpressionNoName node) {
        JClass jc = context.unit.VOID.boxify();
        expr = JExpr.dotclass(jc);
    }

    @Override
    public void caseAPrimaryFieldAccess(APrimaryFieldAccess node) {
        ExpressionAdapter ea = new ExpressionAdapter(new JExprParent(), context);
        node.getExpressionNoName().apply(ea);
        expr = ea.expr.ref(node.getIdentifier().getText());
    }

    @Override
    public void caseASuperFieldAccess(ASuperFieldAccess node) {
        expr = JExpr._super().ref(node.getIdentifier().getText());
    }

    @Override
    public void caseAClassFieldAccess(AClassFieldAccess node) {
        AClassName acn = (AClassName) node.getClassName();
        AName aname = (AName) acn.getName();
        String cname = nameToString(aname);
        try {
            JClass jc = context.resolveType(cname);
            expr = jc.staticRef(node.getIdentifier().getText());
        } catch (ClassNotFoundException ex) {
            Logger.error(aname.getIdentifier().getFirst(), "Could not resolve type: " + cname);
        }
    }

    @Override
    public void caseAArrayAccess(AArrayAccess node) {
        ExpressionAdapter eaArray = new ExpressionAdapter(new JExprParent(), context);
        node.getArray().apply(eaArray);
        ExpressionAdapter eaField = new ExpressionAdapter(new JExprParent(), context);
        node.getField().apply(eaField);
        expr = eaArray.expr.component(eaField.expr);
    }

    private class TypeDiamondAdapter extends DepthFirstAdapter {

        JClass ctype;

        TypeDiamondAdapter(JClass ctype) {
            this.ctype = ctype;
        }

        @Override
        public void caseATypeArgumentsTypeArgumentsOrDiamond(ATypeArgumentsTypeArgumentsOrDiamond node) {
            TypeArgumentsAdapter tpa = new TypeArgumentsAdapter(context, ctype);
            node.getTypeArguments().apply(tpa);
        }

        @Override
        public void caseADiamondTypeArgumentsOrDiamond(ADiamondTypeArgumentsOrDiamond node) {
            Logger.error("Diamond operator not yet supported by CodeModel. Ignoring...");
        }
    }

    public static interface ExpressionParent {

        public JInvocation invoke(JExpression lhs, String method);

        public JInvocation invoke(String method);

        public void addInvocation(JInvocation invoc);

        public void addStatement(JExpressionStatement stmt);

        public JExpressionStatement assign(JAssignmentTarget lhs, JExpression rhs);
    }

    static class JExprParent implements ExpressionParent {

        @Override
        public JInvocation invoke(String method) {
            return JExpr.invoke(method);
        }

        @Override
        public JInvocation invoke(JExpression lhs, String method) {
            return JExpr.invoke(lhs, method);
        }

        @Override
        public void addInvocation(JInvocation invoc) {
            // ignore
        }

        @Override
        public JExpressionStatement assign(JAssignmentTarget lhs, JExpression rhs) {
            return JExpr.assign(lhs, rhs);
        }

        @Override
        public void addStatement(JExpressionStatement stmt) {
            // ignore
        }

    }

    static class InvocationArgumentable implements Argumentable {

        private final JInvocation invocation;

        InvocationArgumentable(JInvocation invocation) {
            this.invocation = invocation;
        }

        @Override
        public Argumentable arg(JExpression expr) {
            invocation.arg(expr);
            return this;
        }

    }
}
