public class Demo implements IJuego{


    private static int PosColumn;
    private static Conecta4 tablero;
    private static MiniMax cpu;

    public void ComenzarDemo() {

        cpu = new MiniMax(Conecta4.Y);
        cpu = new MiniMax(Conecta4.R);
        tablero = new Conecta4();
        tablero.printTablero();
        jugar();
        System.out.println();
        ganador();
    }

    /**
     * Inicia el juego
     */
    @Override
    public void jugar() {
        while(!tablero.Final()) {
            System.out.println();
            switch (tablero.ultimoJugador) {

                case Conecta4.Y:
                    Tabla computerMove1 = cpu.getProxDesplaza(tablero);
                    tablero.desplazaColumna(computerMove1.col, Conecta4.R);
                    System.out.println("Turn: CPU R\nInsertada en columna: "+(computerMove1.col+1)+".");
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

    /**
     * Imprime el ganador de la partida
     */
    @Override
    public void ganador() {
        if (tablero.ganadorAux == Conecta4.R) {
            System.out.println("CPU R GANA!");
            System.out.println(tablero.Ganador);
        } else if (tablero.ganadorAux == Conecta4.Y) {
            System.out.println("CPU Y GANA!");
            System.out.println(tablero.Ganador);
        } else {
            System.out.println("TIED!!");
        }

    }
}