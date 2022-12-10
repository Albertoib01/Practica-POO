package V1;

import V1.IJugador;

public class Jugador implements IJugador {
    private String color;

    /**
     * @return color ficha actual
     */
    public String getColor(){
        return color;
    }

    /**
     * Establece color de ficha
     * @param color ficha
     */
    public void setColor(String color) {
        this.color = color;
    }
}