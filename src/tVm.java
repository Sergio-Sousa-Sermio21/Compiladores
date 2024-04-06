import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class tVm {

    private ArrayList<Value> globalMemory;
    private ArrayList<Object> constantPool = new ArrayList<>();
    private HashMap<Integer, Commands> commands = new HashMap<>();
    private ArrayList<Instrucion> instrucions = new ArrayList<>();

    private Stack<Value> stack = new Stack<>();
    public tVm(String[] args) throws IOException{
        initHash();
        getFiles(args);

    }

    private void initHash(){
        for(Commands c : Commands.values()){
            commands.put(c.ordinal(), c);
        }
    }

    /** Obtém instruções e constantes do arquivo bytecode especificado.
     *
     * @param args Argumentos passados para o método, esperando pelo bytecode.
     * @throws IOException Se ocorrer um erro de E/S durante a leitura do arquivo bytecode
     */
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

    /**Executa o código no array de instrucoes de instruções.
     *
     * @throws Exception Se nenhum comando de parada (HALT) for encontrado durante a execução do código.
     */
    public void runCodeMemory() throws Exception {
        int i = 0;
        while(i<instrucions.size()) {
            switch (instrucions.get(i).getCommand()) {
                case ICONST -> {
                    stack.push(new Value(instrucions.get(i).getValue()));
                }
                case IPRINT -> {
                    System.out.println(stack.pop().getValueInt());
                }
                case IUMINUS ->{
                    stack.push(new Value(-stack.pop().getValueInt()));
                }
                case IADD ->{
                    stack.push(new Value(stack.pop().getValueInt() + stack.pop().getValueInt()));
                }
                case ISUB ->{
                    stack.push(new Value(-stack.pop().getValueInt() + stack.pop().getValueInt()));
                }
                case IMULT ->{
                    stack.push(new Value(stack.pop().getValueInt() * stack.pop().getValueInt()));
                }
                case IDIV ->{
                    int b = stack.pop().getValueInt() ;
                    int a = stack.pop().getValueInt() ;
                    stack.push(new Value(a/b));
                }
                case IMOD ->{
                    int b = stack.pop().getValueInt() ;
                    int a = stack.pop().getValueInt() ;
                    stack.push(new Value(a%b));
                }
                case IEQ ->{
                    int b = stack.pop().getValueInt() ;
                    int a = stack.pop().getValueInt() ;
                    stack.push(new Value(a==b));
                }
                case INEQ ->{
                    int b = stack.pop().getValueInt() ;
                    int a = stack.pop().getValueInt() ;
                    stack.push(new Value(a!=b));
                }
                case ILT ->{
                    int b = stack.pop().getValueInt() ;
                    int a = stack.pop().getValueInt() ;
                    stack.push(new Value(a<b));
                }
                case ILEQ ->{
                    int b = stack.pop().getValueInt() ;
                    int a = stack.pop().getValueInt() ;
                    stack.push(new Value(a<=b));
                }
                case ITOD ->{
                    double a = (double) stack.pop().getValueInt();
                    stack.push(new Value(a));
                }
                case ITOS ->{
                    int a = stack.pop().getValueInt();
                    stack.push(new Value(Integer.toString(a)));
                }
                case DCONST ->{
                    stack.push(new Value((double) constantPool.get(instrucions.get(i).getValue())));
                }
                case DPRINT ->{
                    System.out.println(stack.pop().getValueDouble());
                }
                case DUMINUS ->{
                    stack.push(new Value(-stack.pop().getValueDouble()));
                }
                case DADD ->{
                    double b = stack.pop().getValueDouble();
                    double a = stack.pop().getValueDouble();
                    stack.push(new Value(a+b));
                }
                case DSUB ->{
                    double b = stack.pop().getValueDouble();
                    double a = stack.pop().getValueDouble();
                    stack.push(new Value(a-b));
                }
                case DMULT ->{
                    double b = stack.pop().getValueDouble();
                    double a = stack.pop().getValueDouble();
                    stack.push(new Value(a*b));
                }
                case DDIV ->{
                    double b = stack.pop().getValueDouble();
                    double a = stack.pop().getValueDouble();
                    stack.push(new Value(a/b));
                }
                case DEQ ->{
                    double b = stack.pop().getValueDouble();
                    double a = stack.pop().getValueDouble();
                    stack.push(new Value(a==b));
                }
                case DNEQ ->{
                    double b = stack.pop().getValueDouble();
                    double a = stack.pop().getValueDouble();
                    stack.push(new Value(a!=b));
                }
                case DLT ->{
                    double b = stack.pop().getValueDouble();
                    double a = stack.pop().getValueDouble();
                    stack.push(new Value(a<b));
                }
                case DLEQ ->{
                    double b = stack.pop().getValueDouble();
                    double a = stack.pop().getValueDouble();
                    stack.push(new Value(a<=b));
                }
                case DTOS ->{
                    double a = stack.pop().getValueDouble();
                    stack.push(new Value(Double.toString(a)));
                }
                case SCONST ->{
                    stack.push(new Value((String) constantPool.get(instrucions.get(i).getValue())));
                }
                case SPRINT ->{
                    System.out.println(stack.pop().getValueString());
                }
                case SADD ->{
                    String b = stack.pop().getValueString();
                    String a = stack.pop().getValueString();
                    stack.push(new Value(a+b));
                }
                case SEQ ->{
                    String b = stack.pop().getValueString();
                    String a = stack.pop().getValueString();
                    stack.push(new Value(a.equals(b)));
                } 
                case SNEQ ->{
                    String b = stack.pop().getValueString();
                    String a = stack.pop().getValueString();
                    stack.push(new Value(!a.equals(b)));
                }
                case TCONST ->{
                    stack.push(new Value(true));
                }
                case FCONST ->{
                    stack.push(new Value(false));
                }
                case BPRINT ->{
                    System.out.println(stack.pop().getValueBoolean());
                }
                case BEQ ->{
                    boolean b = stack.pop().getValueBoolean();
                    boolean a = stack.pop().getValueBoolean();
                    stack.push(new Value(a==b));
                }
                case BNEQ ->{
                    boolean b = stack.pop().getValueBoolean();
                    boolean a = stack.pop().getValueBoolean();
                    stack.push(new Value(a!=b));
                }
                case AND ->{
                    boolean b = stack.pop().getValueBoolean();
                    boolean a = stack.pop().getValueBoolean();
                    stack.push(new Value(a && b));
                }
                case OR ->{
                    boolean b = stack.pop().getValueBoolean();
                    boolean a = stack.pop().getValueBoolean();
                    stack.push(new Value(a || b));
                }
                case NOT ->{
                    boolean a = stack.pop().getValueBoolean();
                    stack.push(new Value(!a));
                }
                case BTOS ->{
                    boolean a = stack.pop().getValueBoolean();
                    stack.push(new Value(Boolean.toString(a)));
                }
                case JUMP ->{
                    i = instrucions.get(i).getValue()-1;
                }
                case JUMPT ->{
                    if(stack.pop().getValueBoolean())
                        i = (int) instrucions.get(i).getValue()-1;
                }
                case JUMPF ->{
                    if(!(boolean) stack.pop().getValueBoolean())
                        i = (int) instrucions.get(i).getValue()-1;
                }
                case GALLOC ->{
                    int size = instrucions.get(i).getValue();
                    globalMemory = new ArrayList<>(size);
                }
                case GLOAD ->{
                    int position = instrucions.get(i).getValue();
                    stack.push(globalMemory.get(position));
                }
                case GSTORE ->{
                    int position = instrucions.get(i).getValue();
                    globalMemory.set(position, stack.pop());
                }
                case HALT ->{
                    System.exit(0);
                }
                default -> System.out.println("Unknown command");
            }
            i++;
        }
        throw new Exception(new RuntimeException("No Halt found!"));
    }

    public static void main(String[] args) throws Exception {
        tVm Vm = new tVm(args);
        Vm.runCodeMemory();
    }
}
