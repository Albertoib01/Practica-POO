public class Desplazamiento {

    private Tabla tabla = new Tabla();
    public Desplazamiento(){

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
        desplazamientoElegido.setValor(-1);
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
        desplazaAux.setValor(value);
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
        comparaAux.setValor(value);
        return comparaAux;
    }
}
