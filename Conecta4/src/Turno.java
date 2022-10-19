import java.util.Scanner;
import java.util.Random;

public class Turno {

    private Tablero tablero;

    private Jugador jugador;

    private int fila, columna;

    public Turno(Jugador jugador, Tablero tablero){
        this.jugador=jugador;
        this.tablero = tablero;
    }

    public void colocarFicha(){
        int lleno=0;
        String contenido;
        Scanner sc = new Scanner(System.in);
        System.out.println(tablero);
        System.out.println("Turno: "+jugador.getFicha());
        System.out.println("Introduce una columna donde dejar la ficha: ");
        columna = sc.nextInt();
        while(columna>7 || columna<1){
            System.out.println("Columna Incorrecta !! Valores [1-7]");
            System.out.println("Turno: "+jugador.getFicha());
            System.out.println("Introduce una columna donde dejar la ficha: ");
            columna = sc.nextInt();
        }
        for(int i = 0; i<tablero.filas;i++){
            contenido=tablero.getPosicion(i,columna);
            if(contenido != ""){

            }
        }
    }
}
