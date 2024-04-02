import java.util.Stack;
abstract class Value<T> {
    T data;

    public Value(T data){
        this.data = data;
    }
    public T getData(){
        return data;
    }
}

class DoubleValue extends Value<Double> {

    public DoubleValue(Double Value) {
        super(Value);
    }

}
class Inteiro extends Value<Integer> {
    private Integer Value;

    public Inteiro(int Value) {
        super((Value));
    }

}

class Bool extends Value<Boolean> {
    private boolean Value;

    public Bool(boolean Value) {
        super(Value);
    }

}
class StringValue extends Value<String> {
    private String Value;

    public StringValue(String Value) {
        super(Value);
    }

}
