// Import necessary packages and classes
import Sol.SolBaseVisitor;
import Sol.SolParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.HashMap;
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
    class Var {
        protected String name;
        protected boolean initialized;
        protected String type;

        Var(String n){
            name=n;
            initialized=false;
            type =null;
        }
        Var(String n, boolean i, String t){
            name=n;
            initialized=i;
            type =t;
        }
        Var(String n, String t){
            name=n;
            initialized=false;
            type =t;
        }
        public boolean equals(Object obj) {
            return name.equals(obj.toString());
        }
        @Override
        public String toString() {
            return name;
        }
    }
    private ArrayList<Var> gallocContent;
    private Stack<Boolean> loops;

    /**
     * Constructor for SolVisitorTypeCheck.
     * Initializes instance variables.
     */
    SolVisitorTypeCheck() {
        tree = new ParseTreeProperty<Class<?>>();
        teste = new TesteSemantico();
        errors = new ArrayList<String>();
        gallocContent = new ArrayList<>();
        loops=new Stack<>();
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
     * Visits all the possible commands
     * (print, block, while, for, if, break, and variable values)
     * Verifies if variables are declared
     *
     * @param ctx the parse tree
     * @return
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
            int index = gallocContent.indexOf(new Var(ctx.VAR().getText()));
            Var var = gallocContent.get(index);
            String type = var.type;
            var.initialized = true;
            gallocContent.set(index, var);
            visit(ctx.op());
            String opType = tree.get(ctx.op()).getSimpleName();
            if (type==null)
                errors.add(teste.invalidVariable(ctx.start.getLine(), ctx.VAR().getText()));
            else if (!type.equals(opType))
                errors.add(teste.invalidType(ctx.start.getLine(), opType, type));
        }
        return result;
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitVariable(SolParser.VariableContext ctx) {
        int index = gallocContent.indexOf(new Var(ctx.VAR().getText()));
        if (index!=-1) {
            Var var = gallocContent.get(index);
            String type = var.type;
            switch (type) {
                case "Integer" -> tree.put(ctx, Integer.class);
                case "Double" -> tree.put(ctx, Double.class);
                case "String" -> tree.put(ctx, String.class);
                case "Boolean" -> tree.put(ctx, Boolean.class);
            }
            if (!var.initialized)
                errors.add(teste.notInitialized(ctx.start.getLine(), var.name));
        } else {
            errors.add(teste.invalidVariable(ctx.start.getLine(), ctx.VAR().getText()));
            tree.put(ctx, Integer.class);
        }
        return super.visitVariable(ctx);
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitWhile(SolParser.WhileContext ctx) {
        visit(ctx.op());
        if (!(tree.get(ctx.op()) == Boolean.class))
            errors.add(teste.invalidType(ctx.start.getLine(),tree.get(ctx.op()).getSimpleName(), "Boolean"));
        return visit(ctx.command());
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
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
        gallocContent.add(new Var(ctx.VAR().getText(),true, "Integer"));
        return visit(ctx.command());
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitIf(SolParser.IfContext ctx) {
        if (!(visit(ctx.op()) instanceof Boolean))
            errors.add(teste.invalidType(ctx.start.getLine(),ctx.op(),"boolean"));
        visit(ctx.command());
        return visit(ctx.else_());
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
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

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitIntegerType(SolParser.IntegerTypeContext ctx) {
        tree.put(ctx, Integer.class);
        return super.visitIntegerType(ctx);
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitDoubleType(SolParser.DoubleTypeContext ctx) {
        tree.put(ctx, Double.class);
        return super.visitDoubleType(ctx);
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitStringType(SolParser.StringTypeContext ctx) {
        tree.put(ctx, String.class);
        return super.visitStringType(ctx);
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitBooleanType(SolParser.BooleanTypeContext ctx) {
        tree.put(ctx, Boolean.class);
        return super.visitBooleanType(ctx);
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
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
        return result;
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitDeclarationDef(SolParser.DeclarationDefContext ctx) {
        Class<?> type = tree.get(ctx);
        if (gallocContent.contains(new Var(ctx.VAR().getText())))
            errors.add(teste.alreadyDefined(ctx.start.getLine(),ctx.VAR().getText()));
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
            if (op instanceof String || op instanceof Boolean)
                errors.add(teste.invalidOperator(ctx.op().getRuleIndex(), op));
            if (op instanceof Integer)
                tree.put(ctx, Integer.class);
            else
                tree.put(ctx, Double.class);
            return op;
        }
        if (!(op instanceof Boolean))
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
        Object left = visit(ctx.op(0));
        Object right = visit(ctx.op(1));
        if (left instanceof String || right instanceof String) {
            tree.put(ctx, String.class);
            return left.toString()+right.toString();
        }
        else if(left instanceof Boolean || right instanceof Boolean) {
            errors.add(teste.invalidTwoOperators(ctx.op(0).getRuleIndex(), left, right, left instanceof Boolean, right instanceof Boolean));
            return left;
        }else if(left instanceof Double || right instanceof Double) {
            tree.put(ctx, Double.class);
            return Double.parseDouble(left.toString())+Double.parseDouble(right.toString());
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
        Object left = visit(ctx.op(0));
        Object right = visit(ctx.op(1));
        if (left instanceof Boolean || right instanceof Boolean || left instanceof String || right instanceof String) {
            errors.add(teste.invalidTwoOperators(ctx.op(0).getRuleIndex(), left, right, left instanceof Boolean || left instanceof String, right instanceof Boolean || right instanceof String));
            return left;
        }else if (left instanceof Double || right instanceof Double) {
            if (ctx.MOD() != null) {
                errors.add(teste.invalidTwoOperators(ctx.op(0).getRuleIndex(), left, right, left instanceof Double, right instanceof Double));
                return left;
            }tree.put(ctx, Double.class);
            return Double.parseDouble(left.toString())/Double.parseDouble(right.toString());
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
}
