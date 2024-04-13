// Generated from C:/Users/ASUS/Documents/Lab1typescript/Compiladores/src/Sol.g4 by ANTLR 4.13.1
package Sol;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SolParser}.
 */
public interface SolListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SolParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SolParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SolParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void enterInstrucao(SolParser.InstrucaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void exitInstrucao(SolParser.InstrucaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MULTDIV}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterMULTDIV(SolParser.MULTDIVContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MULTDIV}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitMULTDIV(SolParser.MULTDIVContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OR}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterOR(SolParser.ORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OR}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitOR(SolParser.ORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TRUE}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterTRUE(SolParser.TRUEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TRUE}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitTRUE(SolParser.TRUEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code INT}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterINT(SolParser.INTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code INT}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitINT(SolParser.INTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LOGICALOPERATOREQUALNOT}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterLOGICALOPERATOREQUALNOT(SolParser.LOGICALOPERATOREQUALNOTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LOGICALOPERATOREQUALNOT}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitLOGICALOPERATOREQUALNOT(SolParser.LOGICALOPERATOREQUALNOTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ORDER}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterORDER(SolParser.ORDERContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ORDER}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitORDER(SolParser.ORDERContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NEGACION}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNEGACION(SolParser.NEGACIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NEGACION}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNEGACION(SolParser.NEGACIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ADDSUB}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterADDSUB(SolParser.ADDSUBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ADDSUB}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitADDSUB(SolParser.ADDSUBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AND}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAND(SolParser.ANDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AND}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAND(SolParser.ANDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LOGICALOPERATOR}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterLOGICALOPERATOR(SolParser.LOGICALOPERATORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LOGICALOPERATOR}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitLOGICALOPERATOR(SolParser.LOGICALOPERATORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code STRING}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSTRING(SolParser.STRINGContext ctx);
	/**
	 * Exit a parse tree produced by the {@code STRING}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSTRING(SolParser.STRINGContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FALSE}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterFALSE(SolParser.FALSEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FALSE}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitFALSE(SolParser.FALSEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterDOUBLE(SolParser.DOUBLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitDOUBLE(SolParser.DOUBLEContext ctx);
}