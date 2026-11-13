import java.util.Scanner;
public class Aventura 
{
    
    public static void main(String[] args)
    {
        String rutaArchivo = "clasificacion.xml";
        gestorClasificacion.crearXML(rutaArchivo);

        boolean jugarOtravez = true;
        System.out.println("********** --------------------------------- **********");
        System.out.println("********** BIENVENIDO AL DESPERTAR DEL HEROE **********");
        System.out.println("********** --------------------------------- **********");

        Scanner sc = new Scanner(System.in);
        Personaje heroe = new Personaje(null, 0, 0, 0, 0); 
        System.out.println("\n");

        while(jugarOtravez)
        {
    
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

                            sc.nextLine();

                            String nombrePersona = "";
                            while (nombrePersona.isEmpty())
                            {
                                System.out.println("= == == == == == == == == == == == == == == == = ");
                                System.out.println("Indicame un nombre para tu heroe:");
                                System.out.println("= == == == == == == == == == == == == == == == = ");
                                nombrePersona = sc.nextLine();
                            }
                            heroe.setNombre(nombrePersona);
                            System.out.println("");
                        break;
                        case 2:
                            System.out.println("Mostrando clasificación");
                            gestorClasificacion.leerXML(rutaArchivo);
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
                            System.out.println("Poción de sanación: cura 25 PV");
                            System.out.println("");
                            System.out.println("---GLOSARIO DE NOMBRES---");
                            System.out.println("\n");
                        break;
                        case 4:
                            System.out.println("Saliendo de la aventura");
                            System.out.println("");
                            return;
                        
                        default:
                            System.out.println("Valor no controlado");
                            System.out.println("");
                    }
                }
            while (eleccionMenu != 1);
            if(eleccionMenu == 1)
            {

                System.out.println("**************************");
                System.out.println("   COMIENZA LA AVENTURA");
                System.out.println("**************************");
                prepararHeroe(heroe);

                System.out.println("");

                int enemigosDerrotados = 0;

                Historia.introduccion();
                Historia.combate1();

                BossGuerrero boss1 = new BossGuerrero("Maestro de armas Harlan", 40, 2, 5, 15);
                Combate.luchar(heroe, boss1);
                if(heroe.getVida() <= 0)
                {
                    guardarPuntuacion (rutaArchivo, heroe, enemigosDerrotados);
                    jugarOtravez = reiniciarPartida(sc);
                    continue;
                }
                enemigosDerrotados ++;
                
                Eventos.eventoAleatorio(heroe); 


                Historia.combate2();
                BossMago boss2 = new BossMago("Tejedor de fuego Koegler", 60, 0, 10, 15, 2);
                Combate.luchar(heroe, boss2);
                if(heroe.getVida() <= 0)
                {
                    guardarPuntuacion (rutaArchivo, heroe, enemigosDerrotados);       
                    jugarOtravez = reiniciarPartida(sc);
                    continue;
                }
                enemigosDerrotados ++;
                Eventos.eventoAleatorio(heroe); 

                
                Historia.combate3();
                BossFinal bossFinal = new BossFinal("Comandante Durand", 80, 2, 10, 20, 3);
                Combate.luchar(heroe, bossFinal);
                if(heroe.getVida() <= 0)
                {
                    guardarPuntuacion (rutaArchivo, heroe, enemigosDerrotados);
                    jugarOtravez = reiniciarPartida(sc);
                    continue;
                }
                else if(heroe.getVida() >= 0)
                {
                    Historia.epilogo();
                    System.out.println("¡¡¡ENHORABUENA HAS COMPLETADO LA AVENTURA!!!");
                    enemigosDerrotados ++;

                    int puntosTotales =(enemigosDerrotados * 100) + heroe.getVida();
                    gestorClasificacion.modificarXML(rutaArchivo, heroe.getNombre(), String.valueOf(puntosTotales));
                }
                jugarOtravez = reiniciarPartida(sc);
                }
            jugarOtravez = reiniciarPartida(sc);
        
        }sc.close();
    }
    public static Personaje seleccionarHeroe(Scanner sc)
        {
        Guerrero guerrero = new Guerrero("Guerrero", 100, 2, 5, 15);
        Ladron ladron = new Ladron("Ladron", 75, 0, 10, 20);
        Mago mago = new Mago("Mago", 80, 0, 5, 15, 2);
        Personaje heroe = new Personaje(null, 0, 0, 0, 0); 
            System.out.println("\n");
            System.out.println("=============================");
            System.out.println("     Selecciona el Heroe");
            System.out.println("=============================");
            System.out.println("1.Guerrero");
            guerrero.mostrarEstadisticas();
            System.out.println("");

            System.out.println("2.Ladron");
            ladron.mostrarEstadisticas();
            System.out.println("Tiene la probabilidad de hacer criticos");
            System.out.println("");
                
            System.out.println("3.Mago");
            mago.mostrarEstadisticas();
            System.out.println("Empieza con un arma magica (+2 PA)");
            System.out.println("");

            int seleccionHeroe = sc.nextInt();
            System.out.println("");

            switch (seleccionHeroe) 
            {
                case 1:
                    heroe = new Guerrero("Guerrero", 100, 2, 5, 15);
                    System.out.println("Has escogido al guerrero");
                break;
                case 2:
                    heroe = new Ladron("Ladron", 75, 0, 10, 20);
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
    public static void prepararHeroe(Personaje heroe)
    {
        for(int i = 0; i < 3; i++)
        {
        heroe.getInventario().agregarObjeto(new Objeto("poción de sanación", 25, "Poción revitalizante que cura heridas"));
        }
    }

    public static boolean reiniciarPartida(Scanner sc)
    {
        System.out.println("");
        System.out.println("= == == == == == == == == == == == == == == == = ");
        System.out.println("¿Desea jugar de nuevo?");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.println("= == == == == == == == == == == == == == == == = ");
        System.out.println("");

        int opcionPartida = sc.nextInt();

        return opcionPartida == 1;
    }

    public static void guardarPuntuacion(String ruta, Personaje heroe, int enemigosDerrotados)
    {
        int puntosTotales = enemigosDerrotados *100;
        gestorClasificacion.modificarXML(ruta, heroe.getNombre(), String.valueOf(puntosTotales));
    }
}
