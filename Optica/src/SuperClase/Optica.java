
package SuperClase;

import Clases.*;


public abstract class Optica {
    protected Cliente cl[];
    protected Lentes len[];
    public Optica(int n){
        cl=new Cliente[n];
    }
    public Optica(float m){
        int a=(int)m;
        len= new Lentes[a];
    }
    public abstract void llenadoClientes();
    public abstract void impresionClientes();
    public abstract void llenadoLentes();
    public abstract void impresionLentes();
}
