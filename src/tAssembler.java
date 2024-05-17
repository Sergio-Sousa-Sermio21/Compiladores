import java.io.*;
import java.lang.management.ManagementFactory;
import java.util.*;

import Tasm.TasmBaseListener;
import Tasm.TasmLexer;
import Tasm.TasmParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;


public class tAssembler extends TasmBaseListener {
        private final HashMap<String,Integer> labelsposicion = new HashMap<>();
        private final Map<String, List<Integer>> labelsNotFound = new HashMap<>();
        private final ArrayList<Instrucion> instrucoes = new ArrayList<>();
        private final ArrayList<Object> constantpoll = new ArrayList<>();

        public tAssembler(){}

    /**Metodo que mostra as instruções e a constantPool
     */
    public void debug(){
        System.out.println("----------------------------------------\nConstant Pool:");
        for (int i = 0; i<constantpoll.size(); i++) {
            System.out.println(i + ": " + constantpoll.get(i));
        }
        System.out.println("-----------------------------------------\nInstrution array:");
        for (int i = 0; i<instrucoes.size(); i++) {
            System.out.println("L" + i + ": " + instrucoes.get(i));
        }
        System.out.println("-----------------------------------------");
    }

    /** Escreve bytecode em um file com base nas instruções fornecidas
     *
     * @param args Argumentos presentes na linha de comando.
     * @throws IOException Se ocorrer algum erro de E/S ao escrever o file em bytecode
     */
    private void writeBytecode(String[] args, boolean debug) throws IOException {
            if(debug)
                debug();
            File file = new File(args[0]);
            String newFile = file.getPath().replaceFirst("[.][^.]+$", ".tbc");
            FileOutputStream fos = new FileOutputStream(newFile);
            DataOutputStream bytecodes = new DataOutputStream(fos);
            System.out.println(newFile);
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

    /** Inicializa o processo de compilação do código TASM
     *
     * @param args Os argumentos fornecidos ao iniciar o processo
     */
    public void init(String[] args){
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
                //TestSemantico test = new TestSemantico();
                //test.TestTree(tree);
                ParseTreeWalker walker = new ParseTreeWalker();
                walker.walk(this, tree);
            }
            catch (java.io.IOException e) {
                System.out.println(e);
            }
        }

    /** Guardar labels
     *
     * @param ctx the parse tree
     */
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
        //Fazer isto para todos.
        public void enterINTVALUE(TasmParser.INTVALUEContext ctx) {
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.ICONST().getText().toUpperCase()), Integer.parseInt(ctx.INT().getText())));
        }

        public void enterDOUBLEVALUE(TasmParser.DOUBLEVALUEContext ctx) {
            String value = ctx.INT() != null ? ctx.INT().getText() : ctx.DOUBLE().getText();
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.DCONST().getText().toUpperCase()), constantpoll.size()));
            constantpoll.add(Double.parseDouble(value));
        }

        public void enterSTRINGVALUE(TasmParser.STRINGVALUEContext ctx) {

            instrucoes.add(new Instrucion(Commands.valueOf(ctx.SCONST().getText().toUpperCase()), constantpoll.size()));
            constantpoll.add(ctx.STRING().getText());
        }

        public void resolveLabel(String label, String command){
            if(labelsposicion.containsKey(label))
                instrucoes.add(new Instrucion(Commands.valueOf(command.toUpperCase()), labelsposicion.get(label)));
            else{
                if(labelsNotFound.containsKey(label))
                    labelsNotFound.get(label).add(instrucoes.size());
                else
                    labelsNotFound.computeIfAbsent(label, V -> new ArrayList<>()).add(instrucoes.size());
                instrucoes.add(new Instrucion(Commands.valueOf(command.toUpperCase()),0));
            }
        }

        public void enterJUMP(TasmParser.JUMPContext ctx) {
            resolveLabel(ctx.LABEL().getText(),ctx.JUMP().getText());
        }

        public void enterJUMPT(TasmParser.JUMPTContext ctx) {
            resolveLabel(ctx.LABEL().getText(),ctx.JUMPT().getText());
        }

        public void enterJUMPF(TasmParser.JUMPFContext ctx) {
            resolveLabel(ctx.LABEL().getText(),ctx.JUMPF().getText());
        }

        public void enterInstrucaoInt(TasmParser.InstrucaoIntContext ctx){

            instrucoes.add(new Instrucion(Commands.valueOf(ctx.getText().toUpperCase())));
        }

        public void enterBooleaninstruction(TasmParser.BooleaninstructionContext ctx){

            instrucoes.add(new Instrucion(Commands.valueOf(ctx.getText().toUpperCase())));
        }

        public void enterInstrucaoBoolean(TasmParser.InstrucaoBooleanContext ctx) {

            instrucoes.add(new Instrucion(Commands.valueOf(ctx.getText().toUpperCase())));
        }

        public void enterInstrucaoString(TasmParser.InstrucaoStringContext ctx) {

            instrucoes.add(new Instrucion(Commands.valueOf(ctx.getText().toUpperCase())));
        }

        public void enterHALT(TasmParser.HALTContext ctx) {
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.getText().toUpperCase())));
        }

        public void enterGALLOC(TasmParser.GALLOCContext ctx) {

            instrucoes.add(new Instrucion(Commands.valueOf(ctx.GALLOC().getText().toUpperCase()), Integer.parseInt(ctx.INT().getText())));
        }

        public void enterGLOAD(TasmParser.GLOADContext ctx) {

            instrucoes.add(new Instrucion(Commands.valueOf(ctx.GLOAD().getText().toUpperCase()), Integer.parseInt(ctx.INT().getText())));
        }

        public void enterGSTORE(TasmParser.GSTOREContext ctx) {

            instrucoes.add(new Instrucion(Commands.valueOf(ctx.GSTORE().getText().toUpperCase()), Integer.parseInt(ctx.INT().getText())));
        }

        public void enterLLOAD(TasmParser.LLOADContext ctx){
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.LLOAD().getText().toUpperCase()), ctx.INT() != null ? Integer.parseInt(ctx.INT().getText()): Integer.parseInt(ctx.NEGATIVE().getText())));
        }

        public void enterLSTORE(TasmParser.LSTOREContext ctx){
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.LSTORE().getText().toUpperCase()), ctx.INT() != null ? Integer.parseInt(ctx.INT().getText()): Integer.parseInt(ctx.NEGATIVE().getText())));
        }

        public void enterLALLOC(TasmParser.LALLOCContext ctx){
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.LALLOC().getText().toUpperCase()),Integer.parseInt(ctx.INT().getText())));
        }

        public void enterPOP(TasmParser.POPContext ctx){
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.POP().getText().toUpperCase()), Integer.parseInt(ctx.INT().getText())));
        }

        public void enterRETVAL(TasmParser.RETVALContext ctx){
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.RETVAL().getText().toUpperCase()), Integer.parseInt(ctx.INT().getText())));
        }

        public void enterRET(TasmParser.RETContext ctx){
            instrucoes.add(new Instrucion(Commands.valueOf(ctx.RET().getText().toUpperCase()), Integer.parseInt(ctx.INT().getText())));
        }

        public void enterCALL(TasmParser.CALLContext ctx) {
            resolveLabel(ctx.LABEL().getText(),ctx.CALL().getText());
        }
        public void execute(String[] args, boolean debug) throws IOException {
            init(args);
            writeBytecode(args, debug);
        }

        public static void main(String[] args) throws Exception {
            tAssembler assembler = new tAssembler();
            boolean debug = false;
            List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
            for (String arg : inputArguments) {
                if (arg.contains("jdwp")) {
                    debug = true;
                    break;
                }
            }
            assembler.execute(args, debug);
        }

}
