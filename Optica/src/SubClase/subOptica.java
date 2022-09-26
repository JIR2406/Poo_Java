package SubClase;

import Archivos.ArchivoBinario;
import Clases.*;
import Interfaces.OperacionOptica;
import SuperClase.Optica;
import leer.Leer;
import java.io.*;
import java.util.*;

public class subOptica extends Optica implements OperacionOptica, Serializable {

    private static int longitud;
    ArchivoBinario bin = new ArchivoBinario();
    

    public subOptica(int n) {
        super(n);
    }

    public subOptica(float m) {
        super(m);
    }

    public boolean comprobarNombre(String nombre) {
        int aux = -1;
        boolean a = true;
        for (int i = 0; i < super.cl.length; i++) {
            if (nombre.equals(super.cl[i].getNombre())) {
                aux = 0;
            }
        }
        if (aux == 0) {
            System.out.println("Nombre [" + nombre + "] ya registrado, intenta de nuevo");
            return a = true;
        } else if (aux == -1) {
            return a = false;
        }
        return a;
    }

    public boolean comprobarId(String id) {
        int aux = -1;
        boolean a = true;
        for (int i = 0; i < super.cl.length; i++) {
            if (id.equals(super.cl[i].getId())) {
                aux = 0;
            }
        }
        if (aux == 0) {
            System.out.println("Identificador [" + id + "] ya registrado, intenta de nuevo");
            return a = true;
        } else if (aux == -1) {
            return a = false;
        }
        return a;
    }

    public boolean comprobarIdLentes(String id) {
        int aux = -1;
        boolean a = true;
        for (int i = 0; i < super.len.length; i++) {
            if (id.equals(super.len[i].getId())) {
                aux = 0;
            }
        }
        if (aux == 0) {
            System.out.println("Identificador [" + id + "] ya registrado, intenta de nuevo");
            return a = true;
        } else if (aux == -1) {
            return a = false;
        }
        return a;
    }

    public String selectorSexo() {
        String sexo = "";
        String op;
        do {
            System.out.println("==MENU==\n"
                    + "M) Masculino\n"
                    + "F) Femenino\n"
                    + "O) Otro");
            op = Leer.leerString("Ingrese el sexo del cliente:\t").toLowerCase();
            switch (op) {
                case "m":
                case "masculino":
                    sexo = "Masculino";
                    break;
                case "f":
                case "femenino":
                    sexo = "Femenino";
                    break;
                case "o":
                case "otro":
                    sexo = "Otro";
                    break;
                default:
                    System.out.println("Dato incorrecto, vuelva a ingresar");
                    op = "0";
            }
        } while (op == "0");
        return sexo;
    }

    private void llenadoVacio() {
        for (int i = 0; i < super.cl.length; i++) {
            super.cl[i] = new Cliente();
            super.cl[i].setNombre("");
            super.cl[i].setId("");
        }
    }

    private void llenadoVacioLentes() {
        for (int i = 0; i < super.len.length; i++) {
            super.len[i] = new Lentes();
            super.len[i].setId("");
        }
    }

    @Override
    public void llenadoClientes() {
        llenadoVacio();
        String nombre, id;
        int cont = 0;

        for (int i = 0; i < super.cl.length; i++) {
            if (cont >= 5 && i != 0) {
                cont = 0;
            }
            do {
                try {
                    switch (cont) {
                        case 0:
                            System.out.println("==LLENADO CLIENTE #" + (i + 1) + "==");
                            do {
                                nombre = Leer.leerString("Ingrese el nombre del cliente:\t");
                            } while (comprobarNombre(nombre));
                            super.cl[i].setNombre(nombre);
                            cont++;

                        case 1:
                            super.cl[i].setEdad(Leer.leerInt("Ingrese la edad del cliente:\t"));
                            if (super.cl[i].getEdad() <= 0) {
                                throw new InputMismatchException("El dato ingresado es incorrecto");
                            }

                            cont++;
                        case 2:
                            super.cl[i].setNoTelefono(Leer.leerInt("Ingrese el numero de telefono del cliente:\t"));
                            if (super.cl[i].getNoTelefono() <= 0) {
                                throw new InputMismatchException("El dato ingresado es incorrecto");
                            }

                            cont++;
                        case 3:
                            super.cl[i].setSexo(selectorSexo());
                            cont++;

                        case 4:
                            do {
                                id = Leer.leerString("Ingrese el identificador del cliente:\t");
                            } while (comprobarId(id));
                            super.cl[i].setId(id);
                            cont++;
                    }
                } catch (InputMismatchException e) {
                    e.getMessage();
                    System.out.println("Dato invalido, vuelve a ingresar");
                } finally {
                    Leer.cleanBuffer();
                }
            } while (cont <= 4);
        }

    }

    public String getData(int n) {
        String data = "";
        data += super.cl[n].getNombre() + "\n";
        data += super.cl[n].getEdad() + "\n";
        data += super.cl[n].getNoTelefono() + "\n";
        data += super.cl[n].getSexo() + "\n";
        data += super.cl[n].getId();
        return data;
    }

    @Override

    public void impresionClientes() {
        for (int i = 0; i < super.cl.length; i++) {
            System.out.println("Cliente #" + (i + 1));
            System.out.println("Nombre = " + super.cl[i].getNombre());
            System.out.println("Edad = " + super.cl[i].getEdad());
            System.out.println("No. Telefono = " + super.cl[i].getNoTelefono());
            System.out.println("Sexo = " + super.cl[i].getSexo());
            System.out.println("Id = " + super.cl[i].getId());
            System.out.println("===========");
        }
    }

    @Override
    public void llenadoLentes() {
        String id;
        llenadoVacioLentes();
        int cont = 0;
        for (int i = 0; i < super.len.length; i++) {
            if (cont >= 5 && i != 0) {
                cont = 0;
            }
            do {
                try {
                    switch (cont) {
                        case 0:
                            System.out.println("Llenado de lentes --- " + (i + 1) + " ---");
                            len[i].setTipo(Leer.leerString("Ingrese tipo de lente:\t"));
                            cont++;

                        case 1:
                            len[i].setModelo(Leer.leerString("Ingrese modelo/marca de lente:\t"));
                            cont++;
                        case 2:
                            len[i].setColor(Leer.leerString("Ingrese color:\t"));
                            cont++;
                        case 3:
                            len[i].setGraduacion(Leer.leerFloat("Ingrese graduacion del lente:\t"));
                            cont++;
                        case 4:
                            do {
                                len[i].setCosto(Leer.leerFloat("Ingrese costo:\t"));
                            } while (len[i].getCosto() <= 0);
                            cont++;
                        case 5:
                            do {
                                id = Leer.leerString("Ingrese el identificador del lente:\t");
                            } while (comprobarIdLentes(id));
                            len[i].setId(id);
                            System.out.println("Se completo llenado de lentes ---" + (i + 1) + " ---");
                            cont++;
                    }
                } catch (InputMismatchException e) {
                    e.getMessage();
                    System.out.println("Dato invalido, vuelve a ingresar");
                } finally {
                    Leer.cleanBuffer();
                }
            } while (cont <= 5);
        }

    }

    @Override
    public void impresionLentes() {
        for (int i = 0; i < len.length; i++) {
            System.out.println("Datos de lentes -- " + (i + 1) + " ---");
            System.out.println("Tipo: " + len[i].getTipo());
            System.out.println("Modelo: " + len[i].getModelo());
            System.out.println("Color: " + len[i].getColor());
            System.out.println("Graduacion: " + len[i].getGraduacion());
            System.out.println("Costo: " + len[i].getCosto());
            System.out.println("*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*");
        }
    }

    @Override
    public void añadirCliente() {
        String id;
        int cont = 0;
        String nombre;
        Cliente[] aux = new Cliente[cl.length + 1];
        System.arraycopy(cl, 0, aux, 0, cl.length);
        aux[cl.length] = new Cliente();
        do {
            try {
                switch (cont) {
                    case 0:
                        System.out.println("==LLENADO CLIENTE #" + (getLongitudCliente() + 1) + "==");
                        do {
                            nombre = Leer.leerString("Ingrese el nombre del cliente:\t");
                        } while (comprobarNombre(nombre));
                        aux[getLongitudCliente()].setNombre(nombre);
                        cont++;

                    case 1:
                        aux[getLongitudCliente()].setEdad(Leer.leerInt("Ingrese la edad del cliente:\t"));
                        if (aux[getLongitudCliente()].getEdad() <= 0) {
                            throw new InputMismatchException("El dato ingresado es incorrecto");
                        }

                        cont++;
                    case 2:
                        aux[getLongitudCliente()].setNoTelefono(Leer.leerInt("Ingrese el numero de telefono del cliente:\t"));
                        if (aux[getLongitudCliente()].getNoTelefono() <= 0) {
                            throw new InputMismatchException("El dato ingresado es incorrecto");
                        }

                        cont++;
                    case 3:
                        aux[getLongitudCliente()].setSexo(selectorSexo());
                        cont++;

                    case 4:
                        do {
                            id = Leer.leerString("Ingrese el identificador del cliente:\t");
                        } while (comprobarId(id));
                        aux[getLongitudCliente()].setId(id);
                        cont++;
                }
            } catch (InputMismatchException e) {
                e.getMessage();
                System.out.println("Dato invalido, vuelve a ingresar");
            } finally {
                Leer.cleanBuffer();
            }
        } while (cont <= 4);
        cl = aux;
        System.out.println("*¨¨*¨¨*¨¨* Cliente añadido *¨¨*¨¨*¨¨*");
        try {
            llenadoArchivoClienteE();
        } catch (IOException ex) {
            ex.getMessage();
        } finally{
            Leer.cleanBuffer();
        }

    }

    private boolean buscarID(String id) {
        for (int i = 0; i < cl.length; i++) {
            if (cl[i].getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void eliminarCliente() {
        Cliente[] aux = new Cliente[cl.length - 1];
        System.arraycopy(cl, 0, aux, 0, cl.length - 1);
        cl = aux;
        System.out.println("¡Cliente eliminado!");
    }

    @Override
    public void consultarCliente(String ID) {
        for (int i = 0; i < cl.length; i++) {
            if (cl[i].getId().equals(ID)) {
                System.out.println("*¨¨*¨¨* Datos del cliente *¨¨*¨¨*" + cl[i].getId());
                System.out.println("Nombre: " + cl[i].getNombre());
                System.out.println("Edad: " + cl[i].getEdad());
                System.out.println("No. Telefono: " + cl[i].getNoTelefono());
                System.out.println("Sexo: " + cl[i].getSexo());
                System.out.println("Id: " + cl[i].getId());
                return;
            }
        }
        System.out.println("No existe cliente con ID " + ID);
    }

    @Override
    public void eliminarCliente(String ID) {
        if (buscarID(ID)) {
            Cliente auxCl[] = new Cliente[cl.length - 1];
            for (int i = 0, aux = 0; i < cl.length; i++, aux++) {
                if (!cl[i].getId().equals(ID)) {
                    auxCl[aux] = cl[i];
                } else {
                    aux--;
                }
            }
            cl = auxCl;
        } else {
            System.out.println("No existe cliente con el ID " + ID);
        }
    }

    public int getId(String id) {
        int a = -1;
        for (int i = 0; i < super.len.length; i++) {
            if (super.len[i].getId().equals(id)) {
                a = i;
            }
        }
        return a;
    }

    public int getLongitudLente() {
        return longitud = super.len.length;
    }

    public int getLongitudCliente() {
        return longitud = super.cl.length;
    }

    @Override
    public void eliminarLente(String id) {
        int a = getId(id);
        int aux1 = (super.len.length - 1);
        if (a != -1) {
            for (int i = a; i < (super.len.length - 1); i++) {
                super.len[i] = super.len[i + 1];
            }
            Lentes aux[] = new Lentes[super.len.length - 1];
            System.arraycopy(super.len, 0, aux, 0, super.len.length - 1);
            super.len = new Lentes[aux1];
            super.len = aux;

        } else {
            System.out.println("Los lentes con identificador  [" + id + "] no estan registrado");
        }

    }

    @Override
    public void eliminarUltimoLente() {
        Lentes aux[] = new Lentes[super.len.length - 1];
        System.arraycopy(super.len, 0, aux, 0, super.len.length - 1);
        super.len = aux;
        System.out.println("Dato eliminado");
    }

    @Override
    public void añadirLente() {
        Lentes aux[] = new Lentes[super.len.length + 1];
        System.arraycopy(super.len, 0, aux, 0, super.len.length);
        aux[super.len.length] = new Lentes();
        String id;
        int cont = 0;
        do {
            try {
                switch (cont) {
                    case 0:
                        System.out.println("Llenado de lentes --- " + (super.len.length + 1) + " ---");
                        aux[super.len.length].setTipo(Leer.leerString("Ingrese tipo de lente:\t"));
                        cont++;

                    case 1:
                        aux[super.len.length].setModelo(Leer.leerString("Ingrese modelo/marca de lente:\t"));
                        cont++;
                    case 2:
                        aux[super.len.length].setColor(Leer.leerString("Ingrese color:\t"));
                        cont++;
                    case 3:
                        aux[super.len.length].setGraduacion(Leer.leerFloat("Ingrese graduacion del lente:\t"));
                        cont++;
                    case 4:
                        do {
                            aux[super.len.length].setCosto(Leer.leerFloat("Ingrese costo:\t"));
                        } while (aux[super.len.length].getCosto() <= 0);
                        cont++;
                    case 5:
                        do {
                            id = Leer.leerString("Ingrese el identificador del lente:\t");
                        } while (comprobarIdLentes(id));
                        aux[super.len.length].setId(id);
                        System.out.println("Se completo llenado de lentes ---" + (super.len.length + 1) + " ---");
                        cont++;
                }
            } catch (InputMismatchException e) {
                e.getMessage();
                System.out.println("Dato invalido, vuelve a ingresar");
            } finally {
                Leer.cleanBuffer();
            }
        } while (cont <= 5);
        super.len = aux;
    }

    @Override
    public void busquedaPorCaracteristica(String caracteristica) {
        int cont = 0;
        for (int i = 0; i < super.len.length; i++) {
            if (caracteristica.equals(super.len[i].getColor()) || caracteristica.equals(super.len[i].getModelo()) || caracteristica.equals(super.len[i].getTipo()) || caracteristica.equals(super.len[i].getId())) {
                System.out.println("Datos de lentes -- " + (i + 1) + " ---");
                System.out.println("Tipo: " + len[i].getTipo());
                System.out.println("Modelo: " + len[i].getModelo());
                System.out.println("Color: " + len[i].getColor());
                System.out.println("Graduacion: " + len[i].getGraduacion());
                System.out.println("Costo: " + len[i].getCosto());
                System.out.println("*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*");
                cont = 1;
            }
        }
        if (cont == 0) {
            System.out.println("No existe ningun lente con la caracteristica " + caracteristica);
        }
    }

    @Override
    public void busquedaPorPrecio(float precio) {
        int cont = 0;
        for (int i = 0; i < super.len.length; i++) {
            if (precio == super.len[i].getCosto()) {
                System.out.println("Datos de lentes -- " + (i + 1) + " ---");
                System.out.println("Tipo: " + len[i].getTipo());
                System.out.println("Modelo: " + len[i].getModelo());
                System.out.println("Color: " + len[i].getColor());
                System.out.println("Graduacion: " + len[i].getGraduacion());
                System.out.println("Costo: " + len[i].getCosto());
                System.out.println("*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*¨¨*");
                cont = 1;
            }
        }
        if (cont == 0) {
            System.out.println("No hay ningun lente con el precio " + precio);
        }
    }

    public String llenarNombreArchivoBinCliente() {
        String nombre = "Clientes.dat";
        return nombre;
    }

    public void llenadoArchivoClienteE() throws IOException {
        String nomAr;
        nomAr = llenarNombreArchivoBinCliente();
        bin.escrituraDatos(true, nomAr, super.cl[getLongitudCliente()-1].getNombre(), super.cl[getLongitudCliente()-1].getEdad(), super.cl[getLongitudCliente()-1].getSexo(), super.cl[getLongitudCliente()-1].getNoTelefono(), super.cl[getLongitudCliente()-1].getId());
        System.out.println("Se han registrado el cliente");
    }

    public void llenadoArchivoCliente() throws IOException {
        String nomAr;
        for (int i = 0; i < super.cl.length; i++) {
            nomAr = llenarNombreArchivoBinCliente();
            bin.escrituraDatos(true, nomAr, super.cl[i].getNombre(), super.cl[i].getEdad(), super.cl[i].getSexo(), super.cl[i].getNoTelefono(), super.cl[i].getId());
        }
        System.out.println("Se han registrado todos los clientes en los expedientes personales");
    }

    public void lecturaArchivoClienteE() throws IOException {
        int i = 0;
        try {
            do {
                i = 1;
            } while (i <= 0);
        } catch (InputMismatchException e) {
            e.getMessage();
            System.out.println("Dato incorrecto, vuelve a ingresar:\t");
        } finally {
            Leer.cleanBuffer();
        }
        bin.lecturaDatos(false, llenarNombreArchivoBinCliente());
    }

    public long llenadoBandera() {
        long bandera = 0;
        bandera = new File(llenarNombreArchivoBinCliente()).length();
        return bandera;
    }
    public void sobreescrituraArchivoCliente() throws IOException {
        String nomAr;
        for (int i = 0; i < super.cl.length; i++) {
            nomAr = llenarNombreArchivoBinCliente();
            bin.escrituraDatos(false, nomAr, super.cl[i].getNombre(), super.cl[i].getEdad(), super.cl[i].getSexo(), super.cl[i].getNoTelefono(), super.cl[i].getId());
        }
        System.out.println("Se han sobreescrito todos los clientes en los expedientes personales");
    }
    public void rellenar(){
        llenadoVacio();
        String nombre, id;
        int cont = 0;
        for (int i = 0; i < super.cl.length; i++) {
            if (cont >= 5 && i != 0) {
                cont = 0;
            }
            do {
                try {
                    switch (cont) {
                        case 0:
                            System.out.println("==LLENADO CLIENTE #" + (i + 1) + "==");
                            do {
                                nombre = Leer.leerString("Ingrese el nombre del cliente:\t");
                            } while (comprobarNombre(nombre));
                            super.cl[i].setNombre(nombre);
                            cont++;

                        case 1:
                            super.cl[i].setEdad(Leer.leerInt("Ingrese la edad del cliente:\t"));
                            if (super.cl[i].getEdad() <= 0) {
                                throw new InputMismatchException("El dato ingresado es incorrecto");
                            }

                            cont++;
                        case 2:
                            super.cl[i].setNoTelefono(Leer.leerInt("Ingrese el numero de telefono del cliente:\t"));
                            if (super.cl[i].getNoTelefono() <= 0) {
                                throw new InputMismatchException("El dato ingresado es incorrecto");
                            }

                            cont++;
                        case 3:
                            super.cl[i].setSexo(selectorSexo());
                            cont++;

                        case 4:
                            do {
                                id = Leer.leerString("Ingrese el identificador del cliente:\t");
                            } while (comprobarId(id));
                            super.cl[i].setId(id);
                            cont++;
                    }
                } catch (InputMismatchException e) {
                    e.getMessage();
                    System.out.println("Dato invalido, vuelve a ingresar");
                } finally {
                    Leer.cleanBuffer();
                }
            } while (cont <= 4);
        }

    
    }
}