public class Jugador {

    private String ficha;

    public Jugador(String ficha){
        this.ficha=ficha;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    @Override
    public String toString() {
        return getFicha();
    }
}
