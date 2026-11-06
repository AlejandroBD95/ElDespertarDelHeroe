import java.util.Scanner;
public class Inventario 
{
    private Objeto[] items;
    

    public Inventario (int capacida )
    {
        capacida = 3;
        this.items = new Objeto[capacida];
    }

    public void agregarObjeto(Objeto nuevoObjeto)
    {
        for(int i = 0; i < items.length; i++)
        {
            if (items[i] == null)
            {
                items[i] = nuevoObjeto;
                System.out.print("-> Has guardado una " + nuevoObjeto.getNombreObjeto() + " en el bolsillo de la mochila [" + (i + 1) + "]! <-");
                return;
            }
            System.out.println("-> Bolsillo lleno <-");
        }
    }

    public void revisarInventario()
    {
        for (int i = 0; i < items.length; i++)
        {
            if (items[i] != null)
            {
                System.out.println("-> Bolsillo de la mochila [" + (i+1) +"] " + items[i].getNombreObjeto());
            }
            else
            {
                System.out.println("-> [" + (i + 1) + "] Bolsillo vacío" );
            }
        }
    }
    public void consumirPocion(Personaje heroe) //(Scanner scanner) para pasarserlo por parametro desde main
    {
        Scanner scanner = new Scanner(System.in);
        revisarInventario();

        System.out.println("Elige el bolsillo de la poción que deseas beber");
        int seleccionPocion = scanner.nextInt()-1;

        if(seleccionPocion >= 0 && seleccionPocion < items.length)
        {
            if(items[seleccionPocion] != null)
            {
                System.out.println("-> Has consumido la " + items[seleccionPocion].getNombreObjeto() + " del bolsillo [" + (seleccionPocion + 1) + "]");
                heroe.curar(items[seleccionPocion].getCantidadSanacion());
                items[seleccionPocion] = null;
                if (heroe.getVida() > 100)
                {
                    heroe.setVida(100);
                }
                System.out.println("Te tomas una poción curandote hasta llegar a " + heroe.getVida() + "PV");
                System.out.println(" ");
            }
            else
            {
                System.out.println("-> Bolsillo vacio");
            }
        }
        else if (seleccionPocion < 0 || seleccionPocion > items.length)
        {
            System.out.println("Valor no registrado");
        }
        
    }










}
