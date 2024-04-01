import java.util.Stack;
abstract class Value<T> {
    abstract T obterValue();
}

class DoubleValue extends Value<Double> {
    private double Value;

    public DoubleValue(double Value) {
        this.Value = Value;
    }

    @Override
    public Double obterValue() {
        return Value;
    }
}
class Inteiro extends Value<Integer> {
    private int Value;

    public Inteiro(int Value) {
        this.Value = Value;
    }

    @Override
    public Integer obterValue() {
        return Value;
    }
}

class Bool extends Value<Boolean> {
    private boolean Value;

    public Bool(boolean Value) {
        this.Value = Value;
    }

    @Override
    public Boolean obterValue() {
        return Value;
    }
}
class StringValue extends Value<String> {
    private String Value;

    public StringValue(String Value) {
        this.Value = Value;
    }

    @Override
    public String obterValue() {
        return Value;
    }
}
