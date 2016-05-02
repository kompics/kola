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
package se.sics.kola.metrics;

import java.util.HashSet;
import se.sics.kola.analysis.AnalysisAdapter;
import se.sics.kola.node.EOF;
import se.sics.kola.node.TAbstractKeyword;
import se.sics.kola.node.TAmp;
import se.sics.kola.node.TAmpAmp;
import se.sics.kola.node.TAmpAssign;
import se.sics.kola.node.TAssertKeyword;
import se.sics.kola.node.TAssign;
import se.sics.kola.node.TAt;
import se.sics.kola.node.TBar;
import se.sics.kola.node.TBarAssign;
import se.sics.kola.node.TBarBar;
import se.sics.kola.node.TBooleanKeyword;
import se.sics.kola.node.TBooleanLiteral;
import se.sics.kola.node.TBreakKeyword;
import se.sics.kola.node.TByteKeyword;
import se.sics.kola.node.TCaret;
import se.sics.kola.node.TCaretAssign;
import se.sics.kola.node.TCaseKeyword;
import se.sics.kola.node.TCatchKeyword;
import se.sics.kola.node.TCharKeyword;
import se.sics.kola.node.TCharacterLiteral;
import se.sics.kola.node.TClassKeyword;
import se.sics.kola.node.TColon;
import se.sics.kola.node.TComma;
import se.sics.kola.node.TComponentKeyword;
import se.sics.kola.node.TComponentdefKeyword;
import se.sics.kola.node.TConnectKeyword;
import se.sics.kola.node.TConstKeyword;
import se.sics.kola.node.TContinueKeyword;
import se.sics.kola.node.TDefaultKeyword;
import se.sics.kola.node.TDisconnectKeyword;
import se.sics.kola.node.TDoKeyword;
import se.sics.kola.node.TDot;
import se.sics.kola.node.TDotDotDot;
import se.sics.kola.node.TDoubleKeyword;
import se.sics.kola.node.TElseKeyword;
import se.sics.kola.node.TEmark;
import se.sics.kola.node.TEnumKeyword;
import se.sics.kola.node.TEq;
import se.sics.kola.node.TEventKeyword;
import se.sics.kola.node.TExtendsKeyword;
import se.sics.kola.node.TFinalKeyword;
import se.sics.kola.node.TFinallyKeyword;
import se.sics.kola.node.TFloatKeyword;
import se.sics.kola.node.TFloatingPointLiteral;
import se.sics.kola.node.TForKeyword;
import se.sics.kola.node.TGotoKeyword;
import se.sics.kola.node.TGt;
import se.sics.kola.node.TGteq;
import se.sics.kola.node.THandleKeyword;
import se.sics.kola.node.THandlerKeyword;
import se.sics.kola.node.TIdentifier;
import se.sics.kola.node.TIfKeyword;
import se.sics.kola.node.TImplementsKeyword;
import se.sics.kola.node.TImportKeyword;
import se.sics.kola.node.TIndicationKeyword;
import se.sics.kola.node.TInitKeyword;
import se.sics.kola.node.TInstanceofKeyword;
import se.sics.kola.node.TIntKeyword;
import se.sics.kola.node.TIntegerLiteral;
import se.sics.kola.node.TInterfaceKeyword;
import se.sics.kola.node.TLBkt;
import se.sics.kola.node.TLBrc;
import se.sics.kola.node.TLPar;
import se.sics.kola.node.TLongKeyword;
import se.sics.kola.node.TLt;
import se.sics.kola.node.TLteq;
import se.sics.kola.node.TMinus;
import se.sics.kola.node.TMinusAssign;
import se.sics.kola.node.TMinusMinus;
import se.sics.kola.node.TNativeKeyword;
import se.sics.kola.node.TNeq;
import se.sics.kola.node.TNewKeyword;
import se.sics.kola.node.TNullLiteral;
import se.sics.kola.node.TPackageKeyword;
import se.sics.kola.node.TPercent;
import se.sics.kola.node.TPercentAssign;
import se.sics.kola.node.TPlus;
import se.sics.kola.node.TPlusAssign;
import se.sics.kola.node.TPlusPlus;
import se.sics.kola.node.TPortKeyword;
import se.sics.kola.node.TPrivateKeyword;
import se.sics.kola.node.TProtectedKeyword;
import se.sics.kola.node.TProvidesKeyword;
import se.sics.kola.node.TPublicKeyword;
import se.sics.kola.node.TQmark;
import se.sics.kola.node.TRArrow;
import se.sics.kola.node.TRBkt;
import se.sics.kola.node.TRBrc;
import se.sics.kola.node.TRPar;
import se.sics.kola.node.TRequestKeyword;
import se.sics.kola.node.TRequiresKeyword;
import se.sics.kola.node.TReturnKeyword;
import se.sics.kola.node.TSemi;
import se.sics.kola.node.TShl;
import se.sics.kola.node.TShlAssign;
import se.sics.kola.node.TShortKeyword;
import se.sics.kola.node.TShr;
import se.sics.kola.node.TShrAssign;
import se.sics.kola.node.TSlash;
import se.sics.kola.node.TSlashAssign;
import se.sics.kola.node.TStar;
import se.sics.kola.node.TStarAssign;
import se.sics.kola.node.TStaticKeyword;
import se.sics.kola.node.TStrictfpKeyword;
import se.sics.kola.node.TStringLiteral;
import se.sics.kola.node.TSubscribeKeyword;
import se.sics.kola.node.TSuperKeyword;
import se.sics.kola.node.TSwitchKeyword;
import se.sics.kola.node.TSynchronizedKeyword;
import se.sics.kola.node.TThisKeyword;
import se.sics.kola.node.TThrowKeyword;
import se.sics.kola.node.TThrowsKeyword;
import se.sics.kola.node.TTilde;
import se.sics.kola.node.TTransientKeyword;
import se.sics.kola.node.TTriggerKeyword;
import se.sics.kola.node.TTryKeyword;
import se.sics.kola.node.TUnsubscribeKeyword;
import se.sics.kola.node.TUshr;
import se.sics.kola.node.TUshrAssign;
import se.sics.kola.node.TVoidKeyword;
import se.sics.kola.node.TVolatileKeyword;
import se.sics.kola.node.TWhileKeyword;

/**
 *
 * @author lkroll
 */
class MetricsAdapter extends AnalysisAdapter {
    
    long operands = 0;
    long operators = 0;
    HashSet<String> distinctOperands = new HashSet<>();
    HashSet<String> distinctOperators = new HashSet<>();
    long loc = 0;
    boolean done = false;
    
    @Override
    public void caseTAbstractKeyword(@SuppressWarnings("unused") TAbstractKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTAssertKeyword(@SuppressWarnings("unused") TAssertKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTBooleanKeyword(@SuppressWarnings("unused") TBooleanKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTBreakKeyword(@SuppressWarnings("unused") TBreakKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTByteKeyword(@SuppressWarnings("unused") TByteKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTCaseKeyword(@SuppressWarnings("unused") TCaseKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTCatchKeyword(@SuppressWarnings("unused") TCatchKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTCharKeyword(@SuppressWarnings("unused") TCharKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTClassKeyword(@SuppressWarnings("unused") TClassKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTConstKeyword(@SuppressWarnings("unused") TConstKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTContinueKeyword(@SuppressWarnings("unused") TContinueKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTDefaultKeyword(@SuppressWarnings("unused") TDefaultKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTDoKeyword(@SuppressWarnings("unused") TDoKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTDoubleKeyword(@SuppressWarnings("unused") TDoubleKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTElseKeyword(@SuppressWarnings("unused") TElseKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTEnumKeyword(@SuppressWarnings("unused") TEnumKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTExtendsKeyword(@SuppressWarnings("unused") TExtendsKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTFinalKeyword(@SuppressWarnings("unused") TFinalKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTFinallyKeyword(@SuppressWarnings("unused") TFinallyKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTFloatKeyword(@SuppressWarnings("unused") TFloatKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTForKeyword(@SuppressWarnings("unused") TForKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTIfKeyword(@SuppressWarnings("unused") TIfKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTGotoKeyword(@SuppressWarnings("unused") TGotoKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTImplementsKeyword(@SuppressWarnings("unused") TImplementsKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTImportKeyword(@SuppressWarnings("unused") TImportKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTInstanceofKeyword(@SuppressWarnings("unused") TInstanceofKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTIntKeyword(@SuppressWarnings("unused") TIntKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTInterfaceKeyword(@SuppressWarnings("unused") TInterfaceKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTLongKeyword(@SuppressWarnings("unused") TLongKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTNativeKeyword(@SuppressWarnings("unused") TNativeKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTNewKeyword(@SuppressWarnings("unused") TNewKeyword node)
    {
       operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTPackageKeyword(@SuppressWarnings("unused") TPackageKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTPrivateKeyword(@SuppressWarnings("unused") TPrivateKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTProtectedKeyword(@SuppressWarnings("unused") TProtectedKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTPublicKeyword(@SuppressWarnings("unused") TPublicKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTReturnKeyword(@SuppressWarnings("unused") TReturnKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTShortKeyword(@SuppressWarnings("unused") TShortKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTStaticKeyword(@SuppressWarnings("unused") TStaticKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTStrictfpKeyword(@SuppressWarnings("unused") TStrictfpKeyword node)
    {
       operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTSuperKeyword(@SuppressWarnings("unused") TSuperKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTSwitchKeyword(@SuppressWarnings("unused") TSwitchKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTSynchronizedKeyword(@SuppressWarnings("unused") TSynchronizedKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTThisKeyword(@SuppressWarnings("unused") TThisKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTThrowKeyword(@SuppressWarnings("unused") TThrowKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTThrowsKeyword(@SuppressWarnings("unused") TThrowsKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTTransientKeyword(@SuppressWarnings("unused") TTransientKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTTryKeyword(@SuppressWarnings("unused") TTryKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTVoidKeyword(@SuppressWarnings("unused") TVoidKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTVolatileKeyword(@SuppressWarnings("unused") TVolatileKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTWhileKeyword(@SuppressWarnings("unused") TWhileKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTHandlerKeyword(@SuppressWarnings("unused") THandlerKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTHandleKeyword(@SuppressWarnings("unused") THandleKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTPortKeyword(@SuppressWarnings("unused") TPortKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTComponentKeyword(@SuppressWarnings("unused") TComponentKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTComponentdefKeyword(@SuppressWarnings("unused") TComponentdefKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTSubscribeKeyword(@SuppressWarnings("unused") TSubscribeKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTUnsubscribeKeyword(@SuppressWarnings("unused") TUnsubscribeKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTConnectKeyword(@SuppressWarnings("unused") TConnectKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTDisconnectKeyword(@SuppressWarnings("unused") TDisconnectKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTInitKeyword(@SuppressWarnings("unused") TInitKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTTriggerKeyword(@SuppressWarnings("unused") TTriggerKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTRequiresKeyword(@SuppressWarnings("unused") TRequiresKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTProvidesKeyword(@SuppressWarnings("unused") TProvidesKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTIndicationKeyword(@SuppressWarnings("unused") TIndicationKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTRequestKeyword(@SuppressWarnings("unused") TRequestKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTEventKeyword(@SuppressWarnings("unused") TEventKeyword node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTRArrow(@SuppressWarnings("unused") TRArrow node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTIntegerLiteral(@SuppressWarnings("unused") TIntegerLiteral node)
    {
        operands++;
        distinctOperands.add(node.getText());
    }

    @Override
    public void caseTFloatingPointLiteral(@SuppressWarnings("unused") TFloatingPointLiteral node)
    {
        operands++;
        distinctOperands.add(node.getText());
    }

    @Override
    public void caseTBooleanLiteral(@SuppressWarnings("unused") TBooleanLiteral node)
    {
        operands++;
        distinctOperands.add(node.getText());
    }

    @Override
    public void caseTCharacterLiteral(@SuppressWarnings("unused") TCharacterLiteral node)
    {
        operands++;
        distinctOperands.add(node.getText());
    }

    @Override
    public void caseTStringLiteral(@SuppressWarnings("unused") TStringLiteral node)
    {
        operands++;
        distinctOperands.add(node.getText());
    }

    @Override
    public void caseTNullLiteral(@SuppressWarnings("unused") TNullLiteral node)
    {
        operands++;
        distinctOperands.add(node.getText());
    }

    @Override
    public void caseTIdentifier(@SuppressWarnings("unused") TIdentifier node)
    {
        operands++;
        distinctOperands.add(node.getText());
    }

    @Override
    public void caseTLPar(@SuppressWarnings("unused") TLPar node)
    {
        operators++;
        distinctOperators.add("()");
    }

    @Override
    public void caseTRPar(@SuppressWarnings("unused") TRPar node)
    {
        // ignore and count only left side
    }

    @Override
    public void caseTLBrc(@SuppressWarnings("unused") TLBrc node)
    {
        operators++;
        distinctOperators.add("{}");
    }

    @Override
    public void caseTRBrc(@SuppressWarnings("unused") TRBrc node)
    {
        // ignore and count only left side
    }

    @Override
    public void caseTLBkt(@SuppressWarnings("unused") TLBkt node)
    {
        operators++;
        distinctOperators.add("[]");
    }

    @Override
    public void caseTRBkt(@SuppressWarnings("unused") TRBkt node)
    {
        // ignore and count only left side
    }

    @Override
    public void caseTSemi(@SuppressWarnings("unused") TSemi node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTComma(@SuppressWarnings("unused") TComma node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTDot(@SuppressWarnings("unused") TDot node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTAssign(@SuppressWarnings("unused") TAssign node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTLt(@SuppressWarnings("unused") TLt node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTGt(@SuppressWarnings("unused") TGt node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTEmark(@SuppressWarnings("unused") TEmark node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTTilde(@SuppressWarnings("unused") TTilde node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTQmark(@SuppressWarnings("unused") TQmark node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTColon(@SuppressWarnings("unused") TColon node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTEq(@SuppressWarnings("unused") TEq node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTLteq(@SuppressWarnings("unused") TLteq node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTGteq(@SuppressWarnings("unused") TGteq node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTNeq(@SuppressWarnings("unused") TNeq node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTAmpAmp(@SuppressWarnings("unused") TAmpAmp node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTBarBar(@SuppressWarnings("unused") TBarBar node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTPlusPlus(@SuppressWarnings("unused") TPlusPlus node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTMinusMinus(@SuppressWarnings("unused") TMinusMinus node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTPlus(@SuppressWarnings("unused") TPlus node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTMinus(@SuppressWarnings("unused") TMinus node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTStar(@SuppressWarnings("unused") TStar node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTSlash(@SuppressWarnings("unused") TSlash node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTAmp(@SuppressWarnings("unused") TAmp node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTBar(@SuppressWarnings("unused") TBar node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTCaret(@SuppressWarnings("unused") TCaret node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTPercent(@SuppressWarnings("unused") TPercent node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTShl(@SuppressWarnings("unused") TShl node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTShr(@SuppressWarnings("unused") TShr node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTUshr(@SuppressWarnings("unused") TUshr node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTPlusAssign(@SuppressWarnings("unused") TPlusAssign node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTMinusAssign(@SuppressWarnings("unused") TMinusAssign node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTStarAssign(@SuppressWarnings("unused") TStarAssign node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTSlashAssign(@SuppressWarnings("unused") TSlashAssign node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTAmpAssign(@SuppressWarnings("unused") TAmpAssign node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTBarAssign(@SuppressWarnings("unused") TBarAssign node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTCaretAssign(@SuppressWarnings("unused") TCaretAssign node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTPercentAssign(@SuppressWarnings("unused") TPercentAssign node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTShlAssign(@SuppressWarnings("unused") TShlAssign node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTShrAssign(@SuppressWarnings("unused") TShrAssign node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTUshrAssign(@SuppressWarnings("unused") TUshrAssign node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTDotDotDot(@SuppressWarnings("unused") TDotDotDot node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseTAt(@SuppressWarnings("unused") TAt node)
    {
        operators++;
        distinctOperators.add(node.getText());
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.loc = node.getLine();
        this.done = true;
    }
}
