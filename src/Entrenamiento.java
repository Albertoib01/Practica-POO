import java.util.Scanner;

public class Entrenamiento implements IJuego{
    private static int PosColumn;
    private static Conecta4 tablero;
    //se define el usuario cpu
    private static MiniMax cpu;

    private Memento memento;

    public void entrenamiento() {

        cpu = new MiniMax(Conecta4.Y);
        tablero = new Conecta4();
        tablero.printTablero();
        jugar();
        System.out.println();
        ganador();
    }
    @Override
    public void jugar(){
        String opcion;
        while(!tablero.Final()) {
            guardarEstado(tablero);
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
                    System.out.println("\nHa colocado la ficha donde queria?(s/n) ");
                    Scanner op = new Scanner(System.in);
                    opcion = op.nextLine();
                    if (opcion.equals("n") || opcion.equals("N")){
                        System.out.println("Prueba");
                        recuperarEstado();
                        tablero.ultimoJugador = Conecta4.Y;
                    }
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

    public void guardarEstado(Conecta4 tabla){
        memento = new Memento(tabla);
    }

    public void recuperarEstado(){tablero = memento.recoverOldTablero();}

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
