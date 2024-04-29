// Generated from C:/Users/sergi/Documents/Compiladores/CompiladoresT/t3/Sol.g4 by ANTLR 4.13.1
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
	 * Visit a parse tree produced by {@link SolParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SolParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(SolParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(SolParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(SolParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(SolParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse(SolParser.ElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#empty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty(SolParser.EmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#break}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(SolParser.BreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerType}
	 * labeled alternative in {@link SolParser#declarationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerType(SolParser.IntegerTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleType}
	 * labeled alternative in {@link SolParser#declarationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleType(SolParser.DoubleTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link SolParser#declarationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(SolParser.StringTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanType}
	 * labeled alternative in {@link SolParser#declarationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanType(SolParser.BooleanTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#declarationDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationDef(SolParser.DeclarationDefContext ctx);
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