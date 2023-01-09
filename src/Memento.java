public class Memento {
    public Conecta4 tablero;

    protected Memento(Conecta4 tabl){this.tablero=tabl;}

    public Conecta4 recoverOldTablero(){
        return tablero;
    }
}
