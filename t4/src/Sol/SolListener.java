// Generated from C:/Users/sergi/Documents/Compiladores/CompiladoresT/t4/Sol.g4 by ANTLR 4.13.1
package Sol;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SolParser}.
 */
public interface SolListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SolParser#executable}.
	 * @param ctx the parse tree
	 */
	void enterExecutable(SolParser.ExecutableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#executable}.
	 * @param ctx the parse tree
	 */
	void exitExecutable(SolParser.ExecutableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(SolParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(SolParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SolParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SolParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(SolParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(SolParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(SolParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(SolParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SolParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SolParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(SolParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(SolParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhile(SolParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhile(SolParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#for}.
	 * @param ctx the parse tree
	 */
	void enterFor(SolParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#for}.
	 * @param ctx the parse tree
	 */
	void exitFor(SolParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(SolParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(SolParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#else}.
	 * @param ctx the parse tree
	 */
	void enterElse(SolParser.ElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#else}.
	 * @param ctx the parse tree
	 */
	void exitElse(SolParser.ElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#empty}.
	 * @param ctx the parse tree
	 */
	void enterEmpty(SolParser.EmptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#empty}.
	 * @param ctx the parse tree
	 */
	void exitEmpty(SolParser.EmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#break}.
	 * @param ctx the parse tree
	 */
	void enterBreak(SolParser.BreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#break}.
	 * @param ctx the parse tree
	 */
	void exitBreak(SolParser.BreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerType}
	 * labeled alternative in {@link SolParser#declarationType}.
	 * @param ctx the parse tree
	 */
	void enterIntegerType(SolParser.IntegerTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerType}
	 * labeled alternative in {@link SolParser#declarationType}.
	 * @param ctx the parse tree
	 */
	void exitIntegerType(SolParser.IntegerTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleType}
	 * labeled alternative in {@link SolParser#declarationType}.
	 * @param ctx the parse tree
	 */
	void enterDoubleType(SolParser.DoubleTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleType}
	 * labeled alternative in {@link SolParser#declarationType}.
	 * @param ctx the parse tree
	 */
	void exitDoubleType(SolParser.DoubleTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link SolParser#declarationType}.
	 * @param ctx the parse tree
	 */
	void enterStringType(SolParser.StringTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link SolParser#declarationType}.
	 * @param ctx the parse tree
	 */
	void exitStringType(SolParser.StringTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanType}
	 * labeled alternative in {@link SolParser#declarationType}.
	 * @param ctx the parse tree
	 */
	void enterBooleanType(SolParser.BooleanTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanType}
	 * labeled alternative in {@link SolParser#declarationType}.
	 * @param ctx the parse tree
	 */
	void exitBooleanType(SolParser.BooleanTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#declarationDef}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationDef(SolParser.DeclarationDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#declarationDef}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationDef(SolParser.DeclarationDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Types}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterTypes(SolParser.TypesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Types}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitTypes(SolParser.TypesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(SolParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(SolParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCallOP}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallOP(SolParser.FunctionCallOPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCallOP}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallOP(SolParser.FunctionCallOPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterVariable(SolParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitVariable(SolParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOr(SolParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOr(SolParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterNegation(SolParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitNegation(SolParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(SolParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(SolParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultDivMod}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterMultDivMod(SolParser.MultDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultDivMod}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitMultDivMod(SolParser.MultDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterAnd(SolParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitAnd(SolParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompareMore}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterCompareMore(SolParser.CompareMoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompareMore}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitCompareMore(SolParser.CompareMoreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterCompare(SolParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitCompare(SolParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SolParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SolParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#negate}.
	 * @param ctx the parse tree
	 */
	void enterNegate(SolParser.NegateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#negate}.
	 * @param ctx the parse tree
	 */
	void exitNegate(SolParser.NegateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnVoid}
	 * labeled alternative in {@link SolParser#retType}.
	 * @param ctx the parse tree
	 */
	void enterReturnVoid(SolParser.ReturnVoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnVoid}
	 * labeled alternative in {@link SolParser#retType}.
	 * @param ctx the parse tree
	 */
	void exitReturnVoid(SolParser.ReturnVoidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnInt}
	 * labeled alternative in {@link SolParser#retType}.
	 * @param ctx the parse tree
	 */
	void enterReturnInt(SolParser.ReturnIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnInt}
	 * labeled alternative in {@link SolParser#retType}.
	 * @param ctx the parse tree
	 */
	void exitReturnInt(SolParser.ReturnIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnReal}
	 * labeled alternative in {@link SolParser#retType}.
	 * @param ctx the parse tree
	 */
	void enterReturnReal(SolParser.ReturnRealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnReal}
	 * labeled alternative in {@link SolParser#retType}.
	 * @param ctx the parse tree
	 */
	void exitReturnReal(SolParser.ReturnRealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnBool}
	 * labeled alternative in {@link SolParser#retType}.
	 * @param ctx the parse tree
	 */
	void enterReturnBool(SolParser.ReturnBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnBool}
	 * labeled alternative in {@link SolParser#retType}.
	 * @param ctx the parse tree
	 */
	void exitReturnBool(SolParser.ReturnBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnString}
	 * labeled alternative in {@link SolParser#retType}.
	 * @param ctx the parse tree
	 */
	void enterReturnString(SolParser.ReturnStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnString}
	 * labeled alternative in {@link SolParser#retType}.
	 * @param ctx the parse tree
	 */
	void exitReturnString(SolParser.ReturnStringContext ctx);
}