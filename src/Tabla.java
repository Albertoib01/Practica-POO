public class Tabla {
    int fila;
    int col;
    private int valor;

    public Tabla() {
        fila = -1;
        col = -1;
        valor = 0;
    }
    public Tabla desplazamiento(int row, int col) {
        Tabla desplazamientoElegido = new Tabla();
        desplazamientoElegido.fila = row;
        desplazamientoElegido.col = col;
        desplazamientoElegido.valor = -1;
        return desplazamientoElegido;
    }
    public Tabla desplazamientoPosible(int row, int col, int value) {
        Tabla desplazaAux = new Tabla();
        desplazaAux.fila = row;
        desplazaAux.col = col;
        desplazaAux.valor = value;
        return desplazaAux;
    }

    public Tabla comparaDesplaza(int value) {
        Tabla comparaAux = new Tabla();
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