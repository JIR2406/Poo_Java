package Main;

import SubClase.ValorPi;
import java.util.InputMismatchException;
import leer.Leer;

public class Main {

    public static void main(String[] args) {
        int n = 0;
        int pos;
        char op, os;
        do {
            try {
                n = Leer.leerInt("Ingrese el tamaño del vector PI:\t");

            } catch (InputMismatchException ime) {
                ime.getMessage();
                System.out.println("Error tipo de dato - intente de nuevo");
            } finally {
                Leer.cleanBuffer();
            }
        } while (n <= 0);
        ValorPi vpi = new ValorPi(n);
        do {
            pos = -1;
            System.out.println("==Menu==\n"
                    + "a) Obtener valor de pi aproximado\n"
                    + "b) Obtener valor de pi hasta un tope de posición\n"
                    + "c) Desplegar serie de pi aproximado\n"
                    + "d) Desplegar serie de pi aproximado hasta un tope de posicion\n"
                    + "e) Añadir un valor de cálculo\n"
                    + "f) Eliminar un valor de cálculo\n"
                    + "s) Salir");
            op = Leer.leerChar("Ingrese una opcion:\t");

            switch (op) {

                case 'a':
                case 'A':
                    System.out.println("El valor de PI aproximado es:\t" + vpi.getPi());
                    if (vpi.getLongitud() == 0) {
                        System.out.println("Añade un calculo");
                    }
                    break;
                case 'b':
                case 'B':
                    if (vpi.getLongitud() == 0) {
                        System.out.println("No hay calculos a mostrar, añade un calculo");
                        break;
                    }
                    do {
                        pos = Leer.leerInt("Ingresa el tope de posicion en un rango de 0 - " + (vpi.getLongitud() - 1) + ":\t");
                    } while (pos < 0 || pos >= vpi.getLongitud());
                    System.out.println("El valor de PI aproximado hasta la posicion " + pos + " es:\t" + vpi.getPi(pos));
                    break;
                case 'c':
                case 'C':
                    if (vpi.getLongitud() == 0) {
                        System.out.println("No hay datos en la serie - añade datos");
                        break;
                    }
                    System.out.println(vpi.getSeriePi());
                    break;
                case 'd':
                case 'D':
                    if (vpi.getLongitud() == 0) {
                        System.out.println("No hay datos en la serie - añade datos");
                        break;
                    }
                    do {
                        pos = Leer.leerInt("Ingresa el tope de posicion en un rango de 0 - " + (vpi.getLongitud() - 1) + ":\t");
                    } while (pos < 0 || pos >= vpi.getLongitud());
                    System.out.println(vpi.getSeriePi(pos));
                    break;
                case 'e':
                case 'E':
                    if (vpi.getLongitud() == 0) {
                        System.out.println("El vector PI tiene una longitud de 0 elementos");
                        System.out.println("Deseas añadir nuevos elementos S/N");
                        os = Leer.leerChar("Ingresa opcion:\t");
                        if (os == 's' || os == 'S') {
                            do {
                                n = Leer.leerInt("Ingrese el tamaño del vector PI:\t");
                            } while (n <= 0);
                            vpi = new ValorPi(n);
                            System.out.println("Tamaño de vector modificado");
                        } else {
                            System.out.println("Saliendo de añadir valor de calculo");
                        }
                    } else {
                        vpi.añadirCalculo();
                    }
                    break;
                case 'f':
                case 'F':
                    if (vpi.getLongitud() == 0) {
                        System.out.println("No hay calculos a eliminar - añade un calculo");
                        break;
                    }
                    vpi.eliminarCalculo();
                    break;
                case 's':
                case 'S':
                    break;
                default:
                    System.out.println("OPCIÓN INCORRECTA");
                    break;
            }
        } while (!(op == 's' || op == 'S'));
    }
}
