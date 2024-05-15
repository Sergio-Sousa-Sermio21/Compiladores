// Import necessary packages and classes
import Sol.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The solAssembler class provides functionality to assemble Sol programs
 * into bytecode.
 */
class solCompiler extends SolBaseVisitor {

    private static final String asmFlag = "-asm";

    /**
     * Writes instructions and constant pool to the given DataOutputStream.
     *
     * @param byteStream   The DataOutputStream to write to.
     * @param instructions The list of instructions to write.
     * @param constantPool The list of constants to write.
     * @throws IOException if an I/O error occurs while writing to the stream.
     */
    public static void writeInstructionByte(DataOutputStream byteStream, ArrayList<Instruction> instructions, ArrayList<Object> constantPool) throws IOException {
        // Write instructions to the stream
        for (Instruction instruction : instructions) {
            Integer[] i = instruction.getBytes();
            byteStream.write(i[0]);
            if (i.length > 1)
                byteStream.write(i[1]);
        }
        // Write constant pool to the stream
        byteStream.write(TokenTasm.CONSTANTPOOL.ordinal());
        for (int i = 0; i < constantPool.size(); i++) {
            Object data = constantPool.get(i);
            if (data instanceof Double) {
                byteStream.write(0);
                byteStream.writeDouble((double) data);
            } else {
                byteStream.write(1);
                String string = (String) data;
                byteStream.writeUTF(string.substring(1, string.length() - 1));
            }
        }
    }

    /**
     * Writes instructions to a BufferedWriter in the format suitable for TASM (Turbo Assembler).
     *
     * @param bw             The BufferedWriter to write instructions to.
     * @param instructions   An ArrayList of Instruction objects representing the instructions to be written.
     * @param constantPool   An ArrayList of objects containing constants referenced by instructions.
     * @throws IOException   If an I/O error occurs while writing to the BufferedWriter.
     */
    public static void writeInstructionTasm(BufferedWriter bw, ArrayList<Instruction> instructions, ArrayList<Object> constantPool) throws IOException {
        for (int i=0; i<instructions.size();i++){
            Instruction instruction = instructions.get(i);
            TokenTasm op = instruction.getOp();
            if(op==TokenTasm.SCONST||op==TokenTasm.DCONST)
                bw.write("i"+i+":"+op+" "+constantPool.get(instruction.getArgument()));
            else if (op==TokenTasm.JUMP||op==TokenTasm.JUMPT||op==TokenTasm.JUMPF) {
                bw.write("i"+i+":"+op+" i"+instruction.getArgument());
            } else if (instruction.getArgument()==null)
                bw.write("i"+i+":"+op);
            else
                bw.write("i"+i+":"+op+" "+instruction.getArgument());
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    /**
     * The main method for the solAssembler class.
     *
     * @param args command-line arguments
     * @throws Exception if an error occurs during execution
     */
    public static void main(String[] args) throws Exception {
        boolean asmMode = false;
        String inputFile = null;
        // Check if input file is provided
        List<String> argsL = Arrays.asList(args);
        if (args.length > 1 && argsL.contains(asmFlag)) {
            inputFile = args[0];
            asmMode = true;
        } else if (args.length > 0)
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
            if (parser.getNumberOfSyntaxErrors()>0)
                System.exit(1);
            SolVisitorTypeCheckFunction solVisitorTypeCheckFunction = new SolVisitorTypeCheckFunction();
            solVisitorTypeCheckFunction.visit(tree);
            SolVisitorTypeCheck solVisitorTypeCheck = new SolVisitorTypeCheck(solVisitorTypeCheckFunction.getTree(),solVisitorTypeCheckFunction.getErrors(),solVisitorTypeCheckFunction.getCallListed());
            solVisitorTypeCheck.visit(tree);
            if (!solVisitorTypeCheck.getErrors().isEmpty()) {
                System.out.println(solVisitorTypeCheck.getErrors());
                System.exit(1);
            }
            SolVisitor solVisitor = new SolVisitor(solVisitorTypeCheck.getTree());
            solVisitor.visit(tree);
            if (Debug.isDebugging()) {
                System.out.println("Instructions:");
                for (Instruction i : solVisitor.getInstructions())
                    if (i.getArgument() != null)
                        System.out.println(i.getOp() + ": " + i.getArgument());
                    else
                        System.out.println(i.getOp());
                System.out.println("\nConstant Pool:");
                System.out.println(solVisitor.getConstantPool());
            }
            if (asmMode) {
                ArrayList<Instruction> inst = solVisitor.getInstructions();
                ArrayList<Object> cp = solVisitor.getConstantPool();
                System.out.println("Constant Pool");
                for (int i = 0; i < cp.size(); i++)
                    System.out.println(i + ":" + cp.get(i));
                System.out.println("Instructions:");
                for (int i = 0; i < inst.size(); i++) {
                    System.out.println(i + ":" + inst.get(i));
                }
            }
            // If input file is provided, write to output file
            if (inputFile != null) {
                //Tbc file
                FileOutputStream output = new FileOutputStream(inputFile.replaceFirst("[.][^.]+$", ".tbc"));
                DataOutputStream byteStream = new DataOutputStream(output);
                writeInstructionByte(byteStream, solVisitor.getInstructions(), solVisitor.getConstantPool());

                //Tasm file
                FileWriter tasm = new FileWriter(inputFile.replaceFirst("[.][^.]+$", ".tasm"));
                BufferedWriter bw = new BufferedWriter(tasm);
                writeInstructionTasm(bw, solVisitor.getInstructions(), solVisitor.getConstantPool());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
