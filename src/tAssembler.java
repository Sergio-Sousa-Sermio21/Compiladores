import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

import Tasm.TasmBaseListener;
import Tasm.TasmLexer;
import Tasm.TasmParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class tAssembler extends TasmBaseListener {

        public tAssembler(String args[]){
            init(args);
        }

        public void init(String args[]){
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
                walker.walk(this, tree);

                System.out.println();
            }
            catch (java.io.IOException e) {
                System.out.println(e);
            }
        }
        public void exitExpression(TasmParser.ExpressionContext ctx) {

            List<TerminalNode> value = ctx.LABEL();
            for (TerminalNode terminalNode : value)
                System.out.println("Valor INTVALUE: "+ctx.start.getLine() +" "  + terminalNode);
        }

        public void exitINTVALUE(TasmParser.INTVALUEContext ctx) {
            String value2 = ctx.ICONST().getText();
            String value = ctx.INT().getText();
            System.out.println("Valor INTVALUE: " +ctx.start.getLine() +" " + value2 + " " + value );
        }

        public void exitDOUBLEVALUE(TasmParser.DOUBLEVALUEContext ctx) {
            String value2 = ctx.DCONST().getText();
            String value = ctx.INT() != null ? ctx.INT().getText() : ctx.DOUBLE().getText();
            System.out.println("Valor INTVALUE: "+ctx.start.getLine() +" " + value2 + " " + value );
        }

        public void exitSTRINGVALUE(TasmParser.STRINGVALUEContext ctx) {
            String value2 = ctx.SCONST().getText();
            String value = ctx.STRING().getText();
            System.out.println("Valor INTVALUE: "+ctx.start.getLine() +" "  + value2 + " " + value);
        }

        public void exitJUMP(TasmParser.JUMPContext ctx) {

        }

        public void exitJUMPT(TasmParser.JUMPTContext ctx) {

        }

        public void exitJUMPF(TasmParser.JUMPFContext ctx) {

        }

        public void exitINTINSTRUCTION(TasmParser.INTINSTRUCTIONContext ctx){
            String value = ctx.getText();

            System.out.println("Valor INTINSTRUCTION: "+ctx.start.getLine() +" "  + value);
        }

        public void exitDOUBLEINSTRUCTION(TasmParser.DOUBLEINSTRUCTIONContext ctx) {
            String value = ctx.getText();
            System.out.println("Valor DOUBLEINTINSTRUCTION: "+ctx.start.getLine() +" "  + value);
        }

        public void exitSTRINGINSTRUCTION(TasmParser.STRINGINSTRUCTIONContext ctx) {
            String value = ctx.getText();
            System.out.println("Valor STRINGINTINSTRUCTION: "+ctx.start.getLine() +" "  + value);
        }
        public static void main(String[] args) throws Exception {
            tAssembler assembler = new tAssembler(args);
        }
}
