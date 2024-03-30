import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class tVm {

    private Array[] globalMemory;

    private ArrayList<Byte> codeMemory = new ArrayList<>();
    private ArrayList<Object> constantPool = new ArrayList<>();
    private HashMap<Integer, Commands> commands = new HashMap<>();
    private ArrayList<Instrucion> instrucions = new ArrayList<>();

    private Stack<Object> stack = new Stack<>();
    public tVm(String[] args) throws IOException{
        initHash();
        getFiles(args);
        for(int i = 0; i<codeMemory.size(); i++){
            System.out.println(codeMemory.get(i));
        }

    }

    private void initHash(){
        for(Commands c : Commands.values()){
            commands.put(c.ordinal(), c);
        }
    }

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
        for (Instrucion instrucion : instrucions){
            System.out.println(instrucion);
        }
    }

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
        for(int i = 0; i < constantPool.size(); i++) {
            System.out.println(constantPool.get(i));
        }
    }

    public void runCodeMemory(){
        int i = 0;
        while(i<instrucions.size()) {
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

                }
                case ISUB ->{

                }
                case IMULT ->{

                }
                case IDIV ->{

                }
                case IMOD ->{

                }
                case IEQ ->{

                }
                case INEQ ->{

                }
                case ILT ->{

                }
                case ILEQ ->{

                }
                case ITOD ->{

                }
                case ITOS ->{

                }
                case DCONST ->{

                }
                case DPRINT ->{

                }
                case DUMINUS ->{

                }
                case DADD ->{

                }
                case DSUB ->{

                }
                case DMULT ->{

                }
                case DDIV ->{

                }
                case DEQ ->{

                }
                case DNEQ ->{

                }
                case DLT ->{

                }
                case DLEQ ->{

                }
                case DTOS ->{

                }
                case SCONST ->{

                }
                case SPRINT ->{

                }
                case SADD ->{

                }
                case SEQ ->{

                } 
                case SNEQ ->{

                }
                case TCONST ->{

                }
                case FCONST ->{

                }
                case BPRINT ->{

                }
                case BEQ ->{

                }
                case BNEQ ->{

                }
                case AND ->{

                }
                case OR ->{

                }
                case NOT ->{

                }
                case BTOS ->{

                }
                case JUMP ->{

                }
                case JUMPT ->{

                }
                case JUMPF ->{

                }
                case GALLOC ->{

                }
                case GLOAD ->{

                }
                case GSTORE ->{

                }
                case LABEL ->{

                }
                case HALT ->{

                }
                default -> System.out.println("Unknown command");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        tVm Vm = new tVm(args);
        //Vm.runCodeMemory();
    }
}
