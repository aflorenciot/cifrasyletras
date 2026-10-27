
import java.util.Random;
import java.util.Scanner;

public class cifraexacta {

    // Herramientas globales básicas
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();

    public static void main(String[] args) {
        System.out.println("=== PRUEBA: LA CIFRA EXACTA ===");
        jugarCifraExacta();
    }

    
    // FUNCIÓN 1: Controla la generación del objetivo y los turnos

    public static void jugarCifraExacta() {
        // Generar un número objetivo aleatorio de tres cifras (entre 100 y 999)
        int objetivo = r.nextInt(900) + 100;
        System.out.println("Número objetivo a alcanzar: >>> " + objetivo + " <<<");

        // Generar 6 números auxiliares entre 1 y 10
        int a1 = r.nextInt(10) + 1;
        int a2 = r.nextInt(10) + 1;
        int a3 = r.nextInt(10) + 1;
        int a4 = r.nextInt(10) + 1;
        int a5 = r.nextInt(10) + 1;
        int a6 = r.nextInt(10) + 1;

        // Turno del Jugador 1
        int diferenciaJ1 = turnoJugador("Jugador 1", objetivo, a1, a2, a3, a4, a5, a6);

        // Turno del Jugador 2
        int diferenciaJ2 = turnoJugador("Jugador 2", objetivo, a1, a2, a3, a4, a5, a6);

        // Mostrar resultados y decidir el ganador (gana quien tenga menor diferencia)
        System.out.println("--- RESULTADOS FINALES ---");
        System.out.println("Diferencia del Jugador 1: " + diferenciaJ1);
        System.out.println("Diferencia del Jugador 2: " + diferenciaJ2);

        if (diferenciaJ1 < diferenciaJ2) {
            System.out.println("¡Gana la prueba el Jugador 1 por estar más cerca![cite: 2]");
        } else if (diferenciaJ2 < diferenciaJ1) {
            System.out.println("¡Gana la prueba el Jugador 2 por estar más cerca![cite: 2]");
        } else {
            System.out.println("¡La prueba ha finalizado en empate![cite: 2]");
        }
    }

    
    // FUNCIÓN 2: Gestiona las 5 operaciones de cada jugador
    public static int turnoJugador(String nombre, int objetivo, int a1, int a2, int a3, int a4, int a5, int a6) {
        System.out.println("--- Turno de " + nombre + " ---");
        int acumulado = 0;

        // Cada jugador realiza 5 operaciones
        for (int i = 1; i <= 5; i++) {
            System.out.println("\nOperación " + i + " de 5");
            System.out.println("Números disponibles: [ " + a1 + "  " + a2 + "  " + a3 + "  " + a4 + "  " + a5 + "  " + a6 + " ]");

            int n1 = 0;
            if (i == 1) {
                System.out.print("Elige el primer número: ");
                n1 = sc.nextInt();
            } else {
                n1 = acumulado;
                System.out.println("Usando el resultado anterior como primer número: " + n1);
            }

            System.out.print("Elige el siguiente número auxiliar: ");
            int n2 = sc.nextInt();

            System.out.print("Elige operación (+ (sumar), - (restar), * (multiplicar), / (dividir)) ");
            char opcion = sc.next().charAt(0);

            // Realizar el cálculo de la operación permitida
            if (opcion == '+') {
                acumulado = n1 + n2;
            } else if (opcion == '-') {
                acumulado = n1 - n2;
            } else if (opcion == '*') {
                acumulado = n1 * n2;
            } else if (opcion == '/') {
                if (n2 != 0) {
                    acumulado = n1 / n2;
                } else {
                    System.out.println("Error: No se puede dividir entre cero. Se mantiene el número anterior.");
                    acumulado = n1;
                }
            } else {
                System.out.println("Operación no válida. Se mantiene el número anterior.");
                acumulado = n1;
            }

            System.out.println("Resultado de esta operación: " + acumulado);
        }

        // Calcular la diferencia absoluta respecto al objetivo
        int diferencia = acumulado - objetivo;
        if (diferencia < 0) {
            diferencia = diferencia * -1; // Convertir a positivo si es menor
        }

        System.out.println(">>> Resultado final de " + nombre + ": " + acumulado + " (Diferencia: " + diferencia + ")");
        return diferencia;
    }
}

