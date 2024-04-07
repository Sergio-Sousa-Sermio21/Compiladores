import java.util.EmptyStackException;

public class Error {

    public static void trowError(String error){
        System.err.println(error);
        System.exit(0);
    }

    public static void BuildError(Exception e, Instrucion instrucao, int linha){
        if(e.getClass() == EmptyStackException.class)
            Error.trowError("Command:" + linha + " Stack nao tem elementos o suficientes para a operacao: '" + instrucao.getCommand().toString().toLowerCase() + "'");
        if(e.getClass() == IllegalArgumentException.class)
            Error.trowError("Command:" + linha + ". In instrucion " + instrucao + " " + e.getMessage());
        Error.trowError("Command:" + linha + " " + e);
    }
}
