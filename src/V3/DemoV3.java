package V3;

import V3.Conecta4V3;

public class DemoV3 {


        static int PosColumn;
        static Conecta4V3 tablero;
        static MiniMaxV3 cpu;

        public void ComenzarDemo() {

            cpu = new MiniMaxV3(Conecta4V3.Y);
            cpu = new MiniMaxV3(Conecta4V3.R);
            tablero = new Conecta4V3();

            tablero.printTablero();

            while(!tablero.Final()) {
                System.out.println();
                switch (tablero.ultimoJugador) {

                    case Conecta4V3.Y:
                        TablaV3 computerMove1 = cpu.getProxDesplaza(tablero);
                        tablero.desplazaColumna(computerMove1.col, Conecta4V3.R);
                        System.out.println("Turn: CPU R\nInsertada en columna: "+(computerMove1.col+1)+".");
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
                System.out.println("CPU R GANA!");
                System.out.println(tablero.Ganador);
            } else if (tablero.ganadorAux == Conecta4V3.Y) {
                System.out.println("CPU Y GANA!");
                System.out.println(tablero.Ganador);
            } else {
                System.out.println("TIED!!");
            }
        }
    }

