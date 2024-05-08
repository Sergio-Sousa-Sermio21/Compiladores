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
	 * Visit a parse tree produced by the {@code GALLOC}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGALLOC(TasmParser.GALLOCContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GLOAD}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGLOAD(TasmParser.GLOADContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GSTORE}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGSTORE(TasmParser.GSTOREContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HALT}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHALT(TasmParser.HALTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstrucaoInt}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucaoInt(TasmParser.InstrucaoIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstrucaoDouble}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucaoDouble(TasmParser.InstrucaoDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstrucaoString}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucaoString(TasmParser.InstrucaoStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstrucaoBoolean}
	 * labeled alternative in {@link TasmParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucaoBoolean(TasmParser.InstrucaoBooleanContext ctx);
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
	 * Visit a parse tree produced by {@link TasmParser#stringinstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringinstruction(TasmParser.StringinstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TasmParser#booleaninstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleaninstruction(TasmParser.BooleaninstructionContext ctx);
}