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

    public boolean validar(int columna, Tablero tabl){
        if (columna < 0 || columna > 6){
            System.out.println("Columna invalida. Valores [1-7]:");
            return false;
        }

        if (tabl.getPosicion(0, columna) != ' '){
            System.out.println("Columna invalida. Columna llena.");
            return false;
        }

        return true;
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

    public boolean comprobarTablero(){
        int ocupado= 0;
        boolean lleno = false;
        for(int i = 0; i<6;i++){
            for(int j = 0; j<7;j++){
                if(tablero[i][j]!=' '){
                    ocupado++;
                }
            }
        }
        if(ocupado == 42){
            System.out.println("Tablero lleno");
            lleno  = true;
        }
        return lleno;
    }

    public boolean comprobarVictoria(){
        boolean victoria = false;
        int fichasY = 0;
        int fichasR = 0;
        int i,j,filY=1,columY=1,diagY=1,diagiY=1,filR=1,columR=1,diagR=1,diagiR=1;
        for(i=0; i<6; i++)
        {
            for(j=0; j<7; j++)
            {
                if(tablero[i][j]==tablero[i][j+1] && tablero[i][j+1]!='-' && tablero[i][j]=='Y')
                {
                    filY++;
                }
                else if(tablero[i][j]==tablero[i][j+1] && tablero[i][j+1]!='-' && tablero[i][j]=='R')
                {
                    filR++;
                }
                else if(tablero[j][i]==tablero[j+1][i] && tablero[j+1][i]!='-' && tablero[i][j]=='Y')
                {
                    columY++;
                }
                else if(tablero[j][i]==tablero[j+1][i] && tablero[j+1][i]!='-' && tablero[i][j]=='R')
                {
                    columR++;
                }
            }
            if(tablero[i][i]==tablero[i+1][i+1] && tablero[i+1][i+1]!='-' && tablero[i][j]=='Y')
            {
                diagY++;
            }
            else if(tablero[i][i]==tablero[i+1][i+1] && tablero[i+1][i+1]!='-' && tablero[i][j]=='R')
            {
                diagR++;
            }
        }
        i=0;
        for(j=6; j>=0; j--)
        {
            if(tablero[j][i]==tablero[j-1][i+1] && tablero[j-1][i+1]!='-' && tablero[i][j]=='Y')
            {
                diagiY++;
                i++;
            }
            else if(tablero[j][i]==tablero[j-1][i+1] && tablero[j-1][i+1]!='-' && tablero[i][j]=='R')
            {
                diagiR++;
                i++;
            }
        }
        if(diagR == 4 || diagiR ==4 || filR == 4 || columR == 4){
            System.out.println("Han ganado las fichas rojas");
            victoria = true;
        }
        else if(diagY == 4 || diagiY ==4 || filY == 4 || columY == 4){
            System.out.println("Han ganado las fichas amarillas");
            victoria = true;
        }
        return victoria;
    }
}
