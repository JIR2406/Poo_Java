package Archivos;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import leer.Leer;

public class Archivos {

    File archivo = new File("Quejas.txt");

    public void archivoTexto(boolean adjuntar) {
        {

            try {
                boolean crearArchivo = archivo.createNewFile();
                String queja;
                Scanner leer = new Scanner(System.in);
                FileWriter archivoTexto = new FileWriter(archivo, adjuntar);

                System.out.println("Ingrese queja y/o sugerencias, para salir teclee '*'");
                do {
                    queja = leer.nextLine();
                    if (!queja.equals("*")) {
                        archivoTexto.write(queja + "\n");
                    }
                } while (!queja.equals("*"));
                archivoTexto.close();
                if (crearArchivo) {
                    System.out.println("Archivo de texto creado");
                } 
            } catch (IOException ex) {
                System.out.println("Error al crear archivo: " + ex);
            }
        }

    }

    public void sobreEscrituraQuejas(String data[], boolean adjuntar) throws FileNotFoundException, IOException {
        FileWriter archivoTexto = new FileWriter(archivo, adjuntar);
        for (int i = 0; i < data.length; i++) {
            archivoTexto.write(data[i] + "*");
        }
        archivoTexto.close();
    }

    public void leerQuejas() throws IOException {
        FileReader mostrarQuejas = new FileReader(archivo);
        Scanner leer = new Scanner(mostrarQuejas);
        while (leer.hasNextLine()) {
            System.out.println(leer.nextLine());
        }
        mostrarQuejas.close();
    }

    public boolean existeArchivo() {
        return archivo.exists();
    }

    public void usoArchivo() {
        char op = '\0';
        boolean adjuntar = true;
        boolean bandera;
        try {
            do {
                try {
                    bandera = existeArchivo();
                    System.out.println("Elija una opción");
                    System.out.println("e) Escribir quejas y/o sugerencias");
                    if (bandera) {
                        System.out.println("m) Mostrar quejas y/o sugerencias escritas");
                    }
                    System.out.println("r) Regresar");
                    op = Leer.leerChar("Ingrese opción:\t");
                    switch (op) {
                        case 'e':
                        case 'E':
                            if (bandera) {
                                do {
                                    System.out.println("***** OPCIONES *****");
                                    System.out.println("a) Agregar quejas y/o sugerencias");
                                    System.out.println("s) Sobreescribir quejas y/o sugerencias");
                                    op = Leer.leerChar("Ingrese opción:\t");
                                    switch (op) {
                                        case 'a':
                                            adjuntar = true;
                                            break;
                                        case 's':
                                            adjuntar = false;
                                            break;
                                        default:
                                            System.out.println("Dato incorrecto, vuelva a ingresar");
                                            op = '0';
                                            break;
                                    }
                                } while (op == '0');
                            }
                            archivoTexto(adjuntar);
                            break;
                        case 'm':
                        case 'M':
                            if (bandera) {
                                leerQuejas();
                            } else {
                                System.out.println("Dato incorrecto");
                            }
                            break;
                        case 'r':
                        case 'R':
                            break;
                        default:
                            System.out.println("Opción incorrecta");
                            break;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println(ex.getMessage());
                } catch (IOException sioobe) {
                    System.out.println(sioobe.getMessage());
                } finally {
                    Leer.cleanBuffer();
                }
            } while (!(op == 'r' || op == 'R'));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}