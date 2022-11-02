import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        char respuesta ;

        do {

            Tablero t1 = new Tablero();

            Jugador jugador1 = new Jugador();
            Jugador jugador2 = new Jugador();

            jugador1.setFicha('R');
            jugador2.setFicha('Y');

            System.out.println(t1);

            int turno = 1;
            t1.inicializar();

            while (turno <= 42) {
                boolean seaValido;
                int jugada;
                do {


                    if (turno % 2 == 0) {
                        System.out.println("Turno: " + jugador1.getFicha());
                    } else {
                        System.out.println("Turno: " + jugador2.getFicha());
                    }
                    System.out.println("Mete una columna [1-7]: ");

                    Scanner sc = new Scanner(System.in);
                    jugada = sc.nextInt() - 1;

                    seaValido = t1.validar(jugada, t1);

                } while (!seaValido);


                //mete ficha jugador en tablero
                if(turno % 2 == 0){
                    jugador1.meterFicha(jugada, t1, jugador1);
                }
                else {
                    jugador2.meterFicha(jugada, t1, jugador2);
                }
                turno++;
                System.out.println(t1);
            }


            System.out.println("Tablero lleno");
            System.out.println("Quieres continuar? (s/n)");


            Scanner s = new Scanner(System.in);
            respuesta = s.next().charAt(0);
        }while (respuesta == 's' || respuesta == 'S');
    }
}
