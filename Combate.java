public class Combate 
{
        public static void luchar(Personaje heroe, Personaje boss1)
    {
        
        while (heroe.getVida() > 0 && boss1.getVida() >0) 
        {
            int turno = 1;
            boolean eleccionTurno;
            do 
            {
                System.out.println("Que quieres hacer en el turno " + turno);
                System.out.println("Revisar inventario");
                System.out.println("Tomar una poción");
                System.out.println("Atacar");
                switch (eleccionTurno)
                {
                    case 1:
                        heroe.getInventario().revisarInventario();
                    break;
                    case 2:
                        consumirPocion();
                    break;
                    case 3:
                        atacar();
                }
            } while(eleccionTurno);
        }    
    }
}
