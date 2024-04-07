import java.util.EmptyStackException;

public class Error {

    public static void trowError(String error){
        System.err.println(error);
        System.exit(0);
    }

    public static void BuildError(Exception e, Instrucion instrucao, int linha){
        if(e.getClass() == EmptyStackException.class)
            Error.trowError("Line:" + linha + " Stack doesn't have enough elements for the operation: '" + instrucao.getCommand().toString().toLowerCase() + "'");
        if(e.getClass() == IllegalArgumentException.class)
            Error.trowError("Line:" + linha + ". In instruction " + instrucao + " " + e.getMessage());
        Error.trowError("Line:" + linha + " " + e);
    }
}
