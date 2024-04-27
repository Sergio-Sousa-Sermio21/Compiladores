// Generated from C:/xampp/htdocs/Compiladores/src/Sol.g4 by ANTLR 4.13.1
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
	 * Enter a parse tree produced by {@link SolParser#declarar}.
	 * @param ctx the parse tree
	 */
	void enterDeclarar(SolParser.DeclararContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#declarar}.
	 * @param ctx the parse tree
	 */
	void exitDeclarar(SolParser.DeclararContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(SolParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(SolParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#whileState}.
	 * @param ctx the parse tree
	 */
	void enterWhileState(SolParser.WhileStateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#whileState}.
	 * @param ctx the parse tree
	 */
	void exitWhileState(SolParser.WhileStateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#forState}.
	 * @param ctx the parse tree
	 */
	void enterForState(SolParser.ForStateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#forState}.
	 * @param ctx the parse tree
	 */
	void exitForState(SolParser.ForStateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#ifState}.
	 * @param ctx the parse tree
	 */
	void enterIfState(SolParser.IfStateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#ifState}.
	 * @param ctx the parse tree
	 */
	void exitIfState(SolParser.IfStateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#empty}.
	 * @param ctx the parse tree
	 */
	void enterEmpty(SolParser.EmptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#empty}.
	 * @param ctx the parse tree
	 */
	void exitEmpty(SolParser.EmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#break}.
	 * @param ctx the parse tree
	 */
	void enterBreak(SolParser.BreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#break}.
	 * @param ctx the parse tree
	 */
	void exitBreak(SolParser.BreakContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#tiposNoCodigo}.
	 * @param ctx the parse tree
	 */
	void enterTiposNoCodigo(SolParser.TiposNoCodigoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#tiposNoCodigo}.
	 * @param ctx the parse tree
	 */
	void exitTiposNoCodigo(SolParser.TiposNoCodigoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code INTT}
	 * labeled alternative in {@link SolParser#types}.
	 * @param ctx the parse tree
	 */
	void enterINTT(SolParser.INTTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code INTT}
	 * labeled alternative in {@link SolParser#types}.
	 * @param ctx the parse tree
	 */
	void exitINTT(SolParser.INTTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DOUBLET}
	 * labeled alternative in {@link SolParser#types}.
	 * @param ctx the parse tree
	 */
	void enterDOUBLET(SolParser.DOUBLETContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DOUBLET}
	 * labeled alternative in {@link SolParser#types}.
	 * @param ctx the parse tree
	 */
	void exitDOUBLET(SolParser.DOUBLETContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BOLEANT}
	 * labeled alternative in {@link SolParser#types}.
	 * @param ctx the parse tree
	 */
	void enterBOLEANT(SolParser.BOLEANTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BOLEANT}
	 * labeled alternative in {@link SolParser#types}.
	 * @param ctx the parse tree
	 */
	void exitBOLEANT(SolParser.BOLEANTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code STRINGT}
	 * labeled alternative in {@link SolParser#types}.
	 * @param ctx the parse tree
	 */
	void enterSTRINGT(SolParser.STRINGTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code STRINGT}
	 * labeled alternative in {@link SolParser#types}.
	 * @param ctx the parse tree
	 */
	void exitSTRINGT(SolParser.STRINGTContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(SolParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(SolParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(SolParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(SolParser.BlocoContext ctx);
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
	 * Enter a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(SolParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(SolParser.VariavelContext ctx);
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
	 * Enter a parse tree produced by {@link SolParser#variaveis}.
	 * @param ctx the parse tree
	 */
	void enterVariaveis(SolParser.VariaveisContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#variaveis}.
	 * @param ctx the parse tree
	 */
	void exitVariaveis(SolParser.VariaveisContext ctx);
}