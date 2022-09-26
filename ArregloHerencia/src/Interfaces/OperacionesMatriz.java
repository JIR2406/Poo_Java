
package Interfaces;


public interface OperacionesMatriz {
    public int getPromedio();
    public int getDato(int fila, int columna);
    public int getDatoMayor();
    public int getDatoMenor();
    public void añadirFila(int nvoDatos[]);
    public void añadirColumna(int nvoDatos[]);
    public void eliminarFila();
    public void eliminarColumna();
    public void eliminarDato();
    public int longitudMatriz();
    public void posicionDatoM(int dato);
}
