package Main;

import Archivos.ArchivoObjeto;
import SubClase.subOptica;
import Archivos.Archivos;
import Clases.Cliente;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import leer.Leer;

public class PrbOptica {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int n = 0;
        int cont = 0;
        float m = 0;
        char inciso;
        float precio = 0;
        String caracteristica;
        char elec = '.';
        long bandera;
        boolean adjuntar = true;
        do {
            System.out.println("==MENU PRINCIPAL==\n"
                    + "a) Articulos\n"
                    + "c) Clientes\n"
                    + "q) Quejas y/o Sugerenias\n"
                    + "r) Registrar pedidos\n"
                    + "s) Salir");
            inciso = Leer.leerChar("Ingrese una opcion:\t");
            switch (inciso) {
                case 'A':
                case 'a':
                    do {
                        try {
                            switch (cont) {
                                case 0:
                                    m = Leer.leerInt("Ingrese numero de lentes a registrar:\t");
                            }
                        } catch (InputMismatchException e) {
                            e.getMessage();
                            System.out.println("Dato incorrecto, vuelva a ingresar");
                        } finally {
                            Leer.cleanBuffer();
                        }
                    } while (m <= 0);

                    subOptica lentes = new subOptica(m);
                    lentes.llenadoLentes();
                    do {
                        System.out.println("|** Elija una opcion **|\n"
                                + "a) Imprimir articulos\n"
                                + "b) Añadir lentes\n"
                                + "c) Eliminar lente por identificador\n"
                                + "d) Eliminar ultimos lentes\n"
                                + "e) Busqueda por caracteristica\n"
                                + "f) Busqueda por precio\n"
                                + "*) Regresar");
                        inciso = Leer.leerChar("Ingrese una opcion:\t");
                        switch (inciso) {
                            case 'a':
                            case 'A':
                                if (lentes.getLongitudLente() == 0) {
                                    System.out.println("No hay lentes para mostrar - agrega lentes");
                                } else {
                                    lentes.impresionLentes();
                                }
                                break;
                            case 'b':
                            case 'B':
                                lentes.añadirLente();
                                break;
                            case 'c':
                            case 'C':
                                caracteristica = Leer.leerString("Ingrese el id a eliminar:\t");
                                lentes.eliminarLente(caracteristica);
                                break;
                            case 'd':
                            case 'D':
                                if (lentes.getLongitudLente() == 0) {
                                    System.out.println("No hay lentes a eliminar");
                                } else {
                                    lentes.eliminarUltimoLente();
                                }
                                break;
                            case 'e':
                            case 'E':
                                caracteristica = Leer.leerString("Ingrese la caracteristica del lente a buscar:\t");
                                lentes.busquedaPorCaracteristica(caracteristica);
                                break;
                            case 'f':
                            case 'F':
                                do {
                                    try {
                                        precio = Leer.leerFloat("Ingrese el precio del lente a buscar:\t");
                                    } catch (InputMismatchException I) {
                                        I.getMessage();
                                        System.out.println("Dato incorrecto, vuelva a ingresar");
                                    } finally {
                                        Leer.cleanBuffer();
                                    }
                                } while (precio <= 0);
                                lentes.busquedaPorPrecio(precio);

                                break;
                        }
                    } while (inciso != '*');
                    break;
                case 'C':
                case 'c':
                    do {
                        try {
                            switch (cont) {
                                case 0:
                                    n = Leer.leerInt("Ingrese numero de clientes a registrar:\t");
                            }
                        } catch (InputMismatchException e) {
                            e.getMessage();
                            System.out.println("Dato incorrecto, vuelva a ingresar");
                        } finally {
                            Leer.cleanBuffer();
                        }
                    } while (n <= 0);
                    do {
                        subOptica clientes = new subOptica(n);
                        clientes.llenadoClientes();
                        clientes.llenadoArchivoCliente();
                        do {
                            System.out.println("|** Elija una opcion **|");
                            System.out.println("a) Imprimir clientes ");
                            System.out.println("b) Eliminar ultimo cliente");
                            System.out.println("c) Eliminar cliente con ID");
                            System.out.println("d) Añadir cliente");
                            System.out.println("e) Imprimir cliente con ID en especifico");
                            System.out.println("f) Ver expedientes guardados");
                            System.out.println("g) Modificar expedientes");
                            System.out.println("*) Regresar");
                            inciso = Leer.leerChar("Ingrese opcion :)\t");
                            switch (inciso) {
                                case 'a':
                                case 'A':
                                    if (clientes.getLongitudCliente() == 0) {
                                        System.out.println("No hay clientes para mostrar - agrega clientes");
                                    } else {
                                        clientes.impresionClientes();
                                    }
                                    break;
                                case 'b':
                                case 'B':
                                    if (clientes.getLongitudCliente() == 0) {
                                        System.out.println("No hay clientes a eliminar");
                                    } else {
                                        clientes.eliminarCliente();
                                    }
                                    break;
                                case 'c':
                                case 'C':
                                    String ID = Leer.leerString("Ingrese ID del cliente a eliminar:\t");
                                    clientes.eliminarCliente(ID);
                                    break;
                                case 'd':
                                case 'D':
                                    try {
                                    clientes.añadirCliente();
                                } catch (ArrayIndexOutOfBoundsException q) {
                                    q.getMessage();
                                } finally {
                                    Leer.cleanBuffer();
                                }
                                break;
                                case 'e':
                                case 'E':
                                    ID = Leer.leerString("Ingrese ID del cliente a buscar:\t");
                                    clientes.consultarCliente(ID);
                                    break;
                                case 'f':
                                case 'F':
                                    clientes.lecturaArchivoClienteE();
                                    break;
                                case 'g':
                                case 'G':
                                    clientes.rellenar();
                                    clientes.sobreescrituraArchivoCliente();
                                    break;
                            }
                        } while (inciso != '*');
                    } while (inciso != '*');
                    break;
                case 'r':
                case 'R':
                    ArchivoObjeto aO = new ArchivoObjeto();
                    String nomArchivo = "RegistrosPedidos.obj";
                    try {
                        do {

                            bandera = new File(nomArchivo).length();
                            if (bandera > 0) {
                                System.out.println("==== Elija opción ====");
                                System.out.println("e) Registrar ventas");
                                System.out.println("m) Mostrar registros de ventas");
                                System.out.println("$) Regresar al menu principal");
                                elec = leer.Leer.leerChar("Ingrese opción:\t");
                                switch (elec) {
                                    case 'e':
                                    case 'E':
                                        do {

                                            System.out.println("==== Elija opción =====");
                                            System.out.println("a) Agregar ventas");
                                            System.out.println("s) Sobreescribir ventas");
                                            elec = leer.Leer.leerChar("Ingrese opción:\t");
                                            switch (elec) {
                                                case 'a':
                                                case 'A':
                                                    adjuntar = true;
                                                    break;
                                                case 's':
                                                case 'S':
                                                    System.out.println("**--** Se borraron todos los registros **--**");
                                                    adjuntar = false;
                                                    break;
                                                default:
                                                    System.out.println("Opción incorrecta");
                                                    elec = '0';
                                                    break;
                                            }
                                        } while (elec == '0');
                                        aO.ArchivoObjeto(nomArchivo, adjuntar);
                                        Cliente c = new Cliente();
                                        switch (cont) {
                                            case 0:
                                                c.setId(leer.Leer.leerString("Ingrese ID del cliente:\t"));
                                                cont++;
                                            case 1:
                                                c.setIdLente(leer.Leer.leerString("Ingrese ID del lente elegido:\t"));
                                                cont++;
                                            case 2:
                                                c.setGraduacion(leer.Leer.leerFloat("Ingrese la graduacion:\t"));
                                                cont++;
                                                System.out.println("**--** Venta Registrada **--**");
                                        }
                                        aO.escrituraRegistros(c);
                                        aO.cerrarEscritura();
                                        cont = 0;

                                        leer.Leer.cleanBuffer();
                                    break;
                                    case 'm':
                                    case 'M':
                                        aO.lecturaRegistros(nomArchivo);
                                        System.out.println("*--------* Registro de pedidos *--------*");
                                            Object objeto;
                                            do {
                                                objeto = aO.leerRegistro();
                                                if (objeto instanceof Cliente) {
                                                    System.out.println(((Cliente) objeto).getInformacion());
                                                }
                                            } while (objeto != null);
                                            aO.cerrarLectura();
                                            break;
                                }
                            } else {
                                try {
                                    aO.ArchivoObjeto(nomArchivo, adjuntar);
                                    Cliente c = new Cliente();
                                    switch (cont) {

                                        case 0:
                                            c.setId(leer.Leer.leerString("Ingrese ID del cliente:\t"));
                                            cont++;
                                        case 1:
                                            c.setIdLente(leer.Leer.leerString("Ingrese ID del lente elegido:\t"));
                                            cont++;
                                        case 2:
                                            c.setGraduacion(leer.Leer.leerFloat("Ingrese la graduacion:\t"));
                                            cont++;
                                            System.out.println("**--** Venta Registrada **--**");

                                    }
                                    aO.escrituraRegistros(c);
                                    aO.cerrarEscritura();
                                    cont = 0;
                                } catch (InputMismatchException ex) {
                                    ex.getMessage();
                                } finally {
                                    leer.Leer.cleanBuffer();
                                }
                            }
                        } while (!(elec == '$'));
                    } catch (IOException ex) {
                        ex.getMessage();
                    } finally {
                        leer.Leer.cleanBuffer();
                    }
                    break;
                case 'q':
                case 'Q':
                    Archivos a = new Archivos();
                    a.usoArchivo();
                    break;
                case 's':
                case 'S':
                    break;
                default:
                    System.out.println("Opcion incorrecta, vuelva a ingresar");
            }
        } while (!(inciso == 's' || inciso == 'S'));
    }
}
