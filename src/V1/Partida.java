package V1;

import V1.Tablero;

import java.util.Random;
import java.util.Scanner;

public class Partida {
    private Tablero table;
    private String color1;
    private String color2;
    private boolean turno;

    public Partida(String color1, String color2){
        this.table = new Tablero();
        this.color1=color1;
        this.color2=color2;

        turno=(new Random()).nextBoolean();
    }

    /**
     *
     * @param columna numero columna
     * @return verdadero o falso segun ganador o no
     */
    public boolean Ganador(int columna){
        String ganador;
        if(turno){
            ganador=color1;
        }
        else{
            ganador=color2;
        }
        return table.Ganador(columna,ganador);
    }


    /**
     * Inicia el juego
     */

    public void Comenzar() {
        boolean inicio = true;
        while (inicio) {
            table.printTablero();
            String color;
            if (turno) {
                color = color1;
                System.out.println("Turno jugador " + color1);
            } else {
                color = color2;
                System.out.println("Turno jugador " + color2);
            }
            System.out.print("Introduce columna. ");
            System.out.println("Elige entre 1 y " + table.getColumnas() + ": ");

            Scanner entrada = new Scanner(System.in);
            int columna = entrada.nextInt()-1;

            boolean correcta = table.validar(columna);

            if(correcta){
                table.meterFicha(columna, color);
                if(Ganador(columna)){
                    table.printTablero();
                    if(turno){
                        System.out.println("V1.Jugador " + color1 + " Gana!");
                    }
                    else{
                        System.out.println("V1.Jugador " + color2 + " Gana!");
                    }
                    System.out.println("Quieres jugar de nuevo? (y/n): ");
                    Scanner entrada1 = new Scanner(System.in);
                    String continuar = entrada1.nextLine();
                    if(continuar.toLowerCase().equals("y") || continuar.equals("Y")){
                        limpiar();
                    }
                    if(!(continuar.toLowerCase().equals("y") || continuar.equals("Y")) || continuar.toLowerCase().equals("n")|| continuar.equals("N")) {
                        inicio=false;
                    }
                }
                turno = !turno;
            }
        }
    }

    /**
     * Limpia tablero
     */
    public void limpiar(){
        this.table = new Tablero();
        turno = (new Random()).nextBoolean();
    }
}