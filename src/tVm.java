import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class tVm {

    private Object[] globalMemory;
    private ArrayList<Object> constantPool = new ArrayList<>();
    private Commands[] commands = Commands.values();
    private ArrayList<Instrucion> instrucions = new ArrayList<>();

    private Stack<Value<?>> stack = new Stack<>();
    public tVm(String[] args) throws IOException{
        getFiles(args);

    }

    private void getFiles(String[] args)throws IOException {
        DataInputStream din = new DataInputStream(new FileInputStream(args[0]));
        while(din.available()>0){
            byte bytes = din.readByte();
            if(bytes != Commands.CONSTANTPOOL.ordinal()){
                if(commands[bytes] == Commands.ICONST){
                    instrucions.add(new Instrucion(Commands.ICONST,din.readInt()));
                } else if(commands[bytes] == Commands.JUMP)
                    instrucions.add(new Instrucion(Commands.JUMP,din.readInt()));
                else if(commands[bytes] == Commands.JUMPF)
                    instrucions.add(new Instrucion(Commands.JUMPF,din.readInt()));
                else if(commands[bytes] == Commands.JUMPT)
                    instrucions.add(new Instrucion(Commands.JUMPT,din.readInt()));
                else if(commands[bytes] == Commands.GALLOC)
                    instrucions.add(new Instrucion(Commands.GALLOC,din.readInt()));
                else if(commands[bytes] == Commands.GLOAD)
                    instrucions.add(new Instrucion(Commands.GLOAD,din.readInt()));
                else if(commands[bytes] == Commands.GSTORE)
                    instrucions.add(new Instrucion(Commands.GSTORE,din.readInt()));
                else if(commands[bytes] == Commands.DCONST)
                    instrucions.add(new Instrucion(Commands.DCONST,din.readInt()));
                else if(commands[bytes] == Commands.SCONST)
                    instrucions.add(new Instrucion(Commands.SCONST,din.readInt()));
                else
                    instrucions.add(new Instrucion(commands[bytes]));
            } else {
                break;
            }
        }
        addconstantpool(din);
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
    }
    public void runCodeMemory(){
        int i = 0;
        while(i<instrucions.size()) {
            //System.out.println(instrucions.get(i) + " " + i);
            //System.out.println(stack);
            switch (instrucions.get(i).getCommand()) {
                case ICONST -> {
                    stack.push(new Inteiro(instrucions.get(i).getValue()));
                }
                case IPRINT -> {
                    System.out.println(stack.pop());
                }
                case IUMINUS -> {
                    Value<?> poppedValue = stack.pop();
                    int intValue = (int) poppedValue.obterValue();
                    stack.push(new Inteiro(-intValue));
                }
                case IADD ->{
                    Value<?> value1 = stack.pop();
                    Value<?> value2 = stack.pop();
                    int intValue1 = ((Inteiro) value1).obterValue();
                    int intValue2 = ((Inteiro) value2).obterValue();
                    int result = intValue1 + intValue2;
                    stack.push(new Inteiro(result));
                }
                case ISUB ->{
                    Value<?> value1 = stack.pop();
                    Value<?> value2 = stack.pop();
                    int intValue1 = ((Inteiro) value1).obterValue();
                    int intValue2 = ((Inteiro) value2).obterValue();
                    int result = intValue1 - intValue2;
                    stack.push(new Inteiro(result));
                }
                case IMULT ->{
                    Value<?> value1 = stack.pop();
                    Value<?> value2 = stack.pop();
                    int intValue1 = ((Inteiro) value1).obterValue();
                    int intValue2 = ((Inteiro) value2).obterValue();
                    int result = intValue1 * intValue2;
                    stack.push(new Inteiro(result));
                }
                case IDIV ->{
                    Value<?> value1 = stack.pop();
                    Value<?> value2 = stack.pop();
                    int intValue1 = ((Inteiro) value1).obterValue();
                    int intValue2 = ((Inteiro) value2).obterValue();
                    int result = intValue1 / intValue2;
                    stack.push(new Inteiro(result));
                }
                case IMOD ->{
                    Value<?> value1 = stack.pop();
                    Value<?> value2 = stack.pop();
                    int intValue1 = ((Inteiro) value1).obterValue();
                    int intValue2 = ((Inteiro) value2).obterValue();
                    int result = intValue1 % intValue2;
                    stack.push(new Inteiro(result));
                }
                case IEQ ->{
                    Value<?> bValue = stack.pop();
                    int b = (int) bValue.obterValue();

                    Value<?> aValue = stack.pop();
                    int a = (int) aValue.obterValue();
                    stack.push(new Bool(a==b));
                }
                case INEQ ->{
                    Value<?> bValue = stack.pop();
                    int b = (int) bValue.obterValue();

                    Value<?> aValue = stack.pop();
                    int a = (int) aValue.obterValue();
                    stack.push(new Bool(a!=b));
                }
                case ILT ->{
                    Value<?> bValue = stack.pop();
                    int b = (int) bValue.obterValue();

                    Value<?> aValue = stack.pop();
                    int a = (int) aValue.obterValue();
                    stack.push(new Bool(a<b));
                }
                case ILEQ ->{
                    Value<?> bValue = stack.pop();
                    int b = (int) bValue.obterValue();

                    Value<?> aValue = stack.pop();
                    int a = (int) aValue.obterValue();
                    stack.push(new Bool(a<=b));
                }
                case ITOD ->{
                    //double a = (double) stack.pop();
                    //stack.push(a);
                    Value<?> poppedValue = stack.pop();
                    double Value = (double) poppedValue.obterValue();
                    stack.push(new DoubleValue(Value));
                }
                case ITOS ->{
                    //int a = (int) stack.pop();
                    //stack.push(Integer.toString(a));
                    Value<?> poppedValue = stack.pop();
                    String Value = (String) poppedValue.obterValue();
                    stack.push(new StringValue(Value));
                }
                case DCONST ->{
                    stack.push(new DoubleValue(instrucions.get(i).getValue()));
                }
                case DPRINT ->{
                    System.out.println(stack.pop());

                }
                case DUMINUS ->{
                    Value<?> poppedValue = stack.pop();
                    double doubleValue = (double) poppedValue.obterValue();
                    stack.push(new DoubleValue(-doubleValue));
                }
                case DADD ->{
                    Value<?> value1 = stack.pop();
                    Value<?> value2 = stack.pop();
                    double intValue1 = ((DoubleValue) value1).obterValue();
                    double intValue2 = ((DoubleValue) value2).obterValue();
                    double result = intValue1 + intValue2;
                    stack.push(new DoubleValue(result));
                }
                case DSUB ->{
                    Value<?> value1 = stack.pop();
                    Value<?> value2 = stack.pop();
                    double intValue1 = ((DoubleValue) value1).obterValue();
                    double intValue2 = ((DoubleValue) value2).obterValue();
                    double result = intValue1 - intValue2;
                    stack.push(new DoubleValue(result));
                }
                case DMULT ->{
                    Value<?> value1 = stack.pop();
                    Value<?> value2 = stack.pop();
                    double intValue1 = ((DoubleValue) value1).obterValue();
                    double intValue2 = ((DoubleValue) value2).obterValue();
                    double result = intValue1 * intValue2;
                    stack.push(new DoubleValue(result));
                }
                case DDIV ->{
                    Value<?> value1 = stack.pop();
                    Value<?> value2 = stack.pop();
                    double intValue1 = ((DoubleValue) value1).obterValue();
                    double intValue2 = ((DoubleValue) value2).obterValue();
                    double result = intValue1 / intValue2;
                    stack.push(new DoubleValue(result));
                }
                case DEQ ->{
                    Value<?> bValue = stack.pop();
                    double b = (double) bValue.obterValue();

                    Value<?> aValue = stack.pop();
                    double a = (double) aValue.obterValue();
                    stack.push(new Bool(a==b));
                }
                case DNEQ ->{
                    Value<?> bValue = stack.pop();
                    double b = (double) bValue.obterValue();

                    Value<?> aValue = stack.pop();
                    double a = (double) aValue.obterValue();
                    stack.push(new Bool(a!=b));
                }
                case DLT ->{
                    Value<?> bValue = stack.pop();
                    double b = (double) bValue.obterValue();

                    Value<?> aValue = stack.pop();
                    double a = (double) aValue.obterValue();
                    stack.push(new Bool(a<b));
                }
                case DLEQ ->{
                    Value<?> bValue = stack.pop();
                    double b = (double) bValue.obterValue();

                    Value<?> aValue = stack.pop();
                    double a = (double) aValue.obterValue();
                    stack.push(new Bool(a<=b));
                }
                case DTOS ->{
                    //double a = (double) stack.pop();
                    //stack.push(Double.toString(a));
                    Value<?> poppedValue = stack.pop();
                    int Value = (int) poppedValue.obterValue();
                    stack.push(new Inteiro(Value));
                }
                case SCONST ->{
                    //stack.push(constantPool.get((int) instrucions.get(i).getValue()));
                }
                case SPRINT ->{
                    System.out.println(stack.pop());
                }
                case SADD ->{
                    Value<?> value1 = stack.pop();
                    Value<?> value2 = stack.pop();
                    String intValue1 = ((StringValue) value1).obterValue();
                    String intValue2 = ((StringValue) value2).obterValue();
                    String result = intValue1 + intValue2;
                    stack.push(new StringValue(result));
                }
                case SEQ ->{
                    Value<?> poppedValueB = stack.pop();
                    Value<?> poppedValueA = stack.pop();

                    String B = (String) poppedValueB.obterValue();
                    String A = (String) poppedValueA.obterValue();
                    stack.push(new Bool(A.equals(B)));
                }
                case SNEQ ->{
                    Value<?> poppedValueB = stack.pop();
                    Value<?> poppedValueA = stack.pop();

                    String B = (String) poppedValueB.obterValue();
                    String A = (String) poppedValueA.obterValue();
                    stack.push(new Bool(!A.equals(B)));
                }
                case TCONST ->{
                    stack.push(new Bool(true));
                }
                case FCONST ->{
                    stack.push(new Bool(false));
                }
                case BPRINT ->{
                    System.out.println(stack.pop());
                }
                case BEQ ->{
                    boolean b = (boolean) stack.pop().obterValue();
                    boolean a = (boolean) stack.pop().obterValue();
                    stack.push(new Bool(a==b));
                }
                case BNEQ ->{
                    boolean b = (boolean) stack.pop().obterValue();
                    boolean a = (boolean) stack.pop().obterValue();
                    stack.push(new Bool(a!=b));
                }
                case AND ->{
                    boolean b = (boolean) stack.pop().obterValue();
                    boolean a = (boolean) stack.pop().obterValue();
                    stack.push(new Bool(a && b));
                }
                case OR ->{
                    boolean b = (boolean) stack.pop().obterValue();
                    boolean a = (boolean) stack.pop().obterValue();
                    stack.push(new Bool(a || b));
                }
                case NOT ->{
                    boolean a = (boolean) stack.pop().obterValue();
                    stack.push(new Bool(!a));
                }
                case BTOS ->{
                    boolean a = (boolean) stack.pop().obterValue();
                    stack.push(new StringValue(Boolean.toString(a)));
                }
                //VER PEDRO TUDO ABAIXO DISTO
                case JUMP ->{
                    i = instrucions.get(i).getValue()-1;
                }
                //VER PEDRO
                case JUMPT ->{
                    if((boolean) stack.pop().obterValue())
                        i = instrucions.get(i).getValue()-1;
                }
                //VER PEDRO
                case JUMPF ->{
                    if(!(boolean) stack.pop().obterValue())
                        i = instrucions.get(i).getValue()-1;
                }
                case GALLOC ->{
                    int size = instrucions.get(i).getValue();
                    globalMemory = new Object[size];
                }
                case GLOAD ->{
                    int posicon = instrucions.get(i).getValue();
                    stack.push(new Inteiro((int) globalMemory[posicon]));
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
