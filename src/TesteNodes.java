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
import java.io.InputStream;
import java.util.*;

public class TesteNodes extends SolBaseListener {
    private final ParseTreeProperty<Class<?>> values = new ParseTreeProperty<>();

    private final ArrayList<String> errors = new ArrayList<>();

    public void setValues(ParseTree node, Class<?> a){
        values.put(node,a);
    }

    public Class<?> getValues(ParseTree node){
        return values.get(node);
    }

    @Override public void exitInstrucao(SolParser.InstrucaoContext ctx) {
        setValues(ctx, getValues(ctx.exp()));
    }
    @Override public void exitMULTDIV(SolParser.MULTDIVContext ctx) {
        Class<?> left= getValues(ctx.exp(0));
        Class<?> rigth= getValues(ctx.exp(1));
        if(left == Object.class || rigth == Object.class)
            setValues(ctx, Object.class);
        else {
            if(ctx.op.getText().equals("%") && (left != Integer.class || rigth!= Integer.class)){
                errors.add("Line" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + ": Error in operator % cannot use " + left.getSimpleName() + " and " + rigth.getSimpleName());
                setValues(ctx, Object.class);
            }
            else if(left == String.class || rigth == String.class){
                errors.add("Line" + ctx.start.getLine() + ": Type String is not allowed in " + ctx.op.getText());
                setValues(ctx, Object.class);
            }
            else if(left == Boolean.class || rigth == Boolean.class){
                errors.add("Line" + ctx.start.getLine() + ": Type Boolean is not allowed in " + ctx.op.getText());
                setValues(ctx, Object.class);
            }
            else if(left == Double.class || rigth == Double.class)
                setValues(ctx,Double.class);
            else
                setValues(ctx, Integer.class);
        }

    }

    @Override public void exitORDER(SolParser.ORDERContext ctx) {
        setValues(ctx, getValues(ctx.exp()));
    }
    @Override public void exitNEGACION(SolParser.NEGACIONContext ctx) {
        Class<?> value = getValues(ctx.exp());
        if(value == Object.class)
            setValues(ctx, Object.class);
        if(ctx.op.getText().equals("-")){
            if(value != Integer.class && value != Double.class){
                errors.add("Line" + ctx.start.getLine() + ": Type Boolean and/or String cannot use " + ctx.op.getText() + " operator");
                setValues(ctx, Object.class);
            } else {
                if(value == Double.class)
                    setValues(ctx, Double.class);
                else
                    setValues(ctx, Integer.class);
            }
        } else {
            if(value != Boolean.class){
                errors.add("Line" + ctx.start.getLine() + ": Type must be Boolean to use " + ctx.op.getText() + " operator");
                setValues(ctx, Object.class);
            }else{
                setValues(ctx, Boolean.class);
            }


        }

    }

    @Override public void exitADDSUB(SolParser.ADDSUBContext ctx) {
        Class<?> left= getValues(ctx.exp(0));
        Class<?> rigth= getValues(ctx.exp(1));
        if(left == Object.class || rigth == Object.class)
            setValues(ctx, Object.class);
        else {

            if((left == Boolean.class && rigth != String.class) || (left != String.class && rigth == Boolean.class)){
                errors.add("Line" + ctx.start.getLine() + ": The operator " + ctx.op.getText() + " isn't valid between " + left.getSimpleName() + " and " + rigth.getSimpleName());
                setValues(ctx, Object.class);
            } else {
                if(left == String.class || rigth == String.class)
                    setValues(ctx, String.class);
                else if(left == Double.class || rigth ==  Double.class )
                    setValues(ctx, Double.class);
                else if(left == Integer.class && rigth == Integer.class){
                    setValues(ctx, Integer.class);
                }

            }
        }

    }
    @Override public void exitAND(SolParser.ANDContext ctx) {
        Class<?> left= getValues(ctx.exp(0));
        Class<?> rigth= getValues(ctx.exp(1));
        if(left == Object.class || rigth == Object.class)
            setValues(ctx, Object.class);
        else{
            if(left != Boolean.class || rigth != Boolean.class){
                errors.add("Line" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "Must use Type Boolean for the operator AND" );
                setValues(ctx, Object.class);
            } else {
                setValues(ctx, Boolean.class);
            }


        }
    }
    @Override public void exitOR(SolParser.ORContext ctx) {
        Class<?> left= getValues(ctx.exp(0));
        Class<?> rigth= getValues(ctx.exp(1));
        if(left == Object.class || rigth == Object.class)
            setValues(ctx, Object.class);
        else{
            if(left != Boolean.class || rigth != Boolean.class){
                errors.add("Line" + ctx.start.getLine() + ": Must use Type Boolean for the operator OR" );
                setValues(ctx, Object.class);
            } else {
                setValues(ctx, Boolean.class);
            }
        }

    }

    @Override public void exitLOGICALOPERATOREQUALNOT(SolParser.LOGICALOPERATOREQUALNOTContext ctx) {
        Class<?> left= getValues(ctx.exp(0));
        Class<?> rigth= getValues(ctx.exp(1));
        if(left == Object.class || rigth == Object.class)
            setValues(ctx, Object.class);
        else{
            if(left!=rigth && !((left == Integer.class && rigth == Double.class) || (left == Double.class && rigth == Integer.class))){
                errors.add("Line" + ctx.start.getLine() + ": Cannot compare " + left.getSimpleName() + " and " + rigth.getSimpleName());
                setValues(ctx, Object.class);
            } else
                setValues(ctx, Boolean.class);
        }
    }
    @Override public void exitLOGICALOPERATOR(SolParser.LOGICALOPERATORContext ctx) {
        Class<?> left= getValues(ctx.exp(0));
        Class<?> right= getValues(ctx.exp(1));
        if(left == Object.class || right == Object.class)
            setValues(ctx, Object.class);
        else{
            if(left == String.class || right == String.class || left == Boolean.class || right == Boolean.class){
                errors.add("Line" + ctx.start.getLine() + ": Can not compare " + left.getSimpleName() + " and " + right.getSimpleName()  +" in " + ctx.op.getText());
                setValues(ctx, Object.class);
            } else{
                setValues(ctx, Boolean.class);
            }
        }

    }


    //Listener de valores
    //-----------------------------------------------------------------------------------------------------------------------------------------------

    @Override public void exitINT(SolParser.INTContext ctx) {
        setValues(ctx, Integer.class);
    }
    @Override public void exitDOUBLE(SolParser.DOUBLEContext ctx) {
        setValues(ctx, Double.class);
    }
    @Override public void exitSTRING(SolParser.STRINGContext ctx) {
        setValues(ctx, String.class);
    }
    @Override public void exitTRUE(SolParser.TRUEContext ctx) {
        setValues(ctx, Boolean.class);
    }

    @Override public void exitFALSE(SolParser.FALSEContext ctx) {
        setValues(ctx, Boolean.class);
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
                System.err.println("Detected " + numberOfErrors + " Syntax errors.");
                System.exit(0);
            }
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(this, tree);
        }
        catch (java.io.IOException e) {
            System.out.println(e);
        }
    }
    public ParseTreeProperty<Class<?>> TestTree(ParseTree tree){
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, tree);
        if(!errors.isEmpty())
            Error.printErrors(errors);
        return values;
    }
    public static void main(String[] args) {
        TesteNodes a = new TesteNodes();
        a.init(args);
    }

}
