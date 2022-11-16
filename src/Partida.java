import java.util.Scanner;

public class Partida {


    private char respuesta ;

    private boolean ganado;

    private Tablero t1 = new Tablero();

    private Jugador jugador1 = new Jugador();
    private Jugador jugador2 = new Jugador();

    private int turno = 1;


    public Partida(){
    }

    public void jugar(){
        jugador1.setFicha('R');
        jugador2.setFicha('Y');
        do{
            t1.inicializar();
            System.out.println(t1);
            introducirFicha();
            ganado=t1.comprobarVictoria();
            if(t1.comprobarTablero()){
                System.out.println("Quieres continuar? (s/n)");
                Scanner s = new Scanner(System.in);
                respuesta = s.next().charAt(0);
            }
        }while ((respuesta == 's' || respuesta == 'S') || !ganado);

    }

    public void introducirFicha(){
        while (turno <= 42) {
            int jugada = jugada();
            if(turno % 2 == 0){
                jugador1.meterFicha(jugada, t1, jugador1);
            }
            else {
                jugador2.meterFicha(jugada, t1, jugador2);
            }
            turno++;
            System.out.println(t1);
        }

    }

    public int jugada(){
        int jugada;
        boolean seaValido;
        do {
            if (turno % 2 == 0) {
                System.out.println("Turno: " + jugador1.getFicha());
            } else {
                System.out.println("Turno: " + jugador2.getFicha());
            }
            System.out.println("Mete una columna [1-7]: ");

            Scanner sc = new Scanner(System.in);
            jugada = sc.nextInt() -1;

            seaValido = t1.validar(jugada, t1);

        } while (!seaValido);
        return jugada;
    }
}
