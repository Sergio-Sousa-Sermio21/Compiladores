import java.util.Stack;
abstract class Valor<T> {
    abstract T obterValor();
}

class Real extends Valor<Double> {
    private double valor;

    public Real(double valor) {
        this.valor = valor;
    }

    @Override
    public Double obterValor() {
        return valor;
    }
}
class Inteiro extends Valor<Integer> {
    private int valor;

    public Inteiro(int valor) {
        this.valor = valor;
    }

    @Override
    public Integer obterValor() {
        return valor;
    }
}

class Bool extends Valor<Boolean> {
    private boolean valor;

    public Bool(boolean valor) {
        this.valor = valor;
    }

    @Override
    public Boolean obterValor() {
        return valor;
    }
}
class StringValor extends Valor<String> {
    private String valor;

    public StringValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String obterValor() {
        return valor;
    }
}
