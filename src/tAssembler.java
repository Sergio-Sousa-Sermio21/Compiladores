import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import Tasm.TasmBaseListener;
import Tasm.TasmLexer;
import Tasm.TasmParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class tAssembler extends TasmBaseListener {
        private static final HashMap<String, Commands> commandMap = new HashMap<>();
        private static final HashMap<String,Integer> labelsposicion = new HashMap<>();
        private ArrayList<Instrucion> instrucoes = new ArrayList<>();

        private ArrayList<Object> constantpoll = new ArrayList<>();
        public tAssembler(String args[]) throws IOException {
            initHashMap();
            init(args);
            writeBytecode(args);
            /*
            FileOutputStream fos = new FileOutputStream("inputs/" + out);
            DataOutputStream bytecodes = new DataOutputStream(fos);

            String teste = "Caralho";
            byte[] stringbytes = teste.getBytes(StandardCharsets.UTF_8);
            bytecodes.writeInt(teste.length());
            bytecodes.write(stringbytes);*/

        }

        private void writeBytecode(String[] args) throws IOException {
            //teste.tasm
            File file = new File(args[0]);
            String newFile = file.getName().replaceFirst("[.][^.]+$", ".tbc");
            newFile = "inputs/" + newFile;
            FileOutputStream fos = new FileOutputStream(newFile);
            DataOutputStream bytecodes = new DataOutputStream(fos);
            for (Instrucion instruction : instrucoes) {
                    bytecodes.write(instruction.getCommand().ordinal());
                    if(instruction.getValue() instanceof Integer)
                        bytecodes.writeInt((int) instruction.getValue());
                    if(instruction.getValue() instanceof  String){
                        bytecodes.writeInt(constantpoll.size());
                        constantpoll.add(instruction.getValue());
                    } else if(instruction.getValue() instanceof  Double){
                        bytecodes.writeInt(constantpoll.size());
                        constantpoll.add(instruction.getValue());
                    } else if(instruction.getValue() instanceof TerminalNode){
                        System.out.println(labelsposicion.get(instruction.getValue().toString()));
                        bytecodes.write(labelsposicion.get(instruction.getValue().toString()));
                    }

            }
            writeconstanpoll(bytecodes);
        }

        public void writeconstanpoll(DataOutputStream bytecodes) throws IOException{
            bytecodes.write(Commands.CONSTANTPOOL.ordinal());
            for (Object constant: constantpoll){
                if(constant instanceof Double){
                    bytecodes.writeDouble((double) constant);
                } else if (constant instanceof String finalstring){
                    bytecodes.write(finalstring.length());
                    bytecodes.writeChars(finalstring);
                }

            }
        }

        public void initHashMap(){
            for(Commands c : Commands.values())
                commandMap.put(c.name().toLowerCase(), c);
        }

        public void init(String args[]){
            String inputFile = null;
            if ( args.length>0 )
                inputFile = args[0];
            InputStream is = System.in;
            try {
                if (inputFile != null) is = new FileInputStream(inputFile);
                CharStream input = CharStreams.fromStream(is);
                TasmLexer lexer = new TasmLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                TasmParser parser = new TasmParser(tokens);
                parser.removeErrorListeners(); // Remove the default console error listener
                parser.addErrorListener(new ConsoleErrorListener());

                ParseTree tree = parser.program();
                int numberOfErrors = parser.getNumberOfSyntaxErrors();
                if(numberOfErrors>0){
                    System.err.println("Foram detactados " + numberOfErrors + " erros de Syntax.");
                    System.exit(0);
                }
                TestSemantico test = new TestSemantico();
                test.TestTree(tree);
                ParseTreeWalker walker = new ParseTreeWalker();
                walker.walk(this, tree);
                for(Instrucion intr : instrucoes)
                    System.out.println(intr);
            }
            catch (java.io.IOException e) {
                System.out.println(e);
            }
        }
        public void enterExpression(TasmParser.ExpressionContext ctx) {
            List<TerminalNode> value = ctx.LABEL();
            for (TerminalNode terminalNode : value){
                labelsposicion.put(terminalNode.getText(), instrucoes.size());
            }
        }

        public void enterINTVALUE(TasmParser.INTVALUEContext ctx) {
            instrucoes.add(new Instrucion(commandMap.get(ctx.ICONST().getText()), Integer.parseInt(ctx.INT().getText())));
        }

        public void enterDOUBLEVALUE(TasmParser.DOUBLEVALUEContext ctx) {
            String value = ctx.INT() != null ? ctx.INT().getText() : ctx.DOUBLE().getText();
            instrucoes.add(new Instrucion(commandMap.get(ctx.DCONST().getText()), Double.parseDouble(value)));
        }

        public void enterSTRINGVALUE(TasmParser.STRINGVALUEContext ctx) {
            instrucoes.add(new Instrucion(commandMap.get(ctx.SCONST().getText()), ctx.STRING().getText()));
        }

        public void enterJUMP(TasmParser.JUMPContext ctx) {
            instrucoes.add(new Instrucion(commandMap.get(ctx.JUMP().getText()), ctx.LABEL()));
        }

        public void enterJUMPT(TasmParser.JUMPTContext ctx) {
            instrucoes.add(new Instrucion(commandMap.get(ctx.JUMPT().getText()), ctx.LABEL()));
        }

        public void enterJUMPF(TasmParser.JUMPFContext ctx) {
            instrucoes.add(new Instrucion(commandMap.get(ctx.JUMPF().getText()), ctx.LABEL()));
        }

        public void enterINTINSTRUCTION(TasmParser.INTINSTRUCTIONContext ctx){
            instrucoes.add(new Instrucion(commandMap.get(ctx.getText())));
        }

        public void enterBOLEANINSTRUCION(TasmParser.BOLEANINSTRUCIONContext ctx){
        instrucoes.add(new Instrucion(commandMap.get(ctx.getText())));
        }

        public void enterDOUBLEINSTRUCTION(TasmParser.DOUBLEINSTRUCTIONContext ctx) {
            instrucoes.add(new Instrucion(commandMap.get(ctx.getText())));
        }

        public void enterSTRINGINSTRUCTION(TasmParser.STRINGINSTRUCTIONContext ctx) {
            instrucoes.add(new Instrucion(commandMap.get(ctx.getText())));
        }

        public void enterHALT(TasmParser.HALTContext ctx) {
            instrucoes.add(new Instrucion(commandMap.get(ctx.getText())));
        }

        public void enterGALLOC(TasmParser.GALLOCContext ctx) {
            instrucoes.add(new Instrucion(commandMap.get(ctx.GALLOC().getText()), Integer.parseInt(ctx.INT().getText())));
        }

        public void enterGLOAD(TasmParser.GLOADContext ctx) {
            instrucoes.add(new Instrucion(commandMap.get(ctx.GLOAD().getText()), Integer.parseInt(ctx.INT().getText())));
        }

        public void enterGSTORE(TasmParser.GSTOREContext ctx) {
            instrucoes.add(new Instrucion(commandMap.get(ctx.GSTORE().getText()), Integer.parseInt(ctx.INT().getText())));
        }
        public static void main(String[] args) throws Exception {
            tAssembler assembler = new tAssembler(args);
        }
}
