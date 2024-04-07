import org.antlr.runtime.Token;

public class Instrucion {
    private Commands command;
    private Integer value;

    public Instrucion(Commands codigo, Integer valor){
        command = codigo;
        value = valor;
    }

    public  Instrucion(Commands codigo){    command = codigo;   }

    public Commands getCommand(){   return  command;    }

    public Integer getValue(){   return value;   }

    public void setValue(Integer valor){ value=valor;}

    @Override
    public String toString() {
        if(value != null){
            return  command.name() + " " +  value;
        }
        return command.name();
    }
}
