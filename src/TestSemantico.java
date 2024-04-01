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
    // ArrayList para armazenar mensagens de erro
    private ArrayList<String> errors = new ArrayList<String>();
    // HashSet para armazenar labels únicas
    private HashSet <String> labels = new HashSet<String>();
    // ArrayList para armazenar labels de instruções de salto
    private ArrayList <String> jumpLabels = new ArrayList<String>();
    // Variável booleana para verificar se há uma instrução HALT no programa
    private boolean hasHaltInstruction = false;

    public void exitExpression(TasmParser.ExpressionContext ctx) {

        List<TerminalNode> labels = ctx.LABEL();
        for (TerminalNode label : labels) {
            if (this.labels.contains(label.getText()))
                errors.add("Line " + ctx.start.getLine() + ":A label " + label + " aparece mais do que uma vez no programa!");
            else
                this.labels.add(label.getText());
        }
    }
    // Método chamado quando uma instrução de salto JUMP é finalizada
    public void exitJUMP(TasmParser.JUMPContext ctx) {
        String label = ctx.LABEL().getText();
        label += "-" + ctx.start.getLine();
        jumpLabels.add(label);
    }
    // Método chamado quando uma instrução de salto JUMPT é finalizada
    public void exitJUMPT(TasmParser.JUMPTContext ctx) {
        String label = ctx.LABEL().getText();
        label += "-" + ctx.start.getLine();
        jumpLabels.add(label);
    }
    // Método chamado quando uma instrução de salto JUMPF é finalizada
    public void exitJUMPF(TasmParser.JUMPFContext ctx) {
        String label = ctx.LABEL().getText();
        label += "-" + ctx.start.getLine();
        jumpLabels.add(label);
    }
    // Método chamado quando uma instrução HALT é finalizada
    public void exitHALT(TasmParser.HALTContext ctx) {
        hasHaltInstruction = true;
    }
    // Método privado para verificar se todas as labels utilizadas em instruções de salto são válidas
    private void verifyLabels(){
        for (String jumpLabel : jumpLabels) {
            String[] teste = jumpLabel.split("-");
            if (!this.labels.contains(teste[0])) {
                errors.add("Line " + teste[1] + ":A label " + teste[0] + " nao aparece no programa!");
            }
        }
    }
    // Método para iniciar a análise semântica na árvore de análise sintática gerada
    public void TestTree(ParseTree tree){
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, tree);
        this.verifyLabels();
        if (!hasHaltInstruction)
            errors.add("O programa não possui uma instrução halt.");
        if(!errors.isEmpty()){
            for(String error : errors)
                System.err.println(error);
            System.exit(0);
        }



    }

}
