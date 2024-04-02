public class Value {
    private final Object value;

    public Value(Integer valor){ value = valor;}

    public Value(String valor) { value = valor;}

    public Value(Double valor) { value = valor;}

    public Value(Boolean valor) { value = valor;}

    public Integer getValueInt(){ return (Integer) value;}

    public String getValueString(){ return (String) value;}

    public Double getValueDouble(){ return (Double) value;}

    public Boolean getValueBoolean(){ return (Boolean) value;}
}
