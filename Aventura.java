import java.util.Scanner;
public class Aventura 
{
    
    public static void main(String[] args)
    {
        System.out.println("********** --------------------------------- **********");
        System.out.println("********** BIENVENIDO AL DESPERTAR DEL HEROE **********");
        System.out.println("********** --------------------------------- **********");

        Scanner sc = new Scanner(System.in);
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
                        int heroeEscogido = seleccionarHeroe(sc);
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
        
        
    sc.close();
    }
    public static int seleccionarHeroe(Scanner sc)
        {
        Guerrero guerrero = new Guerrero("Guerrero", 100, 2, 5, 15);
        Ladron ladron = new Ladron("Ladron", 80, 0, 10, 20);
        Mago mago = new Mago("Mago", 80, 0, 5, 15, 2);
            
            System.out.println("\n");
            System.out.println("Selecciona el Heroe");
            System.out.println("1.Guerrero");
            guerrero.mostrarEstadisticas();
            System.out.println("\n");

            System.out.println("2.Ladron");
            ladron.mostrarEstadisticas();
            System.out.println("\n");
                
            System.out.println("3.Mago");
            mago.mostrarEstadisticas();
            System.out.println("\n");

            int seleccionHeroe = sc.nextInt();

            switch (seleccionHeroe) 
            {
                case 1:
                    System.out.println("Has escogido al guerrero");
                break;
                case 2:
                    System.out.println("Has escogido al ladron");
                break;
                case 3:
                    System.out.println("Has escogido al mago");
                break;
                default:
                    System.out.println("Valor no registrado");
                break;
            }
            return seleccionHeroe;
        }
}
