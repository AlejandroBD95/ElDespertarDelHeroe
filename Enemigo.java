import java.util.Random;
public class Enemigo 
{
    Random random = new Random();
    private String nombre;
    private int vida;
    private int armadura;
    private int ataqueMinimo;
    private int ataqueMaximo;
 
    public Enemigo (String nombre, int vida, int armadura, int ataqueMinimo, int ataqueMaximo)
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
    public void setNombre(String nombre)
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

    public int enemigoAtacar()
    {
        int critico = random.nextInt(20)+1;
        int danyoCritico;
        if (critico == 20)
            {
                danyoCritico = 3;
            }


    }


}
