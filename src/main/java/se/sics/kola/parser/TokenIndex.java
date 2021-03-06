/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.parser;

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

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTAbstractKeyword(@SuppressWarnings("unused") TAbstractKeyword node)
    {
        this.index = 0;
    }

    @Override
    public void caseTAssertKeyword(@SuppressWarnings("unused") TAssertKeyword node)
    {
        this.index = 1;
    }

    @Override
    public void caseTBooleanKeyword(@SuppressWarnings("unused") TBooleanKeyword node)
    {
        this.index = 2;
    }

    @Override
    public void caseTBreakKeyword(@SuppressWarnings("unused") TBreakKeyword node)
    {
        this.index = 3;
    }

    @Override
    public void caseTByteKeyword(@SuppressWarnings("unused") TByteKeyword node)
    {
        this.index = 4;
    }

    @Override
    public void caseTCaseKeyword(@SuppressWarnings("unused") TCaseKeyword node)
    {
        this.index = 5;
    }

    @Override
    public void caseTCatchKeyword(@SuppressWarnings("unused") TCatchKeyword node)
    {
        this.index = 6;
    }

    @Override
    public void caseTCharKeyword(@SuppressWarnings("unused") TCharKeyword node)
    {
        this.index = 7;
    }

    @Override
    public void caseTClassKeyword(@SuppressWarnings("unused") TClassKeyword node)
    {
        this.index = 8;
    }

    @Override
    public void caseTConstKeyword(@SuppressWarnings("unused") TConstKeyword node)
    {
        this.index = 9;
    }

    @Override
    public void caseTContinueKeyword(@SuppressWarnings("unused") TContinueKeyword node)
    {
        this.index = 10;
    }

    @Override
    public void caseTDefaultKeyword(@SuppressWarnings("unused") TDefaultKeyword node)
    {
        this.index = 11;
    }

    @Override
    public void caseTDoKeyword(@SuppressWarnings("unused") TDoKeyword node)
    {
        this.index = 12;
    }

    @Override
    public void caseTDoubleKeyword(@SuppressWarnings("unused") TDoubleKeyword node)
    {
        this.index = 13;
    }

    @Override
    public void caseTElseKeyword(@SuppressWarnings("unused") TElseKeyword node)
    {
        this.index = 14;
    }

    @Override
    public void caseTEnumKeyword(@SuppressWarnings("unused") TEnumKeyword node)
    {
        this.index = 15;
    }

    @Override
    public void caseTExtendsKeyword(@SuppressWarnings("unused") TExtendsKeyword node)
    {
        this.index = 16;
    }

    @Override
    public void caseTFinalKeyword(@SuppressWarnings("unused") TFinalKeyword node)
    {
        this.index = 17;
    }

    @Override
    public void caseTFinallyKeyword(@SuppressWarnings("unused") TFinallyKeyword node)
    {
        this.index = 18;
    }

    @Override
    public void caseTFloatKeyword(@SuppressWarnings("unused") TFloatKeyword node)
    {
        this.index = 19;
    }

    @Override
    public void caseTForKeyword(@SuppressWarnings("unused") TForKeyword node)
    {
        this.index = 20;
    }

    @Override
    public void caseTIfKeyword(@SuppressWarnings("unused") TIfKeyword node)
    {
        this.index = 21;
    }

    @Override
    public void caseTGotoKeyword(@SuppressWarnings("unused") TGotoKeyword node)
    {
        this.index = 22;
    }

    @Override
    public void caseTImplementsKeyword(@SuppressWarnings("unused") TImplementsKeyword node)
    {
        this.index = 23;
    }

    @Override
    public void caseTImportKeyword(@SuppressWarnings("unused") TImportKeyword node)
    {
        this.index = 24;
    }

    @Override
    public void caseTInstanceofKeyword(@SuppressWarnings("unused") TInstanceofKeyword node)
    {
        this.index = 25;
    }

    @Override
    public void caseTIntKeyword(@SuppressWarnings("unused") TIntKeyword node)
    {
        this.index = 26;
    }

    @Override
    public void caseTInterfaceKeyword(@SuppressWarnings("unused") TInterfaceKeyword node)
    {
        this.index = 27;
    }

    @Override
    public void caseTLongKeyword(@SuppressWarnings("unused") TLongKeyword node)
    {
        this.index = 28;
    }

    @Override
    public void caseTNativeKeyword(@SuppressWarnings("unused") TNativeKeyword node)
    {
        this.index = 29;
    }

    @Override
    public void caseTNewKeyword(@SuppressWarnings("unused") TNewKeyword node)
    {
        this.index = 30;
    }

    @Override
    public void caseTPackageKeyword(@SuppressWarnings("unused") TPackageKeyword node)
    {
        this.index = 31;
    }

    @Override
    public void caseTPrivateKeyword(@SuppressWarnings("unused") TPrivateKeyword node)
    {
        this.index = 32;
    }

    @Override
    public void caseTProtectedKeyword(@SuppressWarnings("unused") TProtectedKeyword node)
    {
        this.index = 33;
    }

    @Override
    public void caseTPublicKeyword(@SuppressWarnings("unused") TPublicKeyword node)
    {
        this.index = 34;
    }

    @Override
    public void caseTReturnKeyword(@SuppressWarnings("unused") TReturnKeyword node)
    {
        this.index = 35;
    }

    @Override
    public void caseTShortKeyword(@SuppressWarnings("unused") TShortKeyword node)
    {
        this.index = 36;
    }

    @Override
    public void caseTStaticKeyword(@SuppressWarnings("unused") TStaticKeyword node)
    {
        this.index = 37;
    }

    @Override
    public void caseTStrictfpKeyword(@SuppressWarnings("unused") TStrictfpKeyword node)
    {
        this.index = 38;
    }

    @Override
    public void caseTSuperKeyword(@SuppressWarnings("unused") TSuperKeyword node)
    {
        this.index = 39;
    }

    @Override
    public void caseTSwitchKeyword(@SuppressWarnings("unused") TSwitchKeyword node)
    {
        this.index = 40;
    }

    @Override
    public void caseTSynchronizedKeyword(@SuppressWarnings("unused") TSynchronizedKeyword node)
    {
        this.index = 41;
    }

    @Override
    public void caseTThisKeyword(@SuppressWarnings("unused") TThisKeyword node)
    {
        this.index = 42;
    }

    @Override
    public void caseTThrowKeyword(@SuppressWarnings("unused") TThrowKeyword node)
    {
        this.index = 43;
    }

    @Override
    public void caseTThrowsKeyword(@SuppressWarnings("unused") TThrowsKeyword node)
    {
        this.index = 44;
    }

    @Override
    public void caseTTransientKeyword(@SuppressWarnings("unused") TTransientKeyword node)
    {
        this.index = 45;
    }

    @Override
    public void caseTTryKeyword(@SuppressWarnings("unused") TTryKeyword node)
    {
        this.index = 46;
    }

    @Override
    public void caseTVoidKeyword(@SuppressWarnings("unused") TVoidKeyword node)
    {
        this.index = 47;
    }

    @Override
    public void caseTVolatileKeyword(@SuppressWarnings("unused") TVolatileKeyword node)
    {
        this.index = 48;
    }

    @Override
    public void caseTWhileKeyword(@SuppressWarnings("unused") TWhileKeyword node)
    {
        this.index = 49;
    }

    @Override
    public void caseTHandlerKeyword(@SuppressWarnings("unused") THandlerKeyword node)
    {
        this.index = 50;
    }

    @Override
    public void caseTHandleKeyword(@SuppressWarnings("unused") THandleKeyword node)
    {
        this.index = 51;
    }

    @Override
    public void caseTPortKeyword(@SuppressWarnings("unused") TPortKeyword node)
    {
        this.index = 52;
    }

    @Override
    public void caseTComponentKeyword(@SuppressWarnings("unused") TComponentKeyword node)
    {
        this.index = 53;
    }

    @Override
    public void caseTComponentdefKeyword(@SuppressWarnings("unused") TComponentdefKeyword node)
    {
        this.index = 54;
    }

    @Override
    public void caseTSubscribeKeyword(@SuppressWarnings("unused") TSubscribeKeyword node)
    {
        this.index = 55;
    }

    @Override
    public void caseTUnsubscribeKeyword(@SuppressWarnings("unused") TUnsubscribeKeyword node)
    {
        this.index = 56;
    }

    @Override
    public void caseTConnectKeyword(@SuppressWarnings("unused") TConnectKeyword node)
    {
        this.index = 57;
    }

    @Override
    public void caseTDisconnectKeyword(@SuppressWarnings("unused") TDisconnectKeyword node)
    {
        this.index = 58;
    }

    @Override
    public void caseTInitKeyword(@SuppressWarnings("unused") TInitKeyword node)
    {
        this.index = 59;
    }

    @Override
    public void caseTTriggerKeyword(@SuppressWarnings("unused") TTriggerKeyword node)
    {
        this.index = 60;
    }

    @Override
    public void caseTRequiresKeyword(@SuppressWarnings("unused") TRequiresKeyword node)
    {
        this.index = 61;
    }

    @Override
    public void caseTProvidesKeyword(@SuppressWarnings("unused") TProvidesKeyword node)
    {
        this.index = 62;
    }

    @Override
    public void caseTIndicationKeyword(@SuppressWarnings("unused") TIndicationKeyword node)
    {
        this.index = 63;
    }

    @Override
    public void caseTRequestKeyword(@SuppressWarnings("unused") TRequestKeyword node)
    {
        this.index = 64;
    }

    @Override
    public void caseTEventKeyword(@SuppressWarnings("unused") TEventKeyword node)
    {
        this.index = 65;
    }

    @Override
    public void caseTRArrow(@SuppressWarnings("unused") TRArrow node)
    {
        this.index = 66;
    }

    @Override
    public void caseTIntegerLiteral(@SuppressWarnings("unused") TIntegerLiteral node)
    {
        this.index = 67;
    }

    @Override
    public void caseTFloatingPointLiteral(@SuppressWarnings("unused") TFloatingPointLiteral node)
    {
        this.index = 68;
    }

    @Override
    public void caseTBooleanLiteral(@SuppressWarnings("unused") TBooleanLiteral node)
    {
        this.index = 69;
    }

    @Override
    public void caseTCharacterLiteral(@SuppressWarnings("unused") TCharacterLiteral node)
    {
        this.index = 70;
    }

    @Override
    public void caseTStringLiteral(@SuppressWarnings("unused") TStringLiteral node)
    {
        this.index = 71;
    }

    @Override
    public void caseTNullLiteral(@SuppressWarnings("unused") TNullLiteral node)
    {
        this.index = 72;
    }

    @Override
    public void caseTIdentifier(@SuppressWarnings("unused") TIdentifier node)
    {
        this.index = 73;
    }

    @Override
    public void caseTLPar(@SuppressWarnings("unused") TLPar node)
    {
        this.index = 74;
    }

    @Override
    public void caseTRPar(@SuppressWarnings("unused") TRPar node)
    {
        this.index = 75;
    }

    @Override
    public void caseTLBrc(@SuppressWarnings("unused") TLBrc node)
    {
        this.index = 76;
    }

    @Override
    public void caseTRBrc(@SuppressWarnings("unused") TRBrc node)
    {
        this.index = 77;
    }

    @Override
    public void caseTLBkt(@SuppressWarnings("unused") TLBkt node)
    {
        this.index = 78;
    }

    @Override
    public void caseTRBkt(@SuppressWarnings("unused") TRBkt node)
    {
        this.index = 79;
    }

    @Override
    public void caseTSemi(@SuppressWarnings("unused") TSemi node)
    {
        this.index = 80;
    }

    @Override
    public void caseTComma(@SuppressWarnings("unused") TComma node)
    {
        this.index = 81;
    }

    @Override
    public void caseTDot(@SuppressWarnings("unused") TDot node)
    {
        this.index = 82;
    }

    @Override
    public void caseTAssign(@SuppressWarnings("unused") TAssign node)
    {
        this.index = 83;
    }

    @Override
    public void caseTLt(@SuppressWarnings("unused") TLt node)
    {
        this.index = 84;
    }

    @Override
    public void caseTGt(@SuppressWarnings("unused") TGt node)
    {
        this.index = 85;
    }

    @Override
    public void caseTEmark(@SuppressWarnings("unused") TEmark node)
    {
        this.index = 86;
    }

    @Override
    public void caseTTilde(@SuppressWarnings("unused") TTilde node)
    {
        this.index = 87;
    }

    @Override
    public void caseTQmark(@SuppressWarnings("unused") TQmark node)
    {
        this.index = 88;
    }

    @Override
    public void caseTColon(@SuppressWarnings("unused") TColon node)
    {
        this.index = 89;
    }

    @Override
    public void caseTEq(@SuppressWarnings("unused") TEq node)
    {
        this.index = 90;
    }

    @Override
    public void caseTLteq(@SuppressWarnings("unused") TLteq node)
    {
        this.index = 91;
    }

    @Override
    public void caseTGteq(@SuppressWarnings("unused") TGteq node)
    {
        this.index = 92;
    }

    @Override
    public void caseTNeq(@SuppressWarnings("unused") TNeq node)
    {
        this.index = 93;
    }

    @Override
    public void caseTAmpAmp(@SuppressWarnings("unused") TAmpAmp node)
    {
        this.index = 94;
    }

    @Override
    public void caseTBarBar(@SuppressWarnings("unused") TBarBar node)
    {
        this.index = 95;
    }

    @Override
    public void caseTPlusPlus(@SuppressWarnings("unused") TPlusPlus node)
    {
        this.index = 96;
    }

    @Override
    public void caseTMinusMinus(@SuppressWarnings("unused") TMinusMinus node)
    {
        this.index = 97;
    }

    @Override
    public void caseTPlus(@SuppressWarnings("unused") TPlus node)
    {
        this.index = 98;
    }

    @Override
    public void caseTMinus(@SuppressWarnings("unused") TMinus node)
    {
        this.index = 99;
    }

    @Override
    public void caseTStar(@SuppressWarnings("unused") TStar node)
    {
        this.index = 100;
    }

    @Override
    public void caseTSlash(@SuppressWarnings("unused") TSlash node)
    {
        this.index = 101;
    }

    @Override
    public void caseTAmp(@SuppressWarnings("unused") TAmp node)
    {
        this.index = 102;
    }

    @Override
    public void caseTBar(@SuppressWarnings("unused") TBar node)
    {
        this.index = 103;
    }

    @Override
    public void caseTCaret(@SuppressWarnings("unused") TCaret node)
    {
        this.index = 104;
    }

    @Override
    public void caseTPercent(@SuppressWarnings("unused") TPercent node)
    {
        this.index = 105;
    }

    @Override
    public void caseTShl(@SuppressWarnings("unused") TShl node)
    {
        this.index = 106;
    }

    @Override
    public void caseTShr(@SuppressWarnings("unused") TShr node)
    {
        this.index = 107;
    }

    @Override
    public void caseTUshr(@SuppressWarnings("unused") TUshr node)
    {
        this.index = 108;
    }

    @Override
    public void caseTPlusAssign(@SuppressWarnings("unused") TPlusAssign node)
    {
        this.index = 109;
    }

    @Override
    public void caseTMinusAssign(@SuppressWarnings("unused") TMinusAssign node)
    {
        this.index = 110;
    }

    @Override
    public void caseTStarAssign(@SuppressWarnings("unused") TStarAssign node)
    {
        this.index = 111;
    }

    @Override
    public void caseTSlashAssign(@SuppressWarnings("unused") TSlashAssign node)
    {
        this.index = 112;
    }

    @Override
    public void caseTAmpAssign(@SuppressWarnings("unused") TAmpAssign node)
    {
        this.index = 113;
    }

    @Override
    public void caseTBarAssign(@SuppressWarnings("unused") TBarAssign node)
    {
        this.index = 114;
    }

    @Override
    public void caseTCaretAssign(@SuppressWarnings("unused") TCaretAssign node)
    {
        this.index = 115;
    }

    @Override
    public void caseTPercentAssign(@SuppressWarnings("unused") TPercentAssign node)
    {
        this.index = 116;
    }

    @Override
    public void caseTShlAssign(@SuppressWarnings("unused") TShlAssign node)
    {
        this.index = 117;
    }

    @Override
    public void caseTShrAssign(@SuppressWarnings("unused") TShrAssign node)
    {
        this.index = 118;
    }

    @Override
    public void caseTUshrAssign(@SuppressWarnings("unused") TUshrAssign node)
    {
        this.index = 119;
    }

    @Override
    public void caseTDotDotDot(@SuppressWarnings("unused") TDotDotDot node)
    {
        this.index = 120;
    }

    @Override
    public void caseTAt(@SuppressWarnings("unused") TAt node)
    {
        this.index = 121;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 122;
    }
}
