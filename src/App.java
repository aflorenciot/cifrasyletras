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
    public static int numOpera = 5;
    public static int repeticionesPruebas = 1;
    public static int cantidadLetras = 10;

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
            sc.nextLine();
            
            switch (select) {
                case 1:
                    break;
                
                case 2:
                    modoRapido();
                    break;

                case 3:
                    settingsProgram();
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
        sc.nextLine();

        switch (select) {
            case 1:
                //jugarCifraExacta();
                break;
            case 2:
                //jugarPalabraMasLarga();
                break;
            case 3:
                calculadoraHumana();
                break;
            case 4:
                //jugarPruebaOriginal();
                break;
        }
    }

    /**
     * FUNCIÓN CALCULADORA HUMANA
     */
    public static void calculadoraHumana() {
        System.out.println("\n---------------------");
        System.out.println("LA CALCULADORA HUMANA");
        System.out.println("---------------------");
        System.out.println("Se realizarán " + numOpera + " operaciones mentales.");
        System.out.println("Los dos jugadores dispondrán de . Cada error añade 20 segundos de penalización.");

        System.out.println("\nTurno de " + jugador1 + ":");
        System.out.print("Presiona ENTER cuando estés listo para comenzar...");
        sc.nextLine();
        double tiempo1 = rondaCalculadora();

        System.out.println("\nTurno de " + jugador2 + ":");
        System.out.print("Presiona ENTER cuando estés listo para comenzar...");
        sc.nextLine();
        double tiempo2 = rondaCalculadora();

        System.out.println("\n--- RESULTADOS CALCULADORA HUMANA ---");
        System.out.println(jugador1 + ": " + tiempo1 + " segundos");
        System.out.println(jugador2 + ": " + tiempo2 + " segundos");

        if (tiempo1 < tiempo2) {
            gameJugador1++;
            System.out.println("\n¡Ganador de la prueba: " + jugador1 + "!");
        } else if (tiempo2 < tiempo1) {
            gameJugador2++;
            System.out.println("\n¡Ganador de la prueba: " + jugador2 + "!");
        } else {
            System.out.println("\n¡La prueba ha finalizado en empate!");
        }
    }

    public static double rondaCalculadora() {
        int errores = 0;
        int numInicial = r.nextInt(100) + 1;
        char[] operaciones = {'+', '-', '*', '/'};

        long tiempoInicio = System.currentTimeMillis();

        for (int i = 0; i < numOpera; i++) {
            char op = operaciones[r.nextInt(operaciones.length)];
            int valorSecundario = 0;
            int resultadoCorrecto = 0;

            if (op == '+' || op == '-') {
                valorSecundario = r.nextInt(90) + 10;
            } else {
                valorSecundario = r.nextInt(9) + 1;
            }

            if (op == '/') {
                int cociente = r.nextInt(10) + 1;
                numInicial = valorSecundario * cociente;
            }

            switch (op) {
                case '+':
                    resultadoCorrecto = numInicial + valorSecundario;
                    break;
                case '-':
                    resultadoCorrecto = numInicial - valorSecundario;
                    break;
                case '*':
                    resultadoCorrecto = numInicial * valorSecundario;
                    break;
                case '/':
                    resultadoCorrecto = numInicial / valorSecundario;
                    break;
            }

            System.out.println("\nOperación " + (i + 1) + ": " + numInicial + " " + op + " " + valorSecundario);
            System.out.print("Tu respuesta: ");
            int respuestaUsuario = sc.nextInt();
            sc.nextLine();

            if (respuestaUsuario == resultadoCorrecto) {
                System.out.println("¡Correcto!");
            } else {
                System.out.println("¡Incorrecto! El resultado era: " + resultadoCorrecto);
                errores++;
            }

            numInicial = resultadoCorrecto;
        }

        long tiempoFin = System.currentTimeMillis();
        
        double tiempoTotalSegundos = (tiempoFin - tiempoInicio) / 1000.0 + (errores * 20);
        
        System.out.println("\nTiempo base: " + ((tiempoFin - tiempoInicio) / 1000.0) + " segundos.");
        System.out.println("Errores cometidos: " + errores + " (Penalización: " + (errores * 20) + " segundos).");
        
        return tiempoTotalSegundos;
    }
    /**
     * FUNCIÓN SOBRE LA CONFIGURACIÓN DEL PROGRAMA
     */
    public static void settingsProgram() {
        do {
            System.out.println("\n-----------------------");
            System.out.println(" MENÚ DE CONFIGURACIÓN ");
            System.out.println("-----------------------");
            System.out.println("1. Modificar repeticiones de las pruebas (Actual: " + repeticionesPruebas + ")");
            System.out.println("2. Modificar cantidad de letras (Actual: " + cantidadLetras + ")");
            System.out.println("3. Modificar cantidad de operaciones en Calculadora Humana (Actual: " + numOpera + ")");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Selecciona una opción: ");
            
            select = sc.nextInt();

            switch (select) {
                case 1:
                    System.out.print("Introduce el nuevo número de repeticiones (mínimo 1): ");
                    int nuevasRep = sc.nextInt();
                    if (nuevasRep >= 1) {
                        repeticionesPruebas = nuevasRep;
                        System.out.println("¡Configuración actualizada con éxito!");
                    } else {
                        System.out.println("Error: El número de repeticiones debe ser al menos 1.");
                    }
                    break;

                case 2:
                    System.out.print("Introduce la cantidad de letras (mínimo 8, 4 vocales y 4 consonantes): ");
                    int nuevasLetras = sc.nextInt();
                    if (nuevasLetras >= 8) {
                        cantidadLetras = nuevasLetras;
                        System.out.println("¡Configuración actualizada con éxito!");
                    } else {
                        System.out.println("Error: La cantidad de letras debe ser al menos 8 para cumplir con el mínimo de vocales y consonantes.");
                    }
                    break;

                case 3:
                    System.out.print("Introduce la cantidad de operaciones para la calculadora humana (mínimo 1): ");
                    int nuevasOps = sc.nextInt();
                    if (nuevasOps >= 1) {
                        numOpera = nuevasOps;
                        System.out.println("¡Configuración actualizada con éxito!");
                    } else {
                        System.out.println("Error: Debe haber al menos 1 operación.");
                    }
                    break;

                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (select != 4);
    }
    
    
}