import Tasm.TasmBaseListener;
import Tasm.TasmParser;

import java.util.ArrayList;
import java.util.HashSet;

public class TasmListener extends TasmBaseListener {
    private ArrayList<Instruction> instructions;
    /**TODO
     * analisar melhor
     */
    private ArrayList<String> constantPool;
    TasmListener(){
        instructions = new ArrayList<Instruction>();
        constantPool = new ArrayList<String>();
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    @Override
    public void exitIntegerOperation(TasmParser.IntegerOperationContext ctx) {
        instructions.add(new Instruction(ctx.integerOP().getText(),null));
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
        constantPool.add(ctx.LABEL().getText());
        if (ctx.JUMP()!=null)
            instructions.add(new Instruction(ctx.JUMP().getText().toUpperCase(),constantPool.indexOf(ctx.LABEL().getText())));
        else if (ctx.JUMPT()!=null) {
            instructions.add(new Instruction(ctx.JUMPT().getText().toUpperCase(),constantPool.indexOf(ctx.LABEL().getText())));
        }
        else if (ctx.JUMPF()!=null) {
            instructions.add(new Instruction(ctx.JUMPF().getText().toUpperCase(),constantPool.indexOf(ctx.LABEL().getText())));
        }
    }

    @Override
    public void exitConstInteger(TasmParser.ConstIntegerContext ctx) {
        instructions.add(new Instruction(ctx.ICONST().getText(),Integer.getInteger(ctx.INT().getText())));
    }

    @Override
    public void exitConstDouble(TasmParser.ConstDoubleContext ctx) {
        constantPool.add(ctx.DOUBLE().getText());
        instructions.add(new Instruction(ctx.DCONST().getText(),constantPool.indexOf(ctx.DOUBLE().getText())));
    }

    @Override
    public void exitConstString(TasmParser.ConstStringContext ctx) {
        constantPool.add(ctx.STRING().getText());
        instructions.add(new Instruction(ctx.SCONST().getText(), constantPool.indexOf(ctx.STRING().getText())));
    }

}
