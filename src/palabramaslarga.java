import java.util.Random;
import java.util.Scanner;

public class palabramaslarga {

    // Herramientas básicas globales
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();

    public static void main(String[] args) {
        System.out.println("=== PRUEBA: LA PALABRA MÁS LARGA ===");

        // 1. Llamamos a la función que genera las letras
        String letras = generarLetrasDisponibles();
        System.out.println("Letras disponibles: " + letras);

        // 2. Llamamos a la función que gestiona los turnos y los puntos
        ejecutarPrueba(letras);
    }

    
    // FUNCIÓN 1: Genera las letras (mínimo 4 vocales y 4 consonantes)
   
    public static String generarLetrasDisponibles() {
        String vocales = "AEIOU";
        String consonantes = "BCDFGHJLMNÑPRSTV";
        String resultado = "";

        // Generar 4 vocales obligatorias
        for (int i = 0; i < 4; i++) {
            int indice = r.nextInt(vocales.length());
            resultado = resultado + vocales.charAt(indice);
        }

        // Generar 4 consonantes obligatorias
        for (int i = 0; i < 4; i++) {
            int indice = r.nextInt(consonantes.length());
            resultado = resultado + consonantes.charAt(indice);
        }

        // Generar 2 letras más al azar para completar 10
        for (int i = 0; i < 2; i++) {
            if (r.nextBoolean()) {
                int indice = r.nextInt(vocales.length());
                resultado = resultado + vocales.charAt(indice);
            } else {
                int indice = r.nextInt(consonantes.length());
                resultado = resultado + consonantes.charAt(indice);
            }
        }

        return resultado;
    }

    
    // FUNCIÓN 2: Gestiona los turnos, el diccionario y los puntos
    
    public static void ejecutarPrueba(String letras) {
        // Turno del Jugador 1
        System.out.print("Jugador 1, escribe tu palabra: ");
        String palabraJ1 = sc.nextLine().toUpperCase();

        System.out.print("¿Jugador 2, la palabra del Jugador 1 es válida en el diccionario? (1 = Sí, 0 = No) ");
        int diccJ1 = sc.nextInt();
        sc.nextLine(); 

        // Turno del Jugador 2
        System.out.print("Jugador 2, escribe tu palabra: ");
        String palabraJ2 = sc.nextLine().toUpperCase();

        System.out.print("¿Jugador 1, la palabra del Jugador 2 es válida en el diccionario? (1 = Sí, 0 = No) ");
        int diccJ2 = sc.nextInt();

        // Calcular puntos 
        int puntosJ1 = 0;
        if (diccJ1 == 1) {
            puntosJ1 = palabraJ1.length();
        }

        int puntosJ2 = 0;
        if (diccJ2 == 1) {
            puntosJ2 = palabraJ2.length();
        }

        // Mostrar resultados y decidir el ganador
        System.out.println("--- RESULTADOS ---");
        System.out.println("Jugador 1 (" + palabraJ1 + "): " + puntosJ1 + " puntos");
        System.out.println("Jugador 2 (" + palabraJ2 + "): " + puntosJ2 + " puntos");

        if (puntosJ1 > puntosJ2) {
            System.out.println("¡Gana la prueba el Jugador 1!");
        } else if (puntosJ2 > puntosJ1) {
            System.out.println("¡Gana la prueba el Jugador 2!");
        } else {
            System.out.println("¡La prueba ha finalizado en empate!");
        }
    }
}


