import java.io.*;
import java.util.*;

import Tasm.TasmBaseListener;
import Tasm.TasmLexer;
import Tasm.TasmParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;


public class tAssembler extends TasmBaseListener {
        // Mapeia o nome das labels para a posição correspondente nas instruções
        private final HashMap<String,Integer> labelsposicion = new HashMap<>();
        // Lista de instruções geradas a partir do código presente no ficheiro TASM
        private final ArrayList<Instrucion> instrucoes = new ArrayList<>();
        // Mapeia o nome das labels para uma lista de posições que ?????
        private Map<String, List<Integer>> labelsNotFound = new HashMap<>();
        // Lista de constantes utilizadas no código
        private final ArrayList<Object> constantpoll = new ArrayList<>();
        public tAssembler(String[] args) throws IOException {
            init(args);
            writeBytecode(args);
        }
        // Escreve o código de bytes gerado para um arquivo .tbc
        private void writeBytecode(String[] args) throws IOException {
            //teste.tasm
            File file = new File(args[0]);
            String newFile = file.getName().replaceFirst("[.][^.]+$", ".tbc");
            newFile = "inputs/" + newFile;
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

        public void writeConstantPoll(DataOutputStream bytecodes) throws IOException{
            bytecodes.write(Commands.CONSTANTPOOL.ordinal());
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
        // Inicializa o processo de montagem
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
        // Registra a posição das labels
        public void enterExpression(TasmParser.ExpressionContext ctx) {
            List<TerminalNode> value = ctx.LABEL();
            for (TerminalNode terminalNode : value){
                labelsposicion.put(terminalNode.getText(), instrucoes.size());
                if(labelsNotFound.containsKey(terminalNode.getText())){
                    for(int i : labelsNotFound.get(terminalNode.getText())){
                        instrucoes.get(i).setValue(instrucoes.size());
                    }
                }
            }
        }
        // Adiciona uma instrução de inteiro à lista de instruções
        public void enterINTVALUE(TasmParser.INTVALUEContext ctx) {
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.ICONST().getText().toUpperCase()), Integer.parseInt(ctx.INT().getText())));
        }
        // Adiciona uma instrução do tipo double à lista de instruções
        public void enterDOUBLEVALUE(TasmParser.DOUBLEVALUEContext ctx) {
            String value = ctx.INT() != null ? ctx.INT().getText() : ctx.DOUBLE().getText();
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.DCONST().getText().toUpperCase()), constantpoll.size()));
            constantpoll.add(Double.parseDouble(value));
        }
        // Adiciona uma instrução de string à lista de instruções
        public void enterSTRINGVALUE(TasmParser.STRINGVALUEContext ctx) {
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.SCONST().getText().toUpperCase()), constantpoll.size()));
            constantpoll.add(ctx.STRING().getText());
        }
        // Resolve os saltos condicionais e incondicionais
        public void resolveJumps(String label, String command){
            if(labelsposicion.containsKey(label))
                instrucoes.add(new Instrucion(Commands.valueOf(command.toUpperCase()), labelsposicion.get(label)));
            else{
                if(labelsNotFound.containsKey(label))
                    labelsNotFound.get(label).add(instrucoes.size());
                else
                    labelsNotFound.computeIfAbsent(label, k -> new ArrayList<>()).add(instrucoes.size());
                instrucoes.add(new Instrucion(Commands.valueOf(command.toUpperCase()),0));
            }
        }
        // Adiciona a instrução de salto incondicional à lista de instruções
        public void enterJUMP(TasmParser.JUMPContext ctx) {
            resolveJumps(ctx.LABEL().getText(),ctx.JUMP().getText());
        }
        // Adiciona uma instrução de salto condicional verdadeiro à lista de instruções
        public void enterJUMPT(TasmParser.JUMPTContext ctx) {
            resolveJumps(ctx.LABEL().getText(),ctx.JUMPT().getText());
        }
        // Adiciona uma instrução de salto condicional falso à lista de instruções
        public void enterJUMPF(TasmParser.JUMPFContext ctx) {
            resolveJumps(ctx.LABEL().getText(),ctx.JUMPF().getText());
        }
        // Adiciona uma instrução do tipo inteiro à lista de instruções
        public void enterINTINSTRUCTION(TasmParser.INTINSTRUCTIONContext ctx){
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.getText().toUpperCase())));

        }

        public void enterBOLEANINSTRUCION(TasmParser.BOLEANINSTRUCIONContext ctx){
        instrucoes.add(new Instrucion(Commands.valueOf(ctx.getText().toUpperCase())));
        }

        public void enterDOUBLEINSTRUCTION(TasmParser.DOUBLEINSTRUCTIONContext ctx) {
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.getText().toUpperCase())));
        }

        public void enterSTRINGINSTRUCTION(TasmParser.STRINGINSTRUCTIONContext ctx) {
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.getText().toUpperCase())));
        }
        // Adiciona uma instrução de HALT à lista de instruções
        public void enterHALT(TasmParser.HALTContext ctx) {
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.getText().toUpperCase())));
        }
        // Adiciona uma instrução de alocação global à lista de instruções
        public void enterGALLOC(TasmParser.GALLOCContext ctx) {
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.GALLOC().getText().toUpperCase()), Integer.parseInt(ctx.INT().getText())));
        }
        // Adiciona uma instrução de carga global à lista de instruções
        public void enterGLOAD(TasmParser.GLOADContext ctx) {
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.GLOAD().getText().toUpperCase()), Integer.parseInt(ctx.INT().getText())));
        }
        // Adiciona uma instrução de armazenamento global à lista de instruções
        public void enterGSTORE(TasmParser.GSTOREContext ctx) {
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.GSTORE().getText().toUpperCase()), Integer.parseInt(ctx.INT().getText())));
        }
        public static void main(String[] args) throws Exception {
            tAssembler assembler = new tAssembler(args);
        }
}
