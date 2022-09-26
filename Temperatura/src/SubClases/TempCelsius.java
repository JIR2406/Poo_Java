
package SubClases;

import SuperTemperatura.Temperatura;


public class TempCelsius extends Temperatura{
    public TempCelsius(float noGrados){
    super(noGrados);    
    }
    @Override
    public void conversion() {
        System.out.println("Conversion grados Celcius");
        System.out.println("C: "+super.getNoGrados()+" -> F: "+getGradosF());
        System.out.println("C: "+super.getNoGrados()+" -> K: "+getGradosK());
        System.out.println("C: "+super.getNoGrados()+" -> R: "+getGradosR());
    }
    protected float getGradosF(){
        return (super.getNoGrados()*1.8f)+32;
    }
    protected float getGradosK(){
        return(super.getNoGrados()+273.15f);
    }
    protected float getGradosR(){
        return(super.getNoGrados()*1.8f)+491.67f;
    }
}
