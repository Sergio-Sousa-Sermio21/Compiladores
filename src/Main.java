import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String[] file = new String[2];
        file[0] = "C:\\Users\\ASUS\\Documents\\Lab1typescript\\Compiladores\\inputs\\" + name + ".tasm";
        tAssembler assembler = new tAssembler();
        assembler.execute(file);
        file[0] = "C:\\Users\\ASUS\\Documents\\Lab1typescript\\Compiladores\\inputs\\" + name + ".tbc";
        System.out.println();
        tVm vm = new tVm(file);
        vm.runCodeMemory();
    }
}
