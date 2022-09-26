package Main;

import SubClase.*;
import leer.Leer;

public class PrbArregloHerenciaCaracter {

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
                    VectorCaracter ve = new VectorCaracter(n);
                    do {
                        System.out.println("Elija llenado del vector\n"
                                + "A) Aleatorio\n"
                                + "U) Usuario");
                        menu = Leer.leerChar("Ingrese opcion: \t");
                        switch (menu) {
                            case 'a':
                            case 'A':
                                ve.llenadoDatos(0, 255);
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
                                + "J) Obtener longitud del vector\n"
                                + "R) Regresar");
                        menu = Leer.leerChar("Ingrese opcion:\t");
                        switch (menu) {
                            case 'a':
                            case 'A':
                                if (ve.getN() == 0) {
                                    System.out.println("EL VECTOR NO TIENE UN RANGO");
                                    do {
                                        n = Leer.leerInt("Ingrese tamaño del vector:\t");
                                    } while (n <= 0);
                                    ve = new VectorCaracter(n);
                                }
                                do {
                                    System.out.println("Elija llenado del vector\n"
                                            + "A) Aleatorio\n"
                                            + "U) Usuario");
                                    menu = Leer.leerChar("Ingrese opcion: \t");
                                    switch (menu) {
                                        case 'a':
                                        case 'A':
                                            ve.llenadoDatos(0, 255);
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
                                if (ve.getN() == 0) {
                                    System.out.println("No hay datos para obtener - rellene el vector");
                                    break;
                                }
                                int pos;
                                do {
                                    pos = Leer.leerInt("Ingrese posicion de dato (0 - " + (ve.getN() - 1) + "):\t");
                                } while (pos < 0 || pos >= ve.getN());
                                System.out.println("El dato en [" + pos + "] = " + ve.getDato(pos));
                                break;

                            case 'd':
                            case 'D':
                                if (ve.getN() == 0) {
                                    System.out.println("No hay datos a comparar - rellene el vector");
                                    break;
                                }
                                System.out.println("El dato mayor es = " + ve.getDatoMayor());
                                break;

                            case 'e':
                            case 'E':
                                if (ve.getN() == 0) {
                                    System.out.println("No hay datos a comparar - rellene el vector");
                                    break;
                                }
                                System.out.println("El dato menor es = " + ve.getDatoMenor());
                                break;

                            case 'f':
                            case 'F':
                                if (ve.getN() == 0) {
                                    System.out.println("No hay datos a promediar - rellene el vector");
                                    break;
                                }
                                System.out.println("El promedio es:\t" + ve.getPromedio());
                                break;
                            case 'g':
                            case 'G':
                                if (ve.getN() == 0) {
                                    ve = new VectorCaracter(1);
                                }
                                char nvoDato = Leer.leerChar("Ingrese nuevo dato:\t");
                                ve.anadirDato(nvoDato);
                                break;
                            case 'h':
                            case 'H':
                                ve.eliminarDato();
                                break;
                            case 'i':
                            case 'I':
                                if (ve.getN() == 0) {
                                    System.out.println("No hay datos a buscar - rellene la matriz");
                                    break;
                                }
                                char dato = Leer.leerChar("Ingrese el dato:\t");
                                ve.posicionDato(dato);
                                break;
                            case 'J':
                            case 'j':
                                if (ve.getN() == 0) {
                                    System.out.println("No hay datos a eliminar");
                                    break;
                                }
                                System.out.println("La longitud del vector es: " + ve.longitudVector());
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
                    MatrizCaracter mat = new MatrizCaracter(n, m);
                    do {
                        System.out.println("Elija llenado del vector\n"
                                + "A) Aleatorio\n"
                                + "U) Usuario");
                        menu = Leer.leerChar("Ingrese opcion: \t");
                        switch (menu) {
                            case 'a':
                            case 'A':
                                mat.llenadoDatos(0, 255);
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
                        char[] nvoDatos;
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
                                    mat = new MatrizCaracter(n, m);
                                }
                                do {
                                    System.out.println("Elija llenado del vector\n"
                                            + "A) Aleatorio\n"
                                            + "U) Usuario");
                                    menu = Leer.leerChar("Ingrese opcion: \t");
                                    switch (menu) {
                                        case 'a':
                                        case 'A':
                                            mat.llenadoDatos(0, 255);
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
                                    mat = new MatrizCaracter(1, 1);
                                }
                                nvoDatos = new char[mat.getM()];
                                for (int j = 0; j < nvoDatos.length; j++) {
                                    nvoDatos[j] = Leer.leerChar("Ingrese nuevo dato " + j + ":\t");
                                }
                                mat.añadirFila(nvoDatos);
                                break;
                            case 'h':
                            case 'H':
                                if (mat.getN() == 0) {
                                    mat = new MatrizCaracter(1, 1);
                                }
                                nvoDatos = new char[mat.getN()];
                                for (int j = 0; j < nvoDatos.length; j++) {
                                    nvoDatos[j] = Leer.leerChar("Ingrese nuevo dato " + j + ":\t");
                                }
                                mat.añadirColumna(nvoDatos);
                                break;
                            case 'i':
                            case 'I':
                                if (mat.getN() == 0 && mat.getM() == 0) {
                                    System.out.println("No hay datos a eliminar");
                                    break;
                                }
                                mat.eliminarFila();
                            case 'j':
                            case 'J':
                                if (mat.getN() == 0 && mat.getM() == 0) {
                                    System.out.println("No hay datos a eliminar");
                                    break;
                                }
                                mat.eliminarColumna();
                                break;
                            case 'k':
                            case 'K':
                                char datos;
                                if (mat.getN() == 0 && mat.getM() == 0) {
                                    System.out.println("No hay datos - rellena la matriz");
                                    break;
                                }
                                datos = Leer.leerChar("Ingresa el dato a buscar:\t");
                                mat.posicionDatoM(datos);
                                break;
                            case 'L':
                            case 'l':
                                System.out.println("La longitud de la matriz es: " + mat.longitudMatriz());
                                break;
                        }
                    } while (!(menu == 'r' || menu == 'R'));
                    break;
            }
        } while (!(menu == 's' || menu == 'S'));
    }
}
