import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class tVm {

    private Array[] globalMemory;
    private ArrayList<Instrucion> instrucions = new ArrayList<>();

    private ArrayList<Object> constantPool = new ArrayList<>();

    public tVm(String[] args) throws IOException{
        getFile(args);
    }

    private void getFile(String[] args)throws IOException {
        DataInputStream din = new DataInputStream(new FileInputStream(args[0]));
        while(din.available()>0){
            Byte bytes = din.readByte();
            System.out.println(bytes);
        }
    }

    public static void main(String[] args) throws IOException {
        tVm Vm = new tVm(args);
    }
}
