import Sol.SolBaseListener;
import Sol.SolLexer;
import Sol.SolParser;
import Sol.SolBaseVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.*;

public class solCompiler {

    static class Visitor extends SolBaseVisitor<Void> {
        private final Map<String, Class<?>> tiposVariaveis = new HashMap<>();
        public Void visitProgram(SolParser.ProgramContext ctx) {
            visitChildren(ctx);
            System.out.println("Halt");
            return null;
        }


        public Void visitLOGICALOPERATOREQUALNOT(SolParser.LOGICALOPERATOREQUALNOTContext ctx) {
            visitChildren(ctx);
            System.out.println("LOGICALOPERATOREQUALNOT: " + ctx.getText() + " " + ctx.op.getText());
            return null;
        }

        public Void visitInstrucao(SolParser.InstrucaoContext ctx) {
            visitChildren(ctx);
            return null;
        }

        public Void visitPrint(SolParser.PrintContext ctx) {
            visitChildren(ctx);
            System.out.println("Print: " + ctx.getText());
            return null;
        }

        public Void visitWhileState(SolParser.WhileStateContext ctx) {
            visit(ctx.exp());
            System.out.println("WHILE: " + ctx.getText());
            visit(ctx.instrucao());
            return null;
        }

        public Void visitForState(SolParser.ForStateContext ctx) {
            System.out.println("FOR: " + ctx.getText());
            visitChildren(ctx);
            return null;
        }

        public Void visitIfState(SolParser.IfStateContext ctx) {
            visit(ctx.exp());
            System.out.println("IF: " + ctx.getText());
            for(int i =0; i<ctx.instrucao().size(); i++)
                visit(ctx.instrucao().get(i));
            return null;
        }

        public Void visitEmpty(SolParser.EmptyContext ctx) {
            System.out.println("EMPTY: " + ctx.getText());
            return null;
        }

        public Void visitBreak(SolParser.BreakContext ctx) {
            System.out.println("BREAK: " + ctx.getText());
            return null;
        }

        public Void visitBloco(SolParser.BlocoContext ctx) {
            System.out.println("Bloco: " + ctx.getText());
            visitChildren(ctx);
            System.out.println("Bloco: " + ctx.getText());
            return null;
        }

        public Void visitMULTDIV(SolParser.MULTDIVContext ctx) {
            System.out.println("MULTDIV: " + ctx.getText());
            return null;
        }

        public Void visitOR(SolParser.ORContext ctx) {
            System.out.println("OR: " + ctx.getText());
            return null;
        }

        public Void visitINT(SolParser.INTContext ctx) {
            String value = ctx.getText();
            System.out.println("iconst " + value);
            return null;
        }

        public Void visitSTRING(SolParser.STRINGContext ctx) {
            System.out.println("STRING: " + ctx.getText());
            return null;
        }

        public Void visitDOUBLE(SolParser.DOUBLEContext ctx) {
            System.out.println("DOUBLE: " + ctx.getText());
            return null;
        }

        public Void visitNOME(SolParser.NOMEContext ctx) {
            System.out.println("NOME: " + ctx.getText());
            return null;
        }

        @Override
        public Void visitDeclaracao(SolParser.DeclaracaoContext ctx) {
            visitChildren(ctx);
            System.out.println(ctx.NOME());
            System.out.println("Declaracao - " + ctx.getText());
            return null;
        }

        @Override public Void visitTiposNoCodigo(SolParser.TiposNoCodigoContext ctx) {
            visitChildren(ctx);
            System.out.println("Type - " + ctx.getText());
            return null;
        }
        @Override
        public Void visitINTT(SolParser.INTTContext ctx) {
            System.out.println("Tipo-"  + ctx.getText());
            return null;
        }


        public void execute(String[] args) {
            String inputFile = null;
            if (args.length > 0)
                inputFile = args[0];
            InputStream is = System.in;
            try {
                if (inputFile != null) is = new FileInputStream(inputFile);
                CharStream input = CharStreams.fromStream(is);
                SolLexer lexer = new SolLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                SolParser parser = new SolParser(tokens);
                parser.removeErrorListeners(); // Remove the default console error listener
                parser.addErrorListener(new ConsoleErrorListener());
                ParseTree tree = parser.program();
                int numberOfErrors = parser.getNumberOfSyntaxErrors();
                if (numberOfErrors > 0) {
                    System.err.println("Foram detectados " + numberOfErrors + " erros de Syntax.");
                    System.exit(0);
                }
                VerifyNodes teste = new VerifyNodes();
                teste.TestTree(tree);


                //this.visit(tree);
            } catch (IOException e) {
                System.err.println("File Not Found.");
                System.exit(0);
            }
        }

    }

    public void executeSol(String[] args){
        Visitor visitor = new Visitor();
        visitor.execute(args);
    }


    public static void main(String[] args) {
        Visitor visitor = new Visitor();
        visitor.execute(args);
    }

}
