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
    private boolean hasMain;
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
        hasMain=false;
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
     * Retrieves the hashmap containing all available functions.
     * n
     * @return HashMap containing all available functions.
     */
    public HashMap<SolVisitorTypeCheck.Var, ArrayList<Class<?>>> getCallListed() {
        return callListed;
    }

    @Override
    public Object visitExecutable(SolParser.ExecutableContext ctx) {
        Object result = super.visitExecutable(ctx);
        if (!hasMain)
            errors.add(teste.noMainFunction());
        return result;
    }

    /**
     * Visits the function declaration in the parse tree, processes the return type, and registers the function.
     * Checks if the function is named "main" and validates its return type. Adds the function to the list of
     * callable functions with its argument types.
     *
     * @param ctx the parse tree context for the function declaration
     * @return the result of visiting the function declaration, as an Object
     */
    @Override
    public Object visitFunction(SolParser.FunctionContext ctx) {
        Object result = visit(ctx.retType());
        Class<?> type = tree.get(ctx.retType());
        tree.put(ctx, type);
        SolVisitorTypeCheck.Var function = new SolVisitorTypeCheck.Var(ctx.VAR(0).getText(),type.getSimpleName());
        if(function.name.equals("main")) {
            hasMain = true;
            if (type !=Void.class)
                errors.add(teste.invalidMainFunctionType(ctx.start.getLine()));
        }
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

    /**
     * Visits the return integer statement in the parse tree and registers its type as Integer.
     *
     * @param ctx the parse tree context for the return integer statement
     * @return the result of visiting the return integer statement, as an Object
     */
    @Override
    public Object visitReturnInt(SolParser.ReturnIntContext ctx) {
        tree.put(ctx,Integer.class);
        return super.visitReturnInt(ctx);
    }

    /**
     * Visits the return real number statement in the parse tree and registers its type as Double.
     *
     * @param ctx the parse tree context for the return real number statement
     * @return the result of visiting the return real number statement, as an Object
     */
    @Override
    public Object visitReturnReal(SolParser.ReturnRealContext ctx) {
        tree.put(ctx,Double.class);
        return super.visitReturnReal(ctx);
    }

    /**
     * Visits the return string statement in the parse tree and registers its type as String.
     *
     * @param ctx the parse tree context for the return string statement
     * @return the result of visiting the return string statement, as an Object
     */
    @Override
    public Object visitReturnString(SolParser.ReturnStringContext ctx) {
        tree.put(ctx,String.class);
        return super.visitReturnString(ctx);
    }

    /**
     * Visits the return boolean statement in the parse tree and registers its type as Boolean.
     *
     * @param ctx the parse tree context for the return boolean statement
     * @return the result of visiting the return boolean statement, as an Object
     */
    @Override
    public Object visitReturnBool(SolParser.ReturnBoolContext ctx) {
        tree.put(ctx, Boolean.class);
        return super.visitReturnBool(ctx);
    }

    /**
     * Visits the return void statement in the parse tree and registers its type as Void.
     *
     * @param ctx the parse tree context for the return void statement
     * @return the result of visiting the return void statement, as an Object
     */
    @Override
    public Object visitReturnVoid(SolParser.ReturnVoidContext ctx) {
        tree.put(ctx,Void.class);
        return super.visitReturnVoid(ctx);
    }

    /**
     * Visits the integer type declaration in the parse tree and registers its type as Integer.
     *
     * @param ctx the parse tree context for the integer type declaration
     * @return the result of visiting the integer type declaration, as an Object
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
