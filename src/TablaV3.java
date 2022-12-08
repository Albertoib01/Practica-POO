public class TablaV3 {
    int fila;
    int col;
    private int valor;

    public TablaV3() {
        fila = -1;
        col = -1;
        valor = 0;
    }
    public TablaV3 desplazamiento(int row, int col) {
        TablaV3 desplazamientoElegido = new TablaV3();
        desplazamientoElegido.fila = row;
        desplazamientoElegido.col = col;
        desplazamientoElegido.valor = -1;
        return desplazamientoElegido;
    }
    public TablaV3 desplazamientoPosible(int row, int col, int value) {
        TablaV3 desplazaAux = new TablaV3();
        desplazaAux.fila = row;
        desplazaAux.col = col;
        desplazaAux.valor = value;
        return desplazaAux;
    }

    public TablaV3 comparaDesplaza(int value) {
        TablaV3 comparaAux = new TablaV3();
        comparaAux.fila = -1;
        comparaAux.col = -1;
        comparaAux.valor = value;
        return comparaAux;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int Valor1) {
        valor = Valor1;
    }

    public int getFila() {
        return fila;
    }
    public void setFila(int fila1) {
        fila = fila1;
    }

    public int getCol() {
        return col;
    }
    public void setCol(int Column) {
        col = Column;
    }


}
