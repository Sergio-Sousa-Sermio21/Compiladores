// Import necessary packages and classes
import Sol.SolBaseVisitor;
import Sol.SolParser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;

// Define the class SolVisitor which extends SolBaseVisitor
public class SolVisitor extends SolBaseVisitor {
    // Declare instance variables
    private ArrayList<Instruction> instructions;
    private ParseTreeProperty<Class<?>> tree;
    private ArrayList<Object> constantPool;
    private TesteSemantico teste;
    private ArrayList<String> errors;

    // Constructor initializes instance variables
    SolVisitor() {
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
        }else if (ctx.TRUE() != null) {
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
    public Object visitAddSub(SolParser.AddSubContext ctx) {
        Object left = visit(ctx.op(0));
        Object right = visit(ctx.op(1));
        TokenTasm[] operator = null;
        if (ctx.addsubOP.getText().compareTo("+") == 0)
            operator = new TokenTasm[]{TokenTasm.SADD, TokenTasm.DADD, TokenTasm.IADD};
        else
            operator = new TokenTasm[]{null, TokenTasm.DSUB, TokenTasm.ISUB};
        if ((left instanceof String || right instanceof String) && operator[0]!=null) {
            instructions.add(new Instruction(operator[0]));
        }
        else if (left instanceof Boolean || right instanceof Boolean)
            errors.add(teste.invalidTwoOperators(ctx.op(0).getRuleIndex(), left, right, left instanceof Boolean, right instanceof Boolean));
        else if (left instanceof Double || right instanceof Double) {
            instructions.add(new Instruction(operator[1]));
            return Double.parseDouble(left.toString())+Double.parseDouble(right.toString());
        }
        instructions.add(new Instruction(operator[2]));
        return Integer.parseInt(left.toString())+Integer.parseInt(right.toString());
    }

    @Override
    public Object visitMultDivMod(SolParser.MultDivModContext ctx) {
        Object left = visit(ctx.op(0));
        Object right = visit(ctx.op(1));
        TokenTasm[] operator = null;
        if (ctx.multdivmodOp.getText().equals("*"))
            operator = new TokenTasm[]{TokenTasm.DMULT, TokenTasm.IMULT};
        else if (ctx.multdivmodOp.getText().equals("/"))
            operator = new TokenTasm[]{TokenTasm.DMULT, TokenTasm.IMULT};
        else
            operator = new TokenTasm[]{null, TokenTasm.ISUB};

        if (left instanceof Boolean || right instanceof Boolean || left instanceof String || right instanceof String)
            errors.add(teste.invalidTwoOperators(ctx.op(0).getRuleIndex(), left, right, left instanceof Boolean ||left instanceof String, right instanceof Boolean ||right instanceof String));
        else if ((left instanceof Double || right instanceof Double) && operator[0] != null) {
            instructions.add(new Instruction(operator[0]));
            return Double.parseDouble(left.toString())/Double.parseDouble(right.toString());
        }
        instructions.add(new Instruction(operator[1]));
        return Integer.parseInt(left.toString())/Integer.parseInt(right.toString());
    }

    @Override
    public Object visitCompareMore(SolParser.CompareMoreContext ctx) {
        Object left = visit(ctx.type(0));
        Object right = visit(ctx.type(1));
        if (!(left instanceof Integer && right instanceof Integer))
            errors.add(teste.invalidTwoOperators(ctx.type(0).getRuleIndex(), left, right, !(left instanceof Integer), !(right instanceof Integer)));
        instructions.add(new Instruction(TokenTasm.IMOD));
        return Integer.parseInt(left.toString())/Integer.parseInt(right.toString());
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
        instructions.add(new Instruction(TokenTasm.AND));
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
        instructions.add(new Instruction(TokenTasm.OR));
        return Boolean.parseBoolean(left.toString()) || Boolean.parseBoolean(right.toString());
    }
}
