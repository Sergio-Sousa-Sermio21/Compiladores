import java.io.DataInputStream;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class tVm {

    private Array[] globalMemory;
    private ArrayList<Instrucion> instrucions = new ArrayList<>();

    private ArrayList<Object> constantPool = new ArrayList<>();

    public tVm(String[] args){
        getFile(args);
    }

    private void getFile(String[] args)throws IOException{
        DataInputStream din = new DataInputStream(new FileInputStream("file.dat"));
    }

    public static void main(String[] args) {
        tVm Vm = new tVm(args);
    }
}
