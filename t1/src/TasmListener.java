import Tasm.TasmBaseListener;
import Tasm.TasmParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TasmListener extends TasmBaseListener {
    private ArrayList<Instruction> instructions;
    private ArrayList<Object> constantPool;
    private HashMap<String, Integer> labels;
    private ArrayList<String> jumpLabels;

    TasmListener(){
        instructions = new ArrayList<Instruction>();
        constantPool = new ArrayList<Object>();
        labels = new HashMap<String, Integer>();
        jumpLabels = new ArrayList<String>();
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public ArrayList<Object> getConstantPool() {
        return constantPool;
    }

    /**
     * Links jump instructions to line which had the specified label and also checks if the jump instruction referred to a valid label
     */
    public void labelLink(){
        for (int i = 0; i<instructions.size();i++) {
            Instruction instruction = instructions.get(i);
            if (instruction.getToken1().equals(TokenTasm.JUMP) || instruction.getToken1().equals(TokenTasm.JUMPT) || instruction.getToken1().equals(TokenTasm.JUMPF)) {
                String label = jumpLabels.get(instruction.getToken2()-1);
                Integer l = labels.get(label);
                if(l!=null)
                    instruction.setToken2(l);
                else
                    throw new IllegalArgumentException("Invalid label "+label+" at line "+i);
            }
        }
    }
    @Override
    public void exitCommand(TasmParser.CommandContext ctx) {
        int i = instructions.size();
        for (TerminalNode label:ctx.LABEL())
            if (!labels.containsKey(label.getText()))
                labels.put(label.getText(), i);
            else
                throw new IllegalArgumentException("Label "+label.getText()+" has duplicates.");
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
    public void exitHalt(TasmParser.HaltContext ctx) {
        instructions.add(new Instruction(ctx.HALT().getText().toUpperCase(), null));
    }

    @Override
    public void exitJumpOP(TasmParser.JumpOPContext ctx) {
        jumpLabels.add(ctx.LABEL().getText());
        if (ctx.JUMP()!=null)
            instructions.add(new Instruction(ctx.JUMP().getText().toUpperCase(),jumpLabels.size()));
        else if (ctx.JUMPT()!=null) {
            instructions.add(new Instruction(ctx.JUMPT().getText().toUpperCase(),jumpLabels.size()));
        }
        else if (ctx.JUMPF()!=null) {
            instructions.add(new Instruction(ctx.JUMPF().getText().toUpperCase(),jumpLabels.size()));
        }
    }

    @Override
    public void exitConstInteger(TasmParser.ConstIntegerContext ctx) {
        instructions.add(new Instruction(ctx.ICONST().getText().toUpperCase(),Integer.getInteger(ctx.INT().getText())));
    }

    @Override
    public void exitConstDoubleInteger(TasmParser.ConstDoubleIntegerContext ctx) {
        constantPool.add(Double.parseDouble(ctx.INT().getText()));
        instructions.add(new Instruction(ctx.DCONST().getText().toUpperCase(),constantPool.size()));
    }

    @Override
    public void exitConstDouble(TasmParser.ConstDoubleContext ctx) {
        constantPool.add(Double.parseDouble(ctx.DOUBLE().getText()));
        instructions.add(new Instruction(ctx.DCONST().getText().toUpperCase(),constantPool.size()));
    }

    @Override
    public void exitConstString(TasmParser.ConstStringContext ctx) {
        constantPool.add(ctx.STRING().getText());
        instructions.add(new Instruction(ctx.SCONST().getText().toUpperCase(), constantPool.size()));
    }

}
