package SubClase;

import Interfaces.OperacionesVector;
import SuperClase.Arreglo;
import leer.Leer;
import Aleatorio.Aleatorio;

public class VectorEntero extends Arreglo implements OperacionesVector {

    private int vec[];

    public VectorEntero(int n) {
        super(n);
        vec = new int[n];
    }

    @Override
    public int getPromedio() {
        int aux = 0;
        for (int i = 0; i < vec.length; i++) {
            aux += vec[i];
        }
        if (getN() - 1 == 0) {
            aux = 0;
        } else {
            aux /= (getN() - 1);
        }
        return aux;
    }

    @Override
    public void impDatos(char op) {
        System.out.print("[");
        for (int i = 0; i < vec.length; i++) {
            if (i != 0) {
                System.out.print(op);
            }
            System.out.print(vec[i]);
        }
        System.out.println("]");
    }

    @Override
    public int getDato(int pos) {
        return vec[pos];
    }

    @Override
    public int getDatoMayor() {
        int aux = vec[0];
        for (int i = 0; i < vec.length; i++) {
            if (aux > vec[i]) {
                aux = vec[i];
            }
        }
        return aux;
    }

    @Override
    public int getDatoMenor() {
        if (getN() == 0) {
            System.out.println("No hay elementos");
        }
        int aux = vec[0];
        for (int i = 0; i < vec.length; i++) {
            if (aux < vec[i]) {
                aux = vec[i];
            }
        }
        return aux;
    }

    @Override
    public void anadirDato(int nvoDato) {
        int aux[] = new int[getN() + 1];
        System.arraycopy(vec, 0, aux, 0, getN());
        aux[getN()] = nvoDato;
        vec = aux;
        System.out.println("Dato añadido");
    }

    @Override
    public void eliminarDato() {
        if (getN() == 0) {
            System.out.println("No hay elementos a eliminar");
        } else {
            int aux[] = new int[getN() - 1];
            System.arraycopy(vec, 0, aux, 0, getN() - 1);
            setN(getN() - 1);
            vec = aux;
            System.out.println("Dato eliminado");
        }
    }

    @Override
    public void llenadoDatos() {
        for (int i = 0; i < vec.length; i++) {
            vec[i] = Leer.leerInt("Ingrese dato #" + (i + 1) + ":\t");
        }
    }

    @Override
    public void llenadoDatos(int ini, int fin) {
        for (int i = 0; i < vec.length; i++) {
            vec[i] = Aleatorio.getDatoInt(ini, fin);
        }
    }

    public int[] getVec() {
        return vec;
    }

    @Override
    public int longitudVector() {
        return vec.length;
    }

    @Override
    public void posicionDato(int dato) {
        for (int i = 0; i < vec.length; i++) {
            if(vec[i]==dato){
                System.out.println("El dato "+dato+ " esta en la posición "+i);
            }
        }
    }
}
