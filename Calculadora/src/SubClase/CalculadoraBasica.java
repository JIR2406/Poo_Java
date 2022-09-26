package SubClase;

import Interfaces.*;
import SuperClase.Calculadora;

public class CalculadoraBasica extends Calculadora implements Suma,Resta,Multiplicacion,Division{

    public CalculadoraBasica(double n1) {
        super(n1);
    }

    @Override
    public double getResultado(char oper) {
     switch(oper){
         case '+':
             return getSuma();
         case '-':
             return getResta();
         case '*':
             return getMultiplicacion();
         case '/':
             return getDivision();
     }
        return 0;
    }

    @Override
    public double getSuma() {
    return getN1()+getN2();
    }

    @Override
    public double getResta() {
    return getN1()-getN2();
    }

    @Override
    public double getMultiplicacion() {
     return getN1()*getN2();
    }

    @Override
    public double getDivision() {
     return getN1()/getN2();
    }
}
