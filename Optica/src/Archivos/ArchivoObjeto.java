package Archivos;
import java.io.*;

/**
 *
 * @author Nancy
 */
public class ArchivoObjeto {

    File archivo;
    ObjectOutputStream oOS;
    ObjectInputStream oIS;

    public void ArchivoObjeto(String nomArchivo, boolean adjuntar) throws IOException {
        nomArchivo = "RegistrosPedidos.obj";
        archivo = new File(nomArchivo);
        if (!adjuntar || archivo.length() == 0) {
            oOS = new ObjectOutputStream(new FileOutputStream(archivo, adjuntar));
        } else {
            oOS = new ObjectOutputStream(new FileOutputStream(archivo, adjuntar)) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            };
        }
    }

    public void escrituraRegistros(Object registro) throws IOException {
        oOS.writeObject(registro);
    }

    public void lecturaRegistros(String nomArchivo) throws IOException {
        archivo = new File(nomArchivo);
        oIS = new ObjectInputStream(new FileInputStream(archivo));
    }

    public Object leerRegistro() throws IOException, ClassNotFoundException {
        return oIS.readObject();
    }

    public void cerrarLectura() throws IOException {
        oIS.close();
    }

    public void cerrarEscritura() throws IOException {
        oOS.close();
    }

}
