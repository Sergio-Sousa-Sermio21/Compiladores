// Generated from C:/Users/sergi/Documents/Compiladores/CompiladoresT/t2/Sol.g4 by ANTLR 4.13.1
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
	 * Enter a parse tree produced by the {@code Relations}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterRelations(SolParser.RelationsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Relations}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitRelations(SolParser.RelationsContext ctx);
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
	 * Enter a parse tree produced by the {@code CompareMore}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterCompareMore(SolParser.CompareMoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompareMore}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitCompareMore(SolParser.CompareMoreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterCompare(SolParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitCompare(SolParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterAnd(SolParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitAnd(SolParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterOr(SolParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitOr(SolParser.OrContext ctx);
}