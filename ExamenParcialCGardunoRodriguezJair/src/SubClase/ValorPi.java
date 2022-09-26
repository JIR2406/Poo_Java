package SubClase;

import SuperClase.CalculoPi;
import Interfaces.*;

public class ValorPi extends CalculoPi implements OperacionesPi {

    public ValorPi(int n) {
        super(n);
    }

    public int getLongitud() {
        return valorResultados.length;
    }

    @Override
    public float getPi() {
        float aux = 1;
        float pi = 0;
        for (int i = 0; i < valorResultados.length; i++, aux = aux + 2) {
            if (i == 0) {
                pi += 4f / aux;
            } else if (i % 2 != 0 && i != 0) {
                pi -= 4f / aux;
            } else if (i % 2 == 0 && i != 0) {
                pi += 4f / aux;
            }
            valorResultados[i] = pi;
        }
        return pi;
    }

    @Override
    public String getSeriePi() {
        String a = "";
        int aux = 1;
        for (int i = 0; i < valorResultados.length; i++, aux = aux + 2) {
            if (i == 0) {
                a += "4/1";
            } else if (i % 2 != 0 && i != 0) {
                a += "-4/" + aux;
            } else if (i % 2 == 0 && i != 0) {
                a += "+4/" + aux;
            }
        }
        return a;
    }

    @Override
    public String getSeriePi(int pos) {
        String a = "";
        int aux = 1;
        for (int i = 0; i <= pos; i++, aux = aux + 2) {
            if (i == 0) {
                a += "4/1";
            } else if (i % 2 != 0 && i != 0) {
                a += "-4/" + aux;
            } else if (i % 2 == 0 && i != 0) {
                a += "+4/" + aux;
            }
        }
        return a;
    }

    @Override
    public void añadirCalculo() {
        float aux[] = new float[getLongitud() + 1];
        float iaux = 1;
        float pi = 0;
        for (int i = 0; i < aux.length; i++, iaux = iaux + 2) {
            if (i == 0) {
                pi += (4f / iaux);
            } else if (i % 2 != 0 && i != 0) {
                pi -= (4f / iaux);
            } else if (i % 2 == 0 && i != 0) {
                pi += (4f / iaux);
            }
            aux[i] = pi;
        }
        valorResultados = aux;
        System.out.println("Calculo añadido");
    }

    @Override
    public void eliminarCalculo() {
        float aux[] = new float[getLongitud() - 1];
        System.arraycopy(valorResultados, 0, aux, 0, getLongitud() - 1);
        valorResultados = aux;
        System.out.println("Calculo Eliminado");
    }

    @Override
    public float getPi(int pos) {
        getPi();
        return valorResultados[pos];
    }

}
