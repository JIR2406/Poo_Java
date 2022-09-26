
package Main;

import Password.Password;

public class Main {
    public static void main(String[] args) {
        Password ps= new Password();
        ps.generarPassword();
        if (ps.esFuerte()==true){
            System.out.println("La contraseña es fuerte");
        }
        else 
            System.out.println("La contraseña es debil");
        
        System.out.println("La contraseña es:\t"+ps.getContrasena());
    }
}
