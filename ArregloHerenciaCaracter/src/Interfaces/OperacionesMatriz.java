
package Interfaces;


public interface OperacionesMatriz {
    public char getPromedio();
    public char getDato(int fila, int columna);
    public char getDatoMayor();
    public char getDatoMenor();
    public void añadirFila(char nvoDatos[]);
    public void añadirColumna(char nvoDatos[]);
    public void eliminarFila();
    public void eliminarColumna();
    public int longitudMatriz();
    public void posicionDatoM(char dato);
}
