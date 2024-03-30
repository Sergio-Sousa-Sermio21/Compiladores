import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class tVm {

    private Array[] globalMemory;

    private ArrayList<Byte> codeMemory = new ArrayList<>();
    private ArrayList<Object> constantPool = new ArrayList<>();

    public tVm(String[] args) throws IOException{
        getFile(args);
        for(int i = 0; i<codeMemory.size(); i++){
            System.out.println(codeMemory.get(i));
        }

    }

    private void getFile(String[] args)throws IOException {
        DataInputStream din = new DataInputStream(new FileInputStream(args[0]));
        while(din.available()>0){
            byte bytes = din.readByte();
            if(bytes != Commands.CONSTANTPOOL.ordinal()){
                codeMemory.add(bytes);
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
        while(true)
    }

    public static void main(String[] args) throws IOException {
        tVm Vm = new tVm(args);
    }
}
