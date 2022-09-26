package SuperClase;

public abstract class CalculoPi {

    protected float valorResultados[];

    public CalculoPi(int n) {
        valorResultados=new float[n];
    }
    public abstract void añadirCalculo();
    public abstract void eliminarCalculo();
}
