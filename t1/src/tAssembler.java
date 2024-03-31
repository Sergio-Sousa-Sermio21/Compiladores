import Tasm.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class tAssembler extends TasmBaseListener{

    /**
     *
     * @param byteStream
     * @param instructions
     * @param constantPool
     * @throws IOException
     */
    public static void writeInstruction(DataOutputStream byteStream, ArrayList<Instruction> instructions, ArrayList<Object> constantPool) throws IOException {
        for (Instruction instruction : instructions) {
            byteStream.write(instruction.getBytes());
        }
        for (int i = 0; i<constantPool.size(); i++){
            Object data = constantPool.get(i);
            if (data instanceof Double) {
                byteStream.write(0);
                byteStream.writeDouble((double)data);
            } else {
                byteStream.write(1);
                String string = (String) data;
                byte[] bytes =string.getBytes(StandardCharsets.UTF_8);
                byteStream.writeInt(string.length());
                byteStream.write(bytes);
            }
        }
    }

    public static void testeSemantico(TasmListener tasmListener){
        hasHalt(tasmListener);
        tasmListener.labelLink();
    }

    /**
     *
     * @param tasmListener
     */
    public static void hasHalt(TasmListener tasmListener){
           int checkHalt = 0;
           for (Instruction inst : tasmListener.getInstructions()) {
               if (inst.getToken1() == TokenTasm.HALT){
                   checkHalt++;
                   break;
               }
           }
           if(checkHalt == 0)
               throw new RuntimeException("No Halt detected");
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
            ParseTree tree = parser.executable();
            ParseTreeWalker walker = new ParseTreeWalker();
            TasmListener tasmListener = new TasmListener();
            walker.walk(tasmListener,tree);
            testeSemantico(tasmListener);
            if (inputFile != null) {
                FileOutputStream output = new FileOutputStream(inputFile.replaceFirst("[.][^.]+$", ".tbc"));
                DataOutputStream byteStream = new DataOutputStream(output);
                writeInstruction(byteStream, tasmListener.getInstructions(), tasmListener.getConstantPool());
            }
        }
        catch (java.io.IOException e) {
            System.out.println(e);
        }
    }
}