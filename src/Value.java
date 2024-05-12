public class Value {
    private final Object value;

    public Value(Integer valor){ value = valor;}

    public Value(String valor) { value = valor;}

    public Value(Double valor) { value = valor;}

    public Value(Boolean valor) { value = valor;}

    public Value(){ value = null;}

    public Integer getValueInt() throws IllegalArgumentException {
        if(!(value instanceof Integer))
            throw new IllegalArgumentException("Value given isn't type Integer it's "  + value!=null?value.getClass().getSimpleName():"NIL");
        return (Integer) value;
    }

    public String getValueString() throws IllegalArgumentException {
        if(!(value instanceof String)){
            throw new IllegalArgumentException("Value given isn't type String it's "  + value!=null?value.getClass().getSimpleName():"NIL");
        }
        String texto = (String) value;
        texto = texto.replaceAll("\\\\n", "\n")
                .replaceAll("\\\\t", "\t")
                .replaceAll("\\\\r", "\r")
                .replaceAll("\\\\\"", "\"")
                .replaceAll("\\\\\\\\", "\\\\");
        return texto;
    }

    public Double getValueDouble() throws IllegalArgumentException {
        if(!(value instanceof Double))
            throw new IllegalArgumentException("Value given isn't type Double it's " + value!=null?value.getClass().getSimpleName():"NIL");
        return (Double) value;
    }

    public Boolean getValueBoolean() throws IllegalArgumentException {
        if(!(value instanceof Boolean))
            throw new IllegalArgumentException("Value given isn't type Boolean it's "  + value!=null?value.getClass().getSimpleName():"NIL");
        return (Boolean) value;
    }

    public boolean isNULL(){
        return value==null;
    }

    @Override
    public String toString() {
        if(value == null)
            return "NIL";
        if(value instanceof String)
            return "\"" + value + "\"";
        return "" + value;
    }
}
