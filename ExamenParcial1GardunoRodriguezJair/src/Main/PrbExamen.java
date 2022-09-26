package Main;
import Examen.Examen;
import java.util.Scanner;
public class PrbExamen {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int a,x,y;
        double fin;
        char op;
        do{
        System.out.print("Ingresa el tamaño de los vectores: \t");
        a=s.nextInt();
        s.nextLine();
        }while(a<2 || a>=11);
        Examen ex= new Examen(a);
        do{
        System.out.println("==MENU==\n"
                + "1) Llenado por usuario\n"
                + "2) Llenado por aleatorio");
        System.out.print("Ingrese una opcion:\t");
        op=s.nextLine().charAt(0);
        switch(op){
            case '1':
                ex.llenadoVec();
                break;
            case '2':
                do{
                System.out.println("Ingrese el final del rango mayor a 0: \t");
                fin=s.nextDouble();
                s.nextLine();
                }while(fin<=0);
                ex.llenadovec(0, fin);
                break;
            default:
                System.out.println("=Opcion incorrecta=");
                op='0';
                break;
        } 
        } while(op=='0');
        do{
            System.out.println("==MENU 2==\n"
                + "1) Imprimir vectores\n"
                + "2) Rellenar vectores\n"
                + "3) Deducir datos mayores y menores\n"
                + "4) Salir");
        op=s.nextLine().charAt(0);
        switch(op){
            case '1':
                System.out.println("Dame el caracter con el que se va a imprimir:\t");
                op=s.nextLine().charAt(0);
                ex.impresionD(op);
                break;
            case '2':
                    do{
                        System.out.println("==MENU==\n"
                            + "1) Llenado por usuario\n"
                            + "2) Llenado por aleatorio");
                        System.out.print("Ingrese una opcion:\t");
                        op=s.nextLine().charAt(0);
                    switch(op){
                        case '1':
                        ex.llenadoVec();
                        break;
                        case '2':
                    do{
                        System.out.println("Ingrese el final del rango mayor a 0: \t");
                        fin=s.nextDouble();
                    }while(fin<=0);
                        ex.llenadovec(0, fin);
                        break;
                    default:
                        System.out.println("=Opcion incorrecta=");
                        op='0';
                    } 
                        } while(op=='0');
                    break;
            case '3':
            do{
                System.out.print("Dame la posicion del vector #1:\t");
                x=s.nextInt();
                s.nextLine();
            }while(x<0  || x>=ex.getVec().length);    
            do{
                System.out.print("Dame la posicion del vector #2:\t");
                y=s.nextInt();
                s.nextLine();
            }while(y<0 || y>=ex.getVec2().length);
                ex.mayorMenorIgual(x, y);
                break;
            case '4':
                break;
            default:
                System.out.println("Dato incorrecto, vuelva a ingresar");
        }
        }while(op!='4');
        }
    
}
