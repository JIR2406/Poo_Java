
package Interfaces;


public interface OperacionesVector {
    public char getPromedio();
    public char getDato(int pos);
    public char getDatoMayor();
    public char getDatoMenor();
    public void anadirDato(char nvoDato);
    public void eliminarDato();
    public int  longitudVector();
    public void posicionDato(char dato);
}
