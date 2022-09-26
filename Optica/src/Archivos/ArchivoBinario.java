package Archivos;

import Binario.ArchivoDatosEscritura;
import Binario.ArchivoDatosLectura;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import leer.Leer;

public class ArchivoBinario {

    private String nom;
    protected ArchivoDatosLectura archivoLectura;
    protected ArchivoDatosEscritura archivoEscritura;

    public void escrituraDatos(boolean adjuntar, String nomAr, String nombre, int edad, String sexo, int noTelfono, String id) throws IOException {
        int cont = 0;
        String auxString;
        int auxInt;
        archivoEscritura = new ArchivoDatosEscritura(nomAr, adjuntar);
        auxString = nombre;
        archivoEscritura.escrituraString(auxString);
        auxInt = edad;
        archivoEscritura.escrituraInt(auxInt);
        auxString = sexo;
        archivoEscritura.escrituraString(auxString);
        auxInt = noTelfono;
        archivoEscritura.escrituraInt(auxInt);
        auxString = id;
        archivoEscritura.escrituraString(auxString);
        cont = 0;
        archivoEscritura.cerrarArchivo();
    }

    public void lecturaDatos(boolean adjuntar, String nom) throws IOException {

        archivoLectura = new ArchivoDatosLectura(nom);
        System.out.println("Datos dentro del archivo binario");
        while (archivoLectura.getDisponibilidad() > 0) {
            System.out.println("Nombre = " + archivoLectura.leerString());
            System.out.println("Edad = " + archivoLectura.leerInt());
            System.out.println("Sexo = " + archivoLectura.leerString());
            System.out.println("No.Telefono = " + archivoLectura.leerInt());
            System.out.println("Id = " + archivoLectura.leerString());
            System.out.println("============");
        }
        archivoLectura.cerrarArchivo();
    }
}
