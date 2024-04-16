// Import necessary packages and classes
import Sol.SolBaseVisitor;
import Sol.SolParser;

import java.util.ArrayList;

// Define the class SolVisitor which extends SolBaseVisitor
public class SolVisitor extends SolBaseVisitor {
    // Declare instance variables
    private ArrayList<Instruction> instructions;
    private ArrayList<Object> constantPool;

    // Constructor initializes instance variables
    SolVisitor(){
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

    @Override
    public Object visitNegate(SolParser.NegateContext ctx) {
        return super.visitNegate(ctx);
    }

    @Override
    public Object visitAddition(SolParser.AdditionContext ctx) {
        return super.visitAddition(ctx);
    }

    @Override
    public Object visitAnd(SolParser.AndContext ctx) {
        return super.visitAnd(ctx);
    }

    @Override
    public Object visitOr(SolParser.OrContext ctx) {
        return super.visitOr(ctx);
    }
}
