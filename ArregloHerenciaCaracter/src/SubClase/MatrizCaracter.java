package SubClase;

import Interfaces.OperacionesMatriz;
import SuperClase.Arreglo;
import leer.Leer;
import Aleatorio.Aleatorio;

public class MatrizCaracter extends Arreglo implements OperacionesMatriz {

    private int m;
    char mat[][];

    public MatrizCaracter(int n, int m) {
        super(n);
        mat = new char[n][m];
        this.m = m;
    }

    @Override
    public void llenadoDatos() {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = Leer.leerChar("Ingresa dato [" + i + "] [" + j + "]:\t");
            }
        }
    }

    @Override
    public void llenadoDatos(int ini, int fin) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = Aleatorio.getDatoChar(ini, fin);
            }
        }
    }

    @Override
    public void impDatos(char op) {
        for (int i = 0; i < mat.length; i++) {
            System.out.print("[");
            for (int j = 0; j < mat[i].length; j++) {
                if (j != 0) {
                    System.out.print(op);
                }
                System.out.print(mat[i][j]);
            }
            System.out.println("]");
        }
    }

    @Override
    public char getPromedio() {
        int aux = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                aux += (int) mat[i][j];
            }
        }
        return (char) (aux / (mat.length * mat[0].length));
    }

    @Override
    public char getDato(int fila, int columna) {
        return mat[fila][columna];
    }

    @Override
    public char getDatoMayor() {
        int aux = (int) mat[0][0];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (aux < (int) mat[i][j]) {
                    aux = (int) mat[i][j];
                }
            }
        }
        return (char) aux;
    }

    @Override
    public char getDatoMenor() {
        int aux = (int) mat[0][0];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (aux > (int) mat[i][j]) {
                    aux = (int) mat[i][j];
                }
            }
        }
        return (char) aux;
    }

    @Override
    public void añadirFila(char[] nvoDatos) {
        char aux[][] = new char[getN() + 1][getM()];
        for (int i = 0; i < mat.length; i++) {
            System.arraycopy(mat[i], 0, aux[i], 0, getM());
        }
        System.arraycopy(nvoDatos, 0, aux[getN()], 0, getM());
        mat = aux;
        setN(getN() + 1);
        System.out.println("\tFILA AÑADIDA\t");
    }

    @Override
    public void añadirColumna(char[] nvoDatos) {
        char aux[][] = new char[getN()][getM() + 1];
        for (int i = 0; i < mat.length; i++) {
            System.arraycopy(mat[i], 0, aux[i], 0, getM());
            aux[i][getM()] = nvoDatos[i];
        }
        mat = aux;
        setM(getM() + 1);
        System.out.println("\tCOLUMNA AÑADIDA\t");
    }

    @Override
    public void eliminarFila() {
        if (getN() <= 0) {
            setM(0);
            System.out.println("Ya no se pueden eliminar los elementos");
        } else {
            char aux[][] = new char[getN() - 1][getM()];
            for (int i = 0; i < mat.length - 1; i++) {
                System.arraycopy(mat[i], 0, aux[i], 0, getM());
            }
            mat = aux;
            setN(getN() - 1);
            System.out.println("FILA ELIMINADA");
        }
    }

    @Override
    public void eliminarColumna() {
        if (getM() <= 0) {
            setN(0);
            System.out.println("Ya no se pueden eliminar los elementos");
        } else {
            char aux[][] = new char[getN()][getM() - 1];
            for (int i = 0; i < mat.length; i++) {
                System.arraycopy(mat[i], 0, aux[i], 0, getM() - 1);
            }
            mat = aux;
            setM(getM() - 1);
            System.out.println("COLUMNA ELIMINADA ");
        }
    }

    @Override
    public int longitudMatriz() {
        return mat.length * mat[0].length;
    }

    @Override
    public void posicionDatoM(char dato) {
        int aux=0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == dato) {
                    System.out.println("El dato " + dato + " esta en la posicion:\t" + i);
                    aux=1;
                }
            }
        }
        if(aux!=1){
            System.out.println("El dato "+dato+ "no esta en la matriz");
        }
    }

    protected void setM(int m) {
        this.m = m;
    }

    public int getM() {
        return m;
    }
}
