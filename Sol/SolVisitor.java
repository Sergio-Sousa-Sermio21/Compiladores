// Generated from C:/xampp/htdocs/Compiladores/src/Sol.g4 by ANTLR 4.13.1
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
	 * Visit a parse tree produced by {@link SolParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SolParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#instrucao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucao(SolParser.InstrucaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#declarar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarar(SolParser.DeclararContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(SolParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#whileState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileState(SolParser.WhileStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#forState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForState(SolParser.ForStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#ifState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfState(SolParser.IfStateContext ctx);
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
	 * Visit a parse tree produced by {@link SolParser#tiposNoCodigo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTiposNoCodigo(SolParser.TiposNoCodigoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INTT}
	 * labeled alternative in {@link SolParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINTT(SolParser.INTTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DOUBLET}
	 * labeled alternative in {@link SolParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDOUBLET(SolParser.DOUBLETContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BOLEANT}
	 * labeled alternative in {@link SolParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBOLEANT(SolParser.BOLEANTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code STRINGT}
	 * labeled alternative in {@link SolParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSTRINGT(SolParser.STRINGTContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#declaracao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao(SolParser.DeclaracaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#bloco}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloco(SolParser.BlocoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MULTDIV}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMULTDIV(SolParser.MULTDIVContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LOGICALOPERATOREQUALNOT}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOGICALOPERATOREQUALNOT(SolParser.LOGICALOPERATOREQUALNOTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ORDER}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORDER(SolParser.ORDERContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variavel}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(SolParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NEGACION}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNEGACION(SolParser.NEGACIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OR}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOR(SolParser.ORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ADDSUB}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitADDSUB(SolParser.ADDSUBContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AND}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAND(SolParser.ANDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LOGICALOPERATOR}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLOGICALOPERATOR(SolParser.LOGICALOPERATORContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#variaveis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariaveis(SolParser.VariaveisContext ctx);
}