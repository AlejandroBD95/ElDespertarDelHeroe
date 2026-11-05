import java.util.Scanner;
public class Combate 
{
        public static void luchar(Personaje heroe, Personaje boss1)
    {
        
        while (heroe.getVida() > 0 && boss1.getVida() > 0) 
        {
            Scanner sc = new Scanner(System.in);
            int turno = 1;
            int eleccionTurno;
            do 
            {
                System.out.println("Que quieres hacer en el turno " + turno);
                System.out.println("1.Revisar inventario");
                System.out.println("2.Tomar una poción");
                System.out.println("3.Atacar");
                eleccionTurno = sc.nextInt();
                System.out.println("\n");
                switch (eleccionTurno)
                {
                    case 1:
                        heroe.getInventario().revisarInventario();
                    break;
                    case 2:
                        heroe.getInventario().consumirPocion();
                    break;
                    case 3:
                        int danyoHeroe = heroe.atacar();
                        int vidaBossActual = (boss1.getVida() + boss1.getArmadura()) - danyoHeroe;
                        boss1.setVida(vidaBossActual);
                        System.out.println(heroe.getNombre() + " ataca a " + boss1.getNombre() + " infligiendo " + danyoHeroe + "PV");
                    break;
                    case 4:
                        System.out.println("Valor no registrado");
                }
            } while(eleccionTurno != 3);
            
            int danyoBoss = boss1.atacar();
            int vidaHeroeActual = (heroe.getVida() + heroe.getArmadura()) - danyoBoss;
            heroe.setVida(vidaHeroeActual);
            System.out.println(boss1.getNombre() + " ataca al heroe " + heroe.getNombre() + " provocando " + danyoBoss + "PV");
        }     
    }
}
