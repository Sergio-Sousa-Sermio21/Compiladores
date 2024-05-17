// Import necessary packages and classes
import Sol.SolBaseVisitor;
import Sol.SolParser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
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
    private Stack<Integer> breakInstructions;
    private ArrayList<String> gallocContent;
    private ArrayList<LocalVar> localContent;
    private HashMap<String, Integer> callListed;
    private ArrayList<Call> callList;
    private ArrayList<String>functionArgs;
    protected class Call{
        protected String name;
        protected int index;
        Call(String name, int index){
            this.name = name;
            this.index= index;
        }

        @Override
        public boolean equals(Object obj) {
            return name.equals(obj.toString());
        }
        @Override
        public String toString() {
            return name;
        }
    }
    protected class LocalVar{
        protected String name;
        protected int scope;
        LocalVar(String name, int scope){
            this.name = name;
            this.scope= scope;
        }
    }
    private int scope;
    private int mainPosition;
    /**
     * Constructor for SolVisitor.
     * Initializes instance variables.
     *
     * @param t ParseTreeProperty containing type information.
     */
    SolVisitor(ParseTreeProperty<Class<?>> t) {
        tree = t;
        breakInstructions = new Stack<>();
        instructions = new ArrayList<>();
        constantPool = new ArrayList<>();
        gallocContent = new ArrayList<>();
        scope=0;
        mainPosition = 0;
        callListed=new HashMap<>();
        callList=new ArrayList<>();
        functionArgs = new ArrayList<>();
        localContent = new ArrayList<>();
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

    /**TODO comment
     *
     * @return
     */
    private int removeByScope(){
        int result=0;
        for (LocalVar var : localContent){
            if (var.scope == scope) {
                localContent.remove(var);
                result++;
            }
        }
        return result;
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitBlock(SolParser.BlockContext ctx) {
        scope+=1;
        Object result = super.visitBlock(ctx);
        int nPop=removeByScope();
        instructions.add(new Instruction(TokenTasm.POP, nPop));
        scope-=1;
        return result;
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitReturn(SolParser.ReturnContext ctx) {
        Object result = super.visitReturn(ctx);
        Class<?> type=tree.get(ctx);
        if (type == Void.class)
            instructions.add(new Instruction(TokenTasm.RET, 0));
        else
            instructions.add(new Instruction(TokenTasm.RETVAL, functionArgs.size()));
        return result;
    }

    /**TODO comment
     *
     * @param call
     */
    private void setCallPos(Call call){
        for (Call c:callList)
            if (c.equals(call))
                instructions.set(c.index, new Instruction(TokenTasm.CALL, call.index));
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitFunction(SolParser.FunctionContext ctx) {
        String functionName = ctx.VAR(0).getText();
        if(functionName.equals("main"))
            mainPosition = instructions.size();
        callListed.put(functionName, instructions.size());
        for (TerminalNode var:ctx.VAR()){
            functionArgs.add(var.getText());
        }
        Object result = super.visitFunction(ctx);
        if (tree.get(ctx) != Void.class)
            instructions.remove(instructions.size() - 1);
        functionArgs.clear();
        return result;
    }

    /**TODO comment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitFunctionCall(SolParser.FunctionCallContext ctx) {
        Object result = super.visitFunctionCall(ctx);
        callList.add(new Call(ctx.VAR().getText(), instructions.size()));
        instructions.add(new Instruction(TokenTasm.CALL,0));
        return result;
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
        int indexOutLoop = instructions.size();
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
        instructions.add(new Instruction(TokenTasm.LALLOC,1));
        LocalVar var =new LocalVar(ctx.VAR().getText(), -1);
        localContent.add(var);
        int varIndex = localContent.indexOf(var);
        instructions.add(new Instruction(TokenTasm.ICONST, Integer.parseInt(ctx.type(0).getText())));
        instructions.add(new Instruction(TokenTasm.LSTORE, varIndex));
        int jumpHere = instructions.size()-1;
        instructions.add(new Instruction(TokenTasm.LLOAD, varIndex));
        instructions.add(new Instruction(TokenTasm.ICONST, 1));
        instructions.add(new Instruction(TokenTasm.IADD));
        instructions.add(new Instruction(TokenTasm.LSTORE, varIndex));
        instructions.add(new Instruction(TokenTasm.LLOAD, varIndex));
        instructions.add(new Instruction(TokenTasm.ICONST, Integer.parseInt(ctx.type(1).getText())));
        instructions.add(new Instruction(TokenTasm.ILEQ));
        instructions.add(new Instruction(TokenTasm.JUMPF)); //jump out of the loop
        int indexOfJump = instructions.size()-1;
        Object result = visit(ctx.command());
        instructions.add(new Instruction(TokenTasm.JUMP, jumpHere)); //jump again for the loop
        int indexOutLoop = instructions.size();
        instructions.set(indexOfJump, new Instruction(TokenTasm.JUMPF, indexOutLoop)); //jump out of the loop
        while (!breakInstructions.isEmpty() && breakInstructions.peek()< instructions.size())
            instructions.set(breakInstructions.pop(), new Instruction(TokenTasm.JUMP, indexOutLoop));
        localContent.remove(varIndex);
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
        if (functionArgs.contains(ctx.VAR().getText()))
            instructions.add(new Instruction(TokenTasm.LLOAD, -(functionArgs.size()-functionArgs.indexOf(ctx.VAR().getText())+1)));
        else if (localContent.contains(new LocalVar(ctx.VAR().getText(),0)))
            instructions.add(new Instruction(TokenTasm.LLOAD, localContent.indexOf(new LocalVar(ctx.VAR().getText(),0))+2));
        else
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
        if (scope<1)
            instructions.add(new Instruction(TokenTasm.GALLOC,ctx.declarationDef().size()));
        else
            instructions.add(new Instruction(TokenTasm.LALLOC,ctx.declarationDef().size()));
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
        TokenTasm store = null;
        int size = 0;
        if (scope<1) {
            gallocContent.add(ctx.VAR().getText());
            store = TokenTasm.GSTORE;
            size = gallocContent.size() - 1;
        }
        else {
            localContent.add(new LocalVar(ctx.VAR().getText(), scope));
            store = TokenTasm.LSTORE;
            size = localContent.size()-1;
        }
        Object result = null;
        if (ctx.op() !=null) {
            result = visit(ctx.op());
            instructions.add(new Instruction(store, size));
        }
        return result;
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
        instructions.add(new Instruction(TokenTasm.CALL, 0));
        instructions.add(new Instruction(TokenTasm.HALT));
        Object result = super.visitExecutable(ctx);
        for(String functionName:callListed.keySet()) {
            Call functionCall = new Call(functionName, callListed.get(functionName));
            if (callList.contains(functionCall))
                setCallPos(functionCall);
        }
        instructions.set(0, new Instruction(TokenTasm.CALL, mainPosition));
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
            if (functionArgs.contains(ctx.VAR().getText()))
                instructions.add(new Instruction(TokenTasm.LSTORE, -(functionArgs.size()-functionArgs.indexOf(ctx.VAR().getText())+1)));
            else if (localContent.contains(new LocalVar(ctx.VAR().getText(),0)))
                instructions.add(new Instruction(TokenTasm.LSTORE, localContent.indexOf(new LocalVar(ctx.VAR().getText(),0))+2));
            else
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
        return 0;
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
        return 0;
    }

    /**
     * Visits comparison nodes for '<', '>', '<=', '>=' operators in the parse tree.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitCompareMore(SolParser.CompareMoreContext ctx) {
        Object left = visit(ctx.op(0));
        Object right = visit(ctx.op(1));
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
        return true;
    }

    /**
     * Visits comparison nodes for '==' and '!=' operators in the parse tree.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitCompare(SolParser.CompareContext ctx) {
        Object left = visit(ctx.op(0));
        Object right = visit(ctx.op(1));
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
        return true;
    }

    /**
     * Visits logical 'and' nodes in the parse tree.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitAnd(SolParser.AndContext ctx) {
        Object left = visit(ctx.op(0));
        Object right = visit(ctx.op(1));
        instructions.add(new Instruction(TokenTasm.AND));
        return false;
    }

    /**
     * Visits logical 'or' nodes in the parse tree.
     *
     * @param ctx the parse tree node to visit.
     * @return the value associated with the node.
     */
    @Override
    public Object visitOr(SolParser.OrContext ctx) {
        Object left = visit(ctx.op(0));
        Object right = visit(ctx.op(1));
        instructions.add(new Instruction(TokenTasm.OR));
        return true;
    }
}
