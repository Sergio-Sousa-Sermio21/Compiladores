import Sol.SolBaseListener;
import Sol.SolLexer;
import Sol.SolParser;
import Tasm.TasmBaseListener;
import Tasm.TasmLexer;
import Tasm.TasmParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SolAssembler extends SolBaseListener {
    private ParseTreeProperty<Class<?>> values = new ParseTreeProperty<>();
    private final ArrayList<Instrucion> instrucoes = new ArrayList<>();
    private final ArrayList<Object> constantpoll = new ArrayList<>();
    public Class<?> getValues(ParseTree node){
        return values.get(node);
    }

    @Override public void exitProgram(SolParser.ProgramContext ctx) {
        System.out.println("halt");
    }

    @Override public void exitORDER(SolParser.ORDERContext ctx) {
        Class<?> Order = getValues(ctx);
        Class<?> Parent = getValues(ctx.getParent());
        if(Order != Parent){
            if(Parent == String.class)
                if(Order == Integer.class)
                    System.out.println("itos");
                else if(Order == Double.class)
                    System.out.println("dtos");
                else
                    System.out.println("btos");
            else if(Parent==Double.class)
                System.out.println("itod");
        }
    }

    @Override public void exitInstrucao(SolParser.InstrucaoContext ctx) {
        if(getValues(ctx) == Integer.class){
            System.out.println("iprint");
        } else if(getValues(ctx) == Double.class){
            System.out.println("dprint");
        } else if(getValues(ctx) == String.class){
            System.out.println("sprint");
        } else {
            System.out.println("bprint");
        }

    }
    @Override public void exitMULTDIV(SolParser.MULTDIVContext ctx) {
        switch (ctx.op.getText()){
            case "*" -> {
                if(getValues(ctx) == Double.class)
                    System.out.println("dmult");
                else
                    System.out.println("imult");
            }
            case "/" -> {
                if(getValues(ctx) == Double.class)
                    System.out.println("ddiv");
                else
                    System.out.println("idiv");
            }
            case "%" -> {
                if(getValues(ctx) == Double.class)
                    System.out.println("dmod");
                else
                    System.out.println("imod");
            }
        }
        if(getValues(ctx.getParent()) == String.class)
            if(getValues(ctx) == Double.class)
                System.out.println("dtos");
            else
                System.out.println("itos");
        else if (getValues(ctx) != Double.class && getValues(ctx.getParent()) == Double.class)
            System.out.println("itod");
    }
    @Override public void exitNEGACION(SolParser.NEGACIONContext ctx) {
        switch (ctx.op.getText()){
            case "-" -> {
                if(getValues(ctx) == Double.class)
                    System.out.println("duminus");
                else
                    System.out.println("iuminus");
            }
            case "not" -> {
                System.out.println("not");
            }
        }
        if(getValues(ctx.getParent()) == String.class)
            if(getValues(ctx) == Double.class)
                System.out.println("dtos");
            else if(getValues(ctx) == Integer.class)
                System.out.println("itos");
            else
                System.out.println("btos");
        else if (getValues(ctx) != Double.class && getValues(ctx.getParent()) == Double.class)
            System.out.println("itod");
    }

    @Override public void exitADDSUB(SolParser.ADDSUBContext ctx) {
        switch (ctx.op.getText()){
            case "+" -> {
                if(getValues(ctx) == Double.class)
                    System.out.println("dadd");
                else if(getValues(ctx) == Integer.class)
                    System.out.println("iadd");
                else
                    System.out.println("sadd");
            }
            case "-" -> {
                if(getValues(ctx) == Double.class)
                    System.out.println("dsub");
                else
                    System.out.println("isub");
            }
        }
        if(getValues(ctx.getParent()) == String.class)
            if(getValues(ctx) == Double.class)
                System.out.println("dtos");
            else if(getValues(ctx) == Integer.class)
                System.out.println("itos");
        else if (getValues(ctx) != Double.class && getValues(ctx.getParent()) == Double.class)
                System.out.println("itod");
    }
    @Override public void exitAND(SolParser.ANDContext ctx) {
        System.out.println("and");
        if(getValues(ctx.getParent()) == String.class)
            System.out.println("btos");
    }
    @Override public void exitOR(SolParser.ORContext ctx) {
        System.out.println("or");
        if(getValues(ctx.getParent()) == String.class)
            System.out.println("btos");
    }

    @Override public void exitLOGICALOPERATOREQUALNOT(SolParser.LOGICALOPERATOREQUALNOTContext ctx) {
        if(getValues(ctx.getChild(0)) == Double.class){
            switch (ctx.op.getText()) {
                case "==" -> System.out.println("deq");
                case "!=" -> System.out.println("dneq");
            }
        } else if (getValues(ctx.getChild(0)) == Integer.class) {
            switch (ctx.op.getText()) {
                case "==" -> System.out.println("ieq");
                case "!=" -> System.out.println("ineq");
            }
        } else if(getValues(ctx.getChild(0)) == String.class){
            switch (ctx.op.getText()) {
                case "==" -> System.out.println("seq");
                case "!=" -> System.out.println("sneq");
            }
        } else{
            switch (ctx.op.getText()) {
                case "==" -> System.out.println("beq");
                case "!=" -> System.out.println("bneq");
            }
        }
        if(getValues(ctx.getParent()) == String.class)
            System.out.println("btos");
    }
    @Override public void exitLOGICALOPERATOR(SolParser.LOGICALOPERATORContext ctx) {
        if(getValues(ctx.getChild(0)) == Double.class || getValues(ctx.getChild(0)) != Double.class){
            switch (ctx.op.getText()) {
                case "<" -> System.out.println("dlt");
                case ">" -> System.out.println("dgt");
                case "<=" -> System.out.println("dleq");
                case ">=" -> System.out.println("dgeq");
            }
        } else {
            switch (ctx.op.getText()) {
                case "<" -> System.out.println("ilt");
                case ">" -> System.out.println("igt");
                case "<=" -> System.out.println("ileq");
                case ">=" -> System.out.println("igeq");
            }
        }
        if(getValues(ctx.getParent()) == String.class)
            System.out.println("btos");
    }


    //Listener de valores
    //-----------------------------------------------------------------------------------------------------------------------------------------------

    @Override public void exitINT(SolParser.INTContext ctx) {
        instrucoes.add(new Instrucion(Commands.ICONST, Integer.parseInt(ctx.getText())));
        if(getValues(ctx.getParent()) !=Integer.class)
            if(getValues(ctx.getParent()) == String.class)
                System.out.println("itos");
            else if(getValues(ctx.getParent()) == Double.class)
                System.out.println("itod");
            else if(getValues(ctx.getParent()) == Boolean.class){
                if(getValues(ctx.getParent().getChild(0)) == Double.class || getValues(ctx.getParent().getChild(2)) == Double.class)
                    System.out.println("itod");
            }

    }
    @Override public void exitDOUBLE(SolParser.DOUBLEContext ctx) {
        System.out.println("dconst " + ctx.getText());
        if(getValues(ctx.getParent()) !=Double.class)
            if(getValues(ctx.getParent()) == String.class)
                System.out.println("dtos");
    }
    @Override public void exitSTRING(SolParser.STRINGContext ctx) {
        System.out.println("sconst " + ctx.getText());

    }
    @Override public void exitTRUE(SolParser.TRUEContext ctx) {
        System.out.println("tconst ");
        if(getValues(ctx.getParent()) == String.class)
                System.out.println("btos");
    }

    @Override public void exitFALSE(SolParser.FALSEContext ctx) {
        instrucoes.add(new Instrucion(Commands.FCONST));
        if(getValues(ctx.getParent()) == String.class)
            System.out.println("btos");
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------
    public void init(String[] args){
        String inputFile = null;
        if ( args.length>0 )
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
            if(numberOfErrors>0){
                System.err.println("Foram detactados " + numberOfErrors + " erros de Syntax.");
                System.exit(0);
            }
            TesteNodes teste = new TesteNodes();
            values = teste.TestTree(tree);
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(this, tree);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        SolAssembler a = new SolAssembler();
        a.init(args);
    }

}
