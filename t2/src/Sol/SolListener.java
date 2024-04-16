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
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(SolParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(SolParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterAddition(SolParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitAddition(SolParser.AdditionContext ctx);
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
	 * Enter a parse tree produced by the {@code Subctraction}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterSubctraction(SolParser.SubctractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subctraction}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitSubctraction(SolParser.SubctractionContext ctx);
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
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterDivision(SolParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitDivision(SolParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Module}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void enterModule(SolParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Module}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 */
	void exitModule(SolParser.ModuleContext ctx);
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
	 * Enter a parse tree produced by the {@code Lt}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterLt(SolParser.LtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lt}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitLt(SolParser.LtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mt}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterMt(SolParser.MtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mt}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitMt(SolParser.MtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterEqual(SolParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitEqual(SolParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotEqual}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterNotEqual(SolParser.NotEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotEqual}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitNotEqual(SolParser.NotEqualContext ctx);
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