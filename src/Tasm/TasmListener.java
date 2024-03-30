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
	 * Enter a parse tree produced by the {@code DOUBLEVALUE}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterDOUBLEVALUE(TasmParser.DOUBLEVALUEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DOUBLEVALUE}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitDOUBLEVALUE(TasmParser.DOUBLEVALUEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code STRINGVALUE}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterSTRINGVALUE(TasmParser.STRINGVALUEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code STRINGVALUE}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitSTRINGVALUE(TasmParser.STRINGVALUEContext ctx);
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
	 * Enter a parse tree produced by the {@code GALLOC}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterGALLOC(TasmParser.GALLOCContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GALLOC}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitGALLOC(TasmParser.GALLOCContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GLOAD}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterGLOAD(TasmParser.GLOADContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GLOAD}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitGLOAD(TasmParser.GLOADContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GSTORE}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterGSTORE(TasmParser.GSTOREContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GSTORE}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitGSTORE(TasmParser.GSTOREContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HALT}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterHALT(TasmParser.HALTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HALT}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitHALT(TasmParser.HALTContext ctx);
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
	/**
	 * Enter a parse tree produced by the {@code BOLEANINSTRUCION}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterBOLEANINSTRUCION(TasmParser.BOLEANINSTRUCIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BOLEANINSTRUCION}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitBOLEANINSTRUCION(TasmParser.BOLEANINSTRUCIONContext ctx);
}