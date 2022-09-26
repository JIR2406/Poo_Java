package Clases;
import java.io.Serializable;

public class Lentes implements Serializable{

    private String tipo;
    private String modelo;
    private String color;
    private String id;
    private float graduacion;
    private float costo;
    public Lentes() {

    }
    public String getInformacion()
    {
        String aux = "";
        aux += "ID del Lente:\t" + getId() + "\n";
        return aux;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getGraduacion() {
        return graduacion;
    }

    public void setGraduacion(float graduacion) {
        this.graduacion = graduacion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}
