public class Tablero2 {

    private final int filas = 6;
    private final int columnas = 7;

    private char[][] tablero;


    public Tablero2(){
        tablero = new char[filas][columnas];
        inicializar();
    }

    private void inicializar(){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    public char[][] getTablero(){
        return tablero;
    }

    public void setTablero(char[][] tablero) {
        if(filas == tablero.length && columnas == tablero[0].length)
            this.tablero=tablero;
    }

    public void setPosicion(int x, int y, char valor){
        tablero[x][y] = valor;
    }


    public int getPosicion(int x, int y) {
        if(x<filas && y<columnas)
            return tablero[x][y];
        return -1;
    }



    public String toString() {
        String resultado="---------------------------------\n";

        for (int y=0;y< columnas;y++) {
            for (int x=0;x< filas;x++) {
                if(x==0){
                    resultado  = resultado + "| ";
                }
                resultado = resultado + tablero[x][y] + " | ";

            }
            resultado=resultado+"\n";
        }
        resultado = resultado + "---------------------------------\n";
        return resultado;
    }
}
