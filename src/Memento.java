public class Memento {
    public Tabla tablero;

    public Memento(Tabla tabl){
        this.tablero=tabl;
    }

    public Tabla recoverOldTablero(){
        return tablero;
    }
}
