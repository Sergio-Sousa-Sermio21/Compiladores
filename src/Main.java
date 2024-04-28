import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
        for (String arg : inputArguments) {
            if (arg.contains("jdwp") || arg.contains("Xdebug")) {
                System.out.println("O código está sendo executado em modo de depuração.");
                System.exit(0);
            }
        }
        System.out.println("O código não está sendo executado em modo de depuração.");*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String[] file = new String[2];
        file[0] = "C:\\xampp\\htdocs\\Compiladores\\InputsParte3\\" + name + ".sol";
        solCompiler assembler = new solCompiler();
        assembler.executeSol(file);
        file[0] = "C:\\xampp\\htdocs\\Compiladores\\InputsParte3\\" + name + ".tbc";
        tVM vm = new tVM(file);
        vm.runCodeMemory(false);
    }
}
