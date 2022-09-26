
package Main;
import SubClases.*;
import leer.Leer;

public class PrbTemperatura {
    public static void main(String[] args) {
        char op;
        do{
        System.out.println("\t==MENU==\t\n"
                + "A) Temperatura Celsius\n"
                + "B) Temperatura Farenheit\n"
                + "S) Salir");
        op=Leer.leerChar("Elije una opcion:\t");
        switch(op){
            case 'a': case 'A':
                new TempCelsius(Leer.leerFloat("Ingrese grados a convertir:\t")).conversion();
                break;
            case 'b': case 'B':
                new TempFarenheit(Leer.leerFloat("Ingrese grados a convertir:\t")).conversion();
                break;
            case 's': case 'S':
                break;
            default:
                System.out.println("Opcion incorrecta, vuelva a ingresar");
                break;
        }
    }while(!(op=='s'|| op=='S'));
        
    }
    
}
