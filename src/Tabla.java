public class Tabla {
    int fila;
    int col;
    private int valor;

    public Tabla() {
        fila = -1;
        col = -1;
        valor = 0;
    }

    /**
     *
     * @param row numero de fila
     * @param col numero de columna
     * @return tablero
     */
    public Tabla desplazamiento(int row, int col) {
        Tabla desplazamientoElegido = new Tabla();
        desplazamientoElegido.fila = row;
        desplazamientoElegido.col = col;
        desplazamientoElegido.valor = -1;
        return desplazamientoElegido;
    }

    /**
     *
     * @param row numero fila
     * @param col numero columna
     * @param value
     * @return tablero
     */
    public Tabla desplazamientoPosible(int row, int col, int value) {
        Tabla desplazaAux = new Tabla();
        desplazaAux.fila = row;
        desplazaAux.col = col;
        desplazaAux.valor = value;
        return desplazaAux;
    }

    /**
     *
     * @param value
     * @return tablero
     */
    public Tabla comparaDesplaza(int value) {
        Tabla comparaAux = new Tabla();
        comparaAux.fila = -1;
        comparaAux.col = -1;
        comparaAux.valor = value;
        return comparaAux;
    }

    /**
     * @return valor de la casilla
     */
    public int getValor() {
        return valor;
    }

    /**
     * Actualiza valor de la casilla
     * @param Valor1
     */
    public void setValor(int Valor1) {
        valor = Valor1;
    }


    /**
     * @return numero de fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * Actualiza el valor de la fila
     * @param fila1
     */
    public void setFila(int fila1) {
        fila = fila1;
    }

    /**
     * @return numero de columnas
     */
    public int getCol() {
        return col;
    }

    /**
     * Actualiza el valor de la columna
     * @param Column numero columna
     */
    public void setCol(int Column) {
        col = Column;
    }


}