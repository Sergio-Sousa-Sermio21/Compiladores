import Tasm.TasmBaseListener;
import Tasm.TasmParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TasmListener extends TasmBaseListener {
    private ArrayList<Instruction> instructions;
    private HashMap<Integer,String> constantPool;
    TasmListener(){
        instructions = new ArrayList<Instruction>();
        constantPool = new HashMap<Integer,String>();
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public HashMap<Integer,String> getConstantPool() {
        return constantPool;
    }

    @Override
    public void exitCommand(TasmParser.CommandContext ctx) {
        inst;
    }

    @Override
    public void exitIntegerOperation(TasmParser.IntegerOperationContext ctx) {
        instructions.add(new Instruction(ctx.integerOP().getText().toUpperCase(),null));
    }

    @Override
    public void exitDoubleOperation(TasmParser.DoubleOperationContext ctx) {
        instructions.add(new Instruction(ctx.doubleOP().getText().toUpperCase(),null));
    }

    @Override
    public void exitStringOperation(TasmParser.StringOperationContext ctx) {
        instructions.add(new Instruction(ctx.stringOP().getText().toUpperCase(),null));
    }

    @Override
    public void exitBoolOperation(TasmParser.BoolOperationContext ctx) {
        instructions.add(new Instruction(ctx.boolOP().getText().toUpperCase(),null));
    }

    @Override
    public void exitArrayOP(TasmParser.ArrayOPContext ctx) {
        if (ctx.GALLOC()!=null)
            instructions.add(new Instruction(ctx.GALLOC().getText().toUpperCase(),Integer.getInteger(ctx.INT().getText())));
        else if (ctx.GLOAD()!=null) {
            instructions.add(new Instruction(ctx.GLOAD().getText().toUpperCase(),Integer.getInteger(ctx.INT().getText())));
        }
        else if (ctx.GSTORE()!=null) {
            instructions.add(new Instruction(ctx.GSTORE().getText().toUpperCase(),Integer.getInteger(ctx.INT().getText())));
        }
    }

    @Override
    public void exitJumpOP(TasmParser.JumpOPContext ctx) {
        int index = constantPool.size();
        constantPool.put(index, ctx.LABEL().getText());
        if (ctx.JUMP()!=null)
            instructions.add(new Instruction(ctx.JUMP().getText().toUpperCase(),index));
        else if (ctx.JUMPT()!=null) {
            instructions.add(new Instruction(ctx.JUMPT().getText().toUpperCase(),index));
        }
        else if (ctx.JUMPF()!=null) {
            instructions.add(new Instruction(ctx.JUMPF().getText().toUpperCase(),index));
        }
    }

    @Override
    public void exitConstInteger(TasmParser.ConstIntegerContext ctx) {
        instructions.add(new Instruction(ctx.ICONST().getText(),Integer.getInteger(ctx.INT().getText())));
    }

    @Override
    public void exitConstDoubleInteger(TasmParser.ConstDoubleIntegerContext ctx) {
        int index = constantPool.size();
        constantPool.put(index, ctx.INT().getText());
        instructions.add(new Instruction(ctx.DCONST().getText(),index));
    }

    @Override
    public void exitConstDouble(TasmParser.ConstDoubleContext ctx) {
        int index = constantPool.size();
        constantPool.put(index, ctx.DOUBLE().getText());
        instructions.add(new Instruction(ctx.DCONST().getText(),index));
    }

    @Override
    public void exitConstString(TasmParser.ConstStringContext ctx) {
        int index = constantPool.size();
        constantPool.put(index, ctx.STRING().getText());
        instructions.add(new Instruction(ctx.SCONST().getText(), index));
    }

}
