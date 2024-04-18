// Import necessary packages and classes
import Sol.SolBaseVisitor;
import Sol.SolParser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;

// Define the class SolVisitor which extends SolBaseVisitor
public class SolVisitorTypeCheck extends SolBaseVisitor {
    // Declare instance variables
    private ParseTreeProperty<Class<?>> tree;
    private ArrayList<Instruction> instructions;
    private ArrayList<Object> constantPool;
    private TesteSemantico teste;
    private ArrayList<String> errors;

    // Constructor initializes instance variables
    SolVisitorTypeCheck() {
        tree = new ParseTreeProperty<Class<?>>();
        instructions = new ArrayList<Instruction>();
        constantPool = new ArrayList<Object>();
        teste = new TesteSemantico();
        errors = new ArrayList<String>();
    }

    // Getter method for instructions
    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    // Getter method for constant pool
    public ArrayList<Object> getConstantPool() {
        return constantPool;
    }

    public ArrayList<String> getErrors() {
        return errors;
    }

    /**
     * @param ctx the parse tree
     * @return
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
     *
     * @param ctx the parse tree
     * @return
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
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitAddSub(SolParser.AddSubContext ctx) {
        Object left = visit(ctx.op(0));
        Object right = visit(ctx.op(1));
        if (left instanceof String || right instanceof String)
            tree.put(ctx, String.class);
        else if(left instanceof Boolean || right instanceof Boolean)
            errors.add(teste.invalidTwoOperators(ctx.op(0).getRuleIndex(), left, right, left instanceof Boolean, right instanceof Boolean));
        else if(left instanceof Double || right instanceof Double) {
            tree.put(ctx, Double.class);
            return Double.parseDouble(left.toString())+Double.parseDouble(right.toString());
        }
        tree.put(ctx, Integer.class);
        return Integer.parseInt(left.toString())+Integer.parseInt(right.toString());
    }

    @Override
    public Object visitMultDivMod(SolParser.MultDivModContext ctx) {
        Object left = visit(ctx.op(0));
        Object right = visit(ctx.op(1));
        if (left instanceof Boolean || right instanceof Boolean || left instanceof String || right instanceof String)
            errors.add(teste.invalidTwoOperators(ctx.op(0).getRuleIndex(), left, right, left instanceof Boolean ||left instanceof String, right instanceof Boolean ||right instanceof String));
        else if (left instanceof Double || right instanceof Double) {
            if (ctx.MOD() != null)
                errors.add(teste.invalidTwoOperators(ctx.op(0).getRuleIndex(), left, right, left instanceof Double, right instanceof Double));
            tree.put(ctx, Double.class);
            return Double.parseDouble(left.toString())/Double.parseDouble(right.toString());
        }
        tree.put(ctx, Integer.class);
        return Integer.parseInt(left.toString())/Integer.parseInt(right.toString());
    }

    /**
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitCompareMore(SolParser.CompareMoreContext ctx) {
        Object left = visit(ctx.type(0));
        Object right = visit(ctx.type(1));
        if (!((left instanceof Integer||left instanceof Double) && (right instanceof Integer || right instanceof Double)))
            errors.add(teste.invalidTwoOperators(ctx.type(0).getRuleIndex(), left, right, !(left instanceof Integer||left instanceof Double), !(right instanceof Integer||right instanceof Double)));
        tree.put(ctx, Boolean.class);
        return true;
    }

    /**
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitCompare(SolParser.CompareContext ctx) {
        Object left = visit(ctx.type(0));
        Object right = visit(ctx.type(1));
        if (left instanceof Boolean &&!(right instanceof Boolean))
            errors.add(teste.invalidComparison(ctx.type(0).getRuleIndex(),left,right));
        else if (left instanceof String && !(right instanceof String))
            errors.add(teste.invalidComparison(ctx.type(0).getRuleIndex(),left,right));
        else if (!(left instanceof Double || left instanceof Integer) || !(right instanceof Double || right instanceof Integer))
            errors.add(teste.invalidComparison(ctx.type(0).getRuleIndex(),left,right));
        tree.put(ctx, Boolean.class);
        return true;
    }

    /**
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitAnd(SolParser.AndContext ctx) {
        Object left = visit(ctx.type(0));
        Object right = visit(ctx.type(1));
        if (!(left instanceof Boolean && right instanceof Boolean))
            errors.add(teste.invalidTwoOperators(ctx.type(0).getRuleIndex(), left, right, !(left instanceof Boolean), !(right instanceof Boolean)));
        tree.put(ctx, Boolean.class);
        return Boolean.parseBoolean(left.toString()) && Boolean.parseBoolean(right.toString());
    }

    /**
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitOr(SolParser.OrContext ctx) {
        Object left = visit(ctx.type(0));
        Object right = visit(ctx.type(1));
        if (!(left instanceof Boolean && right instanceof Boolean))
            errors.add(teste.invalidTwoOperators(ctx.type(0).getRuleIndex(), left, right, !(left instanceof Boolean), !(right instanceof Boolean)));
        tree.put(ctx, Boolean.class);
        return Boolean.parseBoolean(left.toString()) || Boolean.parseBoolean(right.toString());
    }
}
