import java.util.concurrent.ThreadLocalRandom;

public class BossFinal extends Personaje
{
    public BossFinal(String nombre, int vida, int armadura, int ataqueMinimo, int ataqueMaximo, int danyoMagico)
    {
        super(nombre, vida, armadura, ataqueMinimo, ataqueMaximo, danyoMagico);
    }

    @Override 
    public int atacar()
     {
        int critico = ThreadLocalRandom.current().nextInt(1, 21);
        int danyoCritico;
        if(critico == 20)
            {
                danyoCritico = 3;
            }
        else
            {
                danyoCritico = 0;
            }
        
        int danyoBase = ThreadLocalRandom.current().nextInt(getAtaqueMinimo(), getAtaqueMaximo() +1) + danyoCritico ;
        return danyoBase + getDanyoMagico();
        }
}
