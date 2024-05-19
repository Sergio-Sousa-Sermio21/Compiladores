// Import necessary packages and classes
import Sol.SolBaseVisitor;
import Sol.SolParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * SolVisitorTypeCheck extends SolBaseVisitor to provide type checking functionality
 * for the Sol language parse tree.
 */
public class SolVisitorTypeCheck extends SolBaseVisitor {
    // Declare instance variables
    private ParseTreeProperty<Class<?>> tree;
    private TesteSemantico teste;
    private ArrayList<String> errors;
    private HashMap<Var, ArrayList<Class<?>>> callListed;
    public static class Var {
        protected String name;
        protected boolean initialized;
        protected String type;
        protected int scope;

        Var(String n){
            name=n;
            initialized=false;
            type =null;
            scope=-1;
        }
        Var(String n, boolean i, String t){
            name=n;
            initialized=i;
            type =t;
            scope=-1;
        }
        Var(String n, String t){
            name=n;
            initialized=false;
            type =t;
            scope=-1;
        }
        Var(String n, int scope){
            name=n;
            initialized=false;
            type =null;
            this.scope=scope;
        }
        Var(String n, boolean i, String t, int scope){
            name=n;
            initialized=i;
            type =t;
            this.scope=scope;
        }
        Var(String n, String t, int scope){
            name=n;
            initialized=false;
            type =t;
            this.scope=scope;
        }
        Var(String n, String t, int scope, boolean init){
            name=n;
            initialized=init;
            type =t;
            this.scope=scope;
        }
        public boolean equals(Object obj) {
            return name.equals(obj.toString());
        }
        @Override
        public String toString() {
            return name;
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }
    private Class<?> functionType;
    private ArrayList<Var> gallocContent;
    private Stack<Boolean> loops;
    private int scope;

    /**
     * Constructor for SolVisitorTypeCheck.
     * Initializes instance variables.
     */
    SolVisitorTypeCheck(ParseTreeProperty<Class<?>> t, ArrayList<String> error, HashMap<Var, ArrayList<Class<?>>> callList) {
        tree = t;
        teste = new TesteSemantico();
        errors = error;
        gallocContent = new ArrayList<>();
        loops=new Stack<>();
        functionType = null;
        callListed = callList;
        ret=false;
        retIf=false;
        retElse=false;
        scope=-1;
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
     *
     * @return HashMap containing all available functions.
     */
    public HashMap<Var, ArrayList<Class<?>>> getCallListed() {
        return callListed;
    }

    /**
     * Retrieves the key from the callListed map that matches the given selected key.
     * If the selected key is found in the callListed map, the corresponding key is returned.
     * Otherwise, null is returned.
     */
    private void removeByScope(){
        gallocContent.removeIf(var -> var.scope == scope);
    }

    /**
     * Retrieves the key from the callListed map that matches the given selectedKey.
     * This method iterates through the keys of the callListed map and returns the key
     * that is equal to the specified selectedKey. If no matching key is found, it returns null.
     * @param selectedKey
     * @return
     */
    private Var getKeyCallListed(Var selectedKey){
        for (Var key: callListed.keySet())
            if (selectedKey.equals(key))
                return key;
        return null;
    }

    /**
     * Visits all the possible commands
     * (print, block, while, for, if, break, and variable values)
     * Verifies if variables are declared
     *
     * @param ctx the parse tree
     * @return The result of visiting the command.
     */
    @Override
    public Object visitCommand(SolParser.CommandContext ctx) {
        Object result = null;
        if (ctx.while_() != null){
            loops.push(true);
            result = visit(ctx.while_());
            loops.pop();
            return result;
        }
        if (ctx.for_() !=null){
            loops.push(true);
            result = visit(ctx.for_());
            loops.pop();
            return result;
        }
        result = super.visitCommand(ctx);

        if (ctx.VAR() != null) {
            Var currentVar = new Var(ctx.VAR().getText());
            if (gallocContent.contains(currentVar)) {
                int index = gallocContent.indexOf(currentVar);
                Var var = gallocContent.get(index);
                String type = var.type;
                var.initialized = true;
                gallocContent.set(index, var);
                visit(ctx.op());
                String opType = tree.get(ctx.op()).getSimpleName();
                if (type == null)
                    errors.add(teste.invalidVariable(ctx.start.getLine(), ctx.VAR().getText()));
                else if (!type.equals(opType))
                    errors.add(teste.invalidType(ctx.start.getLine(), opType, type));
            }else
                errors.add(teste.invalidVariable(ctx.start.getLine(), ctx.VAR().getText()));
        }

        if (ctx.PRINT() != null)
            if (tree.get(ctx.op()) == Void.class)
                errors.add(teste.invalidPrintType(ctx.start.getLine()));
        return result;
    }

    /**
     * Visits the function declaration in the parse tree and processes it.
     * This includes checking for return type, handling local variables, validating variable usage,
     * and ensuring the function has a return statement if required.
     *
     * @param ctx the parse tree context for the function declaration
     * @return the result of visiting the function declaration, as an Object
     */
    @Override
    public Object visitFunction(SolParser.FunctionContext ctx) {
        Object result = visit(ctx.retType());
        functionType = tree.get(ctx);
        if (functionType != null){
            int varSize=ctx.VAR().size();
            for (int i=1; i<varSize; i++){
                Var name = new Var(ctx.VAR(i).getText());
                if (gallocContent.contains(name))
                    errors.add(teste.alreadyDefined(ctx.start.getLine(), name.name));
                if(callListed.containsKey(name))
                    errors.add(teste.invalidVariableFunction(ctx.start.getLine(), name.name));
                Var localVariable = new Var(ctx.VAR(i).getText(), tree.get(ctx.declarationType(i-1)).getSimpleName(), scope+1, true);
                gallocContent.add(localVariable);
            }
            visit(ctx.block());
            for (int i=1; i<varSize; i++){
                Var localVariable = new Var(ctx.VAR(i).getText(), tree.get(ctx.declarationType(i-1)).getSimpleName());
                gallocContent.remove(localVariable);
            }
            if (functionType != Void.class && !ret){
                errors.add(teste.noReturn(ctx.start.getLine(), ctx.VAR(0).getText()));
            }
            ret=false;
        } else
            errors.add(teste.invalidFunction(ctx.start.getLine()));
        functionType = null;
        return result;
    }

    /**
     * Converts a string representation of a type to its corresponding Class object.
     * Recognized types are "Integer", "Double", "String", and "Boolean". If the type is not recognized,
     * it returns Void.class.
     *
     * @param type the string representation of the type
     * @return the corresponding Class object, or Void.class if the type is not recognized
     */
    public Class<?> stringToClass(String type){
        switch (type) {
            case "Integer" -> {
                return Integer.class;
            }
            case "Double" -> {
                return Double.class;
            }
            case "String" -> {
                return String.class;
            }
            case "Boolean" -> {
                return Boolean.class;
            }
        }
        return Void.class;
    }

    /**
     * Matches the function arguments and operation contexts to ensure the correct number and types of arguments.
     * If there are mismatches in the number of arguments or the types, it adds corresponding errors.
     *
     * @param line the line number in the source code where the function is being called
     * @param args the list of expected argument types
     * @param ops the list of operation contexts representing the actual arguments
     * @param type the expected return type of the function
     * @return the expected return type of the function
     */
    private Class<?> matchFunction(int line, ArrayList<Class<?>> args, List<SolParser.OpContext> ops, Class<?> type){
        int argSize = args.size();
        int opSize =ops.size();
        if (opSize>argSize)
            errors.add(teste.invalidNumArgsLess(line, argSize, opSize));
        else if (opSize<argSize)
            errors.add(teste.invalidNumArgsMore(line, argSize, opSize));
        else {
            for (int i = 0; i < argSize; i++) {
                SolParser.OpContext op = ops.get(i);
                Class<?> opClass = tree.get(op);
                Class<?> arg = args.get(i);
                if (arg != opClass)
                    errors.add(teste.invalidTypeArgs(line, op.getText(), opClass.getSimpleName(), arg.getSimpleName()));
            }
        }
        return type;
    }

    /**
     * Visits the function call operation in the parse tree and processes it.
     * It stores the type information from the function call into the current context.
     *
     * @param ctx the parse tree context for the function call operation
     * @return the result of visiting the function call operation, as an Object
     */
    @Override
    public Object visitFunctionCallOP(SolParser.FunctionCallOPContext ctx) {
            Object result = super.visitFunctionCallOP(ctx);
            tree.put(ctx, tree.get(ctx.functionCall()));
            return result;
    }

    /**
     * Visits the function call in the parse tree, validates the function call,
     * and ensures the arguments and return type match the function's definition.
     * If the function call is invalid, it adds an error to the list.
     *
     * @param ctx the parse tree context for the function call
     * @return the result of visiting the function call, as an Object
     */
    @Override
    public Object visitFunctionCall(SolParser.FunctionCallContext ctx) {
        Var name = new Var(ctx.VAR().getText());
        Object result = super.visitFunctionCall(ctx);
        if (!callListed.containsKey(name))
            errors.add(teste.invalidCall(ctx.start.getLine(), ctx.VAR().getText()));
        else {
            ArrayList<Class<?>> args=callListed.get(name);
            Class<?> type = stringToClass(getKeyCallListed(name).type);
            tree.put(ctx, matchFunction(ctx.start.getLine(),args, ctx.op(),type));
            return result;
        }
        tree.put(ctx, Void.class);
        return result;
    }

    /**
     * Visits the return statement in the parse tree, validates the return type,
     * and ensures it matches the expected function return type. If the return type
     * is invalid, it adds an error to the list.
     *
     * @param ctx the parse tree context for the return statement
     * @return the result of visiting the return statement, as an Object
     */
    @Override
    public Object visitReturn(SolParser.ReturnContext ctx) {
        if(functionType == null)
            errors.add(teste.invalidReturn(ctx.start.getLine()));
        else {
            if (ctx.op() != null) {
                visit(ctx.op());
                Class<?> type = tree.get(ctx.op());
                tree.put(ctx,type);
                if (functionType != type)
                    errors.add(teste.invalidReturnType(ctx.start.getLine(), ctx.op().getText(), type.getSimpleName(), functionType.getSimpleName()));
            } else if (functionType != Void.class)
                errors.add(teste.invalidReturnType(ctx.start.getLine(),"", functionType.getSimpleName()));
            else
                tree.put(ctx,Void.class);
        }
        ret=true;
        return super.visitReturn(ctx);
    }

    /**
     * Visits a variable declaration in the parse tree, validating and updating the type information.
     *
     * @param ctx The parse tree node representing the variable declaration.
     * @return The result of visiting the variable declaration.
     */
    @Override
    public Object visitVariable(SolParser.VariableContext ctx) {
        int index = gallocContent.indexOf(new Var(ctx.VAR().getText()));
        if (index!=-1) {
            Var var = gallocContent.get(index);
            String type = var.type;
            tree.put(ctx, stringToClass(type));
            if (!var.initialized)
                errors.add(teste.notInitialized(ctx.start.getLine(), var.name));
        } else {
            errors.add(teste.invalidVariable(ctx.start.getLine(), ctx.VAR().getText()));
            tree.put(ctx, Integer.class);
        }
        return super.visitVariable(ctx);
    }

    /**
     * Visits a 'while' loop in the parse tree, validating the loop condition.
     *
     * @param ctx The parse tree node representing the 'while' loop.
     * @return The result of visiting the 'while' loop.
     */
    @Override
    public Object visitWhile(SolParser.WhileContext ctx) {
        visit(ctx.op());
        if (!(tree.get(ctx.op()) == Boolean.class))
            errors.add(teste.invalidType(ctx.start.getLine(),tree.get(ctx.op()).getSimpleName(), "Boolean"));
        return visit(ctx.command());
    }

    /**
     * Visits a 'for' loop in the parse tree, validating the loop condition and loop variable types.
     *
     * @param ctx The parse tree node representing the 'for' loop.
     * @return The result of visiting the 'for' loop.
     */
    @Override
    public Object visitFor(SolParser.ForContext ctx) {
        visit(ctx.type(0));
        visit(ctx.type(1));
        if (!(tree.get(ctx.type(0)) == Integer.class))
            errors.add(teste.invalidType(ctx.start.getLine(),tree.get(ctx.type(0)).getSimpleName(), "Integer"));
        if (!(tree.get(ctx.type(1)) == Integer.class))
            errors.add(teste.invalidType(ctx.start.getLine(),tree.get(ctx.type(1)).getSimpleName(), "Integer"));
        if (gallocContent.contains(new Var(ctx.VAR().getText(), "Integer")))
            errors.add(teste.alreadyDefined(ctx.start.getLine(),ctx.VAR().getText()));
        Var variable = new Var(ctx.VAR().getText(), true, "Integer");
        if (gallocContent.contains(variable))
            errors.add(teste.alreadyDefined(ctx.start.getLine(),variable.name));
        if(callListed.containsKey(variable))
            errors.add(teste.invalidVariableFunction(ctx.start.getLine(), variable.name));
        variable.scope=scope+1;
        gallocContent.add(variable);
        Object result = visit(ctx.command());
        gallocContent.remove(variable);
        return result;
    }

    private boolean ret;
    private boolean retIf;
    private boolean retElse;

    /**
     * Visits an 'if' statement in the parse tree, validating the condition.
     *
     * @param ctx The parse tree node representing the 'if' statement.
     * @return The result of visiting the 'if' statement.
     */
    @Override
    public Object visitIf(SolParser.IfContext ctx) {
        visit(ctx.op());
        if (tree.get(ctx.op()) != Boolean.class)
            errors.add(teste.invalidType(ctx.start.getLine(),ctx.op(),"Boolean"));
        Object result = visit(ctx.command());
        retIf = ret;
        if (ctx.else_() != null){
            ret=false;
            visit(ctx.else_());
            retElse=ret;
            if ((retIf && !retElse)||(!retIf && retElse))
                errors.add(teste.invalidIfReturn(ctx.start.getLine()));
        } else
            ret = false;
        return result;
    }

    /**
     * Visits a block in the parse tree and manages scope changes.
     * This method increments the scope level when entering a block, delegates
     * the visit to the superclass method, removes any elements associated with
     * the current scope, and then decrements the scope level upon exiting the block.
     *
     * @param ctx the parse tree context representing the block to be visited.
     * @return the result of visiting the block, as returned by the superclass method.
     */
    @Override
    public Object visitBlock(SolParser.BlockContext ctx) {
        scope+=1;
        Object result = super.visitBlock(ctx);
        removeByScope();
        scope-=1;
        return result;
    }

    /**
     * Visits a 'break' statement in the parse tree, validating its usage within a loop.
     *
     * @param ctx The parse tree node representing the 'break' statement.
     * @return The result of visiting the 'break' statement.
     */
    @Override
    public Object visitBreak(SolParser.BreakContext ctx) {
        if (loops.isEmpty())
            errors.add(teste.invalidBreak(ctx.start.getLine()));
        return super.visitBreak(ctx);
    }

    /**
     * Visits parenthesis context nodes in the parse tree to handle nested expressions and perform type checking.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitParenthesis(SolParser.ParenthesisContext ctx) {
        Object result = super.visitParenthesis(ctx);
        tree.put(ctx, tree.get(ctx.op()));
        return result;
    }

    /**
     * Visits types context nodes in the parse tree to handle type definitions and perform type checking.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitTypes(SolParser.TypesContext ctx) {
        Object result = super.visitTypes(ctx);
        tree.put(ctx, tree.get(ctx.type()));
        return result;
    }

    /**
     * Visits a declaration statement in the parse tree, associating it with the declaration type and its definition.
     *
     * @param ctx The parse tree node representing the declaration statement.
     * @return The result of visiting the declaration statement.
     */
    @Override
    public Object visitDeclaration(SolParser.DeclarationContext ctx) {
        Object result = visit(ctx.declarationType());
        Class<?> type = tree.get(ctx.declarationType());
        for (SolParser.DeclarationDefContext dd:ctx.declarationDef()) {
            tree.put(dd, type);
            visit(dd);
        }
        tree.put(ctx, tree.get(ctx.declarationType()));
        return type;
    }

    /**
     * Visits a declaration definition in the parse tree, associating it with the declaration type and performing type checking.
     *
     * @param ctx The parse tree node representing the declaration definition.
     * @return The result of visiting the declaration definition.
     */
    @Override
    public Object visitDeclarationDef(SolParser.DeclarationDefContext ctx) {
        Class<?> type = tree.get(ctx);
        Var name = new Var(ctx.VAR().getText());
        if (gallocContent.contains(name))
            errors.add(teste.alreadyDefined(ctx.start.getLine(),name.name));
        if(callListed.containsKey(name))
            errors.add(teste.invalidVariableFunction(ctx.start.getLine(), name.name));
        if (ctx.op()!=null) {
            gallocContent.add(new Var(ctx.VAR().getText(), true, type.getSimpleName()));
            visit(ctx.op());
            Class<?> opType = tree.get(ctx.op());
            if (opType != type)
                errors.add(teste.invalidType(ctx.start.getLine(), opType.getSimpleName(), type.getSimpleName()));
        } else
            gallocContent.add(new Var(ctx.VAR().getText(), type.getSimpleName()));
        return super.visitDeclarationDef(ctx);
    }

    /**
     * Visits type context nodes in the parse tree to assign types.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitType(SolParser.TypeContext ctx) {
        if (ctx.INT() != null) {
            tree.put(ctx, Integer.class);
            return Integer.parseInt(ctx.INT().getText());
        } else if (ctx.DOUBLE() != null){
            tree.put(ctx, Double.class);
            return Double.parseDouble(ctx.DOUBLE().getText());
        }else if(ctx.STRING()!=null){
            tree.put(ctx, String.class);
            return ctx.STRING().getText();
        }
        tree.put(ctx, Boolean.class);
        return ctx.TRUE()!=null?Boolean.parseBoolean(ctx.TRUE().toString())
                :Boolean.parseBoolean(ctx.FALSE().toString());
    }

    /**
     * Visits negate context nodes in the parse tree to handle negation and perform type checking.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitNegate(SolParser.NegateContext ctx) {
        Object op = visit(ctx.op());
        if (ctx.SUB() != null) {
            if (tree.get(ctx.op()) != String.class || tree.get(ctx.op()) != Boolean.class)
                errors.add(teste.invalidOperator(ctx.op().getRuleIndex(), op));
            if (tree.get(ctx.op()) != Integer.class)
                tree.put(ctx, Integer.class);
            else
                tree.put(ctx, Double.class);
            return op;
        }
        if (tree.get(ctx.op()) != Boolean.class)
            errors.add(teste.invalidOperator(ctx.op().getRuleIndex(), op));
        tree.put(ctx, Boolean.class);
        return op;
    }

    /**
     * Visits add/subtract context nodes in the parse tree to handle arithmetic operations and perform type checking.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitAddSub(SolParser.AddSubContext ctx) {
        String left = ctx.op(0).getText();
        String right = ctx.op(1).getText();
        visit(ctx.op(0));
        visit(ctx.op(1));
        if (tree.get(ctx.op(0)) == String.class || tree.get(ctx.op(1)) == String.class) {
            tree.put(ctx, String.class);
            return left+right;
        }
        else if(tree.get(ctx.op(0)) == Boolean.class || tree.get(ctx.op(1)) == Boolean.class) {
            errors.add(teste.invalidTwoOperators(ctx.op(0).getRuleIndex(), left, right,tree.get(ctx.op(0)) == Boolean.class, tree.get(ctx.op(1)) == Boolean.class));
            return left;
        }else if(tree.get(ctx.op(0)) == Double.class || tree.get(ctx.op(1)) == Double.class) {
            tree.put(ctx, Double.class);
            return Double.parseDouble(left)+Double.parseDouble(right);
        }
        tree.put(ctx, Integer.class);
        return 0;
    }

    /**
     * Visits multiply/divide/modulus context nodes in the parse tree to handle arithmetic operations and perform type checking.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitMultDivMod(SolParser.MultDivModContext ctx) {
        String left = ctx.op(0).getText();
        String right = ctx.op(1).getText();
        visit(ctx.op(0));
        visit(ctx.op(1));
        Class<?> e = tree.get(ctx.op(0));
        Class<?> e1 = tree.get(ctx.op(1));
        if (tree.get(ctx.op(0)) == Boolean.class || tree.get(ctx.op(1)) == Boolean.class || tree.get(ctx.op(0)) == String.class || tree.get(ctx.op(1)) == String.class) {
            errors.add(teste.invalidTwoOperators(ctx.op(0).getRuleIndex(), left, right, tree.get(ctx.op(0)) != Boolean.class || tree.get(ctx.op(0)) != String.class, tree.get(ctx.op(1)) != Boolean.class || tree.get(ctx.op(1)) != String.class));
            tree.put(ctx, Integer.class);
            return left;
        }else if (tree.get(ctx.op(0)) == Double.class || tree.get(ctx.op(1)) == Double.class) {
            if (ctx.MOD() != null) {
                errors.add(teste.invalidTwoOperators(ctx.op(0).getRuleIndex(), left, right, tree.get(ctx.op(0)) == Double.class, tree.get(ctx.op(1)) == Double.class));
                tree.put(ctx, Integer.class);
                return left;
            }tree.put(ctx, Double.class);
            return Double.parseDouble(left)/Double.parseDouble(right);
        }
        tree.put(ctx, Integer.class);
        return 0;
    }

    /**
     * Visits comparison context nodes to handle comparison operations and perform type checking.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitCompareMore(SolParser.CompareMoreContext ctx) {
        Object left = visit(ctx.op(0));
        Object right = visit(ctx.op(1));
        Class<?> leftClass = tree.get(ctx.op(0));
        Class<?> rightClass = tree.get(ctx.op(1));
        if (!((leftClass == Integer.class || leftClass == Double.class) && (rightClass == Integer.class || rightClass == Double.class))){
            errors.add(teste.invalidTwoOperators(ctx.op(0).getRuleIndex(), left, right, !(leftClass == Integer.class || leftClass == Double.class), !(rightClass == Integer.class || rightClass == Double.class)));
            return left;
        }tree.put(ctx, Boolean.class);
        return true;
    }

    /**
     * Visits comparison context nodes to handle comparison operations and perform type checking.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitCompare(SolParser.CompareContext ctx) {
        Object left = visit(ctx.op(0));
        Object right = visit(ctx.op(1));
        Class<?> leftClass = tree.get(ctx.op(0));
        Class<?> rightClass = tree.get(ctx.op(1));
        if (leftClass == Boolean.class &&!(rightClass == Boolean.class)) {
            errors.add(teste.invalidComparison(ctx.op(0).getRuleIndex(), left, right));
            return left;
        }else if (leftClass == String.class && !(rightClass == String.class)) {
            errors.add(teste.invalidComparison(ctx.op(0).getRuleIndex(), left, right));
            return left;
        }else if (!(leftClass == Double.class || leftClass == Integer.class) || !(rightClass == Double.class || rightClass == Integer.class)){
            errors.add(teste.invalidComparison(ctx.op(0).getRuleIndex(),left,right));
            return left;
        }tree.put(ctx, Boolean.class);
        return true;
    }

    /**
     * Visits logical 'and' context nodes in the parse tree to handle logical operations and perform type checking.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitAnd(SolParser.AndContext ctx) {
        Object left = visit(ctx.op(0));
        Object right = visit(ctx.op(1));
        Class<?> leftClass = tree.get(ctx.op(0));
        Class<?> rightClass = tree.get(ctx.op(1));
        if (!(leftClass == Boolean.class && rightClass == Boolean.class)) {
            errors.add(teste.invalidTwoOperators(ctx.op(0).getRuleIndex(), left, right, !(left instanceof Boolean), !(right instanceof Boolean)));
            return left;
        }tree.put(ctx, Boolean.class);
        return true;
    }

    /**
     * Visits logical 'or' context nodes in the parse tree to handle logical operations and perform type checking.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitOr(SolParser.OrContext ctx) {
        Object left = visit(ctx.op(0));
        Object right = visit(ctx.op(1));
        Class<?> leftClass = tree.get(ctx.op(0));
        Class<?> rightClass = tree.get(ctx.op(1));
        if (!(leftClass == Boolean.class && rightClass == Boolean.class)) {
            errors.add(teste.invalidTwoOperators(ctx.op(0).getRuleIndex(), left, right, !(left instanceof Boolean), !(right instanceof Boolean)));
            return left;
        }tree.put(ctx, Boolean.class);
        return true;
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
