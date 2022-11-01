import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        char respuesta = 's';

        while (respuesta == 's' || respuesta == 'S'){

            Tablero2 t1 = new Tablero2();
            char jugador = 'R';
            int turno = 1;

            System.out.println(t1);
            while (turno <= 42) {
                boolean seaValido;
                int jugada;
                do {

                    if (turno % 2 == 0) {
                        System.out.println("Turno: " + jugador);
                    } else {
                        System.out.println("Turno: " + jugador);
                    }
                    System.out.println("Mete una columna [1-7]: ");

                    java.util.Scanner sc = new java.util.Scanner(System.in);
                    jugada = sc.nextInt() - 1;

                    seaValido = validar(jugada, t1);

                } while (!seaValido);


                //mete una ficha
                for (int i = 6; i >= 0; i--) {
                    if (t1.getPosicion(i, jugada) == ' ') {
                        t1.setPosicion(i, jugada, jugador);
                        break;
                    }
                }

                //cambia entre los jugadores
                if (jugador == 'R') {
                    jugador = 'Y';
                } else {
                    jugador = 'R';
                }

                turno++;
                System.out.println(t1);
            }


            System.out.println("Tablero lleno");
            System.out.println("Quieres continuar? (s/n)");


            Scanner s = new Scanner(System.in);
            respuesta = s.next().charAt(0);

        }
    }



    public static boolean validar(int columna, Tablero2 tabl){

        //comprueba si el parametro esta dentro de la cantidad de columnas
        if (columna < 0 || columna > 6){
            System.out.println("Columna invalida. Valores [1-7]:");
            return false;
        }

        //comprueba si la columna pasada por parametro esta llena
        if (tabl.getPosicion(0, columna) != ' '){
            System.out.println("Columna invalida. Columna llena.");
            return false;
        }

        return true;
    }
}
