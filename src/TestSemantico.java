import Tasm.TasmBaseListener;
import Tasm.TasmParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class TestSemantico extends TasmBaseListener {
    private final ArrayList<String> errors = new ArrayList<String>();
    private final HashSet <String> labels = new HashSet<String>();
    private final ArrayList <String> jumpLabels = new ArrayList<String>();
    private boolean hasHaltInstruction = false;

    public void exitCALL(TasmParser.CALLContext ctx) {
        String label = ctx.LABEL().getText();
        if (!labels.contains(label)) {
            errors.add("Line " + ctx.start.getLine() + ": The label " + label + " used in CALL instruction is not defined.");
        }
    }

    public void exitExpression(TasmParser.ExpressionContext ctx) {
        List<TerminalNode> labels = ctx.LABEL();
        for (TerminalNode label : labels) {
            if (this.labels.contains(label.getText()))
                errors.add("Line " + ctx.start.getLine() + ":The label " + label + " appears more than once in the program!");
            else
                this.labels.add(label.getText());
        }
    }

    public void exitJUMP(TasmParser.JUMPContext ctx) {
        String label = ctx.LABEL().getText();
        label += "-" + ctx.start.getLine();
        jumpLabels.add(label);
    }

    public void exitJUMPT(TasmParser.JUMPTContext ctx) {
        String label = ctx.LABEL().getText();
        label += "-" + ctx.start.getLine();
        jumpLabels.add(label);
    }

    public void exitJUMPF(TasmParser.JUMPFContext ctx) {
        String label = ctx.LABEL().getText();
        label += "-" + ctx.start.getLine();
        jumpLabels.add(label);
    }

    public void exitHALT(TasmParser.HALTContext ctx) {
        hasHaltInstruction = true;
    }

    private void verifyLabels(){
        for (String jumpLabel : jumpLabels) {
            String[] teste = jumpLabel.split("-");
            if (!this.labels.contains(teste[0])) {
                errors.add("Line " + teste[1] + ":The label " + teste[0] + " doesn't appear in the program programa!");
            }
        }
    }

    /** Testa a árvore para garantir todas as verificações
     *
     * @param tree
     */
    public void TestTree(ParseTree tree){
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, tree);
        this.verifyLabels();
        if (!hasHaltInstruction)
            errors.add("The program doesn't have the halt instruction.");
        if(!errors.isEmpty()){
            for(String error : errors)
                System.err.println(error);
            System.exit(0);
        }

    }

}
