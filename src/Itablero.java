public interface Itablero {

        /**
         * Proporciona la estructura de datos del tablero.
         * @return Array bidimensional de enteros, con los valores de cada casilla del tablero
         */
        char[][] getTablero();

        /**
         * Inicializa el tablero. Coloca un ' ' en todas sus posiciones.
         */
        void inicializar();

        /**
         * Actualiza el tablero con los valores de una estructura de datos.
         * @param tablero Array bidimensional de enteros, con los valores de cada casilla del tablero.
         */
        void setTablero(char[][] tablero);

        /**
         * Actualiza el contenido de la casilla solicitada.
         * @param x Índice x.
         * @param y Índice y
         * @param valor Contenido a colocar en la casilla.
         */
        void setPosicion(int x, int y, int valor);

        /**
         * Proporciona el contenido de la casilla solicitada.
         * @param x Índice x.
         * @param y Índice y
         * @return valor contenido en la casilla de posición (x,y).
         */
        int getPosicion(int x, int y);


        /**
         * Representación de la instancia.
         * @return Cadena de caracteres conteniendo una representación de la instancia.
         */
        @Override
        String toString();
}
