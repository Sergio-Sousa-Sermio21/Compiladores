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
     * @return
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
            String opType = tree.get(ctx.op()).getName();
            if (type==null)
                errors.add(teste.invalidVariable(ctx.getRuleIndex(), ctx.VAR().getText()));
            else if (!type.equals(opType))
                errors.add(teste.invalidType(ctx.getRuleIndex(), opType, type));
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
        String type = gallocContent.get(ctx.VAR().getText());
        if (type!=null)
            switch (type) {
                case "java.lang.Integer" -> tree.put(ctx, Integer.class);
                case "java.lang.Double" -> tree.put(ctx, Double.class);
                case "java.lang.String" -> tree.put(ctx, String.class);
                case "java.lang.Boolean" -> tree.put(ctx, Boolean.class);
            }
        else
            errors.add(teste.invalidVariable(ctx.getRuleIndex(), ctx.VAR().getText()));
        return super.visitVariable(ctx);
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitWhile(SolParser.WhileContext ctx) {
        if (!(visit(ctx.op()) instanceof Boolean))
            errors.add(teste.invalidType(ctx.getRuleIndex(),ctx.op(), "boolean"));
        return visit(ctx.command());
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitFor(SolParser.ForContext ctx) {
        if (!(visit(ctx.type(0)) instanceof Integer))
            errors.add(teste.invalidType(ctx.getRuleIndex(),ctx.type(0), "Integer"));
        if (!(visit(ctx.type(1)) instanceof Integer))
            errors.add(teste.invalidType(ctx.getRuleIndex(),ctx.type(1), "Integer"));
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
            errors.add(teste.invalidType(ctx.getRuleIndex(),ctx.op(),"boolean"));
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
        tree.put(ctx, tree.get(ctx.op()));
        return super.visitParenthesis(ctx);
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
        tree.put(ctx, tree.get(ctx.type()));
        return super.visitTypes(ctx);
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
        gallocContent.put(ctx.VAR().getText(), type.getName());
        if (ctx.INT() != null && type != Integer.class) {
            errors.add(teste.invalidType(ctx.getRuleIndex(),type.getSimpleName(),type.getSimpleName()));
        } else if (ctx.DOUBLE() != null && type != Double.class){
            errors.add(teste.invalidType(ctx.getRuleIndex(),type.getSimpleName(),type.getSimpleName()));
        }else if(ctx.STRING()!=null && type != String.class){
            errors.add(teste.invalidType(ctx.getRuleIndex(),type.getSimpleName(),type.getSimpleName()));
        }else if ((ctx.FALSE()!= null || ctx.TRUE()!=null)&& type != Boolean.class)
            errors.add(teste.invalidType(ctx.getRuleIndex(),type.getSimpleName(),type.getSimpleName()));
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
