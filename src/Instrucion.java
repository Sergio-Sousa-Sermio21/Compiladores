import org.antlr.runtime.Token;

public class Instrucion {
    private Commands command;
    private Object value;

    public Instrucion(Commands codigo, Object valor){
        command = codigo;
        value = valor;
    }

    public  Instrucion(Commands codigo){    command = codigo;   }

    public Commands getCommand(){   return  command;    }

    public Object getValue(){   return value;   }

    @Override
    public String toString() {
        if(value != null){
            if(value instanceof Double)
                return command.name() + " " + value + " Double";
            if(value instanceof Integer)
                return  command.name() + " " + value + " Int";
            if(value instanceof String)
                return  command.name() + " " + value + " String";
            return  command.name() + " " +  value;
        }
        return command.name();
    }
}
