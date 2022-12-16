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