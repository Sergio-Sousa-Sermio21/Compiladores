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
	 * Enter a parse tree produced by the {@code InstrucaoInt}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstrucaoInt(TasmParser.InstrucaoIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstrucaoInt}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstrucaoInt(TasmParser.InstrucaoIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstrucaoDouble}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstrucaoDouble(TasmParser.InstrucaoDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstrucaoDouble}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstrucaoDouble(TasmParser.InstrucaoDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstrucaoString}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstrucaoString(TasmParser.InstrucaoStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstrucaoString}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstrucaoString(TasmParser.InstrucaoStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstrucaoBoolean}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstrucaoBoolean(TasmParser.InstrucaoBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstrucaoBoolean}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstrucaoBoolean(TasmParser.InstrucaoBooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link TasmParser#intinstruction}.
	 * @param ctx the parse tree
	 */
	void enterIntinstruction(TasmParser.IntinstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#intinstruction}.
	 * @param ctx the parse tree
	 */
	void exitIntinstruction(TasmParser.IntinstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TasmParser#doubleinstruction}.
	 * @param ctx the parse tree
	 */
	void enterDoubleinstruction(TasmParser.DoubleinstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#doubleinstruction}.
	 * @param ctx the parse tree
	 */
	void exitDoubleinstruction(TasmParser.DoubleinstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TasmParser#stringinstruction}.
	 * @param ctx the parse tree
	 */
	void enterStringinstruction(TasmParser.StringinstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#stringinstruction}.
	 * @param ctx the parse tree
	 */
	void exitStringinstruction(TasmParser.StringinstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TasmParser#booleaninstruction}.
	 * @param ctx the parse tree
	 */
	void enterBooleaninstruction(TasmParser.BooleaninstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#booleaninstruction}.
	 * @param ctx the parse tree
	 */
	void exitBooleaninstruction(TasmParser.BooleaninstructionContext ctx);
}