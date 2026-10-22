import java.util.Scanner;

public class App {

    private static Scanner sc = new Scanner(System.in);

    public static int select = 0;
    public static void main(String[] args) throws Exception {
        
    }

    public static void menupp() {
        do {
            System.out.println("----------------");
            System.out.println(" MENÚ PRINCIPAL ");
            System.out.println("----------------");
            System.out.println("\n1. Modo Concurso");
            System.out.println("2. Modo Rápido");
            System.out.println("3. Configuración");
            System.out.println("4. Salir");

            System.out.println("Selecciona una opción (1-4): ");
            switch (select) {
                case 1:
                    menu1();
                    break;
                
                case 2:
                    menu2();
                    break;

                case 3:
                    
                    break;
            
                default:

                    break;
            }
        } while (select != 4);
    }

    public static void menu1() {
        do {
            System.out.println("------------------");
            System.out.println(" 1. MODO CONCURSO ");
            System.out.println("------------------");
            System.out.println("\n1. Modo Concurso");
            System.out.println("2. Modo Rápido");
            System.out.println("3. Configuración");
            System.out.println("4. Salir");

            System.out.println("Selecciona una opción (1-4): ");
            switch (select) {
                case 1:
                    menu1();
                    break;
                
                case 2:
                    menu2();
                    break;

                case 3:
                    
                    break;
            
                default:

                    break;
            }
        } while (select != 4);
    }

    public static void menu2() {

    }
}