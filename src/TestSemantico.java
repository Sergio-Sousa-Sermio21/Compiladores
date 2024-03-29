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
    private ArrayList<String> errors = new ArrayList<String>();
    private boolean halt = false;
    private HashSet <String> labels = new HashSet<String>();

    public void exitExpression(TasmParser.ExpressionContext ctx) {
        List<TerminalNode> labels = ctx.LABEL();
        for (TerminalNode label : labels) {
            if (this.labels.contains(label.getText()))

                errors.add("Line " + ctx.start.getLine() + "-A label " + label + " aparece mais do que uma vez no programa!");
            else
                this.labels.add(label.getText());
        }
    }

    public void exitJUMP(TasmParser.JUMPContext ctx) {
        String label = ctx.LABEL().getText();
        if (!labels.contains(label)) {
            errors.add("A label '" + label + "' é referenciada numa intrução jump que não está defenido.");
        }
    }

    public void exitJUMPT(TasmParser.JUMPTContext ctx) {
        String label = ctx.LABEL().getText();
        if (!labels.contains(label)) {
            errors.add("A label '" + label + "' é referenciada numa intrução jumpT que não está defenido.");
        }
    }

    public void exitJUMPF(TasmParser.JUMPFContext ctx) {
        String label = ctx.LABEL().getText();
        if (!labels.contains(label)) {
            errors.add("A label '" + label + "' é referenciada numa intrução jumpF que não está defenido.");
        }
    }

    public void TestTree(ParseTree tree){
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, tree);
        if(!errors.isEmpty()){
            for(String error : errors)
                System.out.println(error);
            System.exit(0);
        }



    }

}
