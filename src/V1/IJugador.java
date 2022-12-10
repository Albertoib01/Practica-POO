package V1;

public interface IJugador {

    /**
     * Establece valor de la ficha del jugador
     * @param color valor del caracter
     */
    void setColor(String color);


    /**
     * Proporciona el valor de la ficha pedida
     * @return ficha del jugador indicado
     */
    String getColor();
}
