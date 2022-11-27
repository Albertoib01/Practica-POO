public class Tablero implements ITablero{
    private final static int filas = 6;
    private final static int columnas = 7;

    Fichas[][] table = new Fichas[filas][columnas];
    public  int getColumnas(){
        return columnas;
    }



    /**
     * Comprueba si el jugador actual es ganador
     * @param columna numero de columna
     * @param ganador jugador del turno actual
     * @return gana jugador actual o no
     */
    public boolean Ganador(int columna, String ganador){
        boolean ganadorAux= false;
        for(int fila=0; fila<filas;fila++){
            if(table[fila][columna] != null){
                int progreso = 3;

                //vertical
                ganadorAux=comprobarVertical(fila,columna,ganador,progreso,ganadorAux);
                /*para ser revisado se necesita 4*/
                progreso =4;
                //horizontal
                ganadorAux=comprobarHorizontal(fila,columna,ganador,progreso,ganadorAux);
                progreso=4;

                //diagonal izq
                ganadorAux=comprobarDiagonalIZQ(fila,columna,ganador,progreso,ganadorAux);
                progreso=4;

                //diagonal drcha
                ganadorAux=comprobarDiagonalDCH(fila,columna,ganador,progreso,ganadorAux);

                break;
            }

        }
        return ganadorAux;
    }

    /**
     * Comprueba si jugador gana con encadenado vertical
     * @param fila numero fila
     * @param columna numero columna
     * @param ganador jugador actual
     * @param progreso numero encadenados
     * @param ganadorAux
     * @return verdadero o falso si gana con vertical
     */
    public boolean comprobarVertical(int fila, int columna, String ganador, int progreso,boolean ganadorAux){

        for(int filaAux = fila + 1; filaAux<filas;filaAux++){
            if(table[filaAux][columna].getColor() == ganador){
                progreso--;
                if(progreso==0){
                    ganadorAux= true;
                }
            }
            else {
                progreso=3;
            }
        }
        return ganadorAux;
    }

    /**
     * Comprueba si jugador gana con encadenado horizontal
     * @param fila numero fila
     * @param columna numero columna
     * @param ganador jugador actual
     * @param progreso numero encadenados
     * @param ganadorAux
     * @return verdadero o falso si gana con horizontal
     */
    public boolean comprobarHorizontal(int fila, int columna, String ganador, int progreso,boolean ganadorAux){
        for(int columnaAux=columna-3;columnaAux<=columna+3;columnaAux++){
            if(columnaAux<0)
                continue;

            if(columnaAux>=columnas)
                break;

            if(table[fila][columnaAux]!= null &&table[fila][columnaAux].getColor()==ganador){
                progreso--;
                if(progreso==0){
                    ganadorAux= true;
                }
            }
            else {
                progreso=4;
            }
        }
        return ganadorAux;
    }

    /**
     * Comprueba si jugador gana con encadenado diagonal izquierda
     * @param fila numero fila
     * @param columna numero columna
     * @param ganador jugador actual
     * @param progreso numero encadenados
     * @param ganadorAux
     * @return verdadero o falso si gana con diagonal izquierda
     */
    public boolean comprobarDiagonalIZQ(int fila, int columna, String ganador, int progreso,boolean ganadorAux){
        for(int filaAux=fila-3, columnaAux=columna-3;filaAux<=fila+3 && columnaAux<=columna+3;filaAux++,columnaAux++){
            if(filaAux < 0 || columnaAux < 0) continue;
            if(filaAux >=filas || columnaAux >=columnas) break;
            if(table[filaAux][columnaAux]!= null &&table[filaAux][columnaAux].getColor()==ganador){

                progreso--;
                if(progreso==0){
                    ganadorAux= true;
                }
            }
            else {
                progreso=4;
            }
        }
        return ganadorAux;
    }

    /**
     * Comprueba si jugador gana con encadenado diagonal derecha
     * @param fila numero fila
     * @param columna numero columna
     * @param ganador jugador actual
     * @param progreso numero encadenados
     * @param ganadorAux
     * @return verdadero o falso si gana con diagonal derecha
     */
    public boolean comprobarDiagonalDCH(int fila, int columna, String ganador, int progreso,boolean ganadorAux){
        for(int filaAux=fila-3, columnaAux=columna+3;filaAux<=fila+3 && columnaAux>=columna-3;filaAux++,columnaAux--){
            if(filaAux < 0 || columnaAux >=columnas) continue;
            if(filaAux >=filas || columnaAux <0) break;
            if(table[filaAux][columnaAux]!= null &&table[filaAux][columnaAux].getColor()==ganador){

                progreso--;
                if(progreso==0){
                    ganadorAux= true;
                }
            }
            else {
                progreso=4;
            }
        }
        return ganadorAux;
    }


    /**
     * Comprueba si la columna esta entre los parametros y no esta llena
     * @param columna numero de columna
     * @return columna valida o no
     */
    public boolean validar(int columna){
        if (columna < 0 || columna > columnas){
            System.out.println("Columna invalida. Valores [1-7]:");
            return false;
        }

        if (table[0][columna] != null){
            System.out.println("Columna invalida. Columna llena.");
            return false;
        }

        return true;
    }


    /**
     * Mete ficha en la columna
     * @param columna numero de columna
     * @param color color ficha actual
     */
    public void meterFicha(int columna, String color) {
        for (int fila = filas-1; fila >= 0; fila--) {
            if(table[fila][columna]==null){
                table[fila][columna]=new Fichas();
                table[fila][columna].setColor(color);
                break;
            }
        }
    }

    /**
     * Imprime el tablero
     */
    public void  printTablero(){
        System.out.println("--- Conecta 4 ---");
        for(int columna=0;columna<columnas+2;columna++)
            System.out.print("--");
        System.out.println();
        for(int fila=0; fila<filas;fila++){
            System.out.print("| ");
            for(int columna=0;columna<columnas;columna++){
                if(table[fila][columna]==null)
                {
                    System.out.print(" ");
                }
                else{
                    System.out.print(table[fila][columna].getColor());
                }
                System.out.print(" | ");
            }
            System.out.println();
        }System.out.print("------------------\n");
    }


}
