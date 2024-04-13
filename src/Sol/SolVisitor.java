// Generated from C:/Users/ASUS/Documents/Lab1typescript/Compiladores/src/Sol.g4 by ANTLR 4.13.1
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
	 * Visit a parse tree produced by the {@code MULTDIV}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMULTDIV(SolParser.MULTDIVContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OR}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOR(SolParser.ORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TRUE}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTRUE(SolParser.TRUEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INT}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINT(SolParser.INTContext ctx);
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
	 * Visit a parse tree produced by the {@code NEGACION}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNEGACION(SolParser.NEGACIONContext ctx);
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
	 * Visit a parse tree produced by the {@code STRING}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSTRING(SolParser.STRINGContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FALSE}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFALSE(SolParser.FALSEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DOUBLE}
	 * labeled alternative in {@link SolParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDOUBLE(SolParser.DOUBLEContext ctx);
}