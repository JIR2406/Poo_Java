
package SuperTemperatura;


public abstract class Temperatura {
    private float noGrados;

    public Temperatura(float noGrados){
    this.noGrados=noGrados;    
    }
    public abstract void conversion();
    
    public float getNoGrados(){
        return noGrados;
    }
    
}
