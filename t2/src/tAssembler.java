// Import necessary packages and classes
import Sol.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Define the class tAssembler
class tAssembler extends SolBaseVisitor{

    private static final String asmFlag = "-asm";

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
            Integer[] i = instruction.getBytes();
            byteStream.write(i[0]);
            if (i.length>1)
                byteStream.write(i[1]);
        }
        // Write constant pool to the stream
        byteStream.write(TokenTasm.CONSTANTPOOL.ordinal());
        for (int i = 0; i<constantPool.size(); i++){
            Object data = constantPool.get(i);
            if (data instanceof Double) {
                byteStream.write(0);
                byteStream.writeDouble((double)data);
            } else {
                byteStream.write(1);
                String string = (String) data;
                byteStream.writeUTF(string.substring(1,string.length()-1));
            }
        }
    }

    // Main method
    public static void main(String[] args) throws Exception {
        boolean asmMode = false;
        String inputFile = null;
        // Check if input file is provided
        List<String> argsL = Arrays.asList(args);
        if ( args.length>1 && argsL.contains(asmFlag)) {
            inputFile = args[0];
            asmMode = true;
        }else if( args.length>0 )
            inputFile = args[0];

        InputStream is = System.in;
        try {
            // If input file is provided, read from file; otherwise, read from standard input
            if (inputFile != null) is = new FileInputStream(inputFile);
            CharStream input = CharStreams.fromStream(is);
            SolLexer lexer = new SolLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SolParser parser = new SolParser(tokens);
            ParseTree tree = parser.executable();
            SolVisitorTypeCheck solVisitorTypeCheck = new SolVisitorTypeCheck();
            SolVisitor solVisitor = new SolVisitor(solVisitorTypeCheck.getTree());
            if (Debug.isDebugging()) {
                System.out.println("Instructions:");
                for (Instruction i : solVisitor.getInstructions())
                    System.out.println(i.getOp() + ": " + i.getArgument());
                System.out.println("\nConstant Pool:");
                System.out.println(solVisitor.getConstantPool());
            }
            if (!solVisitorTypeCheck.getErrors().isEmpty()){
                System.out.println(solVisitorTypeCheck.getErrors());
                System.exit(1);
            }
            if (asmMode){
                ArrayList<Instruction> inst = solVisitor.getInstructions();
                ArrayList<Object> cp = solVisitor.getConstantPool();
                System.out.println("Constant Pool");
                for (int i = 0; i<cp.size(); i++)
                    System.out.println(i+":"+cp.get(i));
                System.out.println("Instructions:");
                for (int i = 0; i < inst.size(); i++) {
                    System.out.println(i+":"+inst.get(i));
                }
            }
            // If input file is provided, write to output file
            if (inputFile != null) {
                FileOutputStream output = new FileOutputStream(inputFile.replaceFirst("[.][^.]+$", ".tbc"));
                DataOutputStream byteStream = new DataOutputStream(output);
                writeInstruction(byteStream, solVisitor.getInstructions(), solVisitor.getConstantPool());
            }
        }
        catch (java.io.IOException e) {
            System.out.println(e);
        }
    }
}
