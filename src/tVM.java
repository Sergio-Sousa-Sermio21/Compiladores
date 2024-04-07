import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class tVM {

    private final ArrayList<Value> globalMemory = new ArrayList<>(0);
    private final ArrayList<Object> constantPool = new ArrayList<>();
    private final HashMap<Integer, Commands> commands = new HashMap<>();
    private final ArrayList<Instrucion> instructions = new ArrayList<>();

    private final Stack<Value> stack = new Stack<>();
    public tVM(String[] args) throws IOException{
        initHash();
        getFiles(args);

    }

    private void initHash(){
        for(Commands c : Commands.values()){
            commands.put(c.ordinal(), c);
        }
    }

    /** Obtem instrucoes e constantes do arquivo bytecode especificado.
     *
     * @param args Argumentos passados para o metodo, esperando pelo bytecode.
     * @throws IOException Se ocorrer um erro de E/S durante a leitura do arquivo bytecode
     */
    private void getFiles(String[] args)throws IOException {
        DataInputStream din = new DataInputStream(new FileInputStream(args[0]));
        while(din.available()>0){
            byte bytes = din.readByte();
            if (bytes != Commands.CONSTANTPOOL.ordinal()) {
                switch (commands.get((int) bytes)) {
                    case ICONST -> instructions.add(new Instrucion(Commands.ICONST, din.readInt()));

                    case JUMP -> instructions.add(new Instrucion(Commands.JUMP, din.readInt()));

                    case JUMPF -> instructions.add(new Instrucion(Commands.JUMPF, din.readInt()));

                    case JUMPT -> instructions.add(new Instrucion(Commands.JUMPT, din.readInt()));

                    case GALLOC -> instructions.add(new Instrucion(Commands.GALLOC, din.readInt()));

                    case GLOAD -> instructions.add(new Instrucion(Commands.GLOAD, din.readInt()));

                    case GSTORE -> instructions.add(new Instrucion(Commands.GSTORE, din.readInt()));

                    case DCONST -> instructions.add(new Instrucion(Commands.DCONST, din.readInt()));

                    case SCONST -> instructions.add(new Instrucion(Commands.SCONST, din.readInt()));

                    default -> instructions.add(new Instrucion(commands.get((int) bytes)));

                }
            } else {
                break;
            }

        }
        addconstantpool(din);
    }

    /** Facilita a organizcao dos bytes
     *
     * @param din  O fluxo de entrada de dados que contém as constantes a serem adicionadas.
     * @throws IOException Se ocorrer um erro de E/S durante a leitura do fluxo de entrada de dados.
     */
    private void addconstantpool(DataInputStream din) throws IOException{
        while(din.available()>0) {
            byte bytes = din.readByte();
            if(bytes == 0){
                constantPool.add(din.readDouble());
            } else if(bytes == 1){
                int size = din.readInt();
                char[] word = new char[size];
                for(int i = 0; i<size; i++)
                    word[i] = din.readChar();
                constantPool.add(new String(word));
            }
        }
    }

    private void printStatus(int i){
        System.out.print(i + ": " + instructions.get(i) + "\t");
        System.out.println("Stack " + stack);
        System.out.print("Global Memory [");
        for (int j = 0; j < globalMemory.size(); j++) {
            System.out.print(globalMemory.get(j));
            if(globalMemory.size() >1 && j<globalMemory.size()-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }


    /**Executa o código no array de instrucoes de instruções.
     *
     */
    public void runCodeMemory(boolean debug){
        int i = 0;
        try {
            while (i < instructions.size()) {
                if(debug)
                    printStatus(i);
                switch (instructions.get(i).getCommand()) {

                    //Parte dos ints
                    case ICONST -> stack.push(new Value(instructions.get(i).getValue()));
                    case IPRINT -> System.out.println(stack.pop().getValueInt());
                    case IUMINUS -> stack.push(new Value(-stack.pop().getValueInt()));
                    case IADD -> stack.push(new Value(stack.pop().getValueInt() + stack.pop().getValueInt()));
                    case ISUB -> stack.push(new Value(-stack.pop().getValueInt() + stack.pop().getValueInt()));
                    case IMULT -> stack.push(new Value(stack.pop().getValueInt() * stack.pop().getValueInt()));

                    case IDIV -> {
                        int b = stack.pop().getValueInt();
                        if(b==0)
                            Error.trowError("Can not divide by zero in line: " + i + " Commands: " + instructions.get(i).getCommand());
                        int a = stack.pop().getValueInt();
                        stack.push(new Value(a / b));
                    }
                    case IMOD -> {
                        int b = stack.pop().getValueInt();
                        int a = stack.pop().getValueInt();
                        stack.push(new Value(a % b));
                    }
                    case IEQ -> {
                        int b = stack.pop().getValueInt();
                        int a = stack.pop().getValueInt();
                        stack.push(new Value(a == b));
                    }
                    case INEQ -> {
                        int b = stack.pop().getValueInt();
                        int a = stack.pop().getValueInt();
                        stack.push(new Value(a != b));
                    }
                    case ILT -> {
                        int b = stack.pop().getValueInt();
                        int a = stack.pop().getValueInt();
                        stack.push(new Value(a < b));
                    }
                    case ILEQ -> {
                        int b = stack.pop().getValueInt();
                        int a = stack.pop().getValueInt();
                        stack.push(new Value(a <= b));
                    }
                    case ITOD -> {
                        double a = (double) stack.pop().getValueInt();
                        stack.push(new Value(a));
                    }
                    case ITOS -> {
                        int a = stack.pop().getValueInt();
                        stack.push(new Value(Integer.toString(a)));
                    }
                    //Parte dos doubles
                    case DCONST -> stack.push(new Value((double) constantPool.get(instructions.get(i).getValue())));
                    case DPRINT -> System.out.println(stack.pop().getValueDouble());
                    case DUMINUS -> stack.push(new Value(-stack.pop().getValueDouble()));

                    case DADD -> {
                        double b = stack.pop().getValueDouble();
                        double a = stack.pop().getValueDouble();
                        stack.push(new Value(a + b));
                    }
                    case DSUB -> {
                        double b = stack.pop().getValueDouble();
                        double a = stack.pop().getValueDouble();
                        stack.push(new Value(a - b));
                    }
                    case DMULT -> {
                        double b = stack.pop().getValueDouble();
                        double a = stack.pop().getValueDouble();
                        stack.push(new Value(a * b));
                    }
                    case DDIV -> {
                        double b = stack.pop().getValueDouble();
                        if(b==0)
                            Error.trowError("Can not divide by zero in line: " + i + " Commands: " + instructions.get(i).getCommand());
                        double a = stack.pop().getValueDouble();
                        stack.push(new Value(a / b));
                    }
                    case DEQ -> {
                        double b = stack.pop().getValueDouble();
                        double a = stack.pop().getValueDouble();
                        stack.push(new Value(a == b));
                    }
                    case DNEQ -> {
                        double b = stack.pop().getValueDouble();
                        double a = stack.pop().getValueDouble();
                        stack.push(new Value(a != b));
                    }
                    case DLT -> {
                        double b = stack.pop().getValueDouble();
                        double a = stack.pop().getValueDouble();
                        stack.push(new Value(a < b));
                    }
                    case DLEQ -> {
                        double b = stack.pop().getValueDouble();
                        double a = stack.pop().getValueDouble();
                        stack.push(new Value(a <= b));
                    }
                    case DTOS -> {
                        double a = stack.pop().getValueDouble();
                        stack.push(new Value(Double.toString(a)));
                    }
                    case SCONST -> stack.push(new Value((String) constantPool.get(instructions.get(i).getValue())));
                    case SPRINT -> System.out.println(stack.pop().getValueString());

                    case SADD -> {
                        String b = stack.pop().getValueString();
                        String a = stack.pop().getValueString();
                        stack.push(new Value(a + b));
                    }
                    case SEQ -> {
                        String b = stack.pop().getValueString();
                        String a = stack.pop().getValueString();
                        stack.push(new Value(a.equals(b)));
                    }
                    case SNEQ -> {
                        String b = stack.pop().getValueString();
                        String a = stack.pop().getValueString();
                        stack.push(new Value(!a.equals(b)));
                    }
                    //Comandos dos boolean
                    case TCONST -> stack.push(new Value(true));
                    case FCONST -> stack.push(new Value(false));
                    case BPRINT -> System.out.println(stack.pop().getValueBoolean());

                    case BEQ -> {
                        boolean b = stack.pop().getValueBoolean();
                        boolean a = stack.pop().getValueBoolean();
                        stack.push(new Value(a == b));
                    }
                    case BNEQ -> {
                        boolean b = stack.pop().getValueBoolean();
                        boolean a = stack.pop().getValueBoolean();
                        stack.push(new Value(a != b));
                    }
                    case AND -> {
                        boolean b = stack.pop().getValueBoolean();
                        boolean a = stack.pop().getValueBoolean();
                        stack.push(new Value(a && b));
                    }
                    case OR -> {
                        boolean b = stack.pop().getValueBoolean();
                        boolean a = stack.pop().getValueBoolean();
                        stack.push(new Value(a || b));
                    }
                    case NOT -> {
                        boolean a = stack.pop().getValueBoolean();
                        stack.push(new Value(!a));
                    }
                    case BTOS -> {
                        boolean a = stack.pop().getValueBoolean();
                        stack.push(new Value(Boolean.toString(a)));
                    }
                    case JUMP -> i = instructions.get(i).getValue() - 1;

                    case JUMPT -> {
                        if (stack.pop().getValueBoolean())
                            i = instructions.get(i).getValue() - 1;
                    }
                    case JUMPF -> {
                        if (!(boolean) stack.pop().getValueBoolean())
                            i = instructions.get(i).getValue() - 1;
                    }
                    case GALLOC -> {
                        int size = instructions.get(i).getValue();
                        globalMemory.ensureCapacity(size + globalMemory.size());
                        int oldSize = globalMemory.size();
                        while (globalMemory.size() < size+oldSize) {
                            globalMemory.add(new Value());
                        }
                    }
                    case GLOAD -> {
                        int position = instructions.get(i).getValue();
                        if(position>= globalMemory.size() || position<0)
                            Error.trowError("Index out of bound " + position + " for size: " + globalMemory.size());
                        if(globalMemory.get(position).isNULL())
                            Error.trowError("The value you're trying to access in line: " + i +" and Command: " + instructions.get(i).getCommand() + " is NIL");
                        stack.push(globalMemory.get(position));
                    }
                    case GSTORE -> {
                        int position = instructions.get(i).getValue();
                        if(position>= globalMemory.size() || position<0)
                            Error.trowError("Index out of bound" + position + "for size: " + globalMemory.size());
                        globalMemory.set(position, stack.pop());
                    }

                    case HALT -> System.exit(0);
                    default -> System.err.println("Unknown command");
                }
                i++;
            }
        }catch (Exception e){
            Error.BuildError(e, instructions.get(i), i);
        }
        Error.trowError("No Halt found!");
    }
    public static void main(String[] args) throws Exception {
        tVM Vm = new tVM(args);
        boolean debug = false;
        List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
        for (String arg : inputArguments) {
            if (arg.contains("jdwp") || arg.contains("Xdebug")) {
                debug = true;
                break;
            }
        }
        Vm.runCodeMemory(debug);
    }
}
