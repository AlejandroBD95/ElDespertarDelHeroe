import java.util.concurrent.ThreadLocalRandom;
public class Personaje 
{

    private String nombre;
    private int vida;
    private int armadura;
    private int ataqueMinimo;
    private int ataqueMaximo;
    private int danyoMagico;
    

    public Personaje(String nombre, int vida, int armadura, int ataqueMinimo, int ataqueMaximo,int danyoMagico)
    {
        this.nombre = nombre;
        this.vida = vida;
        this.armadura = armadura;
        this.ataqueMinimo = ataqueMinimo;
        this.ataqueMaximo = ataqueMaximo;
        this.danyoMagico = danyoMagico; 
    }


    public Personaje(String nombre, int vida, int armadura, int ataqueMinimo, int ataqueMaximo)
    {
        this.nombre = nombre;
        this.vida = vida;
        this.armadura = armadura;
        this.ataqueMinimo = ataqueMinimo;
        this.ataqueMaximo = ataqueMaximo;
    }

    public String getNombre()
    {
        return this.nombre;
    }
    public void setNombre (String nombre)
    {
        this.nombre = nombre;
    }

    public int getVida()
    {
        return this.vida;
    }
    public void setVida(int vida)
    {
        this.vida = vida;
    }

    public int getArmadura()
    {
        return this.armadura;
    }
    public void setArmadura(int armadura)
    {
        this.armadura = armadura;
    }

    public int getAtaqueMinimo()
    {
        return this.ataqueMinimo;
    }
    public void setAtaqueMinimo(int ataqueMinimo)
    {
        this.ataqueMinimo = ataqueMinimo;
    }

    public int getAtaqueMaximo()
    {
        return this.ataqueMaximo;
    }
    public void setAtaqueMaximo(int ataqueMaximo)
    {
        this.ataqueMaximo = ataqueMaximo;
    }

    public int getDanyoMagico()
    {
        return this.danyoMagico;
    }
    public void setDanyoMagico(int danyoMagico)
    {
        this.danyoMagico = danyoMagico;
    }

    public void mostrarEstadisticas()
    {
        System.out.println("Héroe "+ nombre);
        System.out.println(vida + " PV");
        System.out.println(armadura + " PD");
        System.out.println(ataqueMinimo + "-" + ataqueMaximo + " PA");
    }

    public int atacar()
    {
        return ThreadLocalRandom.current().nextInt(ataqueMinimo, ataqueMaximo +1);
    }

    public int atacarMagia()
    {
        int danyoBase = ThreadLocalRandom.current().nextInt(ataqueMinimo, ataqueMaximo +1);
        return danyoBase + danyoMagico;
    }

    public int atacarCritico()
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
        
        int danyoBaseCritico = ThreadLocalRandom.current().nextInt(ataqueMinimo, ataqueMaximo +1) + danyoCritico;
        return danyoBaseCritico;
    }

}
