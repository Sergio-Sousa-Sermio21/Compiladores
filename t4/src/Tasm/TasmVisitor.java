// Generated from C:/Users/jogat/OneDrive/Documents/GitHub/Compiladores/t4/Tasm.g4 by ANTLR 4.13.1
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
	 * Visit a parse tree produced by {@link TasmParser#executable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecutable(TasmParser.ExecutableContext ctx);
	/**
	 * Visit a parse tree produced by {@link TasmParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(TasmParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstInteger}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInteger(TasmParser.ConstIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstDoubleInteger}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDoubleInteger(TasmParser.ConstDoubleIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstDouble}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDouble(TasmParser.ConstDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstString}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstString(TasmParser.ConstStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerOperation(TasmParser.IntegerOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleOperation(TasmParser.DoubleOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringOperation(TasmParser.StringOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOperation(TasmParser.BoolOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JumpOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpOperation(TasmParser.JumpOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayOperation(TasmParser.ArrayOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StackOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStackOperation(TasmParser.StackOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnOperation}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnOperation(TasmParser.ReturnOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Halt}
	 * labeled alternative in {@link TasmParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHalt(TasmParser.HaltContext ctx);
	/**
	 * Visit a parse tree produced by {@link TasmParser#integerOP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerOP(TasmParser.IntegerOPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TasmParser#doubleOP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleOP(TasmParser.DoubleOPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TasmParser#stringOP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringOP(TasmParser.StringOPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TasmParser#boolOP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOP(TasmParser.BoolOPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TasmParser#jumpOP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpOP(TasmParser.JumpOPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TasmParser#arrayOP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayOP(TasmParser.ArrayOPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TasmParser#stackOP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStackOP(TasmParser.StackOPContext ctx);
	/**
	 * Visit a parse tree produced by {@link TasmParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(TasmParser.ReturnContext ctx);
}