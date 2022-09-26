package Interfaces;

/**
 *
 * @author Nancy
 */
public interface OperacionOptica {

    public void añadirCliente();

    public void eliminarCliente();

    public void consultarCliente(String ID);

    public void eliminarCliente(String ID);
    
    public void eliminarLente(String id);
    
    public void eliminarUltimoLente();
    
    public void añadirLente();
    
    public void busquedaPorCaracteristica(String caracteristica);
    
    public void busquedaPorPrecio(float precio);
}
