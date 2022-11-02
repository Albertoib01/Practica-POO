public interface IJugador {

    /**
     * Establece valor de la ficha del jugador
     * @param x valor del caracter
     */
    void setFicha(char x);


    /**
     * Proporciona el valor de la ficha pedida
     * @return ficha del jugador indicado
     */
    char getFicha();


    /**
     * Introduce la ficha del jugador indicado en la columna del tablero
     * @param columna Indice x del tablero
     * @param tablero Array bidimensional de caracteres
     * @param jugador
     */
    void meterFicha(int columna, Tablero tablero, Jugador jugador);
}