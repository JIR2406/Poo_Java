
package SubClase;

import SuperClase.Arreglo;
import leer.Leer;
import Aleatorio.Aleatorio;
import Interfaces.OperacionesMatriz;


public class MatrizEntero extends Arreglo implements OperacionesMatriz{
    private int m;
    int mat[][];
    public MatrizEntero(int n, int m){
        super(n);
        mat= new int[n][m];
        this.m=m;
    }
    @Override
    public void llenadoDatos() {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j]= Leer.leerInt("Ingrese dato entero: ["+i+"] ["+j+"]:\t");
            }
        }
        System.out.println("\tLLENADO COMPLETADO\t");
     }

    @Override
    public void llenadoDatos(int ini, int fin) {
                for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j]= Aleatorio.getDatoInt(ini, fin);
            }
        }
                System.out.println("\tLLENADO COMPLETO\t");
    }

    @Override
    public void impDatos(char op) {
        for (int i = 0; i < mat.length; i++) {
            System.out.print("[");
            for (int j = 0; j < mat[i].length; j++) {
                if(j!=0){
                    System.out.print(op);
                }
                System.out.print(mat[i][j]);
            }
            System.out.println("]");
        }
    }

    @Override
    public int getPromedio() {
    int pro=0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                pro+=mat[i][j];
            }
        }
        return pro/=(getN()*getM());
    }

    @Override
    public int getDato(int fila, int columna) {
    return mat[fila][columna];
    }

    @Override
    public int getDatoMayor() {
        int aux=mat[0][0];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(aux<mat[i][j]){
                    aux=mat[i][j];
                }
            }
        }
        return aux;
    }

    @Override
    public int getDatoMenor() {
        int aux=mat[0][0];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(aux>mat[i][j]){
                    aux=mat[i][j];
                }
            }
 
        }
    return aux;
}


    @Override
    public void eliminarDato() {
        
    }
    protected void setM(int m){
        this.m=m;
    }
    public int getM(){
        return m;
    }

    @Override
    public void añadirFila(int nvoDatos[]) {
        int aux[][] = new int [getN()+1][getM()];
        for (int i = 0; i < mat.length; i++) {
            System.arraycopy(mat[i], 0, aux[i], 0, getM());
        }
        System.arraycopy(nvoDatos, 0, aux[getN()], 0, getM());
        mat=aux;
        setN(getN()+1);
        System.out.println("\tFILA AÑADIDA\t");
            }

    @Override
    public void añadirColumna(int nvoDatos[]) {
        int aux[][]= new int [getN()][getM()+1];
        for (int i = 0; i < mat.length; i++) {
            System.arraycopy(mat[i], 0, aux[i], 0, getM());
            aux[i][getM()]= nvoDatos[i];
        }
        mat=aux;
        setM(getM()+1);
        System.out.println("\tCOLUMNA AÑADIDA\t");
    }

    @Override
    public void eliminarFila() {
        if(getN()<=0){
            setM(0);
            System.out.println("Ya no se pueden eliminar los elementos");
        } else{
    int aux[][]= new int[getN()-1][getM()];
        for (int i = 0; i < mat.length-1; i++) {
            System.arraycopy(mat[i], 0, aux[i], 0, getM());
        }
        mat=aux;
        setN(getN()-1);
        System.out.println("FILA ELIMINADA");
        }}

    @Override
    public void eliminarColumna() {
        if(getM()<=0){
            setN(0);
            System.out.println("Ya no se pueden eliminar los elementos");
        }else{
        int aux[][]= new int [getN()][getM()-1];
        for (int i = 0; i < mat.length; i++) {
            System.arraycopy(mat[i], 0, aux[i], 0, getM()-1);
        }
        mat=aux;
        setM(getM()-1);
        System.out.println("COLUMNA ELIMINADA ");
    }}

    @Override
    public int longitudMatriz() {
    return mat.length;
    }

    @Override
    public void posicionDatoM(int dato) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j]==dato){
                    System.out.println("El dato "+dato+" esta en la posicion ["+i+"] ["+j+"]");
                }
            }
        }
    }

}
