public class Instrucion {
    private final Commands command;
    private Integer value;

    public Instrucion(Commands codigo, Integer valor){
        command = codigo;
        value = valor;
    }

    public  Instrucion(Commands codigo){    command = codigo;   }

    public Commands getCommand(){   return  command;    }

    public boolean isValueNull(){
        return value == null;
    }

    public Integer getValue(){   return value;   }

    public void setValue(Integer valor){ value=valor;}

    @Override
    public String toString() {
        if(value != null){
            if(command == Commands.JUMP || command == Commands.JUMPF || command == Commands.JUMPT)
                return  command.name() + " L" +  value;
            else
                return  command.name() + " " +  value;
        }
        return command.name();
    }
}
