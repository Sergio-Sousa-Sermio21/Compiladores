// Import necessary packages and classes
import Sol.SolBaseVisitor;
import Sol.SolParser;

import javax.management.InvalidAttributeValueException;
import java.io.InvalidObjectException;
import java.util.ArrayList;

// Define the class SolVisitor which extends SolBaseVisitor
public class SolVisitor extends SolBaseVisitor {
    // Declare instance variables
    private ArrayList<Instruction> instructions;
    private ArrayList<Object> constantPool;

    // Constructor initializes instance variables
    SolVisitor() {
        instructions = new ArrayList<Instruction>();
        constantPool = new ArrayList<Object>();
    }

    // Getter method for instructions
    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    // Getter method for constant pool
    public ArrayList<Object> getConstantPool() {
        return constantPool;
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitType(SolParser.TypeContext ctx) {
        if (ctx.INT() != null) {
            Integer i = Integer.getInteger(ctx.INT().getText());
            instructions.add(new Instruction(TokenTasm.ICONST, i));
            return i;
        } else if (ctx.DOUBLE() != null){
            Double d = Double.parseDouble(ctx.DOUBLE().getText());
            constantPool.add(d);
            instructions.add(new Instruction(TokenTasm.DCONST,constantPool.size()-1));
            return d;
        }else if(ctx.STRING()!=null){
            String s = ctx.STRING().getText();
            constantPool.add(s);
            instructions.add(new Instruction(TokenTasm.SCONST,constantPool.size()-1));
            return s;
        }  else if (ctx.TRUE() != null) {
            Boolean t = Boolean.getBoolean(ctx.TRUE().getText());
            instructions.add(new Instruction(TokenTasm.TCONST));
            return t;
        }else {
            Boolean f = Boolean.getBoolean(ctx.FALSE().getText());
            instructions.add(new Instruction(TokenTasm.TCONST));
            return f;
        }
    }

    /**
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitParenthesis(SolParser.ParenthesisContext ctx) {
        return visit(ctx.op());
    }

    //TODO
    /**
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitNegate(SolParser.NegateContext ctx) {
        return visit(ctx.op());
    }

    /**
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitAddition(SolParser.AdditionContext ctx) {
        Object left = visit(ctx.op(0));
        Object right = visit(ctx.op(1));
        if (left instanceof String || right instanceof String)
            instructions.add(new Instruction(TokenTasm.SADD));
        else if (left instanceof Boolean || right instanceof Boolean)
            throw (left instanceof Boolean) ? new RuntimeException("error in line " + ctx.op(1).getRuleIndex()
                        + ": invalid atribute " + left.toString() + ".\n")
                        : new RuntimeException("error in line " + ctx.op(1).getRuleIndex()
                        + ": invalid atribute " + right.toString() + ".\n");
        else if (left instanceof Double || right instanceof Double)
            instructions.add(new Instruction(TokenTasm.DCONST));
        else
            instructions.add(new Instruction(TokenTasm.ICONST));
        return visit(ctx.op().get(0));
    }

    /**
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitAnd(SolParser.AndContext ctx) {
        return super.visitAnd(ctx);
    }

    /**
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitOr(SolParser.OrContext ctx) {
        return super.visitOr(ctx);
    }
}
