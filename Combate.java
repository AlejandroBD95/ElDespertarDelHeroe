import java.util.Scanner;
public class Combate 
{
        public static void luchar(Personaje heroe, Personaje boss1)
    {
        int turno = 1;
        while (heroe.getVida() > 0 && boss1.getVida() > 0) 
        {
            Scanner sc = new Scanner(System.in);
            int eleccionTurno;
            do 
            {
                System.out.println("****************************************");
                System.out.println("------------TURNO " + turno);
                System.out.println("------------1.Revisar inventario");
                System.out.println("------------2.Tomar una poción");
                System.out.println("------------3.Atacar");
                System.out.println("****************************************");
                eleccionTurno = sc.nextInt();
                System.out.println("\n");
                switch (eleccionTurno)
                {
                    case 1:
                        heroe.getInventario().revisarInventario();
                    break;
                    case 2:
                        heroe.getInventario().consumirPocion(heroe);;
                    break;
                    case 3:
                        System.out.println("*****---TURNO DEL HEROE---*****");
                        int danyoHeroe = heroe.atacar();
                        int vidaBossActual = (boss1.getVida() + boss1.getArmadura()) - danyoHeroe;
                        boss1.setVida(vidaBossActual);
                        if (boss1.getVida() < 0)
                        {
                            boss1.setVida(0);
                        }
                        System.out.println(heroe.getNombre() + " ataca a " + boss1.getNombre() + " infligiendo " + danyoHeroe + "PV");
                        System.out.println("");
                        System.out.println("La vida actual del jefe " + boss1.getNombre() + " es de " + boss1.getVida() + " PV");
                        System.out.println("");
                    break;
                    case 4:
                        System.out.println("Valor no registrado");
                }
            } while(eleccionTurno != 3);
            if (boss1.getVida() == 0)
            {
                System.out.println("=============================");
                System.out.println("HAS DERROTADO A " + boss1.getNombre() + "!!!");
                System.out.println("");
                System.out.println("=============================");
                return;
            }
            else if (heroe.getVida() == 0)
            {
                System.out.println("     ***     ");
                System.out.println("Has sido derrotado...");
                System.out.println("     ***     ");
                Historia.derrota();
                return;
            }
            System.out.println("*****---TURNO DEL ENEMIGO---*****");
            System.out.println(" ");
            int danyoBoss = boss1.atacar();
            int vidaHeroeActual = (heroe.getVida() + heroe.getArmadura()) - danyoBoss;
            heroe.setVida(vidaHeroeActual);
            if (heroe.getVida() <0 )
            {
                heroe.setVida(0);
            }
            System.out.println(boss1.getNombre() + " ataca al heroe " + heroe.getNombre() + " provocando " + danyoBoss + "PV");
            System.out.println("");
            System.out.println("Te quedan " + heroe.getVida() + " PV");
            System.out.println("");
            turno++;
        }   
    }
}
