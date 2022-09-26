package Clases;

import java.io.Serializable;

public class Cliente implements Serializable{

    private String id;
    private String nombre;
    private int edad;
    private int noTelefono;
    private String sexo;
    private float graduacion;
    private String idLente;
    
    public Cliente(){
        
    }
    
    public String getInformacion()
    {
        String aux = "";
        aux += "---- P E D I D O ----\n";
        aux += "ID del cliente:\t" + getId() + "\n";
        aux += "Graduacion :\t" + getGraduacion() + "\n";
        aux += "ID del modelo del lente elegido:\t" + getId() + "\n";
        aux += "*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/";
        return aux;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNoTelefono() {
        return noTelefono;
    }

    public void setNoTelefono(int noTelefono) {
        this.noTelefono = noTelefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the graduacion
     */
    public float getGraduacion() {
        return graduacion;
    }

    /**
     * @param graduacion the graduacion to set
     */
    public void setGraduacion(float graduacion) {
        this.graduacion = graduacion;
    }

    /**
     * @return the idLente
     */
    public String getIdLente() {
        return idLente;
    }

    /**
     * @param idLente the idLente to set
     */
    public void setIdLente(String idLente) {
        this.idLente = idLente;
    }

}
