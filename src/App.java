import java.util.Random;
import java.util.Scanner;

public class App {

    /**
     * VARIABLE GLOBALES
     */
    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();

    public static int select = 0;
    public static int gameJugador1 = 0;
    public static int gameJugador2 = 0;
    public static int numOperations = 5;

    public static String jugador1 = "jugador1";
    public static String jugador2 = "jugador2";

    /**
     * EJECUCIÓN DE MAIN
     */
    public static void main(String[] args) throws Exception {
        do {
            System.out.println("----------------");
            System.out.println(" MENÚ PRINCIPAL ");
            System.out.println("----------------");
            System.out.println("\n1. Modo Concurso");
            System.out.println("2. Modo Rápido");
            System.out.println("3. Configuración");
            System.out.println("4. Salir");

            System.out.print("Selecciona una opción: ");
            select = sc.nextInt();
            
            switch (select) {
                case 1:
                    break;
                
                case 2:
                    modoRapido();
                    break;

                case 3:
                    break;

                case 4:
                    break;
            }
        } while (select != 4);
    }

    /**
     * FUNCIÓN MODO RÁPIDO
     */
    public static void modoRapido() {
        System.out.println("\n=== MODO RÁPIDO ===");
        System.out.println("1. Cifra exacta");
        System.out.println("2. La palabra más larga");
        System.out.println("3. La calculadora humana");
        System.out.println("4. Prueba original (El código secreto)");

        System.out.print("Selecciona la prueba que deseas jugar (1-3): ");
        int select = sc.nextInt();

        switch (select) {
            case 1:
                //jugarCifraExacta();
                break;
            case 2:
                //jugarPalabraMasLarga();
                break;
            case 3:
                calculadoreHumana();
                break;
            case 4:
                //jugarPruebaOriginal();
                break;
        }

        if (gameJugador1 > gameJugador2) {
            System.out.println("\n¡Ganador de la prueba: " + jugador1 + "!");
        } else if (gameJugador2 > gameJugador1) {
            System.out.println("\n¡Ganador de la prueba: " + jugador2 + "!");
        } else {
            System.out.println("\n¡La prueba ha finalizado en empate!");
        }
    }

    /**
     * FUNCIÓN CALCULADORA HUMANA
     */
    public static void calculadoraHumana() {
        System.out.println("\n >>> CALCULADORA HUMANA <<< ");
        System.out.println("\n El programa dará una operación random que se debe realizar");

        System.out.println();
    }
}