// Generated from C:/Users/sergi/Documents/Compiladores/CompiladoresT/t2/Sol.g4 by ANTLR 4.13.1
package Sol;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SolParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SolVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SolParser#executable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecutable(SolParser.ExecutableContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(SolParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Types}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypes(SolParser.TypesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(SolParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(SolParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(SolParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultDivMod}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivMod(SolParser.MultDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Relations}
	 * labeled alternative in {@link SolParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelations(SolParser.RelationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SolParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#negate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegate(SolParser.NegateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompareMore}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareMore(SolParser.CompareMoreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(SolParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(SolParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link SolParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(SolParser.OrContext ctx);
}