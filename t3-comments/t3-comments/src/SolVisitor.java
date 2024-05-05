// Import necessary packages and classes
import Sol.SolBaseVisitor;
import Sol.SolParser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

/**
 * SolVisitor extends SolBaseVisitor to provide custom visiting functionality
 * for the Sol language parse tree.
 */
public class SolVisitor extends SolBaseVisitor {
    // Declare instance variables
    private ArrayList<Instruction> instructions;
    private ParseTreeProperty<Class<?>> tree;
    private ArrayList<Object> constantPool;
    private TesteSemantico teste;
    private Stack<Integer> breakInstructions;
    private ArrayList<String> gallocContent;

    /**
     * Constructor for SolVisitor.
     * Initializes instance variables.
     *
     * @param t ParseTreeProperty containing type information.
     */
    SolVisitor(ParseTreeProperty<Class<?>> t) {
        tree = t;
        breakInstructions = new Stack<>();
        instructions = new ArrayList<Instruction>();
        constantPool = new ArrayList<Object>();
        teste = new TesteSemantico();
        gallocContent = new ArrayList<String>();
    }

    /**
     * Retrieves the list of instructions generated during traversal.
     *
     * @return ArrayList of instructions.
     */
    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    /**
     * Retrieves the constant pool containing all literals.
     *
     * @return ArrayList of constants.
     */
    public ArrayList<Object> getConstantPool() {
        return constantPool;
    }

    /**
     * Visits an 'if' statement in the parse tree, generating corresponding TASM instructions.
     *
     * @param ctx The parse tree node representing the 'if' statement.
     * @return The result of visiting the 'if' statement, typically generated TASM instructions.
     */
    @Override
    public Object visitIf(SolParser.IfContext ctx) {
        int jumpHere = instructions.size();
        visit(ctx.op());
        instructions.add(new Instruction(TokenTasm.JUMPF, jumpHere)); //jump out of the loop
        int indexOfJump = instructions.size()-1;
        Object result = visit(ctx.command());
        instructions.add(new Instruction(TokenTasm.JUMP, 0));
        int indexOfElseJump=instructions.size()-1;
        instructions.set(indexOfJump, new Instruction(TokenTasm.JUMPF, instructions.size()));
        if (ctx.else_()!= null)
            visit(ctx.else_());
        instructions.set(indexOfElseJump, new Instruction(TokenTasm.JUMP, instructions.size()));
        return result;
    }

    /**
     * Visits a 'while' loop in the parse tree, generating corresponding TASM instructions.
     *
     * @param ctx The parse tree node representing the 'while' loop.
     * @return The result of visiting the 'while' loop, typically generated TASM instructions.
     */
    @Override
    public Object visitWhile(SolParser.WhileContext ctx) {
        int jumpHere = instructions.size();
        visit(ctx.op());
        instructions.add(new Instruction(TokenTasm.JUMPF, jumpHere)); //jump out of the loop
        int indexOfJump = instructions.size()-1;
        Object result = visit(ctx.command());
        instructions.add(new Instruction(TokenTasm.JUMP, jumpHere)); //jump again for the loop
        int indexOutLoop = instructions.size()-1;
        instructions.set(indexOfJump, new Instruction(TokenTasm.JUMPF, indexOutLoop)); //jump out of the loop
        while (!breakInstructions.isEmpty() && breakInstructions.peek()< instructions.size())
            instructions.set(breakInstructions.pop(), new Instruction(TokenTasm.JUMP, indexOutLoop));
        return result;
    }

    /**
     * Visits a 'for' loop in the parse tree, generating corresponding TASM instructions.
     *
     * @param ctx The parse tree node representing the 'for' loop.
     * @return The result of visiting the 'for' loop, typically generated TASM instructions.
     */
    @Override
    public Object visitFor(SolParser.ForContext ctx) {
        instructions.add(new Instruction(TokenTasm.GALLOC,1));
        String var = ctx.VAR().getText();
        gallocContent.add(var);
        int varIndex = gallocContent.indexOf(var);
        instructions.add(new Instruction(TokenTasm.ICONST, Integer.parseInt(ctx.type(0).getText())));
        instructions.add(new Instruction(TokenTasm.GSTORE, varIndex));
        int jumpHere = instructions.size()-1;
        instructions.add(new Instruction(TokenTasm.GLOAD, varIndex));
        instructions.add(new Instruction(TokenTasm.ICONST, 1));
        instructions.add(new Instruction(TokenTasm.IADD));
        instructions.add(new Instruction(TokenTasm.GSTORE, varIndex));
        instructions.add(new Instruction(TokenTasm.GLOAD, varIndex));
        instructions.add(new Instruction(TokenTasm.ICONST, Integer.parseInt(ctx.type(1).getText())));
        instructions.add(new Instruction(TokenTasm.ILEQ));
        instructions.add(new Instruction(TokenTasm.JUMPF)); //jump out of the loop
        int indexOfJump = instructions.size()-1;
        Object result = visit(ctx.command());
        instructions.add(new Instruction(TokenTasm.JUMP, jumpHere)); //jump again for the loop
        int indexOutLoop = instructions.size()-1;
        instructions.set(indexOfJump, new Instruction(TokenTasm.JUMPF, indexOutLoop)); //jump out of the loop
        while (!breakInstructions.isEmpty() && breakInstructions.peek()< instructions.size())
            instructions.set(breakInstructions.pop(), new Instruction(TokenTasm.JUMP, indexOutLoop));
        gallocContent.remove(var);
        return result;
    }

    /**
     * Visits a 'break' statement in the parse tree, generating corresponding TASM instructions.
     *
     * @param ctx The parse tree node representing the 'break' statement.
     * @return The result of visiting the 'break' statement.
     */
    @Override
    public Object visitBreak(SolParser.BreakContext ctx) {
        breakInstructions.push(instructions.size());
        instructions.add(new Instruction(TokenTasm.JUMP));
        return super.visitBreak(ctx);
    }

    @Override
    public Object visitVariable(SolParser.VariableContext ctx) {
        instructions.add(new Instruction(TokenTasm.GLOAD,gallocContent.indexOf(ctx.VAR().getText())));
        return super.visitVariable(ctx);
    }

    /**
     * Visits a declaration statement in the parse tree, generating corresponding TASM instructions.
     *
     * @param ctx The parse tree node representing the declaration statement.
     * @return The result of visiting the declaration statement.
     */
    @Override
    public Object visitDeclaration(SolParser.DeclarationContext ctx) {
        instructions.add(new Instruction(TokenTasm.GALLOC,ctx.declarationDef().size()));
        Object result = null;
        for (SolParser.DeclarationDefContext i:ctx.declarationDef())
            result = visit(i);
        return result;
    }

    /**
     * Visits a declaration definition in the parse tree, generating corresponding TASM instructions.
     *
     * @param ctx The parse tree node representing the declaration definition.
     * @return The result of visiting the declaration definition.
     */
    @Override
    public Object visitDeclarationDef(SolParser.DeclarationDefContext ctx) {
        gallocContent.add(ctx.VAR().getText());
        if (ctx.INT()!=null){
            instructions.add(new Instruction(TokenTasm.ICONST,Integer.parseInt(ctx.INT().getText())));
            instructions.add(new Instruction(TokenTasm.GSTORE, gallocContent.size()-1));
        } else if (ctx.DOUBLE()!=null) {
            constantPool.add(Double.parseDouble(ctx.DOUBLE().getText()));
            instructions.add(new Instruction(TokenTasm.DCONST, constantPool.size()-1));
            instructions.add(new Instruction(TokenTasm.GSTORE, gallocContent.size()-1));
        }else if (ctx.STRING()!=null) {
            constantPool.add(ctx.STRING().getText());
            instructions.add(new Instruction(TokenTasm.SCONST,constantPool.size()-1));
            instructions.add(new Instruction(TokenTasm.GSTORE, gallocContent.size()-1));
        } else if (ctx.TRUE()!=null) {
            instructions.add(new Instruction(TokenTasm.TCONST));
            instructions.add(new Instruction(TokenTasm.GSTORE, gallocContent.size()-1));
        } else if (ctx.FALSE()!=null) {
            instructions.add(new Instruction(TokenTasm.FCONST));
            instructions.add(new Instruction(TokenTasm.GSTORE, gallocContent.size()-1));
        }
        return super.visitDeclarationDef(ctx);
    }

    /**
     * Visits a 'types' statement in the parse tree, generating corresponding TASM instructions.
     *
     * @param ctx The parse tree node representing the 'types' statement.
     * @return The result of visiting the 'types' statement.
     */
    @Override
    public Object visitTypes(SolParser.TypesContext ctx) {
        tree.put(ctx, tree.get(ctx.type()));
        return super.visitTypes(ctx);
    }

    /**
     * Visits type nodes in the parse tree and generates instructions accordingly.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitType(SolParser.TypeContext ctx) {
        if (tree.get(ctx) == Integer.class) {
            Integer i = Integer.parseInt(ctx.INT().getText());
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

    /**
     * Visits executable nodes in the parse tree and appends HALT instruction.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitExecutable(SolParser.ExecutableContext ctx) {
        Object result = super.visitExecutable(ctx);
        instructions.add(new Instruction(TokenTasm.HALT));
        return result;
    }

    /**
     * Visits command nodes in the parse tree and generates print instructions.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitCommand(SolParser.CommandContext ctx) {
        Object result = super.visitCommand(ctx);
        if (ctx.PRINT()!=null) {
            if (tree.get(ctx.op()) == Integer.class)
                instructions.add(new Instruction(TokenTasm.IPRINT));
            if (tree.get(ctx.op()) == Double.class)
                instructions.add(new Instruction(TokenTasm.DPRINT));
            if (tree.get(ctx.op()) == String.class)
                instructions.add(new Instruction(TokenTasm.SPRINT));
            if (tree.get(ctx.op()) == Boolean.class)
                instructions.add(new Instruction(TokenTasm.BPRINT));
        }
        if (ctx.VAR() != null){
            instructions.add(new Instruction(TokenTasm.GSTORE, gallocContent.indexOf(ctx.VAR().getText())));
        }
        return result;
    }

    /**
     * Visits parenthesis nodes in the parse tree.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitParenthesis(SolParser.ParenthesisContext ctx) {
        return visit(ctx.op());
    }

    /**
     * Visits negate nodes in the parse tree.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
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
     * Visits add/subtract nodes in the parse tree.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
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
            instructions.add(new Instruction(operator[0]));
            return Double.parseDouble(left.toString())+Double.parseDouble(right.toString());
        }
        instructions.add(new Instruction(operator[1]));
        return Integer.parseInt(left.toString())+Integer.parseInt(right.toString());
    }

    /**
     * Visits multiply/divide/modulus nodes in the parse tree.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
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
     * Visits comparison nodes for '<', '>', '<=', '>=' operators in the parse tree.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
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

    /**
     * Visits comparison nodes for '==' and '!=' operators in the parse tree.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
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
     * Visits logical 'and' nodes in the parse tree.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitAnd(SolParser.AndContext ctx) {
        Object left = visit(ctx.type(0));
        Object right = visit(ctx.type(1));
        instructions.add(new Instruction(TokenTasm.AND));
        return Boolean.parseBoolean(left.toString()) && Boolean.parseBoolean(right.toString());
    }

    /**
     * Visits logical 'or' nodes in the parse tree.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitOr(SolParser.OrContext ctx) {
        Object left = visit(ctx.type(0));
        Object right = visit(ctx.type(1));
        instructions.add(new Instruction(TokenTasm.OR));
        return Boolean.parseBoolean(left.toString()) || Boolean.parseBoolean(right.toString());
    }
}
