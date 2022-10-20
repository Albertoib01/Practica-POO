public class Main2 {

    public static void main(String[] args) {

        Tablero2 t1 = new Tablero2();

        char jugador = 'R';

        int turno = 1;

        while (turno <= 42) {
            boolean seaValido;
            int jugada;
            do {
                System.out.println(t1);

                if (turno % 2 == 0) {
                    System.out.println("Turno: " + jugador);
                } else {
                    System.out.println("Turno: " + jugador);
                }
                System.out.println("Mete una columna: ");

                java.util.Scanner sc = new java.util.Scanner(System.in);
                jugada = sc.nextInt();

                seaValido = validar(jugada, t1);

            } while (seaValido == false);

            turno++;


            for (int i = 7; i >= 0; i--) {
                if (t1.getPosicion(jugada, i) == ' ') {
                    t1.setPosicion(jugada, i, jugador);
                    break;
                }
            }


            if (jugador == 'R') {
                jugador = 'Y';
            } else {
                jugador = 'R';
            }
        }
    }



    public static boolean validar(int columna, Tablero2 tabl){

        if (columna < 0 || columna > 6){
            return false;
        }

        if (tabl.getPosicion(0, columna) != ' '){
            return false;
        }

        return true;
    }
}
