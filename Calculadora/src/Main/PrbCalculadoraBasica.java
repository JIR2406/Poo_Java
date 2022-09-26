
package Main;
import SubClase.CalculadoraBasica;
import leer.Leer;

public class PrbCalculadoraBasica {
    public static void main(String[] args) {
        double n1=Leer.leerDouble("Ingrese primer numero:\t");
        CalculadoraBasica a=new CalculadoraBasica(n1);
        a.setN2(Leer.leerDouble("Ingese segundo numero:\t"));
        char op;
        System.out.println("Elije una operacion\n"
                + "+) Suma\n"
                + "-) Resta\n"
                + "*) Multiplicacion\n"
                + "/) Division\n"
                + "m) Modificar Datos\n"
                + "s) Salir");
        op=Leer.leerChar("Ingrese opcion:\t");
        do{
        switch(op){
            case'+':
            case'-':
            case'*':
            case'/':
                System.out.println("El resultado es: "+a.getResultado(op));
                break;
            case 'm': case 'M':
                n1=Leer.leerDouble("Ingresa primer numero:\t");
                a= new CalculadoraBasica(n1);
                a.setN2(Leer.leerDouble("Ingrese segundo numero:\t"));
                
        }}while(!(op=='s'||op=='S'));
    }
}
