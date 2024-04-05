public class Value {
    private final Object value;

    public Value(Integer valor){ value = valor;}

    public Value(String valor) { value = valor;}

    public Value(Double valor) { value = valor;}

    public Value(Boolean valor) { value = valor;}

    public Integer getValueInt(){
        if(!(value instanceof Integer))
            throw new IllegalStateException("Value given isn't type Integer it's "  + value.getClass());
        return (Integer) value;
    }

    public String getValueString(){
        if(!(value instanceof String texto))
            throw new IllegalStateException("Value given isn't type String it's "  + value.getClass());
        texto = texto.replaceAll("\\\\n", "\n")
                .replaceAll("\\\\t", "\t")
                .replaceAll("\\\\r", "\r")
                .replaceAll("\\\\\"", "\"")
                .replaceAll("\\\\\\\\", "\\\\");
        return texto;
    }

    public Double getValueDouble(){
        if(!(value instanceof Double))
            throw new IllegalStateException("Value given isn't type Double it's "  + value.getClass());
        return (Double) value;
    }

    public Boolean getValueBoolean(){
        if(!(value instanceof Boolean))
            throw new IllegalStateException("Value given isn't type Boolean it's "  + value.getClass());
        return (Boolean) value;
    }
}
