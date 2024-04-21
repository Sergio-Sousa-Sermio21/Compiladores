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

import java.io.*;
import java.util.*;

public class SolAssembler {

    static class Parse extends  SolBaseListener{
        private ParseTreeProperty<Class<?>> values = new ParseTreeProperty<>();
        // ArrayLists que contem as instrucoes e os seus valores respetivos
        private final ArrayList<Instrucion> instrucoes = new ArrayList<>();
        private final ArrayList<Object> constantpoll = new ArrayList<>();
        public Class<?> getValues(ParseTree node){
            return values.get(node);
        }

        public void debug(){
            System.out.println("----------------------------------------\nConstant Pool:");
            for (int i = 0; i<constantpoll.size(); i++) {
                System.out.println(i + ": " + constantpoll.get(i));
            }
            System.out.println("-----------------------------------------\nInstrution array:");
            for (int i = 0; i<instrucoes.size(); i++) {
                System.out.println(i + ": " + instrucoes.get(i));
            }
            System.out.println("-----------------------------------------");
        }

        @Override public void exitProgram(SolParser.ProgramContext ctx) {
            instrucoes.add(new Instrucion(Commands.HALT));
        }

        /** Escreve bytecode em um file com base nas instruções fornecidas
         *
         * @param args Argumentos presentes na linha de comando.
         * @throws IOException Se ocorrer algum erro de E/S ao escrever o file em bytecode
         */
        private void writeBytecode(String[] args) throws IOException {
            File file = new File(args[0]);
            String newFile = file.getPath().replaceFirst("[.][^.]+$", ".tbc");
            FileOutputStream fos = new FileOutputStream(newFile);
            DataOutputStream bytecodes = new DataOutputStream(fos);
            for (Instrucion instruction : instrucoes) {
                bytecodes.write(instruction.getCommand().ordinal());
                if(instruction.getValue() != null){
                    bytecodes.writeInt( instruction.getValue());
                }
            }
            writeConstantPoll(bytecodes);
        }
        /** Escreve a tabela de constantes em bytecode no fim do file
         *
         * @param bytecodes Serve para a criação de dados em byte
         * @throws IOException Se ocorrer algum erro de E/S ao escrever na constant
         */
        public void writeConstantPoll(DataOutputStream bytecodes) throws IOException{
            bytecodes.write(Commands.values().length);
            for (Object constant: constantpoll){
                if(constant instanceof Double){
                    bytecodes.write(0);
                    bytecodes.writeDouble((double) constant);
                } else if (constant instanceof String finalstring){
                    finalstring = finalstring.substring(1,finalstring.length()-1);
                    bytecodes.write(1);
                    bytecodes.writeInt(finalstring.length());
                    bytecodes.writeChars(finalstring);
                }

            }
        }
        @Override public void exitORDER(SolParser.ORDERContext ctx) {
            Class<?> Order = getValues(ctx);
            Class<?> Parent = getValues(ctx.getParent());
            if(Order != Parent){
                if(Parent == String.class)
                    if(Order == Integer.class){
                        instrucoes.add(new Instrucion(Commands.ITOS));
                    }
                    else if(Order == Double.class) {
                        instrucoes.add(new Instrucion(Commands.DTOS));
                    }
                    else {
                        instrucoes.add(new Instrucion(Commands.BTOS));
                    }
                else if(Parent==Double.class) {
                    instrucoes.add(new Instrucion(Commands.ITOD));
                }
            }
        }

        @Override public void exitInstrucao(SolParser.InstrucaoContext ctx) {
            if(getValues(ctx) == Integer.class){
                instrucoes.add(new Instrucion(Commands.IPRINT));
            } else if(getValues(ctx) == Double.class){
                instrucoes.add(new Instrucion(Commands.DPRINT));
            } else if(getValues(ctx) == String.class){
                instrucoes.add(new Instrucion(Commands.SPRINT));
            } else {
                instrucoes.add(new Instrucion(Commands.BPRINT));
            }

        }
        @Override public void exitMULTDIV(SolParser.MULTDIVContext ctx) {
            switch (ctx.op.getText()){
                case "*" -> {
                    if(getValues(ctx) == Double.class)
                        instrucoes.add(new Instrucion(Commands.DMULT));
                    else
                        instrucoes.add(new Instrucion(Commands.IMULT));
                }
                case "/" -> {
                    if(getValues(ctx) == Double.class)
                        instrucoes.add(new Instrucion(Commands.DDIV));
                    else
                        instrucoes.add(new Instrucion(Commands.IDIV));
                }
                case "%" -> {
                    instrucoes.add(new Instrucion(Commands.IMOD));
                }
            }
            if(getValues(ctx.getParent()) == String.class)
                if(getValues(ctx) == Double.class)
                    instrucoes.add(new Instrucion(Commands.DTOS));
                else
                    instrucoes.add(new Instrucion(Commands.ITOS));
            else if (getValues(ctx) != Double.class && getValues(ctx.getParent()) == Double.class)
                instrucoes.add(new Instrucion(Commands.ITOD));
        }
        @Override public void exitNEGACION(SolParser.NEGACIONContext ctx) {
            switch (ctx.op.getText()){
                case "-" -> {
                    if(getValues(ctx) == Double.class)
                        instrucoes.add(new Instrucion(Commands.DUMINUS));
                    else
                        instrucoes.add(new Instrucion(Commands.IUMINUS));
                }
                case "not" -> {
                    instrucoes.add(new Instrucion(Commands.NOT));
                }
            }
            if(getValues(ctx.getParent()) == String.class)
                if(getValues(ctx) == Double.class) {
                    instrucoes.add(new Instrucion(Commands.DTOS));
                }
                else if(getValues(ctx) == Integer.class) {
                    instrucoes.add(new Instrucion(Commands.ITOS));
                }
                else {
                    instrucoes.add(new Instrucion(Commands.BTOS));
                }
            else if (getValues(ctx) != Double.class && getValues(ctx.getParent()) == Double.class) {
                instrucoes.add(new Instrucion(Commands.ITOD));
            }
        }

        @Override public void exitADDSUB(SolParser.ADDSUBContext ctx) {
            switch (ctx.op.getText()){
                case "+" -> {
                    if(getValues(ctx) == Double.class)
                        instrucoes.add(new Instrucion(Commands.DADD));
                    else if(getValues(ctx) == Integer.class)
                        instrucoes.add(new Instrucion(Commands.IADD));
                    else
                        instrucoes.add(new Instrucion(Commands.SADD));
                }
                case "-" -> {
                    if(getValues(ctx) == Double.class)
                        instrucoes.add(new Instrucion(Commands.DSUB));
                    else
                        instrucoes.add(new Instrucion(Commands.ISUB));
                }
            }
            if(getValues(ctx.getParent()) == String.class)
                if(getValues(ctx) == Double.class) {
                    instrucoes.add(new Instrucion(Commands.DTOS));
                }
                else if(getValues(ctx) == Integer.class) {
                    instrucoes.add(new Instrucion(Commands.ITOS));
                }
                else if (getValues(ctx) != Double.class && getValues(ctx.getParent()) == Double.class) {
                    instrucoes.add(new Instrucion(Commands.ITOD));
                }
        }
        @Override public void exitAND(SolParser.ANDContext ctx) {
            instrucoes.add(new Instrucion(Commands.AND));
            if(getValues(ctx.getParent()) == String.class) {
                instrucoes.add(new Instrucion(Commands.BTOS));
            }
        }
        @Override public void exitOR(SolParser.ORContext ctx) {
            instrucoes.add(new Instrucion(Commands.OR));
            if(getValues(ctx.getParent()) == String.class){
                instrucoes.add(new Instrucion(Commands.BTOS));
            }
        }

        @Override public void exitLOGICALOPERATOREQUALNOT(SolParser.LOGICALOPERATOREQUALNOTContext ctx) {
            if(getValues(ctx.exp(0)) == Double.class || getValues(ctx.exp(1)) == Double.class){
                switch (ctx.op.getText()) {
                    case "==" -> instrucoes.add(new Instrucion(Commands.DEQ));
                    case "!=" -> instrucoes.add(new Instrucion(Commands.DNEQ));
                }
            } else if (getValues(ctx.exp(0)) == Integer.class) {
                switch (ctx.op.getText()) {
                    case "==" -> instrucoes.add(new Instrucion(Commands.IEQ));
                    case "!=" -> instrucoes.add(new Instrucion(Commands.INEQ));
                }
            } else if(getValues(ctx.exp(0)) == String.class){
                switch (ctx.op.getText()) {
                    case "==" -> instrucoes.add(new Instrucion(Commands.SEQ));
                    case "!=" -> instrucoes.add(new Instrucion(Commands.SNEQ));
                }
            } else{
                switch (ctx.op.getText()) {
                    case "==" -> instrucoes.add(new Instrucion(Commands.BEQ));
                    case "!=" -> instrucoes.add(new Instrucion(Commands.BNEQ));
                }
            }
            if(getValues(ctx.getParent()) == String.class) {
                instrucoes.add(new Instrucion(Commands.BTOS));
            }
        }
        @Override public void exitLOGICALOPERATOR(SolParser.LOGICALOPERATORContext ctx) {
            if(getValues(ctx.exp(0)) == Double.class || getValues(ctx.exp(1)) == Double.class){
                switch (ctx.op.getText()) {
                    case "<" -> instrucoes.add(new Instrucion(Commands.DLT));
                    case ">" -> {
                        instrucoes.add(new Instrucion(Commands.DLEQ));
                        instrucoes.add(new Instrucion(Commands.NOT));
                    }
                    case "<=" -> instrucoes.add(new Instrucion(Commands.DLEQ));
                    case ">=" -> {
                        instrucoes.add(new Instrucion(Commands.DLT));
                        instrucoes.add(new Instrucion(Commands.NOT));
                    }
                }
            } else {
                switch (ctx.op.getText()) {
                    case "<" -> instrucoes.add(new Instrucion(Commands.ILT));
                    case ">" -> {
                        instrucoes.add(new Instrucion(Commands.ILEQ));
                        instrucoes.add(new Instrucion(Commands.NOT));
                    }
                    case "<=" -> instrucoes.add(new Instrucion(Commands.ILEQ));
                    case ">=" -> {
                        instrucoes.add(new Instrucion(Commands.ILT));
                        instrucoes.add(new Instrucion(Commands.NOT));
                    }
                }
            }
            if(getValues(ctx.getParent()) == String.class) {
                instrucoes.add(new Instrucion(Commands.BTOS));
            }
        }


        //Listener de valores
        //-----------------------------------------------------------------------------------------------------------------------------------------------

        @Override public void exitINT(SolParser.INTContext ctx) {
            instrucoes.add(new Instrucion(Commands.ICONST, Integer.parseInt(ctx.getText())));
            if (getValues(ctx.getParent()) == String.class) {
                instrucoes.add(new Instrucion(Commands.ITOS));
            } else if (getValues(ctx.getParent()) == Double.class) {
                instrucoes.add(new Instrucion(Commands.ITOD));
            } else if (getValues(ctx.getParent()) == Boolean.class) {
                if (getValues(ctx.getParent().getChild(0)) == Double.class || getValues(ctx.getParent().getChild(2)) == Double.class) {
                    instrucoes.add(new Instrucion(Commands.ITOD));
                }
            }
        }
        @Override public void exitDOUBLE(SolParser.DOUBLEContext ctx) {
            int i = constantpoll.indexOf(Double.parseDouble(ctx.getText()));
            if(i==-1){
                instrucoes.add(new Instrucion(Commands.DCONST, constantpoll.size()));
                constantpoll.add(Double.parseDouble(ctx.getText()));
            } else
                instrucoes.add(new Instrucion(Commands.DCONST, i));

            if (getValues(ctx.getParent()) == String.class) {
                instrucoes.add(new Instrucion(Commands.DTOS));
            }
        }
        @Override public void exitSTRING(SolParser.STRINGContext ctx) {
            int i = constantpoll.indexOf(ctx.getText());
            if(i==-1){
                instrucoes.add(new Instrucion(Commands.SCONST, constantpoll.size()));
                constantpoll.add(ctx.getText());
            } else {
                instrucoes.add(new Instrucion(Commands.SCONST, i));
            }

        }

        @Override public void exitTRUE(SolParser.TRUEContext ctx) {
            instrucoes.add(new Instrucion(Commands.TCONST));
            if (getValues(ctx.getParent()) == String.class) {
                instrucoes.add(new Instrucion(Commands.BTOS));
            }
        }

        @Override public void exitFALSE(SolParser.FALSEContext ctx) {
            instrucoes.add(new Instrucion(Commands.FCONST));
            if (getValues(ctx.getParent()) == String.class) {
                instrucoes.add(new Instrucion(Commands.BTOS));
            }
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
                System.err.println("File Not Found.");
                System.exit(0);
            }
        }

        public void execute(String[] args, boolean debug){
            try{
                init(args);
                if(debug)
                    debug();
                writeBytecode(args);
            } catch (Exception e){
                System.exit(0);
            }

        }
    }

    public static void main(String[] args){
        Parse a = new Parse();
        a.execute(args, false);
    }

}
