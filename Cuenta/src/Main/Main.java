
package Main;
import Cuenta.Cuenta;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
    String titular;
    double cantidad;
    char op;
        System.out.print("Ingresa el nombre del titular de la cuenta: \t");
        titular=s.nextLine();
        Cuenta cu= new Cuenta(titular);
        do{
        System.out.print("==MENU==\n"
                + "a) Ingresar dinero\n"
                + "b) Retirar dinero\n"
                + "c) Ver estado de cuenta\n"
                + "s) Salir\n"
                + "Ingrese una opcion: \t");
        op=s.nextLine().charAt(0);
        switch(op){
            case'a':
            case'A':
                System.out.print("Ingrese la cantidad a ingresar a la cuenta:\t");
                cantidad=s.nextDouble();
                cu.ingresar(cantidad);
                s.nextLine();
                break;
            case'b':
            case'B':
                cu.retirar();
                break;
            case'c':
            case'C':
                System.out.println("Nombre titular:\t"+cu.getTitular());
                System.out.println("Cantidad total:\t"+cu.getCantidad());
                break;
            case's':
            case 'S':
                break;
            default:
                System.out.println("Dato incorrecto");
                break;
        }
        }while(!(op=='s'|| op=='S'));
        System.out.println("==CERRANDO PROGRAMA==");
    }
    
}
