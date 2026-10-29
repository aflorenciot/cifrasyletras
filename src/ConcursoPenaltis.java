
import java.util.Scanner;
import java.util.Random;

public class ConcursoPenaltis {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    static int goles1 = 0;
    static int goles2 = 0;

    public static void main(String[] args) {

        System.out.println("=== PENALTI MATEMATICO ===");
        System.out.println("Dos jugadores, cinco penaltis cada uno.");
        System.out.println();

        for (int i = 1; i <= 5; i++) {

            System.out.println("--- RONDA " + i + " ---");

            jugarPenalti(1);
            jugarPenalti(2);

            System.out.println();
            System.out.println("MARCADOR");
            System.out.println("Jugador 1: " + goles1);
            System.out.println("Jugador 2: " + goles2);
            System.out.println();
        }

        mostrarResultado();
    }

    public static void jugarPenalti(int jugador) {

        int num1 = random.nextInt(20) + 10;
        int num2 = random.nextInt(15) + 2;
        int operacion = random.nextInt(4) + 1;
        int resultado = 0;
        int respuesta;

        System.out.println("Turno del jugador " + jugador);

        if (operacion == 1) {
            resultado = num1 + num2;
            System.out.println("Calcula: " + num1 + " + " + num2);
        } else if (operacion == 2) {
            resultado = num1 - num2;
            System.out.println("Calcula: " + num1 + " - " + num2);
        } else if (operacion == 3) {
            num1 = random.nextInt(12) + 2;
            num2 = random.nextInt(9) + 2;
            resultado = num1 * num2;
            System.out.println("Calcula: " + num1 + " x " + num2);
        } else {
            num2 = random.nextInt(9) + 2;
            resultado = num2 * (random.nextInt(10) + 2);
            num1 = resultado;
            System.out.println("Calcula: " + num1 + " / " + num2);
            resultado = num1 / num2;
        }

        System.out.print("Resultado: ");
        respuesta = sc.nextInt();

        if (respuesta == resultado) {

            System.out.println("Correcto! Puedes chutar.");
            System.out.println("1. Izquierda");
            System.out.println("2. Centro");
            System.out.println("3. Derecha");
            System.out.print("Elige direccion: ");

            int direccion = sc.nextInt();

            while (direccion < 1 || direccion > 3) {
                System.out.print("Elige 1, 2 o 3: ");
                direccion = sc.nextInt();
            }

            int portero = random.nextInt(3) + 1;

            System.out.println("El portero elige: " + portero);

            if (direccion != portero) {

                System.out.println("GOOOOL!");

                if (jugador == 1) {
                    goles1++;
                } else {
                    goles2++;
                }

            } else {
                System.out.println("PARADA DEL PORTERO!");
            }

        } else {
            System.out.println("Incorrecto! Pierdes el penalti.");
            System.out.println("La respuesta era: " + resultado);
        }
    }

    public static void mostrarResultado() {

        System.out.println("=== RESULTADO FINAL ===");
        System.out.println("Jugador 1: " + goles1 + " goles");
        System.out.println("Jugador 2: " + goles2 + " goles");

        if (goles1 > goles2) {
            System.out.println("GANA EL JUGADOR 1!");
        } else if (goles2 > goles1) {
            System.out.println("GANA EL JUGADOR 2!");
        } else {
            System.out.println("EMPATE!");
        }
    }
}