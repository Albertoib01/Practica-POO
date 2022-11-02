public interface Itablero {


        /**
         * Inicializa el tablero. Coloca un ' ' en todas sus posiciones.
         */
        void inicializar();


        /**
         * Actualiza el contenido de la casilla solicitada.
         * @param x Índice x.
         * @param y Índice y
         * @param valor Contenido a colocar en la casilla.
         */
        void setPosicion(int x, int y, char valor);

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

        /**
         * Comprueba si el valor metido por el jugador es valido
         * @return booleano indicando si es valido o no
         */

        boolean validar(int columna, Tablero tabl);
}
