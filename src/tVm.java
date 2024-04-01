import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class tVm {
    // Memória global para armazenamento de dados
    private Object[] globalMemory;
    private ArrayList<Object> constantPool = new ArrayList<>();
    private HashMap<Integer, Commands> commands = new HashMap<>();
    // Lista de instruções a serem executadas
    private ArrayList<Instrucion> instrucions = new ArrayList<>();

    private Stack<Object> stack = new Stack<>();
    // Construtor da máquina virtual
    public tVm(String[] args) throws IOException{
        initHash();
        getFiles(args);

    }
    // Inicialização do mapeamento de códigos de operação para instruções
    private void initHash(){
        for(Commands c : Commands.values()){
            commands.put(c.ordinal(), c);
        }
    }
    // Leitura do arquivo binário de instruções
    private void getFiles(String[] args)throws IOException {
        DataInputStream din = new DataInputStream(new FileInputStream(args[0]));
        while(din.available()>0){
            byte bytes = din.readByte();
            if(bytes != Commands.CONSTANTPOOL.ordinal()){
                if(commands.get((int) bytes) == Commands.ICONST){
                    instrucions.add(new Instrucion(Commands.ICONST,din.readInt()));
                } else if(commands.get((int) bytes) == Commands.JUMP)
                    instrucions.add(new Instrucion(Commands.JUMP,din.readInt()));
                else if(commands.get((int) bytes) == Commands.JUMPF)
                    instrucions.add(new Instrucion(Commands.JUMPF,din.readInt()));
                else if(commands.get((int) bytes) == Commands.JUMPT)
                    instrucions.add(new Instrucion(Commands.JUMPT,din.readInt()));
                else if(commands.get((int) bytes) == Commands.GALLOC)
                    instrucions.add(new Instrucion(Commands.GALLOC,din.readInt()));
                else if(commands.get((int) bytes) == Commands.GLOAD)
                    instrucions.add(new Instrucion(Commands.GLOAD,din.readInt()));
                else if(commands.get((int) bytes) == Commands.GSTORE)
                    instrucions.add(new Instrucion(Commands.GSTORE,din.readInt()));
                else if(commands.get((int) bytes) == Commands.DCONST)
                    instrucions.add(new Instrucion(Commands.DCONST,din.readInt()));
                else if(commands.get((int) bytes) == Commands.SCONST)
                    instrucions.add(new Instrucion(Commands.SCONST,din.readInt()));
                else
                    instrucions.add(new Instrucion(commands.get((int) bytes)));
            } else {
                break;
            }
        }
        addconstantpool(din);
    }
    // Adição de constantes ao pool de constantes?????
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
    // Execução das instruções na memória de código
    public void runCodeMemory(){
        int i = 0;
        while(i<instrucions.size()) {
            //System.out.println(instrucions.get(i) + " " + i);
            //System.out.println(stack);
            switch (instrucions.get(i).getCommand()) {
                case ICONST -> {
                    stack.push(instrucions.get(i).getValue());
                }
                case IPRINT -> {
                    System.out.println(stack.pop());
                }
                case IUMINUS ->{
                    stack.push(-(int)stack.pop());
                }
                case IADD ->{
                    stack.push((int) stack.pop() + (int) stack.pop());
                }
                case ISUB ->{
                    int b = (int) stack.pop();
                    int a = (int) stack.pop();
                    stack.push(a-b);
                }
                case IMULT ->{
                    int b = (int) stack.pop();
                    int a = (int) stack.pop();
                    stack.push(a*b);
                }
                case IDIV ->{
                    int b = (int) stack.pop();
                    int a = (int) stack.pop();
                    stack.push(a/b);
                }
                case IMOD ->{
                    int b = (int) stack.pop();
                    int a = (int) stack.pop();
                    stack.push(a%b);
                }
                case IEQ ->{
                    int b = (int) stack.pop();
                    int a = (int) stack.pop();
                    stack.push(a==b);
                }
                case INEQ ->{
                    int b = (int) stack.pop();
                    int a = (int) stack.pop();
                    stack.push(a!=b);
                }
                case ILT ->{
                    int b = (int) stack.pop();
                    int a = (int) stack.pop();
                    stack.push(a<b);
                }
                case ILEQ ->{
                    int b = (int) stack.pop();
                    int a = (int) stack.pop();
                    stack.push(a<=b);
                }
                case ITOD ->{
                    double a = (double) stack.pop();
                    stack.push(a);
                }
                case ITOS ->{
                    int a = (int) stack.pop();
                    stack.push(Integer.toString(a));
                }
                case DCONST ->{
                    stack.push(constantPool.get((int) instrucions.get(i).getValue()));
                }
                case DPRINT ->{
                    System.out.println(stack.pop());
                }
                case DUMINUS ->{
                    stack.push(-(double)stack.pop());
                }
                case DADD ->{
                    double b = (double) stack.pop();
                    double a = (double) stack.pop();
                    stack.push(a+b);
                }
                case DSUB ->{
                    double b = (double) stack.pop();
                    double a = (double) stack.pop();
                    stack.push(a-b);
                }
                case DMULT ->{
                    double b = (double) stack.pop();
                    double a = (double) stack.pop();
                    stack.push(a*b);
                }
                case DDIV ->{
                    double b = (double) stack.pop();
                    double a = (double) stack.pop();
                    stack.push(a/b);
                }
                case DEQ ->{
                    double b = (double) stack.pop();
                    double a = (double) stack.pop();
                    stack.push(a==b);
                }
                case DNEQ ->{
                    double b = (double) stack.pop();
                    double a = (double) stack.pop();
                    stack.push(a!=b);
                }
                case DLT ->{
                    double b = (double) stack.pop();
                    double a = (double) stack.pop();
                    stack.push(a<b);
                }
                case DLEQ ->{
                    double b = (double) stack.pop();
                    double a = (double) stack.pop();
                    stack.push(a<=b);
                }
                case DTOS ->{
                    double a = (double) stack.pop();
                    stack.push(Double.toString(a));
                }
                case SCONST ->{
                    stack.push(constantPool.get((int) instrucions.get(i).getValue()));
                }
                case SPRINT ->{
                    System.out.println(stack.pop());
                }
                case SADD ->{
                    String b = (String) stack.pop();
                    String a = (String) stack.pop();
                    stack.push(a+b);
                }
                case SEQ ->{
                    String b = (String) stack.pop();
                    String a = (String) stack.pop();
                    stack.push(a.equals(b));
                } 
                case SNEQ ->{
                    String b = (String) stack.pop();
                    String a = (String) stack.pop();
                    stack.push(!a.equals(b));
                }
                case TCONST ->{
                    stack.push(true);
                }
                case FCONST ->{
                    stack.push(false);
                }
                case BPRINT ->{
                    System.out.println(stack.pop());
                }
                case BEQ ->{
                    boolean b = (boolean) stack.pop();
                    boolean a = (boolean) stack.pop();
                    stack.push(a==b);
                }
                case BNEQ ->{
                    boolean b = (boolean) stack.pop();
                    boolean a = (boolean) stack.pop();
                    stack.push(a!=b);
                }
                case AND ->{
                    boolean b = (boolean) stack.pop();
                    boolean a = (boolean) stack.pop();
                    stack.push(a && b);
                }
                case OR ->{
                    boolean b = (boolean) stack.pop();
                    boolean a = (boolean) stack.pop();
                    stack.push(a || b);
                }
                case NOT ->{
                    boolean a = (boolean) stack.pop();
                    stack.push(!a);
                }
                case BTOS ->{
                    boolean a = (boolean) stack.pop();
                    stack.push(Boolean.toString(a));
                }
                case JUMP ->{
                    i = (int) instrucions.get(i).getValue()-1;
                }
                case JUMPT ->{
                    if((boolean) stack.pop())
                        i = (int) instrucions.get(i).getValue()-1;
                }
                case JUMPF ->{
                    if(!(boolean) stack.pop())
                        i = (int) instrucions.get(i).getValue()-1;
                }
                case GALLOC ->{
                    int size = (int) instrucions.get(i).getValue();
                    globalMemory = new Object[size];
                }
                case GLOAD ->{
                    int posicon = (int) instrucions.get(i).getValue();
                    stack.push(globalMemory[posicon]);
                }
                case GSTORE ->{
                    int position = (int) instrucions.get(i).getValue();
                    globalMemory[position] = stack.pop();
                }
                case HALT ->{
                    System.exit(0);
                }
                default -> System.out.println("Unknown command");
            }
            i++;
        }
    }

    public static void main(String[] args) throws IOException {
        tVm Vm = new tVm(args);
        Vm.runCodeMemory();
    }
}
