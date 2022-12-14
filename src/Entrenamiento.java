import java.util.Scanner;

public class Entrenamiento implements IJuego{
    static int PosColumn;
    static Conecta4 tablero;
    //se define el usuario cpu
    static MiniMax cpu;

    public void entrenamiento() {

        cpu = new MiniMax(Conecta4.Y);
        tablero = new Conecta4();
        tablero.printTablero();
        jugar();
        System.out.println();
        ganador();
    }

    public void jugar(){
        while(!tablero.Final()) {
            System.out.println();
            switch (tablero.ultimoJugador) {

                case Conecta4.Y:
                    System.out.print("Turn: R");
                    try {
                        do {
                            System.out.print("\nEnter a column to drop a token (1-7): ");
                            Scanner in = new Scanner(System.in);
                            PosColumn = in.nextInt();
                        } while (tablero.ColumnaLlena(PosColumn -1));
                    } catch (Exception e){
                        System.out.println("Numero invalido. Values [1-7]");
                        break;
                    }

                    tablero.desplazaColumna(PosColumn -1, Conecta4.R);
                    System.out.println();
                    break;

                case Conecta4.R:
                    Tabla computerMove = cpu.getProxDesplaza(tablero);
                    tablero.desplazaColumna(computerMove.col, Conecta4.Y);
                    System.out.println("Turn: CPU Y\nInsertada en columna: "+(computerMove.col+1));
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
            System.out.println("CPU Y GANA!");
            System.out.println(tablero.Ganador);
        } else {
            System.out.println("TIED!!");
        }
    }

}
