import java.util.concurrent.ThreadLocalRandom;

public class Mago extends Personaje
{
    public Mago(String nombre, int vida, int armadura, int ataqueMinimo, int ataqueMaximo,int danyoMagico)
    {
        super(nombre, vida, armadura, ataqueMinimo, ataqueMaximo, danyoMagico);
    }
    @Override 
    public int atacar()
    {
        int danyoBase = ThreadLocalRandom.current().nextInt(getAtaqueMinimo(), getAtaqueMaximo() +1);
        return danyoBase + getDanyoMagico();
    }    
}
