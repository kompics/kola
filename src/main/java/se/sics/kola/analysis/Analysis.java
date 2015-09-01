/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.analysis;

import se.sics.kola.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAJavaCompilationUnit(AJavaCompilationUnit node);
    void caseACompilationUnit(ACompilationUnit node);
    void caseAPackageDeclaration(APackageDeclaration node);
    void caseASingleImportDeclaration(ASingleImportDeclaration node);
    void caseATypeImportDeclaration(ATypeImportDeclaration node);
    void caseAStaticImportDeclaration(AStaticImportDeclaration node);
    void caseADemandImportDeclaration(ADemandImportDeclaration node);
    void caseAClassTypeDeclaration(AClassTypeDeclaration node);
    void caseAInterfaceTypeDeclaration(AInterfaceTypeDeclaration node);
    void caseAPortTypeDeclaration(APortTypeDeclaration node);
    void caseAEventTypeDeclaration(AEventTypeDeclaration node);
    void caseAComponentTypeDeclaration(AComponentTypeDeclaration node);
    void caseASemiTypeDeclaration(ASemiTypeDeclaration node);
    void caseAAnnotationModifier(AAnnotationModifier node);
    void caseAPublicModifier(APublicModifier node);
    void caseAProtectedModifier(AProtectedModifier node);
    void caseAPrivateModifier(APrivateModifier node);
    void caseAAbstractModifier(AAbstractModifier node);
    void caseAStaticModifier(AStaticModifier node);
    void caseAFinalModifier(AFinalModifier node);
    void caseAStrictfpModifier(AStrictfpModifier node);
    void caseATransientModifier(ATransientModifier node);
    void caseAVolatileModifier(AVolatileModifier node);
    void caseASynchronizedModifier(ASynchronizedModifier node);
    void caseANativeModifier(ANativeModifier node);
    void caseAName(AName node);
    void caseAClassClassDeclaration(AClassClassDeclaration node);
    void caseAEnumClassDeclaration(AEnumClassDeclaration node);
    void caseAInterfaceInterfaceDeclaration(AInterfaceInterfaceDeclaration node);
    void caseAAnnotationInterfaceDeclaration(AAnnotationInterfaceDeclaration node);
    void caseANormalAnnotationAnnotation(ANormalAnnotationAnnotation node);
    void caseAMarkerAnnotationAnnotation(AMarkerAnnotationAnnotation node);
    void caseASingleAnnotation(ASingleAnnotation node);
    void caseANormalAnnotation(ANormalAnnotation node);
    void caseAElementValuePair(AElementValuePair node);
    void caseAConditionalElementValue(AConditionalElementValue node);
    void caseAAnnotationElementValue(AAnnotationElementValue node);
    void caseAArrayElementValue(AArrayElementValue node);
    void caseAElementValueArrayInitializer(AElementValueArrayInitializer node);
    void caseAMarkerAnnotation(AMarkerAnnotation node);
    void caseASingleElementAnnotation(ASingleElementAnnotation node);
    void caseANormalClassDeclaration(ANormalClassDeclaration node);
    void caseAEnumDeclaration(AEnumDeclaration node);
    void caseANormalInterfaceDeclaration(ANormalInterfaceDeclaration node);
    void caseAAnnotationTypeDeclaration(AAnnotationTypeDeclaration node);
    void caseATypeParameter(ATypeParameter node);
    void caseATypeBound(ATypeBound node);
    void caseASubscribeKolaKeyword(ASubscribeKolaKeyword node);
    void caseAUnsubscribeKolaKeyword(AUnsubscribeKolaKeyword node);
    void caseAConnectKolaKeyword(AConnectKolaKeyword node);
    void caseADisconnectKolaKeyword(ADisconnectKolaKeyword node);
    void caseARequiresKolaKeyword(ARequiresKolaKeyword node);
    void caseAProvidesKolaKeyword(AProvidesKolaKeyword node);
    void caseATriggerKolaKeyword(ATriggerKolaKeyword node);
    void caseAPortDeclaration(APortDeclaration node);
    void caseAEventDeclaration(AEventDeclaration node);
    void caseAHeaderFields(AHeaderFields node);
    void caseAComponentDeclaration(AComponentDeclaration node);
    void caseAPortBody(APortBody node);
    void caseAIndicationPortBodyDeclaration(AIndicationPortBodyDeclaration node);
    void caseARequestPortBodyDeclaration(ARequestPortBodyDeclaration node);
    void caseAIndicationsDeclaration(AIndicationsDeclaration node);
    void caseARequestsDeclaration(ARequestsDeclaration node);
    void caseAComponentBody(AComponentBody node);
    void caseAMemberComponentBodyDeclaration(AMemberComponentBodyDeclaration node);
    void caseAInstanceComponentBodyDeclaration(AInstanceComponentBodyDeclaration node);
    void caseAStaticComponentBodyDeclaration(AStaticComponentBodyDeclaration node);
    void caseAConstuctorComponentBodyDeclaration(AConstuctorComponentBodyDeclaration node);
    void caseAInitComponentBodyDeclaration(AInitComponentBodyDeclaration node);
    void caseAPortComponentBodyDeclaration(APortComponentBodyDeclaration node);
    void caseAComponentComponentBodyDeclaration(AComponentComponentBodyDeclaration node);
    void caseAHandlingComponentBodyDeclaration(AHandlingComponentBodyDeclaration node);
    void caseAHandleHandlingDeclaration(AHandleHandlingDeclaration node);
    void caseAHandlerHandlingDeclaration(AHandlerHandlingDeclaration node);
    void caseAConnectHandlingDeclaration(AConnectHandlingDeclaration node);
    void caseASubscribeHandlingDeclaration(ASubscribeHandlingDeclaration node);
    void caseADisconnectHandlingDeclaration(ADisconnectHandlingDeclaration node);
    void caseAUnsubscribeHandlingDeclaration(AUnsubscribeHandlingDeclaration node);
    void caseAInitDeclaration(AInitDeclaration node);
    void caseARequiresPortFieldDeclaration(ARequiresPortFieldDeclaration node);
    void caseAProvidesPortFieldDeclaration(AProvidesPortFieldDeclaration node);
    void caseAChildDeclaration(AChildDeclaration node);
    void caseAComponentInitialization(AComponentInitialization node);
    void caseAHandleDeclaration(AHandleDeclaration node);
    void caseAHandlerDeclaration(AHandlerDeclaration node);
    void caseAIntegerLiteral(AIntegerLiteral node);
    void caseAFloatingPointLiteral(AFloatingPointLiteral node);
    void caseABooleanLiteral(ABooleanLiteral node);
    void caseACharacterLiteral(ACharacterLiteral node);
    void caseAStringLiteral(AStringLiteral node);
    void caseANullLiteral(ANullLiteral node);
    void caseAClassType(AClassType node);
    void caseAInterfaceType(AInterfaceType node);
    void caseAClassOrInterfaceTypeNoArguments(AClassOrInterfaceTypeNoArguments node);
    void caseAClassOrInterfaceType(AClassOrInterfaceType node);
    void caseATypeDeclSpecifier(ATypeDeclSpecifier node);
    void caseAArgsWithName(AArgsWithName node);
    void caseAClassName(AClassName node);
    void caseAGtTypeArguments(AGtTypeArguments node);
    void caseAShrTypeArguments(AShrTypeArguments node);
    void caseAUshrTypeArguments(AUshrTypeArguments node);
    void caseAReferenceTypeArgument(AReferenceTypeArgument node);
    void caseAWildcardTypeArgument(AWildcardTypeArgument node);
    void caseAWildcard(AWildcard node);
    void caseAExtendsWildcardBounds(AExtendsWildcardBounds node);
    void caseASuperWildcardBounds(ASuperWildcardBounds node);
    void caseANumericPrimitiveType(ANumericPrimitiveType node);
    void caseABooleanPrimitiveType(ABooleanPrimitiveType node);
    void caseAIntegralNumericType(AIntegralNumericType node);
    void caseAFloatingNumericType(AFloatingNumericType node);
    void caseAByteIntegralType(AByteIntegralType node);
    void caseAShortIntegralType(AShortIntegralType node);
    void caseAIntIntegralType(AIntIntegralType node);
    void caseALongIntegralType(ALongIntegralType node);
    void caseACharIntegralType(ACharIntegralType node);
    void caseAFloatFloatingPointType(AFloatFloatingPointType node);
    void caseADoubleFloatingPointType(ADoubleFloatingPointType node);
    void caseAClassReferenceType(AClassReferenceType node);
    void caseAArrayReferenceType(AArrayReferenceType node);
    void caseAClassReferenceTypeNoArguments(AClassReferenceTypeNoArguments node);
    void caseAArrayReferenceTypeNoArguments(AArrayReferenceTypeNoArguments node);
    void caseAClassArrayType(AClassArrayType node);
    void caseAPrimitiveArrayType(APrimitiveArrayType node);
    void caseAClassArrayTypeNoArguments(AClassArrayTypeNoArguments node);
    void caseAPrimitiveArrayTypeNoArguments(APrimitiveArrayTypeNoArguments node);
    void caseAPrimitiveType(APrimitiveType node);
    void caseAReferenceType(AReferenceType node);
    void caseAPrimitiveTypeNoArguments(APrimitiveTypeNoArguments node);
    void caseAReferenceTypeNoArguments(AReferenceTypeNoArguments node);
    void caseAClassBody(AClassBody node);
    void caseAMemberClassBodyDeclaration(AMemberClassBodyDeclaration node);
    void caseAInstanceClassBodyDeclaration(AInstanceClassBodyDeclaration node);
    void caseAStaticClassBodyDeclaration(AStaticClassBodyDeclaration node);
    void caseAConstructorClassBodyDeclaration(AConstructorClassBodyDeclaration node);
    void caseAEnumBody(AEnumBody node);
    void caseAEnumConstant(AEnumConstant node);
    void caseAInterfaceBody(AInterfaceBody node);
    void caseAConstantInterfaceMemberDeclaration(AConstantInterfaceMemberDeclaration node);
    void caseAMethodInterfaceMemberDeclaration(AMethodInterfaceMemberDeclaration node);
    void caseAClassInterfaceMemberDeclaration(AClassInterfaceMemberDeclaration node);
    void caseAInterfaceInterfaceMemberDeclaration(AInterfaceInterfaceMemberDeclaration node);
    void caseASemiInterfaceMemberDeclaration(ASemiInterfaceMemberDeclaration node);
    void caseAFieldClassMemberDeclaration(AFieldClassMemberDeclaration node);
    void caseAMethodClassMemberDeclaration(AMethodClassMemberDeclaration node);
    void caseAClassClassMemberDeclaration(AClassClassMemberDeclaration node);
    void caseAInterfaceClassMemberDeclaration(AInterfaceClassMemberDeclaration node);
    void caseASemiClassMemberDeclaration(ASemiClassMemberDeclaration node);
    void caseAConstantDeclaration(AConstantDeclaration node);
    void caseAIdVariableDeclarator(AIdVariableDeclarator node);
    void caseAInitializerVariableDeclarator(AInitializerVariableDeclarator node);
    void caseAVariableDeclaratorId(AVariableDeclaratorId node);
    void caseAExpressionVariableInitializer(AExpressionVariableInitializer node);
    void caseAInitializerVariableInitializer(AInitializerVariableInitializer node);
    void caseAAbstractMethodDeclaration(AAbstractMethodDeclaration node);
    void caseAFieldDeclaration(AFieldDeclaration node);
    void caseAMethodDeclaration(AMethodDeclaration node);
    void caseAMethodHeader(AMethodHeader node);
    void caseAMethodDeclarator(AMethodDeclarator node);
    void caseAAnnotationTypeBody(AAnnotationTypeBody node);
    void caseAAbstractAnnotationTypeElementDeclaration(AAbstractAnnotationTypeElementDeclaration node);
    void caseAConstantAnnotationTypeElementDeclaration(AConstantAnnotationTypeElementDeclaration node);
    void caseAClassAnnotationTypeElementDeclaration(AClassAnnotationTypeElementDeclaration node);
    void caseAInterfaceAnnotationTypeElementDeclaration(AInterfaceAnnotationTypeElementDeclaration node);
    void caseASemiAnnotationTypeElementDeclaration(ASemiAnnotationTypeElementDeclaration node);
    void caseAInstanceInitializer(AInstanceInitializer node);
    void caseAStaticInitializer(AStaticInitializer node);
    void caseAArrayInitializer(AArrayInitializer node);
    void caseAConstructorDeclaration(AConstructorDeclaration node);
    void caseAConstructorDeclarator(AConstructorDeclarator node);
    void caseASimpleTypeName(ASimpleTypeName node);
    void caseAParameterFormalParameterList(AParameterFormalParameterList node);
    void caseAParametersFormalParameterList(AParametersFormalParameterList node);
    void caseAVariableLastFormalParameter(AVariableLastFormalParameter node);
    void caseAFormalLastFormalParameter(AFormalLastFormalParameter node);
    void caseAFormalParameter(AFormalParameter node);
    void caseAExpressionArgument(AExpressionArgument node);
    void caseANameArgument(ANameArgument node);
    void caseATypeResult(ATypeResult node);
    void caseAVoidResult(AVoidResult node);
    void caseAThrows(AThrows node);
    void caseAExceptionType(AExceptionType node);
    void caseABlockMethodBody(ABlockMethodBody node);
    void caseASemiMethodBody(ASemiMethodBody node);
    void caseABlock(ABlock node);
    void caseAVariableBlockStatement(AVariableBlockStatement node);
    void caseAClassBlockStatement(AClassBlockStatement node);
    void caseAStatementBlockStatement(AStatementBlockStatement node);
    void caseAWithoutTrailingSubstatementStatement(AWithoutTrailingSubstatementStatement node);
    void caseALabeledStatementStatement(ALabeledStatementStatement node);
    void caseAIfStatement(AIfStatement node);
    void caseAIfElseStatement(AIfElseStatement node);
    void caseAWhileStatementStatement(AWhileStatementStatement node);
    void caseAForStatementStatement(AForStatementStatement node);
    void caseABlockStatementWithoutTrailingSubstatement(ABlockStatementWithoutTrailingSubstatement node);
    void caseAEmptyStatementStatementWithoutTrailingSubstatement(AEmptyStatementStatementWithoutTrailingSubstatement node);
    void caseAExpressionStatementStatementWithoutTrailingSubstatement(AExpressionStatementStatementWithoutTrailingSubstatement node);
    void caseAAssertStatementStatementWithoutTrailingSubstatement(AAssertStatementStatementWithoutTrailingSubstatement node);
    void caseASwitchStatementStatementWithoutTrailingSubstatement(ASwitchStatementStatementWithoutTrailingSubstatement node);
    void caseADoStatementStatementWithoutTrailingSubstatement(ADoStatementStatementWithoutTrailingSubstatement node);
    void caseABreakStatementStatementWithoutTrailingSubstatement(ABreakStatementStatementWithoutTrailingSubstatement node);
    void caseAContinueStatementStatementWithoutTrailingSubstatement(AContinueStatementStatementWithoutTrailingSubstatement node);
    void caseAReturnStatementStatementWithoutTrailingSubstatement(AReturnStatementStatementWithoutTrailingSubstatement node);
    void caseASynchronizedStatementStatementWithoutTrailingSubstatement(ASynchronizedStatementStatementWithoutTrailingSubstatement node);
    void caseAThrowStatementStatementWithoutTrailingSubstatement(AThrowStatementStatementWithoutTrailingSubstatement node);
    void caseATryStatementStatementWithoutTrailingSubstatement(ATryStatementStatementWithoutTrailingSubstatement node);
    void caseAConnectStatementWithoutTrailingSubstatement(AConnectStatementWithoutTrailingSubstatement node);
    void caseADisconnectStatementWithoutTrailingSubstatement(ADisconnectStatementWithoutTrailingSubstatement node);
    void caseASubscribeStatementWithoutTrailingSubstatement(ASubscribeStatementWithoutTrailingSubstatement node);
    void caseAUnsubscribeStatementWithoutTrailingSubstatement(AUnsubscribeStatementWithoutTrailingSubstatement node);
    void caseATriggerStatementWithoutTrailingSubstatement(ATriggerStatementWithoutTrailingSubstatement node);
    void caseALabeledStatement(ALabeledStatement node);
    void caseALocalVariableDeclaration(ALocalVariableDeclaration node);
    void caseAStatementExpression(AStatementExpression node);
    void caseAIfThenStatement(AIfThenStatement node);
    void caseAIfThenElseStatement(AIfThenElseStatement node);
    void caseAWhileStatement(AWhileStatement node);
    void caseABasicForForStatement(ABasicForForStatement node);
    void caseAEnhancedForForStatement(AEnhancedForForStatement node);
    void caseAExpressionBasicForStatement(AExpressionBasicForStatement node);
    void caseANameBasicForStatement(ANameBasicForStatement node);
    void caseAStatementForInit(AStatementForInit node);
    void caseALocalForInit(ALocalForInit node);
    void caseAForUpdate(AForUpdate node);
    void caseAEnhancedForStatement(AEnhancedForStatement node);
    void caseASimpleAssertStatement(ASimpleAssertStatement node);
    void caseADetailsAssertStatement(ADetailsAssertStatement node);
    void caseASwitchStatement(ASwitchStatement node);
    void caseASwitchBlock(ASwitchBlock node);
    void caseASwitchBlockStatementGroup(ASwitchBlockStatementGroup node);
    void caseAConstantSwitchLabel(AConstantSwitchLabel node);
    void caseAConstantNameSwitchLabel(AConstantNameSwitchLabel node);
    void caseADefaultSwitchLabel(ADefaultSwitchLabel node);
    void caseADoStatement(ADoStatement node);
    void caseABreakStatement(ABreakStatement node);
    void caseAContinueStatement(AContinueStatement node);
    void caseAExpressionReturnStatement(AExpressionReturnStatement node);
    void caseAVoidReturnStatement(AVoidReturnStatement node);
    void caseASynchronizedStatement(ASynchronizedStatement node);
    void caseAThrowStatement(AThrowStatement node);
    void caseACatchTryStatement(ACatchTryStatement node);
    void caseAFinallyTryStatement(AFinallyTryStatement node);
    void caseAResourcesTryStatement(AResourcesTryStatement node);
    void caseACatchClause(ACatchClause node);
    void caseACatchFormalParameter(ACatchFormalParameter node);
    void caseAFinally(AFinally node);
    void caseATryWithResourcesStatement(ATryWithResourcesStatement node);
    void caseAResourceSpecification(AResourceSpecification node);
    void caseAResource(AResource node);
    void caseAConnectStatement(AConnectStatement node);
    void caseASubscribeStatement(ASubscribeStatement node);
    void caseADisconnectStatement(ADisconnectStatement node);
    void caseAUnsubscribeStatement(AUnsubscribeStatement node);
    void caseATriggerStatement(ATriggerStatement node);
    void caseAExpressionLeftHandSide(AExpressionLeftHandSide node);
    void caseAFieldLeftHandSide(AFieldLeftHandSide node);
    void caseAArrayLeftHandSide(AArrayLeftHandSide node);
    void caseAAssignAssignmentOperator(AAssignAssignmentOperator node);
    void caseAStarAssignAssignmentOperator(AStarAssignAssignmentOperator node);
    void caseASlashAssignAssignmentOperator(ASlashAssignAssignmentOperator node);
    void caseAPercentAssignAssignmentOperator(APercentAssignAssignmentOperator node);
    void caseAPlusAssignAssignmentOperator(APlusAssignAssignmentOperator node);
    void caseAMinusAssignAssignmentOperator(AMinusAssignAssignmentOperator node);
    void caseAShlAssignAssignmentOperator(AShlAssignAssignmentOperator node);
    void caseAShrAssignAssignmentOperator(AShrAssignAssignmentOperator node);
    void caseAUshrAssignAssignmentOperator(AUshrAssignAssignmentOperator node);
    void caseAAmpAssignAssignmentOperator(AAmpAssignAssignmentOperator node);
    void caseACaretAssignAssignmentOperator(ACaretAssignAssignmentOperator node);
    void caseABarAssignAssignmentOperator(ABarAssignAssignmentOperator node);
    void caseAConstructorBody(AConstructorBody node);
    void caseAThisExplicitConstructorInvocation(AThisExplicitConstructorInvocation node);
    void caseASuperExplicitConstructorInvocation(ASuperExplicitConstructorInvocation node);
    void caseAPrimaryExplicitConstructorInvocation(APrimaryExplicitConstructorInvocation node);
    void caseANameExpression(ANameExpression node);
    void caseAExpressionExpression(AExpressionExpression node);
    void caseAAssignmentExpressionNoName(AAssignmentExpressionNoName node);
    void caseAQmarkExpressionNoName(AQmarkExpressionNoName node);
    void caseACorExpressionNoName(ACorExpressionNoName node);
    void caseACandExpressionNoName(ACandExpressionNoName node);
    void caseAIorExpressionNoName(AIorExpressionNoName node);
    void caseAEorExpressionNoName(AEorExpressionNoName node);
    void caseAAndExpressionNoName(AAndExpressionNoName node);
    void caseAEqExpressionNoName(AEqExpressionNoName node);
    void caseANeqExpressionNoName(ANeqExpressionNoName node);
    void caseAInstanceofExpressionNoName(AInstanceofExpressionNoName node);
    void caseALtExpressionNoName(ALtExpressionNoName node);
    void caseAGtExpressionNoName(AGtExpressionNoName node);
    void caseALteqExpressionNoName(ALteqExpressionNoName node);
    void caseAGteqExpressionNoName(AGteqExpressionNoName node);
    void caseAShlExpressionNoName(AShlExpressionNoName node);
    void caseAShrExpressionNoName(AShrExpressionNoName node);
    void caseAUshrExpressionNoName(AUshrExpressionNoName node);
    void caseAPlusExpressionNoName(APlusExpressionNoName node);
    void caseAMinusExpressionNoName(AMinusExpressionNoName node);
    void caseAMulExpressionNoName(AMulExpressionNoName node);
    void caseADivExpressionNoName(ADivExpressionNoName node);
    void caseAModExpressionNoName(AModExpressionNoName node);
    void caseAPreIncExpressionNoName(APreIncExpressionNoName node);
    void caseAPreDecrExpressionNoName(APreDecrExpressionNoName node);
    void caseAUplusExpressionNoName(AUplusExpressionNoName node);
    void caseAUminusExpressionNoName(AUminusExpressionNoName node);
    void caseATildeExpressionNoName(ATildeExpressionNoName node);
    void caseAEmarkExpressionNoName(AEmarkExpressionNoName node);
    void caseAPcastExpressionNoName(APcastExpressionNoName node);
    void caseARcastExpressionNoName(ARcastExpressionNoName node);
    void caseAPostIncExpressionNoName(APostIncExpressionNoName node);
    void caseAPostDecrExpressionNoName(APostDecrExpressionNoName node);
    void caseALiteralExpressionNoName(ALiteralExpressionNoName node);
    void caseATypeExpressionNoName(ATypeExpressionNoName node);
    void caseAVoidExpressionNoName(AVoidExpressionNoName node);
    void caseAThisExpressionNoName(AThisExpressionNoName node);
    void caseAClassExpressionNoName(AClassExpressionNoName node);
    void caseAFieldExpressionNoName(AFieldExpressionNoName node);
    void caseAMethodExpressionNoName(AMethodExpressionNoName node);
    void caseAArrayExpressionNoName(AArrayExpressionNoName node);
    void caseAArrayCreationExpressionNoName(AArrayCreationExpressionNoName node);
    void caseAInstanceExpressionNoName(AInstanceExpressionNoName node);
    void caseAExpressionExpressionNoName(AExpressionExpressionNoName node);
    void caseAConstantExpressionNoName(AConstantExpressionNoName node);
    void caseAMethodMethodInvocation(AMethodMethodInvocation node);
    void caseAPrimaryMethodInvocation(APrimaryMethodInvocation node);
    void caseASuperMethodInvocation(ASuperMethodInvocation node);
    void caseAClassMethodInvocation(AClassMethodInvocation node);
    void caseATypeMethodInvocation(ATypeMethodInvocation node);
    void caseAKolaMethodInvocation(AKolaMethodInvocation node);
    void caseANewClassInstanceCreationExpression(ANewClassInstanceCreationExpression node);
    void caseAPrimaryClassInstanceCreationExpression(APrimaryClassInstanceCreationExpression node);
    void caseATypeArgumentsTypeArgumentsOrDiamond(ATypeArgumentsTypeArgumentsOrDiamond node);
    void caseADiamondTypeArgumentsOrDiamond(ADiamondTypeArgumentsOrDiamond node);
    void caseAPrimaryFieldAccess(APrimaryFieldAccess node);
    void caseASuperFieldAccess(ASuperFieldAccess node);
    void caseAClassFieldAccess(AClassFieldAccess node);
    void caseAArrayAccess(AArrayAccess node);
    void caseAPrimitiveArrayCreationExpression(APrimitiveArrayCreationExpression node);
    void caseAClassArrayCreationExpression(AClassArrayCreationExpression node);
    void caseAPrimitiveInitializerArrayCreationExpression(APrimitiveInitializerArrayCreationExpression node);
    void caseAClassInitializerArrayCreationExpression(AClassInitializerArrayCreationExpression node);
    void caseADimExpr(ADimExpr node);
    void caseADim(ADim node);

    void caseTComment(TComment node);
    void caseTAbstractKeyword(TAbstractKeyword node);
    void caseTAssertKeyword(TAssertKeyword node);
    void caseTBooleanKeyword(TBooleanKeyword node);
    void caseTBreakKeyword(TBreakKeyword node);
    void caseTByteKeyword(TByteKeyword node);
    void caseTCaseKeyword(TCaseKeyword node);
    void caseTCatchKeyword(TCatchKeyword node);
    void caseTCharKeyword(TCharKeyword node);
    void caseTClassKeyword(TClassKeyword node);
    void caseTConstKeyword(TConstKeyword node);
    void caseTContinueKeyword(TContinueKeyword node);
    void caseTDefaultKeyword(TDefaultKeyword node);
    void caseTDoKeyword(TDoKeyword node);
    void caseTDoubleKeyword(TDoubleKeyword node);
    void caseTElseKeyword(TElseKeyword node);
    void caseTEnumKeyword(TEnumKeyword node);
    void caseTExtendsKeyword(TExtendsKeyword node);
    void caseTFinalKeyword(TFinalKeyword node);
    void caseTFinallyKeyword(TFinallyKeyword node);
    void caseTFloatKeyword(TFloatKeyword node);
    void caseTForKeyword(TForKeyword node);
    void caseTIfKeyword(TIfKeyword node);
    void caseTGotoKeyword(TGotoKeyword node);
    void caseTImplementsKeyword(TImplementsKeyword node);
    void caseTImportKeyword(TImportKeyword node);
    void caseTInstanceofKeyword(TInstanceofKeyword node);
    void caseTIntKeyword(TIntKeyword node);
    void caseTInterfaceKeyword(TInterfaceKeyword node);
    void caseTLongKeyword(TLongKeyword node);
    void caseTNativeKeyword(TNativeKeyword node);
    void caseTNewKeyword(TNewKeyword node);
    void caseTPackageKeyword(TPackageKeyword node);
    void caseTPrivateKeyword(TPrivateKeyword node);
    void caseTProtectedKeyword(TProtectedKeyword node);
    void caseTPublicKeyword(TPublicKeyword node);
    void caseTReturnKeyword(TReturnKeyword node);
    void caseTShortKeyword(TShortKeyword node);
    void caseTStaticKeyword(TStaticKeyword node);
    void caseTStrictfpKeyword(TStrictfpKeyword node);
    void caseTSuperKeyword(TSuperKeyword node);
    void caseTSwitchKeyword(TSwitchKeyword node);
    void caseTSynchronizedKeyword(TSynchronizedKeyword node);
    void caseTThisKeyword(TThisKeyword node);
    void caseTThrowKeyword(TThrowKeyword node);
    void caseTThrowsKeyword(TThrowsKeyword node);
    void caseTTransientKeyword(TTransientKeyword node);
    void caseTTryKeyword(TTryKeyword node);
    void caseTVoidKeyword(TVoidKeyword node);
    void caseTVolatileKeyword(TVolatileKeyword node);
    void caseTWhileKeyword(TWhileKeyword node);
    void caseTHandlerKeyword(THandlerKeyword node);
    void caseTHandleKeyword(THandleKeyword node);
    void caseTPortKeyword(TPortKeyword node);
    void caseTComponentKeyword(TComponentKeyword node);
    void caseTComponentdefKeyword(TComponentdefKeyword node);
    void caseTSubscribeKeyword(TSubscribeKeyword node);
    void caseTUnsubscribeKeyword(TUnsubscribeKeyword node);
    void caseTConnectKeyword(TConnectKeyword node);
    void caseTDisconnectKeyword(TDisconnectKeyword node);
    void caseTInitKeyword(TInitKeyword node);
    void caseTTriggerKeyword(TTriggerKeyword node);
    void caseTRequiresKeyword(TRequiresKeyword node);
    void caseTProvidesKeyword(TProvidesKeyword node);
    void caseTIndicationKeyword(TIndicationKeyword node);
    void caseTRequestKeyword(TRequestKeyword node);
    void caseTEventKeyword(TEventKeyword node);
    void caseTRArrow(TRArrow node);
    void caseTIntegerLiteral(TIntegerLiteral node);
    void caseTFloatingPointLiteral(TFloatingPointLiteral node);
    void caseTBooleanLiteral(TBooleanLiteral node);
    void caseTCharacterLiteral(TCharacterLiteral node);
    void caseTStringLiteral(TStringLiteral node);
    void caseTNullLiteral(TNullLiteral node);
    void caseTIdentifier(TIdentifier node);
    void caseTLPar(TLPar node);
    void caseTRPar(TRPar node);
    void caseTLBrc(TLBrc node);
    void caseTRBrc(TRBrc node);
    void caseTLBkt(TLBkt node);
    void caseTRBkt(TRBkt node);
    void caseTSemi(TSemi node);
    void caseTComma(TComma node);
    void caseTDot(TDot node);
    void caseTAssign(TAssign node);
    void caseTLt(TLt node);
    void caseTGt(TGt node);
    void caseTEmark(TEmark node);
    void caseTTilde(TTilde node);
    void caseTQmark(TQmark node);
    void caseTColon(TColon node);
    void caseTEq(TEq node);
    void caseTLteq(TLteq node);
    void caseTGteq(TGteq node);
    void caseTNeq(TNeq node);
    void caseTAmpAmp(TAmpAmp node);
    void caseTBarBar(TBarBar node);
    void caseTPlusPlus(TPlusPlus node);
    void caseTMinusMinus(TMinusMinus node);
    void caseTPlus(TPlus node);
    void caseTMinus(TMinus node);
    void caseTStar(TStar node);
    void caseTSlash(TSlash node);
    void caseTAmp(TAmp node);
    void caseTBar(TBar node);
    void caseTCaret(TCaret node);
    void caseTPercent(TPercent node);
    void caseTShl(TShl node);
    void caseTShr(TShr node);
    void caseTUshr(TUshr node);
    void caseTPlusAssign(TPlusAssign node);
    void caseTMinusAssign(TMinusAssign node);
    void caseTStarAssign(TStarAssign node);
    void caseTSlashAssign(TSlashAssign node);
    void caseTAmpAssign(TAmpAssign node);
    void caseTBarAssign(TBarAssign node);
    void caseTCaretAssign(TCaretAssign node);
    void caseTPercentAssign(TPercentAssign node);
    void caseTShlAssign(TShlAssign node);
    void caseTShrAssign(TShrAssign node);
    void caseTUshrAssign(TUshrAssign node);
    void caseTDotDotDot(TDotDotDot node);
    void caseTAt(TAt node);
    void caseTWhiteSpaces(TWhiteSpaces node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
