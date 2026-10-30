import java.util.Random;
import java.util.Scanner;

public class CifrasYLetras {

    /**
     * VARIABLE GLOBALES
     */
    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();

    public static int select1 = 0;
    public static int select2 = 0;
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
            select1 = sc.nextInt();
            sc.nextLine();
            
            switch (select1) {
                case 1:
                    modoConcurso();
                    break;
                
                case 2:
                    modoRapido();
                    break;

                case 3:
                    settingsProgram();
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (select1 != 4);
    }

    /**
     * FUNCIÓN MODO CONCURSO
     */
    public static void modoConcurso() {
        System.out.println("\n=== MODO CONCURSO ===");
        jugarCifraExacta();
        jugarPalabraMasLarga();
        calculadoraHumana();
        jugarPruebaOriginal();
    }

    /**
     * FUNCIÓN MODO RÁPIDO
     */
    public static void modoRapido() {
        System.out.println("\n=== MODO RÁPIDO ===");
        System.out.println("1. Cifra exacta");
        System.out.println("2. La palabra más larga");
        System.out.println("3. La calculadora humana");
        System.out.println("4. Prueba original (Penalti Matemático)");

        System.out.print("Selecciona la prueba que deseas jugar (1-4): ");
        int select = sc.nextInt();
        sc.nextLine();

        switch (select) {
            case 1:
                jugarCifraExacta();
                break;
            case 2:
                jugarPalabraMasLarga();
                break;
            case 3:
                calculadoraHumana();
                break;
            case 4:
                jugarPruebaOriginal();
                break;
            default:
                System.out.println("Prueba no válida.");
        }
    }

    /**
     * FUNCIÓN LA CIFRA EXACTA
     */
    public static void jugarCifraExacta() {
        System.out.println("\n=== PRUEBA: LA CIFRA EXACTA ===");
        
        int objetivo = r.nextInt(900) + 100;
        System.out.println("Número objetivo a alcanzar: >>> " + objetivo + " <<<");

        int a1 = r.nextInt(10) + 1;
        int a2 = r.nextInt(10) + 1;
        int a3 = r.nextInt(10) + 1;
        int a4 = r.nextInt(10) + 1;
        int a5 = r.nextInt(10) + 1;
        int a6 = r.nextInt(10) + 1;

        int diferenciaJ1 = turnoJugadorCifra(jugador1, objetivo, a1, a2, a3, a4, a5, a6);
        int diferenciaJ2 = turnoJugadorCifra(jugador2, objetivo, a1, a2, a3, a4, a5, a6);

        System.out.println("\n--- RESULTADOS CIFRA EXACTA ---");
        System.out.println("Diferencia de " + jugador1 + ": " + diferenciaJ1);
        System.out.println("Diferencia de " + jugador2 + ": " + diferenciaJ2);

        if (diferenciaJ1 < diferenciaJ2) {
            gameJugador1++;
            System.out.println("¡Gana la prueba " + jugador1 + " por estar más cerca!");
        } else if (diferenciaJ2 < diferenciaJ1) {
            gameJugador2++;
            System.out.println("¡Gana la prueba " + jugador2 + " por estar más cerca!");
        } else {
            System.out.println("¡La prueba ha finalizado en empate!");
        }
    }

    public static int turnoJugadorCifra(String nombre, int objetivo, int a1, int a2, int a3, int a4, int a5, int a6) {
        System.out.println("\n--- Turno de " + nombre + " ---");
        int acumulado = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.println("\nOperación " + i + " de 5");
            System.out.println("Números disponibles: [ " + a1 + "  " + a2 + "  " + a3 + "  " + a4 + "  " + a5 + "  " + a6 + " ]");

            int n1 = 0;
            if (i == 1) {
                System.out.print("Elige el primer número: ");
                n1 = sc.nextInt();
                sc.nextLine();
            } else {
                n1 = acumulado;
                System.out.println("Usando el resultado anterior como primer número: " + n1);
            }

            System.out.print("Elige el siguiente número auxiliar: ");
            int n2 = sc.nextInt();
            sc.nextLine();

            System.out.print("Elige operación (+ (sumar), - (restar), * (multiplicar), / (dividir)): ");
            char opcion = sc.next().charAt(0);
            sc.nextLine();

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

        int diferencia = acumulado - objetivo;
        if (diferencia < 0) {
            diferencia = diferencia * -1;
        }

        System.out.println(">>> Resultado final de " + nombre + ": " + acumulado + " (Diferencia: " + diferencia + ")");
        return diferencia;
    }

    /**
     * FUNCIÓN LA PALABRA MÁS LARGA
     */
    public static void jugarPalabraMasLarga() {
        System.out.println("\n=== PRUEBA: LA PALABRA MÁS LARGA ===");
        
        String letras = generarLetrasDisponibles();
        System.out.println("Letras disponibles: " + letras);

        System.out.print(jugador1 + ", escribe tu palabra: ");
        String palabraJ1 = sc.nextLine().toUpperCase();

        System.out.print("¿" + jugador2 + ", la palabra de " + jugador1 + " es válida en el diccionario? (1 = Sí, 0 = No) ");
        int diccJ1 = sc.nextInt();
        sc.nextLine(); 

        System.out.print(jugador2 + ", escribe tu palabra: ");
        String palabraJ2 = sc.nextLine().toUpperCase();

        System.out.print("¿" + jugador1 + ", la palabra de " + jugador2 + " es válida en el diccionario? (1 = Sí, 0 = No) ");
        int diccJ2 = sc.nextInt();
        sc.nextLine();

        int puntosJ1 = 0;
        if (diccJ1 == 1) {
            puntosJ1 = palabraJ1.length();
        }

        int puntosJ2 = 0;
        if (diccJ2 == 1) {
            puntosJ2 = palabraJ2.length();
        }

        System.out.println("\n--- RESULTADOS PALABRA MÁS LARGA ---");
        System.out.println(jugador1 + " (" + palabraJ1 + "): " + puntosJ1 + " puntos");
        System.out.println(jugador2 + " (" + palabraJ2 + "): " + puntosJ2 + " puntos");

        if (puntosJ1 > puntosJ2) {
            gameJugador1++;
            System.out.println("¡Gana la prueba " + jugador1 + "!");
        } else if (puntosJ2 > puntosJ1) {
            gameJugador2++;
            System.out.println("¡Gana la prueba " + jugador2 + "!");
        } else {
            System.out.println("¡La prueba ha finalizado en empate!");
        }
    }

    public static String generarLetrasDisponibles() {
        String vocales = "AEIOU";
        String consonantes = "BCDFGHJLMNÑPRSTV";
        String resultado = "";

        for (int i = 0; i < 4; i++) {
            int indice = r.nextInt(vocales.length());
            resultado = resultado + vocales.charAt(indice);
        }

        for (int i = 0; i < 4; i++) {
            int indice = r.nextInt(consonantes.length());
            resultado = resultado + consonantes.charAt(indice);
        }

        for (int i = 0; i < (cantidadLetras - 8); i++) {
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

    /**
     * FUNCIÓN CALCULADORA HUMANA
     */
    public static void calculadoraHumana() {
        System.out.println("\n---------------------");
        System.out.println("LA CALCULADORA HUMANA");
        System.out.println("---------------------");
        System.out.println("Se realizarán " + numOpera + " operaciones mentales.");
        System.out.println("Los dos jugadores dispondrán de tiempo cronometrado. Cada error añade 20 segundos de penalización.");

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
     * FUNCIÓN PRUEBA ORIGINAL: PENALTI MATEMÁTICO (Integrada)
     */
    public static void jugarPruebaOriginal() {
        System.out.println("\n=== PRUEBA ORIGINAL: PENALTI MATEMÁTICO ===");
        System.out.println("Dos jugadores, cinco penaltis cada uno.");
        System.out.println();

        int goles1 = 0;
        int goles2 = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.println("--- RONDA " + i + " ---");

            goles1 += turnoPenalti(jugador1);
            goles2 += turnoPenalti(jugador2);

            System.out.println();
            System.out.println("MARCADOR DE LA PRUEBA");
            System.out.println(jugador1 + ": " + goles1 + " goles");
            System.out.println(jugador2 + ": " + goles2 + " goles");
            System.out.println();
        }

        System.out.println("=== RESULTADO FINAL PRUEBA ORIGINAL ===");
        System.out.println(jugador1 + ": " + goles1 + " goles");
        System.out.println(jugador2 + ": " + goles2 + " goles");

        if (goles1 > goles2) {
            gameJugador1++;
            System.out.println("¡Gana la prueba " + jugador1 + "!");
        } else if (goles2 > goles1) {
            gameJugador2++;
            System.out.println("¡Gana la prueba " + jugador2 + "!");
        } else {
            System.out.println("¡La prueba ha finalizado en empate!");
        }
    }

    public static int turnoPenalti(String nombreJugador) {
        int num1 = r.nextInt(20) + 10;
        int num2 = r.nextInt(15) + 2;
        int operacion = r.nextInt(4) + 1;
        int resultado = 0;
        int respuesta;

        System.out.println("Turno de " + nombreJugador);

        if (operacion == 1) {
            resultado = num1 + num2;
            System.out.println("Calcula: " + num1 + " + " + num2);
        } else if (operacion == 2) {
            resultado = num1 - num2;
            System.out.println("Calcula: " + num1 + " - " + num2);
        } else if (operacion == 3) {
            num1 = r.nextInt(12) + 2;
            num2 = r.nextInt(9) + 2;
            resultado = num1 * num2;
            System.out.println("Calcula: " + num1 + " x " + num2);
        } else {
            num2 = r.nextInt(9) + 2;
            resultado = num2 * (r.nextInt(10) + 2);
            num1 = resultado;
            System.out.println("Calcula: " + num1 + " / " + num2);
            resultado = num1 / num2;
        }

        System.out.print("Resultado: ");
        respuesta = sc.nextInt();
        sc.nextLine();

        if (respuesta == resultado) {
            System.out.println("¡Correcto! Puedes chutar.");
            System.out.println("1. Izquierda");
            System.out.println("2. Centro");
            System.out.println("3. Derecha");
            System.out.print("Elige dirección: ");

            int direccion = sc.nextInt();
            sc.nextLine();

            while (direccion < 1 || direccion > 3) {
                System.out.print("Elige 1, 2 o 3: ");
                direccion = sc.nextInt();
                sc.nextLine();
            }

            int portero = r.nextInt(3) + 1;
            System.out.println("El portero elige: " + portero);

            if (direccion != portero) {
                System.out.println("¡GOOOOL!");
                return 1;
            } else {
                System.out.println("¡PARADA DEL PORTERO!");
                return 0;
            }

        } else {
            System.out.println("¡Incorrecto! Pierdes el penalti.");
            System.out.println("La respuesta era: " + resultado);
            return 0;
        }
    }

    /**
     * MENÚ DE CONFIGURACIÓN DEL PROGRAMA
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
            select2 = sc.nextInt();
            sc.nextLine();

            switch (select2) {
                case 1:
                    System.out.print("Introduce el nuevo número de repeticiones (mínimo 1): ");
                    int numRep = sc.nextInt();
                    sc.nextLine();
                    if (numRep >= 1) {
                        repeticionesPruebas = numRep;
                        System.out.println("¡Configuración actualizada con éxito!");
                    } else {
                        System.out.println("Error: El número de repeticiones debe ser al menos 1.");
                    }
                    break;

                case 2:
                    System.out.print("Introduce la cantidad de letras (mínimo 8, 4 vocales y 4 consonantes): ");
                    int numWord = sc.nextInt();
                    sc.nextLine();
                    if (numWord >= 8) {
                        cantidadLetras = numWord;
                        System.out.println("¡Configuración actualizada con éxito!");
                    } else {
                        System.out.println("Error: La cantidad de letras debe ser al menos de 8 caracteres.");
                    }
                    break;

                case 3:
                    System.out.print("Introduce la cantidad de operaciones para la calculadora humana (mínimo 1): ");
                    int numOp = sc.nextInt();
                    sc.nextLine();
                    if (numOp >= 1) {
                        numOpera = numOp;
                        System.out.println("¡Configuración actualizada con éxito!");
                    } else {
                        System.out.println("Error: Debe haber al menos 1 operación.");
                    }
                    break;

                case 4:
                    System.out.println("Volviendo al Menú Principal...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while(select2 != 4);
    }
}