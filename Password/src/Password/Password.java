package Password;
import java.util.Scanner;

public class Password {
    private int longitud;
    private String contraseña;
    static Scanner s= new Scanner(System.in);
    public Password(){
        this.longitud=8;
    }
    public Password(int longitud){
        this.longitud=longitud;
    }
    public boolean esFuerte(){
        boolean a=false;
        int auxN=0,auxL=0;
        for(int i=0;i<longitud;i++){
            if(contraseña.charAt(i)<=100){
            auxN++;
            }
            else{
            auxL++;
            }
            if(auxN>=5 &&auxL>=1){
            a=true;
        }
        }
        return a;
    }
    private void setContrasena(String contraseña){
        this.contraseña=contraseña;
    }
    public int getLongitud(){
        return longitud;
    }
    public String getContrasena(){
        return contraseña;
    }
    public void generarPassword(){
            System.out.println("Dame la contraseña: ");
            contraseña=s.next();
            while(contraseña.length()>getLongitud()){
            System.out.println("Dame la contraseña: ");
            contraseña=s.next();
            }
            setContrasena(contraseña);
    }
    public char charA(){
        int aux = (int) (Math.random() * 90 + 1 - 65) + 65;
        char letra = (char) aux;
        return letra;
    }
}
