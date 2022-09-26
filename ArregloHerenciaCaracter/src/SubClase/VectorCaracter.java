package SubClase;

import Interfaces.OperacionesVector;
import SuperClase.Arreglo;
import leer.Leer;
import Aleatorio.Aleatorio;

public class VectorCaracter extends Arreglo implements OperacionesVector {

    char vec[];

    public VectorCaracter(int n) {
        super(n);
        vec = new char[n];
    }

    @Override
    public void llenadoDatos() {
        for (int i = 0; i < vec.length; i++) {
            vec[i] = Leer.leerChar("Ingrese el dato #" + 1 + ":\t");
        }
    }

    @Override
    public void llenadoDatos(int ini, int fin) {
        for (int i = 0; i < vec.length; i++) {
            vec[i] = Aleatorio.getDatoChar(ini, fin);
        }
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
    public char getPromedio() {
        int aux = 0;
        for (int i = 0; i < vec.length; i++) {
            aux += (int) vec[i];
        }
        return (char) (aux / vec.length);
    }

    @Override
    public char getDato(int pos) {
        return vec[pos];
    }

    @Override
    public char getDatoMayor() {
        int aux = (int) vec[0];
        for (int i = 0; i < vec.length; i++) {
            if (aux < (int) vec[i]) {
                aux = (int) vec[i];
            }
        }
        return (char) aux;
    }

    @Override
    public char getDatoMenor() {
        int aux = (int) vec[0];
        for (int i = 0; i < vec.length; i++) {
            if (aux > (int) vec[i]) {
                aux = (int) vec[i];
            }
        }
        return (char) aux;
    }

    @Override
    public void anadirDato(char nvoDato) {
        char aux[] = new char[getN() + 1];
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
            char aux[] = new char[getN() - 1];
            System.arraycopy(vec, 0, aux, 0, getN() - 1);
            setN(getN() - 1);
            vec = aux;
            System.out.println("Dato eliminado");
        }
    }

    @Override
    public int longitudVector() {
        return vec.length;
    }

    @Override
    public void posicionDato(char dato) {
        int aux=0;
        for (int i = 0; i < vec.length; i++) {
            if (vec[i] == dato) {
                System.out.println("La posicion del dato " + dato + " es: \t" + i);
                aux=1;
            }
        }

        if (aux!=1) {
            System.out.println("El dato " + dato + " no esta en el vector");
        }
    }
}
