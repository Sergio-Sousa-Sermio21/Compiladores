// Import necessary packages and classes
import Tasm.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Define the class tAssembler
class tAssembler extends TasmBaseListener{

    /**
     * Writes instructions and constant pool to the given DataOutputStream.
     * @param byteStream The DataOutputStream to write to.
     * @param instructions The list of instructions to write.
     * @param constantPool The list of constants to write.
     * @throws IOException if an I/O error occurs while writing to the stream.
     */
    public static void writeInstruction(DataOutputStream byteStream, ArrayList<Instruction> instructions, ArrayList<Object> constantPool) throws IOException {
        // Write instructions to the stream
        for (Instruction instruction : instructions) {
            byteStream.write(instruction.getBytes());
        }
        // Write constant pool to the stream
        for (int i = 0; i<constantPool.size(); i++){
            Object data = constantPool.get(i);
            if (data instanceof Double) {
                byteStream.write(0);
                byteStream.writeDouble((double)data);
            } else {
                byteStream.write(1);
                String string = (String) data;
                byte[] bytes =string.substring(1,string.length()-1).getBytes(StandardCharsets.UTF_8);
                byteStream.writeInt(string.length());
                byteStream.write(bytes);
            }
        }
    }

    /**
     * Performs semantic checks, such as ensuring the presence of a HALT instruction and linking jump instructions to labels.
     * @param tasmListener The TasmListener instance to perform semantic checks on.
     */
    public static void testeSemantico(TasmListener tasmListener){
        hasHalt(tasmListener);
        tasmListener.labelLink();
    }

    /**
     * Checks if the instructions contain a HALT instruction.
     * @param tasmListener The TasmListener instance to check.
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

    // Main method
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        // Check if input file is provided
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        try {
            // If input file is provided, read from file; otherwise, read from standard input
            if (inputFile != null) is = new FileInputStream(inputFile);
            CharStream input = CharStreams.fromStream(is);
            TasmLexer lexer = new TasmLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TasmParser parser = new TasmParser(tokens);
            ParseTree tree = parser.executable();
            ParseTreeWalker walker = new ParseTreeWalker();
            TasmListener tasmListener = new TasmListener();
            walker.walk(tasmListener,tree);
            // Perform semantic checks
            testeSemantico(tasmListener);
            // If input file is provided, write to output file
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
