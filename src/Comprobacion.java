public class Comprobacion {
    private final static int filas = 6;
    private final static int columnas = 7;


    /**
     * Comprueba si jugador gana con encadenado vertical
     * @param fila numero fila
     * @param columna numero columna
     * @param ganador jugador actual
     * @param progreso numero encadenados
     * @param ganadorAux
     * @return verdadero o falso si gana con vertical
     */
    public boolean comprobarVertical(Ficha[][] table,int fila, int columna, String ganador, int progreso,boolean ganadorAux){

        if(!ganadorAux){
            for (int filaAux = fila + 1; filaAux < filas; filaAux++) {
                if (table[filaAux][columna].getColor() == ganador) {
                    progreso--;
                    if (progreso == 0) {
                        ganadorAux = true;
                    }
                } else {
                    progreso = 3;
                }
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
    public boolean comprobarHorizontal(Ficha[][] table,int fila, int columna, String ganador, int progreso,boolean ganadorAux){
        if(!ganadorAux){
            for (int columnaAux = columna - 3; columnaAux <= columna + 3; columnaAux++) {
                if (columnaAux < 0)
                    continue;

                if (columnaAux >= columnas)
                    break;

                if (table[fila][columnaAux] != null && table[fila][columnaAux].getColor() == ganador) {
                    progreso--;
                    if (progreso == 0) {
                        ganadorAux = true;
                    }
                } else {
                    progreso = 4;
                }
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
    public boolean comprobarDiagonalIZQ(Ficha[][] table,int fila, int columna, String ganador, int progreso,boolean ganadorAux){
        if(!ganadorAux){
            for (int filaAux = fila - 3, columnaAux = columna - 3; filaAux <= fila + 3 && columnaAux <= columna + 3; filaAux++, columnaAux++) {
                if (filaAux < 0 || columnaAux < 0) continue;
                if (filaAux >= filas || columnaAux >= columnas) break;
                if (table[filaAux][columnaAux] != null && table[filaAux][columnaAux].getColor() == ganador) {

                    progreso--;
                    if (progreso == 0) {
                        ganadorAux = true;
                    }
                } else {
                    progreso = 4;
                }
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
    public boolean comprobarDiagonalDCH(Ficha[][] table,int fila, int columna, String ganador, int progreso,boolean ganadorAux){
        if(!ganadorAux){
            for (int filaAux = fila - 3, columnaAux = columna + 3; filaAux <= fila + 3 && columnaAux >= columna - 3; filaAux++, columnaAux--) {
                if (filaAux < 0 || columnaAux >= columnas) continue;
                if (filaAux >= filas || columnaAux < 0) break;
                if (table[filaAux][columnaAux] != null && table[filaAux][columnaAux].getColor() == ganador) {

                    progreso--;
                    if (progreso == 0) {
                        ganadorAux = true;
                    }
                } else {
                    progreso = 4;
                }
            }
        }
        return ganadorAux;
    }
}
