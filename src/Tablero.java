public class Tablero implements Itablero{

    protected final int filas = 6;
    protected final int columnas = 7;

    private char[][] tablero;


    public Tablero(){
        tablero = new char[filas][columnas];
    }

    public void inicializar(){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = ' ';
            }
        }
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

        for (int y=0;y< filas;y++) {
            for (int x=0;x< columnas;x++) {
                if(x==0){
                    resultado  = resultado + "| ";
                }
                resultado = resultado + tablero[y][x] + " | ";

            }
            resultado=resultado+"\n";
        }
        resultado = resultado + "---------------------------------\n";
        return resultado;
    }
}
