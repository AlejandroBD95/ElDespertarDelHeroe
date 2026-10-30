public class Inventario 
{
    private Objeto[] items;
    

    public Inventario (int capacida)
    {
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
            System.out.println("-> Mochilla llena, no puedes llevar más pociones <-");
        }
    }







}
