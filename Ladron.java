import java.util.concurrent.ThreadLocalRandom;

public class Ladron extends Personaje
{
    public Ladron(String nombre, int vida, int armadura, int ataqueMinimo, int ataqueMaximo)
    {
        super( nombre,  vida,  armadura,  ataqueMinimo,  ataqueMaximo);
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
        
        int danyoBase = ThreadLocalRandom.current().nextInt(getAtaqueMinimo(), getAtaqueMaximo() +1) + danyoCritico;
        return danyoBase;
    }
}
