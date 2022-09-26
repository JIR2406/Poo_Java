package Main;

import SubClase.MatrizEntero;
import SubClase.VectorEntero;
import leer.Leer;

public class PrbArreglo {

    public static void main(String[] args) {
        int n, m;
        char op, menu;
        do {
            System.out.println("Elija un tipo de arreglo\n"
                    + "v) Vector\n"
                    + "m) Matriz\n"
                    + "s) Salir");
            menu = Leer.leerChar("Ingrese opcion: \t");
            switch (menu) {
                case 'v':
                case 'V':
                    do {
                        n = Leer.leerInt("Ingrese tamaño del vector:\t");
                    } while (n <= 0);
                    VectorEntero ve = new VectorEntero(n);
                    do {
                        System.out.println("Elija llenado del vector\n"
                                + "A) Aleatorio\n"
                                + "U) Usuario");
                        menu = Leer.leerChar("Ingrese opcion: \t");
                        switch (menu) {
                            case 'a':
                            case 'A':
                                ve.llenadoDatos(0, 99);
                                break;
                            case 'u':
                            case 'U':
                                ve.llenadoDatos();
                                break;
                            default:
                                menu = '0';
                        }
                    } while (menu == '0');
                    do {
                        System.out.println("Elija opcion de vector\n"
                                + "A) Rellenar vector\n"
                                + "B) Imprimir vector\n"
                                + "C) Obtener dato de posicion\n"
                                + "D) Obtener dato mayor de vector\n"
                                + "E) Obtener dato menor de vector\n"
                                + "F) Obtener promedio\n"
                                + "G) Añadir dato a vector\n"
                                + "H) Eliminar dato de vector\n"
                                + "I) Obtener posicion de un dato\n"
                                + "J) Obtener longitud del vector"
                                + "R) Regresar");
                        menu = Leer.leerChar("Ingrese opcion:\t");
                        switch (menu) {
                            case 'a':
                            case 'A':
                                do {
                                    System.out.println("Elija llenado del vector\n"
                                            + "A) Aleatorio\n"
                                            + "U) Usuario");
                                    menu = Leer.leerChar("Ingrese opcion: \t");
                                    switch (menu) {
                                        case 'a':
                                        case 'A':
                                            ve.llenadoDatos(0, 99);
                                            break;
                                        case 'u':
                                        case 'U':
                                            ve.llenadoDatos();
                                            break;
                                        default:
                                            menu = '0';
                                    }
                                } while (menu == '0');
                                break;
                            case 'b':
                            case 'B':
                                op = Leer.leerChar("Ingrese separador de datos:\t");
                                ve.impDatos(op);
                                break;
                            case 'c':
                            case 'C':
                                int pos;
                                do {
                                    pos = Leer.leerInt("Ingrese posicion de dato (0 - " + (ve.getN() - 1) + "):\t");
                                } while (pos < 0 || pos > ve.getN());
                                System.out.println("El dato en [" + pos + "] = " + ve.getDato(pos));
                                break;

                            case 'd':
                            case 'D':
                                System.out.println("El dato mayor es = " + ve.getDatoMayor());
                                break;

                            case 'e':
                            case 'E':
                                System.out.println("El dato menor es = " + ve.getDatoMenor());
                                break;

                            case 'f':
                            case 'F':
                                System.out.println("El promedio es:\t" + ve.getPromedio());
                                break;
                            case 'g':
                            case 'G':
                                int nvoDato = Leer.leerInt("Ingrese nuevo dato:\t");
                                ve.anadirDato(nvoDato);
                                break;
                            case 'h':
                            case 'H':
                                ve.eliminarDato();
                                break;
                            case 'i':
                            case 'I':
                                ve.eliminarDato();
                                break;
                            case 'J':
                            case 'j':
                                ve.eliminarDato();
                                break;
                        }
                    } while (!(menu == 'r' || menu == 'R'));
                    break;
                case 'm':
                case 'M':
                    do {
                        n = Leer.leerInt("Ingrese tamaño de las filas:\t");
                    } while (n <= 0);
                    do {
                        m = Leer.leerInt("Ingrese tamaño de las columnas:\t");
                    } while (m <= 0);
                    MatrizEntero mat = new MatrizEntero(n, m);
                    do {
                        System.out.println("Elija llenado del vector\n"
                                + "A) Aleatorio\n"
                                + "U) Usuario");
                        menu = Leer.leerChar("Ingrese opcion: \t");
                        switch (menu) {
                            case 'a':
                            case 'A':
                                mat.llenadoDatos(0, 99);
                                break;
                            case 'u':
                            case 'U':
                                mat.llenadoDatos();
                                break;
                            default:
                                menu = '0';
                        }
                    } while (menu == '0');
                    do {
                        int[] nvoDatos;
                        System.out.println("Elija opcion de vector\n"
                                + "A) Rellenar matriz\n"
                                + "B) Imprimir matriz\n"
                                + "C) Obtener dato de fila y columna\n"
                                + "D) Obtener dato mayor de matriz\n"
                                + "E) Obtener dato menor de matriz\n"
                                + "F) Obtener promedio\n"
                                + "G) Añadir fila a matriz\n"
                                + "H) Añadir columna a matriz\n"
                                + "I) Eliminar fila a matriz\n"
                                + "J) Eliminar columna de matriz\n"
                                + "K) Obtener posicion de un dato\n"
                                + "L) Obtener longitud de la matriz\n"
                                + "R) Regresar");
                        menu = Leer.leerChar("Ingrese opcion:\t");
                        switch (menu) {
                            case 'a':
                            case 'A':
                                if (mat.getN() <= 0 && mat.getM() <= 0) {
                                    System.out.println("LA MATRIZ NO TIENE FILAS NI COLUMNAS");
                                    do {
                                        n = Leer.leerInt("Ingrese tamaño de las filas:\t");
                                    } while (n <= 0);
                                    do {
                                        m = Leer.leerInt("Ingrese tamaño de las columnas:\t");
                                    } while (m <= 0);
                                    mat = new MatrizEntero(n, m);
                                }
                                do {
                                    System.out.println("Elija llenado del vector\n"
                                            + "A) Aleatorio\n"
                                            + "U) Usuario");
                                    menu = Leer.leerChar("Ingrese opcion: \t");
                                    switch (menu) {
                                        case 'a':
                                        case 'A':
                                            mat.llenadoDatos(0, 99);
                                            break;
                                        case 'u':
                                        case 'U':
                                            mat.llenadoDatos();
                                            break;
                                        default:
                                            menu = '0';
                                    }
                                } while (menu == '0');
                                break;
                            case 'b':
                            case 'B':
                                op = Leer.leerChar("Ingrese separador de datos:\t");
                                mat.impDatos(op);
                                break;
                            case 'c':
                            case 'C':
                                if (mat.getN() == 0 && mat.getM() == 0) {
                                    System.out.println("No hay datos para obtener - rellene la matriz");
                                    break;
                                }
                                int fila,
                                 columna;
                                do {
                                    fila = Leer.leerInt("Ingrese posicion de la fila (0 - " + (mat.getN() - 1) + "):\t");
                                } while (fila < 0 || fila > mat.getN());
                                do {
                                    columna = Leer.leerInt("Ingrese posicion de la columna (0 - " + (mat.getM() - 1) + "):\t");
                                } while (columna < 0 || fila > mat.getM());
                                System.out.println("El dato en [" + fila + "] [" + columna + "] = " + mat.getDato(fila, columna));
                                break;
                            case 'd':
                            case 'D':
                                if (mat.getN() == 0 && mat.getM() == 0) {
                                    System.out.println("No hay datos a comparar - rellene la matriz");
                                    break;
                                }
                                System.out.println("El dato mayor es = " + mat.getDatoMayor());
                                break;
                            case 'e':
                            case 'E':
                                if (mat.getN() == 0 && mat.getM() == 0) {
                                    System.out.println("No hay datos a comparar - rellene la matriz");
                                    break;
                                }
                                System.out.println("El dato menor es = " + mat.getDatoMenor());
                                break;
                            case 'f':
                            case 'F':
                                if (mat.getN() == 0 && mat.getM() == 0) {
                                    System.out.println("No hay datos a promediar - rellene la matriz");
                                    break;
                                }
                                System.out.println("El promedio de los elementos es:\t" + mat.getPromedio());
                                break;
                            case 'g':
                            case 'G':
                                if (mat.getM() == 0) {
                                    mat = new MatrizEntero(1, 1);
                                }
                                nvoDatos = new int[mat.getM()];
                                for (int j = 0; j < nvoDatos.length; j++) {
                                    nvoDatos[j] = Leer.leerInt("Ingrese nuevo dato " + j + ":\t");
                                }
                                mat.añadirFila(nvoDatos);
                                break;
                            case 'h':
                            case 'H':
                                if (mat.getN() == 0) {
                                    mat = new MatrizEntero(1, 1);
                                }
                                nvoDatos = new int[mat.getN()];
                                for (int j = 0; j < nvoDatos.length; j++) {
                                    nvoDatos[j] = Leer.leerInt("Ingrese nuevo dato " + j + ":\t");
                                }
                                mat.añadirColumna(nvoDatos);
                                break;
                            case 'i':
                            case 'I':
                                int dato=Leer.leerInt("Ingrese el dato a buscar:\t");
                                mat.posicionDatoM(dato);
                                break;
                            case 'j':
                            case 'J':
                                mat.eliminarColumna();
                                break;
                        }
                    } while (!(menu == 'r' || menu == 'R'));
                    break;
            }
        } while (!(menu == 's' || menu == 'S'));
    }
}
