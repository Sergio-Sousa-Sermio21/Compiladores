import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;
import java.util.Stack;

import Tasm.TasmBaseListener;
import Tasm.TasmLexer;
import Tasm.TasmParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class tAssembler {

    public static class Evaluator extends TasmBaseListener{
        private Stack<Objects> stack = new Stack<Objects>();

        public void exitExpression(TasmParser.ExpressionContext ctx) {

        }

        public void exitINTVALUE(TasmParser.INTVALUEContext ctx) {
            String value = ctx.getText();
            System.out.println("Valor INTVALUE: " + value);
        }

        public void exitDOUBLEVALUE(TasmParser.DOUBLEVALUEContext ctx) {
            String value = ctx.getText();
            System.out.println("Valor INTVALUE: " + value);
        }

        public void exitSTRINGVALUE(TasmParser.STRINGVALUEContext ctx) {
            String value = ctx.getText();
            System.out.println("Valor INTVALUE: " + value);
        }

        public void exitJUMP(TasmParser.JUMPContext ctx) {

        }

        public void exitJUMPT(TasmParser.JUMPTContext ctx) {

        }

        public void exitJUMPF(TasmParser.JUMPFContext ctx) {

        }

        public void exitINTINSTRUCTION(TasmParser.INTINSTRUCTIONContext ctx){
            String value = ctx.getText();
            System.out.println("Valor INTINSTRUCTION: " + value);
        }

        public void exitDOUBLEINSTRUCTION(TasmParser.DOUBLEINSTRUCTIONContext ctx) {
            String value = ctx.getText();
            System.out.println("Valor DOUBLEINTINSTRUCTION: " + value);
        }

        public void exitSTRINGINSTRUCTION(TasmParser.STRINGINSTRUCTIONContext ctx) {
            String value = ctx.getText();
            System.out.println("Valor STRINGINTINSTRUCTION: " + value);
        }
        public static void main(String[] args) throws Exception {
            String inputFile = null;
            if ( args.length>0 ) inputFile = args[0];
            InputStream is = System.in;
            try {
                if (inputFile != null) is = new FileInputStream(inputFile);
                CharStream input = CharStreams.fromStream(is);
                TasmLexer lexer = new TasmLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                TasmParser parser = new TasmParser(tokens);
                ParseTree tree = parser.program();
                ParseTreeWalker walker = new ParseTreeWalker();
                Evaluator evalProp = new Evaluator();
                walker.walk(evalProp, tree);
                //System.out.println("properties result = " + evalProp.getValue(tree));
            }
            catch (java.io.IOException e) {
                System.out.println(e);
            }
        }
    }

}
