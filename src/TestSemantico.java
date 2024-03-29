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

        List<TerminalNode> value = ctx.LABEL();
        for (TerminalNode terminalNode : value)
            System.out.println("Valor INTVALUE: " + terminalNode);

        //Verify unique labels?
        for (String label : labels) {
            int Ocorrencias = Collections.frequency(labels,label);
            if(Ocorrencias > 1){
                errors.add("A label "+ label + " aparece mais do que uma vez no programa!");
            }
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
