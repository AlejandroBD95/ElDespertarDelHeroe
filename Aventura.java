import java.util.Scanner;
public class Aventura 
{
    
    public static void main(String[] args)
    {
        System.out.println("********** --------------------------------- **********");
        System.out.println("********** BIENVENIDO AL DESPERTAR DEL HEROE **********");
        System.out.println("********** --------------------------------- **********");

        Scanner sc = new Scanner(System.in);
        Personaje heroe = new Personaje(null, 0, 0, 0, 0); 
        System.out.println("\n");

        int eleccionMenu ;
        do 
            {
            
            System.out.println("1.Nueva partida");
            System.out.println("2.Ver clasificación");
            System.out.println("3.Ayuda");
            System.out.println("4.Salir");
            System.out.println("\n");
            System.out.println("Escoge una opción");
            eleccionMenu = sc.nextInt();
                switch (eleccionMenu) 
                {
                   case 1:
                        System.out.println("Iniciando partida");
                        heroe = seleccionarHeroe(sc);
                        System.out.println("");
                    break;
                    case 2:
                        System.out.println("Mostrando clasificación");
                        System.out.println("");
                    break;
                    case 3:
                        System.out.println("Mostrando ayuda");
                        System.out.println("\n");
                        System.out.println("---GLOSARIO DE NOMBRES---");
                        System.out.println("");
                        System.out.println("PV = Puntos de Vida");
                        System.out.println("PD = Puntos de Defensa");
                        System.out.println("PA = Puntos de Ataque");
                        System.out.println("");
                        System.out.println("---GLOSARIO DE NOMBRES---");
                        System.out.println("\n");
                    break;
                    case 4:
                        System.out.println("Saliendo de la aventura");
                        System.out.println("");
                    break;
                    default:
                        System.out.println("Valor no controlado");
                        System.out.println("");
                }
            }
        while (eleccionMenu != 1 && eleccionMenu != 4);

        System.out.println("**************************");
        System.out.println("COMIENZA LA AVENTURA");
        System.out.println("**************************");
        System.out.println("");

        Historia.introduccion();
        Historia.combate1();

        BossGuerrero boss1 = new BossGuerrero("Maestro de armas Harlan", 40, 2, 5, 15);
        Combate.luchar(heroe, boss1);

        Historia.combate2();
        BossMago boss2 = new BossMago("Tejedor de fuego Koegler", 60, 0, 10, 15, 2);
        Combate.luchar(heroe, boss2);
        
        Historia.combate3();
        BossFinal bossFinal = new BossFinal("Comandante Durand", 80, 2, 10, 20, 3);
        Combate.luchar(heroe, bossFinal);

    sc.close();
    }
    public static Personaje seleccionarHeroe(Scanner sc)
        {
        Guerrero guerrero = new Guerrero("Guerrero", 100, 2, 5, 15);
        Ladron ladron = new Ladron("Ladron", 75, 0, 10, 20);
        Mago mago = new Mago("Mago", 80, 0, 5, 15, 2);
        Personaje heroe = new Personaje(null, 0, 0, 0, 0); 
            System.out.println("\n");
            System.out.println("Selecciona el Heroe");
            System.out.println("1.Guerrero");
            guerrero.mostrarEstadisticas();
            System.out.println("");

            System.out.println("2.Ladron");
            ladron.mostrarEstadisticas();
            System.out.println("");
                
            System.out.println("3.Mago");
            mago.mostrarEstadisticas();
            System.out.println("");

            int seleccionHeroe = sc.nextInt();

            switch (seleccionHeroe) 
            {
                case 1:
                    heroe = new Guerrero("Guerrero", 100, 2, 5, 15);
                    System.out.println("Has escogido al guerrero");
                break;
                case 2:
                    heroe = new Ladron("Ladron", 80, 0, 10, 20);
                    System.out.println("Has escogido al ladron");
                break;
                case 3:
                    heroe = new Mago("Mago", 80, 0, 5, 15, 2);
                    System.out.println("Has escogido al mago");
                break;
                default:
                    System.out.println("Valor no registrado");
                break;
            }
            return heroe;
        }
}
