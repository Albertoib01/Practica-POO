import java.util.Scanner;
public class Basic implements IJuego{
    private static int PosColumn;
    private static Conecta4 tablero;


    public void BasicPlay (){
        tablero = new Conecta4();
        tablero.printTablero();
        jugar();
        System.out.println();
        ganador();
    }

    @Override
    public void jugar() {
        while(!tablero.Final()) {
            System.out.println();
            switch (tablero.ultimoJugador) {
                //Turno R
                case Conecta4.Y:
                    System.out.print("Turno: R");
                    try {
                        do {
                            System.out.print("\nIntroduce una columna para meter una ficha (1-7): ");
                            Scanner in = new Scanner(System.in);
                            PosColumn = in.nextInt();
                        } while (tablero.ColumnaLlena(PosColumn -1));
                    } catch (Exception e){
                        System.out.println("Numero invalido. Valores [1-7]");
                        break;
                    }
                    //Movimiento de usuario
                    tablero.desplazaColumna(PosColumn -1, Conecta4.R);
                    System.out.println();
                    break;
                //Turn Y
                case Conecta4.R:
                    System.out.print("Turno: Y");
                    try {
                        do {
                            System.out.print("\nIntroduce una columna para meter una ficha (1-7): ");
                            Scanner in = new Scanner(System.in);
                            PosColumn = in.nextInt();
                        } while (tablero.ColumnaLlena(PosColumn -1));
                    } catch (Exception e){
                        System.out.println("Numero invalido. Valores [1-7]");
                        break;
                    }
                    //Movimiento de usuario
                    tablero.desplazaColumna(PosColumn -1, Conecta4.Y);
                    System.out.println();
                    break;
                default:
                    break;
            }
            tablero.printTablero();
        }

    }

    @Override
    public void ganador() {
        if (tablero.ganadorAux == Conecta4.R) {
            System.out.println("R Gana!");
            System.out.println(tablero.Ganador);
        } else if (tablero.ganadorAux == Conecta4.Y) {
            System.out.println("Y Gana!");
            System.out.println(tablero.Ganador);
        } else {
            System.out.println("Empate!!");
        }
    }
}
