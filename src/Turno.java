import java.util.Scanner;
import java.util.Random;

public class Turno {

    private Tablero tablero;

    private Jugador jugador;

    private int fila = 0, columna = 0;

    public Turno(Jugador jugador, Tablero tablero){
        this.jugador=jugador;
        this.tablero = tablero;
    }

    public void colocarFicha(){

        String contenido;
        Scanner sc = new Scanner(System.in);
        System.out.println(tablero);
        System.out.println("Turno: "+jugador.getFicha());
        System.out.println("Introduce una columna donde dejar la ficha: ");
        columna = sc.nextInt();
        while(!validar(columna, tablero)){
            System.out.println("Columna Incorrecta !! Valores [1-7]");
            System.out.println("Turno: "+jugador.getFicha());
            System.out.println("Introduce una columna donde dejar la ficha: ");
            columna = sc.nextInt();
        }
        for(int i = 0; i<tablero.filas;i++){
            contenido=tablero.getPosicion(i,columna);
            if(contenido != ""){
                i++;
            } else {
                tablero.setFicha(i, columna, jugador.getFicha());
            }
        }
    }


    public boolean validar(int columna, Tablero tablero){

            if (columna < 0 || columna > 6) {                          //comprueba columna valida
                return false;
            }

            if (tablero.getPosicion(0, columna) != " ") {           //comprueba si columna llena
                return false;
            }

        return true;
    }
}
