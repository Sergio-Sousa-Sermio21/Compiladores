import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class tVM {
    private final ArrayList<ObjectValue> globalMemory= new ArrayList<ObjectValue>();
    private final ArrayList<Object> constantPool = new ArrayList<Object>();
    private final ArrayList<Instruction> instructions = new ArrayList<Instruction>();
    private final Stack<ObjectValue> stack=new Stack<ObjectValue>();
    private int pc;
    private int fp = 0;

    public tVM(DataInputStream tbc) {
        addData(tbc);
        this.pc = 0;
    }

    /**
     * Converts Instructions bytes to actual instruction objects
     * @param tbc file
     */
    public void addInstructions(DataInputStream tbc) throws IOException {
        int cp = TokenTasm.CONSTANTPOOL.ordinal();
        while (tbc.available() > 0) {
            byte bs = tbc.readByte();
            if (bs == cp)
                break;
            TokenTasm instruction = TokenTasm.valueOf(bs);
            switch (instruction){
                case ICONST -> instructions.add(new Instruction(TokenTasm.ICONST,(int) tbc.readByte()));
                case DCONST -> instructions.add(new Instruction(TokenTasm.DCONST,(int) tbc.readByte()));
                case SCONST -> instructions.add(new Instruction(TokenTasm.SCONST, (int)tbc.readByte()));
                case JUMP -> instructions.add(new Instruction(TokenTasm.JUMP,(int) tbc.readByte()));
                case JUMPT -> instructions.add(new Instruction(TokenTasm.JUMPT,(int) tbc.readByte()));
                case JUMPF -> instructions.add(new Instruction(TokenTasm.JUMPF, (int)tbc.readByte()));
                case GALLOC -> instructions.add(new Instruction(TokenTasm.GALLOC,(int) tbc.readByte()));
                case GLOAD -> instructions.add(new Instruction(TokenTasm.GLOAD,(int) tbc.readByte()));
                case GSTORE -> instructions.add(new Instruction(TokenTasm.GSTORE, (int)tbc.readByte()));
                case LALLOC -> instructions.add(new Instruction(TokenTasm.LALLOC ,(int)tbc.readByte() ));
                case LLOAD -> instructions.add(new Instruction(TokenTasm.LLOAD,(int)tbc.readByte()));
                case LSTORE -> instructions.add(new Instruction(TokenTasm.LSTORE,(int)tbc.readByte()));
                case POP -> instructions.add(new Instruction(TokenTasm.POP,(int)tbc.readByte()));
                case CALL -> instructions.add(new Instruction(TokenTasm.CALL,(int)tbc.readByte()));
                case RET -> instructions.add(new Instruction(TokenTasm.RET,(int)tbc.readByte()));
                case RETVAL -> instructions.add(new Instruction(TokenTasm.RETVAL,(int)tbc.readByte()));
                default -> instructions.add(new Instruction(instruction, null));
            }
        }
    }

    /**
     * Converts constant pool data to objects in constantPool arrayList
     * @param tbc file
     */
    public void addConstantPool(DataInputStream tbc) throws IOException {
        while (tbc.available() > 0) {
            byte bs = tbc.readByte();
            if (bs == 0)
                constantPool.add(tbc.readDouble());
            else
                constantPool.add(tbc.readUTF());
        }
    }

    /**
     * Joins instructions and constant pool data conversion
     * @param tbc file
     */
    public void addData(DataInputStream tbc) {
        try {
            addInstructions(tbc);
            addConstantPool(tbc);
        } catch (IOException e) {
            System.out.println("Not a valid file\nDetails:" + e);
        }
    }

    private int Return(int pos){
        for(int j = 2; j < stack.size() - fp; j++)
            stack.pop();
        int n = instructions.get(pos).getArgument();
        pos = stack.pop().getInt(pos);
        fp = stack.pop().getInt(pos);
        for (int j = 0; j < n; j++)
            stack.pop();
        return pos;
    }

    /**
     * Execute the code in the file
     */
    public void execute() {
        for (int i = 0; i < instructions.size(); i++) {
            Instruction instruction = instructions.get(i);
            TokenTasm op = instruction.getOp();
            try {
                switch (op) {
                    case ICONST:
                        stack.push(new ObjectValue(instruction.getArgument()));
                        break;
                    case DCONST:
                        stack.push(new ObjectValue((Double) constantPool.get(instruction.getArgument())));
                        break;
                    case SCONST:
                        stack.push(new ObjectValue((String) constantPool.get(instruction.getArgument())));
                        break;
                    case TCONST:
                        stack.push(new ObjectValue(true));
                        break;
                    case FCONST:
                        stack.push(new ObjectValue(false));
                        break;
                    case IPRINT, DPRINT, SPRINT, BPRINT:
                        System.out.println(stack.pop());
                        break;
                    case IUMINUS:
                        stack.push(new ObjectValue(-stack.pop().getInt(i)));
                        break;
                    case DUMINUS:
                        stack.push(new ObjectValue(-stack.pop().getDouble(i)));
                        break;
                    case IADD:
                        stack.push(new ObjectValue(stack.pop().getInt(i) + stack.pop().getInt(i)));
                        break;
                    case DADD:
                        stack.push(new ObjectValue(stack.pop().getDouble(i) + stack.pop().getDouble(i)));
                        break;
                    case ISUB:
                        int isubr = stack.pop().getInt(i);
                        int isubl = stack.pop().getInt(i);
                        stack.push(new ObjectValue(isubl - isubr));
                        break;
                    case DSUB:
                        double dsubr = stack.pop().getDouble(i);
                        double dsubl = stack.pop().getDouble(i);
                        stack.push(new ObjectValue(dsubl - dsubr));
                        break;
                    case IMULT:
                        stack.push(new ObjectValue(stack.pop().getInt(i) * stack.pop().getInt(i)));
                        break;
                    case DMULT:
                        stack.push(new ObjectValue(stack.pop().getDouble(i) * stack.pop().getDouble(i)));
                        break;
                    case IDIV:
                        int idivr = stack.pop().getInt(i);
                        if (idivr==0)
                            throw new IllegalArgumentException("Cannot divide by 0 in line: " +(i+1));
                        int idivl= stack.pop().getInt(i);
                        stack.push(new ObjectValue(idivl / idivr));
                        break;
                    case DDIV:
                        double ddivr = stack.pop().getDouble(i);
                        if (ddivr==0)
                            throw new IllegalArgumentException("Cannot divide by 0 in line: " +(i+1));
                        double ddivl = stack.pop().getDouble(i);
                        stack.push(new ObjectValue(ddivl / ddivr));
                        break;
                    case IMOD:
                        int mod = stack.pop().getInt(i);
                        int num = stack.pop().getInt(i);
                        stack.push(new ObjectValue(num % mod));
                        break;
                    case IEQ:
                        stack.push(new ObjectValue(stack.pop().getInt(i) == stack.pop().getInt(i)));
                        break;
                    case DEQ:
                        stack.push(new ObjectValue(stack.pop().getDouble(i) == stack.pop().getDouble(i)));
                        break;
                    case INEQ:
                        int ineqr = stack.pop().getInt(i);
                        int ineql = stack.pop().getInt(i);
                        stack.push(new ObjectValue(ineql != ineqr));
                        break;
                    case DNEQ:
                        double dneqr = stack.pop().getDouble(i);
                        double dneql = stack.pop().getDouble(i);
                        stack.push(new ObjectValue(dneql != dneqr));
                        break;
                    case ILT:
                        int iltr = stack.pop().getInt(i);
                        int iltl = stack.pop().getInt(i);
                        stack.push(new ObjectValue(iltl < iltr));
                        break;
                    case ILEQ:
                        int ileqr = stack.pop().getInt(i);
                        int ileql = stack.pop().getInt(i);
                        stack.push(new ObjectValue(ileql <= ileqr));
                        break;
                    case DLEQ:
                        double dleqr = stack.pop().getDouble(i);
                        double dleql = stack.pop().getDouble(i);
                        stack.push(new ObjectValue(dleql <= dleqr));
                        break;
                    case DLT:
                        double dltr = stack.pop().getDouble(i);
                        double dltl = stack.pop().getDouble(i);
                        stack.push(new ObjectValue(dltl < dltr));
                        break;
                    case ITOD:
                        stack.push(new ObjectValue((double)stack.pop().getInt(i)));
                        break;
                    case DTOS:
                        stack.push(new ObjectValue(String.valueOf(stack.pop().getDouble(i))));
                        break;
                    case ITOS:
                        stack.push(new ObjectValue(String.valueOf(stack.pop().getInt(i))));
                        break;
                    case SADD:
                        String right = stack.pop().getString(i);
                        stack.push(new ObjectValue(stack.pop().getString(i) + right));
                        break;
                    case SEQ:
                        stack.push(new ObjectValue((stack.pop().getString(i)).equals(stack.pop().getString(i))));
                        break;
                    case SNEQ:
                        stack.push(new ObjectValue(!(stack.pop()).getString(i).equals(stack.pop().getString(i))));
                        break;
                    case BEQ:
                        stack.push(new ObjectValue(stack.pop().getBool(i) == stack.pop().getBool(i)));
                        break;
                    case BNEQ:
                        stack.push(new ObjectValue(stack.pop().getBool(i) != stack.pop().getBool(i)));
                        break;
                    case AND:
                        stack.push(new ObjectValue(stack.pop().getBool(i) && stack.pop().getBool(i)));
                        break;
                    case OR:
                        stack.push(new ObjectValue(stack.pop().getBool(i) || stack.pop().getBool(i)));
                        break;
                    case NOT:
                        stack.push(new ObjectValue(!stack.pop().getBool(i)));
                        break;
                    case BTOS:
                        stack.push(new ObjectValue(String.valueOf(stack.pop().getBool(i))));
                        break;
                    //It indicates the line in the tasm file so its -2 (for the next loop iteration and arrayList access)
                    case JUMP:
                        i = instruction.getArgument()-1;
                        break;
                    case JUMPT:
                        if (stack.pop().getBool(i))
                            i = instruction.getArgument()-1;
                        break;
                    case JUMPF:
                        if (!stack.pop().getBool(i))
                            i = instruction.getArgument()-1;
                        break;
                    case GALLOC:
                        for (int j = 0; j < instruction.getArgument(); j++)
                            globalMemory.add(new ObjectValue("NIL"));
                        break;
                    case GLOAD:
                        Integer indexLoad = instruction.getArgument();
                        if (globalMemory.size()<indexLoad)
                            throw new IllegalArgumentException("Cannot access global memory in index "+indexLoad+" at line "+
                                    i+" instruction " + op);
                        stack.push(globalMemory.get(indexLoad));
                        break;
                    case GSTORE:
                        Integer indexStore = instruction.getArgument();
                        if (globalMemory.size()<indexStore)
                            throw new IllegalArgumentException("Cannot access global memory in index "+indexStore+" at line "+
                                    i+" instruction " + op);
                        globalMemory.set(indexStore, new ObjectValue(stack.pop().getInt(i)));
                        break;
                    case HALT:
                        System.out.println("Finished execution");
                        System.exit(0);
                        return;
                    case LALLOC:
                        int pos = instructions.get(i).getArgument();
                        int temp = stack.size();
                        while (stack.size() < temp + pos) {
                            stack.push(new ObjectValue("NIL"));
                        }
                        break;
                    case LLOAD:
                        stack.push(stack.elementAt(instructions.get(i).getArgument() + fp));
                        break;
                    case LSTORE:
                        stack.set(instructions.get(i).getArgument() + fp, stack.pop());
                        break;
                    case POP:
                        for(int j = 0; j < instructions.get(i).getArgument(); j++)
                            stack.pop();
                        break;
                    case CALL:
                        stack.push(new ObjectValue(fp));
                        fp= stack.size()-1;
                        if(i+1>= instructions.size())
                            throw new IllegalArgumentException("Illegal argument in index " + i);
                        stack.push(new ObjectValue(i));
                        i = instructions.get(i).getArgument()-1;
                        break;
                    case RETVAL:
                        ObjectValue result = stack.pop();
                        i = Return(i);
                        stack.push(result);
                        break;
                    case RET:
                        i = Return(i);
                        break;

                    default:
                        throw new IllegalArgumentException("Invalid reference to operation: " + op);
                }
            }catch (IllegalArgumentException e){
                System.out.println("Was not able to execute:\n"+e.getMessage());
                System.exit(1);
            }catch (EmptyStackException e){
                System.out.println("Was not able to execute (empty stack) in line "+i+" at operation: " +op);
                System.exit(1);
            } catch (OutOfMemoryError e){
                System.out.println("Was not able to execute:\nInfinite loop found, fix label positions and jump calls.");
                System.exit(1);
            }
        }
        System.out.println("No halt detected, exiting...");
        System.exit(1);
    }


    public static void main(String[] args) {
        String inputFile = null;
        // Check if input file is provided
        if (args.length > 0) inputFile = args[0];
        InputStream is = System.in;
        try {
            // If input file is provided, read from file; otherwise, read from standard input
            if (inputFile != null) is = new FileInputStream(inputFile);
            DataInputStream tbc = new DataInputStream(is);
            tVM vm = new tVM(tbc);
            if (Debug.isDebugging()){
                System.out.println("Instructions:");
                for (Instruction i : vm.instructions)
                    System.out.println(i.getOp()+": "+ i.getArgument());
                System.out.println("\nConstant Pool:");
                System.out.println(vm.constantPool);
            }
            vm.execute();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

