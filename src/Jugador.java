public class Jugador implements IJugador{


    private char ficha;

    public Jugador() {

    }

    public void setFicha(char x){
        this.ficha = x;
    }

    public char getFicha() {
        return ficha;
    }

    public void meterFicha(int columna, Tablero tablero, Jugador jugador) {
        for (int i = 6; i >= 0; i--) {
            if (tablero.getPosicion(i, columna) == ' ') {
                tablero.setPosicion(i, columna, jugador.getFicha());
                break;
            }
        }
    }
}
