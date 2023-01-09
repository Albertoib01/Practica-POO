public class Memento {
    public Conecta4 tablero;

    public Memento(Conecta4 tabl){this.tablero=tabl;}

    public Conecta4 recoverOldTablero(){
        return tablero;
    }
}
