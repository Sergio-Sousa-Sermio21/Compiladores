// Import necessary packages and classes
import Sol.SolBaseVisitor;
import Sol.SolParser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * SolVisitorTypeCheckFunction extends SolBaseVisitor to provide type checking functionality for functions
 * for the Sol language parse tree.
 */
public class SolVisitorTypeCheckFunction extends SolBaseVisitor {
    // Declare instance variables
    private ParseTreeProperty<Class<?>> tree;
    private TesteSemantico teste;
    private ArrayList<String> errors;
    private HashMap<SolVisitorTypeCheck.Var, ArrayList<Class<?>>> callListed;
    /**
     * Constructor for SolVisitorTypeCheckFunction.
     * Initializes instance variables.
     */
    SolVisitorTypeCheckFunction() {
        tree = new ParseTreeProperty<Class<?>>();
        teste = new TesteSemantico();
        errors = new ArrayList<String>();
        callListed = new HashMap<>();
    }

    /**
     * Retrieves the list of type checking errors.
     *
     * @return ArrayList of error messages.
     */
    public ArrayList<String> getErrors() {
        return errors;
    }

    /**
     * Retrieves the type tree containing type information.
     *
     * @return ParseTreeProperty containing type information.
     */
    public ParseTreeProperty<Class<?>> getTree() {
        return tree;
    }

    /**
     * Retrieves the function hashmap containing all available functions.
     *
     * @return HashMap containing all available functions.
     */
    public HashMap<SolVisitorTypeCheck.Var, ArrayList<Class<?>>> getCallListed() {
        return callListed;
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitFunction(SolParser.FunctionContext ctx) {
        Object result = visit(ctx.retType());
        Class<?> type = tree.get(ctx.retType());
        tree.put(ctx, type);
        SolVisitorTypeCheck.Var function = new SolVisitorTypeCheck.Var(ctx.VAR(0).getText(),type.getSimpleName());
        if (callListed.containsKey(function)){
            errors.add(teste.alreadyDefinedFunction(ctx.start.getLine(),function.name));
        }else {
            ArrayList<Class<?>> typeArgs = new ArrayList<>();
            for (SolParser.DeclarationTypeContext declaration:ctx.declarationType()) {
                visit(declaration);
                typeArgs.add(tree.get(declaration));
            }
            callListed.put(function, typeArgs);
        }
        return result;
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitReturnInt(SolParser.ReturnIntContext ctx) {
        tree.put(ctx,Integer.class);
        return super.visitReturnInt(ctx);
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitReturnReal(SolParser.ReturnRealContext ctx) {
        tree.put(ctx,Double.class);
        return super.visitReturnReal(ctx);
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitReturnString(SolParser.ReturnStringContext ctx) {
        tree.put(ctx,String.class);
        return super.visitReturnString(ctx);
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitReturnBool(SolParser.ReturnBoolContext ctx) {
        tree.put(ctx, Boolean.class);
        return super.visitReturnBool(ctx);
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitReturnVoid(SolParser.ReturnVoidContext ctx) {
        tree.put(ctx,Void.class);
        return super.visitReturnVoid(ctx);
    }

    /**
     * Visits an 'integerType' node in the parse tree, associating it with the Integer class type.
     *
     * @param ctx The parse tree node representing the 'integerType'.
     * @return The result of visiting the 'integerType'.
     */
    @Override
    public Object visitIntegerType(SolParser.IntegerTypeContext ctx) {
        tree.put(ctx, Integer.class);
        return super.visitIntegerType(ctx);
    }

    /**
     * Visits a 'doubleType' node in the parse tree, associating it with the Double class type.
     *
     * @param ctx The parse tree node representing the 'doubleType'.
     * @return The result of visiting the 'doubleType'.
     */
    @Override
    public Object visitDoubleType(SolParser.DoubleTypeContext ctx) {
        tree.put(ctx, Double.class);
        return super.visitDoubleType(ctx);
    }

    /**
     * Visits a 'stringType' node in the parse tree, associating it with the String class type.
     *
     * @param ctx The parse tree node representing the 'stringType'.
     * @return The result of visiting the 'stringType'.
     */
    @Override
    public Object visitStringType(SolParser.StringTypeContext ctx) {
        tree.put(ctx, String.class);
        return super.visitStringType(ctx);
    }

    /**
     * Visits a 'booleanType' node in the parse tree, associating it with the Boolean class type.
     *
     * @param ctx The parse tree node representing the 'booleanType'.
     * @return The result of visiting the 'booleanType'.
     */
    @Override
    public Object visitBooleanType(SolParser.BooleanTypeContext ctx) {
        tree.put(ctx, Boolean.class);
        return super.visitBooleanType(ctx);
    }
}
