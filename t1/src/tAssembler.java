import Tasm.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

class tAssembler extends TasmBaseListener{

    public void writeInstruction(DataOutputStream byteStream, ArrayList<Instruction> instructions) throws IOException {
        for (Instruction instruction : instructions) {
            byteStream.write(instruction.getBytes());
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