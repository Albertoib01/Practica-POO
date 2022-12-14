import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu
{
    public  void ComenzarMenu() {
        Basic basic = new Basic();
        Demo demo = new Demo();
        Entrenamiento training = new Entrenamiento();

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("----- Conecta 4 -----");
            System.out.println("1. Opcion 1 (mode Basic)");
            System.out.println("2. Opcion 2 (mode Training)");
            System.out.println("3. Opcion 3 (mode Demo)");
            System.out.println("4. Salir");

            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        String continuar;
                        do {
                            System.out.println("Has seleccionado la opcion 1 (mode Basic)");
                            basic.BasicPlay();
                            System.out.println("Quieres jugar de nuevo? (y/n): ");
                            Scanner entrada1 = new Scanner(System.in);
                            continuar = entrada1.nextLine();
                        } while (continuar.toLowerCase().equals("y") || continuar.equals("Y"));
                        if(!(continuar.toLowerCase().equals("y") || continuar.equals("Y")) || continuar.toLowerCase().equals("n")|| continuar.equals("N")) {
                            salir=true;
                        }
                        break;
                    case 2:
                        do {
                            System.out.println("Has seleccionado la opcion 2 (mode Training)");
                            training.entrenamiento();
                            System.out.println("Quieres jugar de nuevo? (y/n): ");
                            Scanner entrada1 = new Scanner(System.in);
                            continuar = entrada1.nextLine();
                        } while (continuar.toLowerCase().equals("y") || continuar.equals("Y"));
                        if(!(continuar.toLowerCase().equals("y") || continuar.equals("Y")) || continuar.toLowerCase().equals("n")|| continuar.equals("N")) {
                            salir=true;
                        }
                        break;
                    case 3:
                        do {
                            System.out.println("Has seleccionado la opcion 3 (mode Demo)");
                            demo.ComenzarDemo();
                            System.out.println("Quieres jugar de nuevo? (y/n): ");
                            Scanner entrada1 = new Scanner(System.in);
                            continuar = entrada1.nextLine();
                        } while (continuar.toLowerCase().equals("y") || continuar.equals("Y"));
                        if(!(continuar.toLowerCase().equals("y") || continuar.equals("Y")) || continuar.toLowerCase().equals("n")|| continuar.equals("N")) {
                            salir=true;
                        }
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

}