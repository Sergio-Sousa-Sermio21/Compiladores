// Generated from C:/Users/ASUS/Documents/Compiladores/src/Tasm.g4 by ANTLR 4.13.1
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
	 * Visit a parse tree produced by the {@code DCONST}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDCONST(TasmParser.DCONSTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SCONST}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSCONST(TasmParser.SCONSTContext ctx);
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
	 * Visit a parse tree produced by the {@code INTIINSTRUCTION}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINTIINSTRUCTION(TasmParser.INTIINSTRUCTIONContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link TasmParser#intinstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntinstruction(TasmParser.IntinstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TasmParser#doubleinstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleinstruction(TasmParser.DoubleinstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TasmParser#strinstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrinstruction(TasmParser.StrinstructionContext ctx);
}