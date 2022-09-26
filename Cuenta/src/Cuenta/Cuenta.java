
package Cuenta;
import java.util.Scanner;

public class Cuenta {
    static Scanner s= new Scanner(System.in);
    private String titular;
    private double cantidad;
    public Cuenta(String titular){
        this.titular=titular;
    }
    private void setCantidad(double cantidad){
        this.cantidad=cantidad;
    }
    public double getCantidad(){
        return cantidad;
    }
    public String getTitular(){
        return titular;
    }
    public void ingresar(double cantidad){
        cantidad+=getCantidad();
        if(cantidad>=0){
            setCantidad(cantidad);
        }
        else{
            //
        }
    }
    public void retirar(){
        double retiro,aux;
        System.out.print("El saldo actual es: "+getCantidad()+" ingresa la cantidad a retirar: \t");
        retiro=s.nextDouble();
        while(retiro<=0||retiro>getCantidad()){
            System.out.println("Cantidad incorrecta, vuelva a ingresar");
            System.out.print("El saldo actual es: "+getCantidad()+" ingresa la cantidad a retirar: \t");
            retiro=s.nextDouble();
        }
        aux=getCantidad()-retiro;
        if(aux<0){
            setCantidad(0);
        }
        else if(aux>=0){
            setCantidad(aux);
        }
    }
}
