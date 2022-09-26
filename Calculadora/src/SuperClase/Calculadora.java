package SuperClase;

public abstract class Calculadora {

    private double n1;
    private double n2;

    public Calculadora(double n1) {
        this.n1 = n1;
    }

    public abstract double getResultado(char oper);

    public double getN1() {
        return n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }
}
