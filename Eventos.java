import java.util.concurrent.ThreadLocalRandom;
public class Eventos 
{
    public static void eventoAleatorio(Personaje heroe)
    {
        int evento = ThreadLocalRandom.current().nextInt(1,9);

        System.out.println("\n==================================");
        System.out.println("       EVENTO");
        System.out.println("==================================\n");

        switch (evento) 
        {
            case 1:
                System.out.println("");
                System.out.println("Tras derrotar al jefe encuentras un pequeño cofre");
                System.out.println("Abres el cofre y... encuentras una simple poción");
                heroe.getInventario().agregarObjeto(new Objeto("poción de sanación", 25, "Poción revitalizante que cura heridas"));
                System.out.println("");
            break;
        
            case 2:
                System.out.println("");
                System.out.println("Pasada la sala del jefe encuentras un gran baúl");
                System.out.println("Abres el baúl con cierta dificultad y... esta lleno de pociones!!!");
                Aventura.prepararHeroe(heroe);
                System.out.println("");
            break;

            case 3:
                System.out.println("");
                System.out.println("Tras eliminar al jefe deja caer una bolsa pesada...");
                System.out.println("La abres y ves un gran cantidad de oro!!!");
                System.out.println("Una pena que no estemos aqui por eso...");
                System.out.println("");
            break;

            case 4:
                System.out.println("");
                System.out.println("Al derrotar al jefe encuentras un estante con pergaminos en un sala contigua...");
                System.out.println("Ves lo que parece ser una hechizo para armas de la casa Darrow");
                System.out.println("Recitas las escritura y tu arma tiembla!!! (aumentando tu daño en +2)");
                heroe.setAtaqueMinimo(heroe.getAtaqueMinimo() + 2);
                heroe.setAtaqueMaximo(heroe.getAtaqueMaximo() + 2 );
                System.out.println("");
            break;

            case 5:
                System.out.println("");
                System.out.println("El camino parece tranquilo, continuas tu aventura...");
                System.out.println("");
            break;

            case 6:
                System.out.println("");
                System.out.println("Continuas el camino y te encuentras con una pequeña forja mágica");
                System.out.println("Encuentras un pequeño pergamino con la runa de un escudo");
                System.out.println("Decides leerlo (aumenta tu armadura en +2)");
                heroe.setArmadura(heroe.getArmadura() + 2);
                System.out.println("");
            break;

            case 7:
                System.out.println("");
                System.out.println("El camino parece tranquilo, continuas tu aventura...");
                System.out.println("");
            break;
            
            case 8:
                System.out.println("");
                System.out.println("El camino parece tranquilo, continuas tu aventura...");
                System.out.println("Tropiezas con un mochila de explorador");
                System.out.println("La mochila contenia una poción!!!");
                heroe.getInventario().agregarObjeto(new Objeto("poción de sanación", 25, "Poción revitalizante que cura heridas"));
                System.out.println("");
            break;
        }
    }
}
