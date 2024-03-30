import Tasm.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class tAssembler extends TasmBaseListener{

    public void writeInstruction(DataOutputStream byteStream, ArrayList<Instruction> instructions, HashMap<Integer, String> constantPool) throws IOException {
        for (Instruction instruction : instructions) {
            byteStream.write(instruction.getBytes());
        }
        for (Map.Entry<Integer,String> data : constantPool.entrySet()){
            String value = data.getValue();
            Integer key = data.getKey();
            byte[] bytes = value.getBytes(StandardCharsets.UTF_8);

            // Convert double to bytes (assuming 8 bytes for double)
            // Example conversion using ByteBuffer
            // If the value stored is a double, you need to handle it differently
            if (constantValue instanceof Double) {
                double doubleValue = Double.parseDouble(constantValue);
                ByteBuffer buffer = ByteBuffer.allocate(Double.BYTES);
                buffer.putDouble(doubleValue);
                bytes = buffer.array();
            }
        }
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
            System.out.println("visitor result = " + result);
        }
        catch (java.io.IOException e) {
            System.out.println(e);
        }
    }
}