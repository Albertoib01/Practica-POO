import java.util.Scanner;

public class EntrenamientoV3 {
        static int PosColumn;
        static Conecta4V3 tablero;
        //se define el usuario cpu
        static MiniMaxV3 cpu;

        public void entrenamiento() {

            cpu = new MiniMaxV3(Conecta4V3.Y);
            tablero = new Conecta4V3();
            tablero.printTablero();

            while(!tablero.Final()) {
                System.out.println();
                switch (tablero.ultimoJugador) {

                    case Conecta4V3.Y:
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

                        tablero.desplazaColumna(PosColumn -1, Conecta4V3.R);
                        System.out.println();
                        break;

                    case Conecta4V3.R:
                        TablaV3 computerMove = cpu.getProxDesplaza(tablero);
                        tablero.desplazaColumna(computerMove.col, Conecta4V3.Y);
                        System.out.println("Turn: CPU Y\nInsertada en columna: "+(computerMove.col+1));
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
                System.out.println("CPU Y GANA!");
                System.out.println(tablero.Ganador);
            } else {
                System.out.println("TIED!!");
            }

        }

}
