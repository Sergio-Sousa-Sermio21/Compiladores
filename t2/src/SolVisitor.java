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

    // Constructor initializes instance variables
    SolVisitor(ParseTreeProperty<Class<?>> t) {
        tree = t;
        instructions = new ArrayList<Instruction>();
        constantPool = new ArrayList<Object>();
        teste = new TesteSemantico();
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
        if (tree.get(ctx) == Integer.class) {
            Integer i = Integer.getInteger(ctx.INT().getText());
            instructions.add(new Instruction(TokenTasm.ICONST, i));
            if (tree.get(ctx.getParent().getParent()) == String.class)
                instructions.add(new Instruction(TokenTasm.ITOS));
            else if (tree.get(ctx.getParent().getParent()) == Double.class)
                instructions.add(new Instruction(TokenTasm.ITOD));
            return i;
        } else if (tree.get(ctx) == Double.class){
            Double d = Double.parseDouble(ctx.DOUBLE().getText());
            constantPool.add(d);
            instructions.add(new Instruction(TokenTasm.DCONST,constantPool.size()-1));
            if (tree.get(ctx.getParent().getParent()) == String.class)
                instructions.add(new Instruction(TokenTasm.DTOS));
            return d;
        }else if(tree.get(ctx) == String.class){
            String s = ctx.STRING().getText();
            constantPool.add(s);
            instructions.add(new Instruction(TokenTasm.SCONST,constantPool.size()-1));
            return s;
        }else if (ctx.TRUE() != null) {
            Boolean t = Boolean.getBoolean(ctx.TRUE().getText());
            instructions.add(new Instruction(TokenTasm.TCONST));
            if (tree.get(ctx.getParent().getParent()) == String.class)
                instructions.add(new Instruction(TokenTasm.BTOS));
            return t;
        }else {
            Boolean f = Boolean.getBoolean(ctx.FALSE().getText());
            instructions.add(new Instruction(TokenTasm.FCONST));
            if (tree.get(ctx.getParent().getParent()) == String.class)
                instructions.add(new Instruction(TokenTasm.BTOS));
            return f;
        }
    }

    @Override
    public Object visitCommand(SolParser.CommandContext ctx) {
        if (tree.get(ctx.op()) == Integer.class)
            instructions.add(new Instruction(TokenTasm.IPRINT));
        if (tree.get(ctx.op()) == Double.class)
            instructions.add(new Instruction(TokenTasm.DPRINT));
        if (tree.get(ctx.op()) == String.class)
            instructions.add(new Instruction(TokenTasm.SPRINT));
        if (tree.get(ctx.op()) == Boolean.class)
            instructions.add(new Instruction(TokenTasm.BPRINT));
        return super.visitCommand(ctx);
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

    /**
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitNegate(SolParser.NegateContext ctx) {
        if (tree.get(ctx) == Boolean.class)
            instructions.add(new Instruction(TokenTasm.NOT));
        else if (tree.get(ctx) == Integer.class)
            instructions.add(new Instruction(TokenTasm.IUMINUS));
        else
            instructions.add(new Instruction(TokenTasm.DUMINUS));
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
        if (tree.get(ctx) == String.class){
            instructions.add(new Instruction(TokenTasm.SADD));
            return left.toString()+right.toString();
        }
        if (ctx.addsubOP.getText().compareTo("+") == 0)
            operator = new TokenTasm[]{TokenTasm.DADD, TokenTasm.IADD};
        else
            operator = new TokenTasm[]{TokenTasm.DSUB, TokenTasm.ISUB};
        if (tree.get(ctx) == Double.class) {
            instructions.add(new Instruction(operator[1]));
            return Double.parseDouble(left.toString())+Double.parseDouble(right.toString());
        }
        instructions.add(new Instruction(operator[2]));
        return Integer.parseInt(left.toString())+Integer.parseInt(right.toString());
    }

    /**
     *
     * @param ctx the parse tree
     * @return
     */
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
            operator = new TokenTasm[]{null, TokenTasm.IMOD};
        if (tree.get(ctx) == Double.class && operator[0] != null) {
            instructions.add(new Instruction(operator[0]));
            return Double.parseDouble(left.toString())/Double.parseDouble(right.toString());
        }
        instructions.add(new Instruction(operator[1]));
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
        TokenTasm[] operator = null;
        Instruction addNot = null;
        switch (ctx.compareMoreOp.getText()){
            case "<" ->{
                operator = new TokenTasm[]{TokenTasm.DLT, TokenTasm.ILT};
            }
            case ">" ->{
                operator = new TokenTasm[]{TokenTasm.DLT, TokenTasm.ILT};
                addNot=new Instruction(TokenTasm.NOT);
            }
            case "<=" ->{
                operator = new TokenTasm[]{TokenTasm.DLEQ, TokenTasm.ILEQ};
            }
            default ->{
                operator = new TokenTasm[]{TokenTasm.DLEQ, TokenTasm.ILEQ};
                addNot=new Instruction(TokenTasm.NOT);
            }
        }
        if (tree.get(ctx) == Double.class) {
            instructions.add(new Instruction(operator[0]));
            if (addNot != null)
                instructions.add(addNot);
            return Double.parseDouble(left.toString()) < Double.parseDouble(right.toString());
        }
        instructions.add(new Instruction(operator[1]));
        if (tree.get(ctx) == Double.class){
            if (addNot != null)
                instructions.add(addNot);
        }
        return Integer.parseInt(left.toString())<Integer.parseInt(right.toString());
    }

    /**TODO
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitCompare(SolParser.CompareContext ctx) {
        Object left = visit(ctx.type(0));
        Object right = visit(ctx.type(1));
        TokenTasm[] operator = null;
        if (ctx.compareOP.getText().equals("=="))
            operator = new TokenTasm[]{TokenTasm.DEQ, TokenTasm.IEQ};
        else
            operator = new TokenTasm[]{TokenTasm.DNEQ, TokenTasm.INEQ};
        if (tree.get(ctx) == Double.class) {
            instructions.add(new Instruction(operator[0]));
            return Double.parseDouble(left.toString()) < Double.parseDouble(right.toString());
        }
        instructions.add(new Instruction(operator[1]));
        return Integer.parseInt(left.toString())<Integer.parseInt(right.toString());
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
        instructions.add(new Instruction(TokenTasm.OR));
        return Boolean.parseBoolean(left.toString()) || Boolean.parseBoolean(right.toString());
    }
}
