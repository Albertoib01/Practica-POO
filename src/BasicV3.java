import java.util.Scanner;
public class BasicV3 {
    static int PosColumn;
    static Conecta4V3 tablero;


    public void BasicPlay (){
        tablero = new Conecta4V3();
        tablero.printTablero();

        while(!tablero.Final()) {
            System.out.println();
            switch (tablero.ultimoJugador) {
                //Turn R
                case Conecta4V3.Y:
                    System.out.print("Turn: Red");
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
                    //Movimiento de usuario
                    tablero.desplazaColumna(PosColumn -1, Conecta4V3.R);
                    System.out.println();
                    break;
                //Turn Y
                case Conecta4V3.R:
                    System.out.print("Turn: Yellow");
                    try {
                        do {
                            System.out.print("\nSelect a column to drop your piece (1-7): ");
                            Scanner in = new Scanner(System.in);
                            PosColumn = in.nextInt();
                        } while (tablero.ColumnaLlena(PosColumn -1));
                    } catch (Exception e){
                        System.out.println("Numero invalido. Values [1-7]");
                        break;
                    }
                    //Movimiento de usuario
                    tablero.desplazaColumna(PosColumn -1, Conecta4V3.Y);
                    System.out.println();
                    break;
                default:
                    break;
            }
            tablero.printTablero();
        }

        System.out.println();
        if (tablero.ganadorAux == Conecta4V3.R) {
            System.out.println("R Gana!");
            System.out.println(tablero.Ganador);
        } else if (tablero.ganadorAux == Conecta4V3.Y) {
            System.out.println("Y Gana!");
            System.out.println(tablero.Ganador);
        } else {
            System.out.println("TIED!!");
        }
    }

}