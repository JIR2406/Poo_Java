package SubClase;

import SuperClase.Arreglo;
import leer.Leer;
import Aleatorio.Aleatorio;
import Interfaces.MetodosArreglo;

public class MatrizReal extends Arreglo implements MetodosArreglo {

    private int m;
    double mat[][];

    public MatrizReal(int n, int m) {
        super(n);
        this.m = m;
        mat = new double[n][m];
    }

    @Override
    public void llenadoDatos() {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = Leer.leerDouble("Ingrese el dato [" + i + "] [" + j + "]:\t");
            }
        }
    }

    @Override
    public void llenadoDatos(int ini, int fin) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = Aleatorio.getDatoDouble(ini, fin, 2);
            }
        }
    }

    @Override
    public void impDatos(char op) {
        for (int i = 0; i < mat.length; i++) {
            System.out.print("{");
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
    public void intercambioFila(int filaIni, int filaFin) {
        double auxiliar;
        for (int i = 0; i < mat.length; i++) {
            auxiliar = mat[filaIni][i];
            mat[filaIni][i] = mat[filaFin][i];
            mat[filaFin][i] = auxiliar;

        }
    }

    @Override
    public void intercambioColumna(int columnaIni, int columnaFin) {
        double auxiliar;
        for (int i = 0; i < mat[0].length; i++) {
            auxiliar = mat[i][columnaIni];
            mat[i][columnaIni] = mat[i][columnaFin];
            mat[i][columnaFin] = auxiliar;

        }
    }

    public int getM() {
        return m;
    }
}
