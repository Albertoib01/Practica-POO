import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Partida partida = new Partida();
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("---------Conecta 4---------\n");
        System.out.println("1.Jugar\n2.Salir");
        opcion = sc.nextInt();
        switch (opcion){
            case 0: break;
            case 1: partida.jugar(); break;
        }
    }
}
