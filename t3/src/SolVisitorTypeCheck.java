// Import necessary packages and classes
import Sol.SolBaseVisitor;
import Sol.SolParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * SolVisitorTypeCheck extends SolBaseVisitor to provide type checking functionality
 * for the Sol language parse tree.
 */
public class SolVisitorTypeCheck extends SolBaseVisitor {
    // Declare instance variables
    private ParseTreeProperty<Class<?>> tree;
    private TesteSemantico teste;
    private ArrayList<String> errors;

    private HashMap<String, String> gallocContent;
    private boolean insideLoop;

    /**
     * Constructor for SolVisitorTypeCheck.
     * Initializes instance variables.
     */
    SolVisitorTypeCheck() {
        tree = new ParseTreeProperty<Class<?>>();
        teste = new TesteSemantico();
        errors = new ArrayList<String>();
        gallocContent = new HashMap<>();
        insideLoop=false;
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
     * @return The result of visiting the command.
     */
    @Override
    public Object visitCommand(SolParser.CommandContext ctx) {
        Object result = null;
        if (ctx.while_() != null){
            insideLoop = true;
            result = visit(ctx.while_());
            insideLoop = false;
            return result;
        }
        if (ctx.for_() !=null){
            insideLoop = true;
            result = visit(ctx.for_());
            insideLoop = false;
            return result;
        }
        result = super.visitCommand(ctx);

        if (ctx.VAR() != null) {
            String type = gallocContent.get(ctx.VAR().getText());
            visit(ctx.op());
            String opType = tree.get(ctx.op()).getSimpleName();
            if (type==null)
                errors.add(teste.invalidVariable(ctx.getRuleIndex(), ctx.VAR().getText()));
            else if (!type.equals(opType))
                errors.add(teste.invalidType(ctx.getRuleIndex(), opType, type));
        }
        return result;
    }

    /**
     * Visits a variable declaration in the parse tree, validating and updating the type information.
     *
     * @param ctx The parse tree node representing the variable declaration.
     * @return The result of visiting the variable declaration.
     */
    @Override
    public Object visitVariable(SolParser.VariableContext ctx) {
        String type = gallocContent.get(ctx.VAR().getText());
        if (type!=null)
            switch (type) {
                case "Integer" -> tree.put(ctx, Integer.class);
                case "Double" -> tree.put(ctx, Double.class);
                case "String" -> tree.put(ctx, String.class);
                case "Boolean" -> tree.put(ctx, Boolean.class);
            }
        else
            errors.add(teste.invalidVariable(ctx.getRuleIndex(), ctx.VAR().getText()));
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
            errors.add(teste.invalidType(ctx.getRuleIndex(),tree.get(ctx.op()).getSimpleName(), "Boolean"));
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
            errors.add(teste.invalidType(ctx.getRuleIndex(),tree.get(ctx.type(0)).getSimpleName(), "Integer"));
        if (!(tree.get(ctx.type(1)) == Integer.class))
            errors.add(teste.invalidType(ctx.getRuleIndex(),tree.get(ctx.type(1)).getSimpleName(), "Integer"));
        return visit(ctx.command());
    }

    /**
     * Visits an 'if' statement in the parse tree, validating the condition.
     *
     * @param ctx The parse tree node representing the 'if' statement.
     * @return The result of visiting the 'if' statement.
     */
    @Override
    public Object visitIf(SolParser.IfContext ctx) {
        if (!(visit(ctx.op()) instanceof Boolean))
            errors.add(teste.invalidType(ctx.getRuleIndex(),ctx.op(),"boolean"));
        visit(ctx.command());
        return visit(ctx.else_());
    }

    /**
     * Visits a 'break' statement in the parse tree, validating its usage within a loop.
     *
     * @param ctx The parse tree node representing the 'break' statement.
     * @return The result of visiting the 'break' statement.
     */
    @Override
    public Object visitBreak(SolParser.BreakContext ctx) {
        if (!insideLoop)
            errors.add(teste.invalidBreak(ctx.getRuleIndex()));
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
     * Visits relation context nodes in the parse tree to handle relational operations and perform type checking.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitRelations(SolParser.RelationsContext ctx) {
        tree.put(ctx, tree.get(ctx.rel()));
        return super.visitRelations(ctx);
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
        return result;
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
        gallocContent.put(ctx.VAR().getText(), type.getSimpleName());
        if (ctx.INT() != null && type != Integer.class) {
            errors.add(teste.invalidType(ctx.getRuleIndex(),"Integer",type.getSimpleName()));
        } else if (ctx.DOUBLE() != null && type != Double.class){
            errors.add(teste.invalidType(ctx.getRuleIndex(),"Double",type.getSimpleName()));
        }else if(ctx.STRING()!=null && type != String.class){
            errors.add(teste.invalidType(ctx.getRuleIndex(),"String",type.getSimpleName()));
        }else if ((ctx.FALSE()!= null || ctx.TRUE()!=null)&& type != Boolean.class)
            errors.add(teste.invalidType(ctx.getRuleIndex(),"Boolean",type.getSimpleName()));
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
        return Integer.parseInt(left.toString())+Integer.parseInt(right.toString());
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
        return Integer.parseInt(left.toString())/Integer.parseInt(right.toString());
    }

    /**
     * Visits comparison context nodes to handle comparison operations and perform type checking.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitCompareMore(SolParser.CompareMoreContext ctx) {
        Object left = visit(ctx.type(0));
        Object right = visit(ctx.type(1));
        if (!((left instanceof Integer || left instanceof Double) && (right instanceof Integer || right instanceof Double))){
            errors.add(teste.invalidTwoOperators(ctx.type(0).getRuleIndex(), left, right, !(left instanceof Integer || left instanceof Double), !(right instanceof Integer || right instanceof Double)));
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
        Object left = visit(ctx.type(0));
        Object right = visit(ctx.type(1));
        if (left instanceof Boolean &&!(right instanceof Boolean)) {
            errors.add(teste.invalidComparison(ctx.type(0).getRuleIndex(), left, right));
            return left;
        }else if (left instanceof String && !(right instanceof String)) {
            errors.add(teste.invalidComparison(ctx.type(0).getRuleIndex(), left, right));
            return left;
        }else if (!(left instanceof Double || left instanceof Integer) || !(right instanceof Double || right instanceof Integer)){
            errors.add(teste.invalidComparison(ctx.type(0).getRuleIndex(),left,right));
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
        Object left = visit(ctx.type(0));
        Object right = visit(ctx.type(1));
        if (!(left instanceof Boolean && right instanceof Boolean)) {
            errors.add(teste.invalidTwoOperators(ctx.type(0).getRuleIndex(), left, right, !(left instanceof Boolean), !(right instanceof Boolean)));
            return left;
        }tree.put(ctx, Boolean.class);
        return Boolean.parseBoolean(left.toString()) && Boolean.parseBoolean(right.toString());
    }

    /**
     * Visits logical 'or' context nodes in the parse tree to handle logical operations and perform type checking.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitOr(SolParser.OrContext ctx) {
        Object left = visit(ctx.type(0));
        Object right = visit(ctx.type(1));
        if (!(left instanceof Boolean && right instanceof Boolean)) {
            errors.add(teste.invalidTwoOperators(ctx.type(0).getRuleIndex(), left, right, !(left instanceof Boolean), !(right instanceof Boolean)));
            return left;
        }tree.put(ctx, Boolean.class);
        return Boolean.parseBoolean(left.toString()) || Boolean.parseBoolean(right.toString());
    }
}
