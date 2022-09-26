
package Examen;
import java.util.Scanner;
public class Examen {
    static Scanner s=new Scanner(System.in);
    private double vec[];
    private double vec2[];
    public Examen(int a){
        this.vec=new double[a];
        this.vec2=new double[a];
    }
    private void setVec(double vec[]){
        this.vec=vec;
    }
    public double[] getVec(){
        return vec;
    }
    
    private void setVec2(double vec[]){
        this.vec2=vec;
    }
    public double[] getVec2(){
        return vec2;
    }
    public void llenadoVec(){
        for (int i = 0; i < getVec().length; i++) {
            System.out.print("Dame el dato #"+(i+1)+":\t");
            vec[i]=s.nextDouble();
        }
            setVec(vec);
        int n=(vec.length-1);
        for (int i = 0; i < getVec2().length; i++, n--) {
            vec2[i]=vec[n];
        }
            setVec2(vec2);
    }    
    public void llenadovec(double ini, double fin){
        for (int i = 0; i < getVec().length; i++) {
            vec[i]=numA(ini,fin);
        }
            setVec(vec);
        int n=(vec.length-1);
        for (int i = 0; i < getVec2().length; i++, n--) {
            vec2[i]=vec[n];
        }
            setVec2(vec2);
    }
    public double numA(double ini, double fin){
        return Math.random()*((fin+1)-ini)+ini+1;
    }
    public void impresionD(char a){
        System.out.print("Vec #1 = "); 
        for (int i = 0; i < vec.length; i++) {
            if(i!=0){
                System.out.print(a);
            }
            System.out.print(vec[i]);
        }
        
        System.out.print("\nVec #2 = ");
        for (int i = 0; i < vec2.length; i++) {
            if(i!=0){
                System.out.print(a);
            }
            System.out.print(vec2[i]);
        }
        System.out.println("");
    }
    public void mayorMenorIgual(int a, int b){
        if(vec[a]>vec2[b]){
            System.out.println("El vector 1 es mayor al vector 2");
        }
        else if(vec[a]<vec2[b]){
            System.out.println("El vector 2 es mayor al vector 1");
        }
        else if(vec[a]==vec2[b]){
            System.out.println("El vector 1 es igual al vector 2");
        }
    }
}
