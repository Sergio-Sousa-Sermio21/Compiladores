// Generated from C:/Users/ASUS/Documents/Lab1typescript/Compiladores/src/Tasm.g4 by ANTLR 4.13.1
package Tasm;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TasmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TasmVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TasmParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TasmParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link TasmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(TasmParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INTVALUE}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINTVALUE(TasmParser.INTVALUEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DOUBLEVALUE}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDOUBLEVALUE(TasmParser.DOUBLEVALUEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code STRINGVALUE}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSTRINGVALUE(TasmParser.STRINGVALUEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JUMP}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJUMP(TasmParser.JUMPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JUMPT}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJUMPT(TasmParser.JUMPTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JUMPF}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJUMPF(TasmParser.JUMPFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HALT}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHALT(TasmParser.HALTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INTINSTRUCTION}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINTINSTRUCTION(TasmParser.INTINSTRUCTIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DOUBLEINSTRUCTION}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDOUBLEINSTRUCTION(TasmParser.DOUBLEINSTRUCTIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code STRINGINSTRUCTION}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSTRINGINSTRUCTION(TasmParser.STRINGINSTRUCTIONContext ctx);
}