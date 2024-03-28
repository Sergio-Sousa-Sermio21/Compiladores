// Generated from C:/Users/ASUS/Documents/Lab1typescript/Compiladores/src/Tasm.g4 by ANTLR 4.13.1
package Tasm;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TasmParser}.
 */
public interface TasmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TasmParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TasmParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TasmParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TasmParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(TasmParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(TasmParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code INTVALUE}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterINTVALUE(TasmParser.INTVALUEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code INTVALUE}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitINTVALUE(TasmParser.INTVALUEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DCONST}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterDCONST(TasmParser.DCONSTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DCONST}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitDCONST(TasmParser.DCONSTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SCONST}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterSCONST(TasmParser.SCONSTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SCONST}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitSCONST(TasmParser.SCONSTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JUMP}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterJUMP(TasmParser.JUMPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JUMP}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitJUMP(TasmParser.JUMPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JUMPT}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterJUMPT(TasmParser.JUMPTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JUMPT}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitJUMPT(TasmParser.JUMPTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JUMPF}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterJUMPF(TasmParser.JUMPFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JUMPF}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitJUMPF(TasmParser.JUMPFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code INTINSTRUCTION}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterINTINSTRUCTION(TasmParser.INTINSTRUCTIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code INTINSTRUCTION}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitINTINSTRUCTION(TasmParser.INTINSTRUCTIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DOUBLEINSTRUCTION}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterDOUBLEINSTRUCTION(TasmParser.DOUBLEINSTRUCTIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DOUBLEINSTRUCTION}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitDOUBLEINSTRUCTION(TasmParser.DOUBLEINSTRUCTIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code STRINGINSTRUCTION}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterSTRINGINSTRUCTION(TasmParser.STRINGINSTRUCTIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code STRINGINSTRUCTION}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitSTRINGINSTRUCTION(TasmParser.STRINGINSTRUCTIONContext ctx);
}