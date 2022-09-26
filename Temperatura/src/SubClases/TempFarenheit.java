
package SubClases;

import SuperTemperatura.Temperatura;


public class TempFarenheit extends Temperatura{
    public TempFarenheit(float noGrados){
        super(noGrados);
    }

    @Override
    public void conversion() {
    System.out.println("Conversion grados Farenheit");
    System.out.println("F: "+super.getNoGrados()+"° -> C: "+getGradosC()+"°");
    System.out.println("F: "+super.getNoGrados()+" -> K: "+getGradosK()+"°");
    System.out.println("F: "+super.getNoGrados()+" -> R: "+getGradosR()+"°");
    }
    protected float getGradosC(){
        return ((super.getNoGrados()-32f)*(5/9f));
    }
    protected float getGradosK(){
        return(((super.getNoGrados()-32f)*(5/9f))+273.15f);
    }
    protected float getGradosR(){
        return(super.getNoGrados()+459.67f);
    }


}
