package Main;

import SubClase.MatrizReal;
import leer.Leer;

public class PrbIntercambioArreglo {

    public static void main(String[] args) {
        char op;
        int n, m;
        int ini, fin;
        do {
            n = Leer.leerInt("Ingrese tamaño de las filas:\t");
        } while (n <= 0);
        do {
            m = Leer.leerInt("Ingrese tamaño de las columnas:\t");
        } while (m <= 0);
        MatrizReal mat = new MatrizReal(n, m);
        do {
            System.out.println("==MENU==\n"
                    + "1) Llenado de datos\n"
                    + "2) Imprimir\n"
                    + "3) Intercambio filas\n"
                    + "4) Intercambio columnas\n"
                    + "5) Salir");
            op = Leer.leerChar("Ingrese opcion:\t");
            switch (op) {
                case '1':
                    System.out.println("==MENU LLENADO==\n"
                            + "a) Aleatorio\n"
                            + "u) Usuario");
                    op = Leer.leerChar("Ingresa opcion:\t");
                    switch (op) {
                        case 'a':
                        case 'A':
                            mat.llenadoDatos(0, 100);
                            break;
                        case 'b':
                        case 'B':
                            mat.llenadoDatos();
                            break;
                    }
                    break;
                case '2':
                    op = Leer.leerChar("Ingresa el separador:\t");
                    mat.impDatos(op);
                    break;
                case '3':
                    do {
                        ini = Leer.leerInt("Dame la fila #1 en un rango de (0 -" + (mat.getN() - 1) + "):\t");
                    } while (ini < 0 || ini >= mat.getN());
                    do {
                        fin = Leer.leerInt("Dame la fila #2 en un rango de (0 - " + (mat.getN() - 1) + "):\t");

                        if (ini == fin) {
                            System.out.println("Dato incorrecto, no se puede intercambiar la misma fila - vuelva a ingresar");
                        }
                    } while (fin < 0 || fin >= mat.getN() || fin == ini);
                    mat.intercambioFila(ini, fin);
                    break;
                case '4':
                    do {
                        ini = Leer.leerInt("Dame la columna #1 en un rango de (0 -" + (mat.getM() - 1) + ":)\t");
                    } while (ini < 0 || ini >= mat.getM());
                    do {
                        fin = Leer.leerInt("Dame la columna #2 en un rango de (0 - " + (mat.getM() - 1) + "):\t");
                        if (ini == fin) {
                            System.out.println("Dato incorrecto, no se puede intercambiar la misma columna - vuelva a ingresar");
                        }
                    } while (fin < 0 || fin >= mat.getM() || fin == ini);
                    mat.intercambioColumna(ini, fin);
                    break;
                case '5':
                    op = '0';
                    break;
            }
        } while (op != '0');
    }
}
