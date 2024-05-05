// Generated from C:/Users/sergi/Documents/Compiladores/CompiladoresT/t1/Sol.g4 by ANTLR 4.13.1
package Tasm;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TasmParser}.
 */
public interface TasmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TasmParser#executable}.
	 * @param ctx the parse tree
	 */
	void enterExecutable(TasmParser.ExecutableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#executable}.
	 * @param ctx the parse tree
	 */
	void exitExecutable(TasmParser.ExecutableContext ctx);
	/**
	 * Enter a parse tree produced by {@link TasmParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(TasmParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(TasmParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstInteger}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void enterConstInteger(TasmParser.ConstIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstInteger}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void exitConstInteger(TasmParser.ConstIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstDoubleInteger}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void enterConstDoubleInteger(TasmParser.ConstDoubleIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstDoubleInteger}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void exitConstDoubleInteger(TasmParser.ConstDoubleIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstDouble}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void enterConstDouble(TasmParser.ConstDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstDouble}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void exitConstDouble(TasmParser.ConstDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstString}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void enterConstString(TasmParser.ConstStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstString}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void exitConstString(TasmParser.ConstStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void enterIntegerOperation(TasmParser.IntegerOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void exitIntegerOperation(TasmParser.IntegerOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void enterDoubleOperation(TasmParser.DoubleOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void exitDoubleOperation(TasmParser.DoubleOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void enterStringOperation(TasmParser.StringOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void exitStringOperation(TasmParser.StringOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void enterBoolOperation(TasmParser.BoolOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void exitBoolOperation(TasmParser.BoolOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JumpOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void enterJumpOperation(TasmParser.JumpOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JumpOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void exitJumpOperation(TasmParser.JumpOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void enterArrayOperation(TasmParser.ArrayOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void exitArrayOperation(TasmParser.ArrayOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Halt}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void enterHalt(TasmParser.HaltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Halt}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 */
	void exitHalt(TasmParser.HaltContext ctx);
	/**
	 * Enter a parse tree produced by {@link TasmParser#integerOP}.
	 * @param ctx the parse tree
	 */
	void enterIntegerOP(TasmParser.IntegerOPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#integerOP}.
	 * @param ctx the parse tree
	 */
	void exitIntegerOP(TasmParser.IntegerOPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TasmParser#doubleOP}.
	 * @param ctx the parse tree
	 */
	void enterDoubleOP(TasmParser.DoubleOPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#doubleOP}.
	 * @param ctx the parse tree
	 */
	void exitDoubleOP(TasmParser.DoubleOPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TasmParser#stringOP}.
	 * @param ctx the parse tree
	 */
	void enterStringOP(TasmParser.StringOPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#stringOP}.
	 * @param ctx the parse tree
	 */
	void exitStringOP(TasmParser.StringOPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TasmParser#boolOP}.
	 * @param ctx the parse tree
	 */
	void enterBoolOP(TasmParser.BoolOPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#boolOP}.
	 * @param ctx the parse tree
	 */
	void exitBoolOP(TasmParser.BoolOPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TasmParser#jumpOP}.
	 * @param ctx the parse tree
	 */
	void enterJumpOP(TasmParser.JumpOPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#jumpOP}.
	 * @param ctx the parse tree
	 */
	void exitJumpOP(TasmParser.JumpOPContext ctx);
	/**
	 * Enter a parse tree produced by {@link TasmParser#arrayOP}.
	 * @param ctx the parse tree
	 */
	void enterArrayOP(TasmParser.ArrayOPContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#arrayOP}.
	 * @param ctx the parse tree
	 */
	void exitArrayOP(TasmParser.ArrayOPContext ctx);
}