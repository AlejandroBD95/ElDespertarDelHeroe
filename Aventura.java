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
        System.out.println("Nueva partida");
        System.out.println("Ver clasificación");
        System.out.println("Ayuda");
        System.out.println("Salir");
        System.out.println("+");

        int eleccionMenu = sc.nextInt();
        mostrarMenu(eleccionMenu);


    // control  
        Guerrero guerrero = new Guerrero("Guerrero", 100, 2, 5, 15);
        Ladron ladron = new Ladron("Ladron", 80, 10, 20);
        Mago mago = new Mago("Mago", 80, 10, 15);
    

        guerrero.mostrarEstadisticas();
        System.out.println("\n");

        ladron.mostrarEstadisticas();
        System.out.println("\n");

        mago.mostrarEstadisticas();
        System.out.println("\n");
    //control
    sc.close();
    }

    public static int mostrarMenu(int eleccionMenu)
    {
        while (eleccionMenu != 1 && eleccionMenu != 4)
            {
                switch (eleccionMenu) 
                {
                   case 1:
                        System.out.println("Iniciando partida");
                    break;
                    case 2:
                        System.out.println("Mostrando clasificación");
                    break;
                    case 3:
                        System.out.println("Mostrando ayuda");
                    break;
                    case 4:
                        System.out.println("Saliendo de la aventura");
                    break;
                    default:
                        System.out.println("Valor no controlado");
                }
            }
        return eleccionMenu;
    }

}
