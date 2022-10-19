import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Turno turno;

        Jugador jugador1;

        Jugador jugador2;

        Tablero tablero = new Tablero();

        System.out.println("--- CONECTA 4 ---\n");

        tablero.inicializar();
        tablero.toString();

        Random rnd = new Random();
        int num = (rnd.nextInt() * 10+1);
        if(num%2 == 0){
            jugador1 = new Jugador("Y");
            jugador2 = new Jugador("R");
        }
        else{
            jugador1 = new Jugador("R");
            jugador2 = new Jugador("Y");
        }

        do{
            turno = new Turno(jugador1,tablero);
            turno.colocarFicha();
            turno= new Turno(jugador2,tablero);
            turno.colocarFicha();
        }while(!tablero.lleno());
    }
}