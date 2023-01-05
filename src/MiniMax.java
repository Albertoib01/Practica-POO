import java.util.LinkedList;
import java.util.Random;

public class MiniMax {
    //Profundidad, cuanto mayor mayor profundidad mayor es su efectividad de decision
    protected int Depth;
    protected int cpu;

    public MiniMax(int jugador) {
        Depth = 5;
        cpu = jugador;
    }

    /**
     * Inicializa el algoritmo MiniMax
     * @param tablero
     * @return
     */
    public Tabla getProxDesplaza(Conecta4 tablero) {
        //elegir el valor mayor de los menores
        return max(tablero.TablaCopia(tablero), 0);
    }

    /**
     * Minimo jugadas de R
     * @param tablero
     * @param depth numero de profundidad
     * @return
     */
    public Tabla min(Conecta4 tablero, int depth) {
        Random r = new Random();
        Desplazamiento aux = new Desplazamiento();
        if((tablero.Final()) || (depth == Depth)){
            Tabla iniciaDesplaza = new Tabla();
            iniciaDesplaza = aux.desplazamientoPosible(tablero.MovimientoFinal.fila, tablero.MovimientoFinal.col, tablero.utilityFunction());
            return iniciaDesplaza;
        }else{

            LinkedList<Conecta4> hijos = new LinkedList<Conecta4>(tablero.getHijos(Conecta4.R));
            Tabla minDesplazamiento = new Tabla();
            minDesplazamiento = aux.comparaDesplaza(Integer.MAX_VALUE);
            for (int i =0; i < hijos.size();i++) {
                Conecta4 hijo = hijos.get(i);
                //Aumenta la profundidad
                Tabla desplaza = max(hijo, depth + 1);
                //menor valor returned max
                if(desplaza.getValor() <= minDesplazamiento.getValor()) {
                    if ((desplaza.getValor() == minDesplazamiento.getValor())) {
                        //si 0, se escribe maxMove. si no, the maxMove is the same
                        if (r.nextInt(2) == 0) {
                            minDesplazamiento.setFila(hijo.MovimientoFinal.fila);
                            minDesplazamiento.setCol(hijo.MovimientoFinal.col);
                            minDesplazamiento.setValor(desplaza.getValor());
                        }
                    }
                    else {
                        minDesplazamiento.setFila(hijo.MovimientoFinal.fila);
                        minDesplazamiento.setCol(hijo.MovimientoFinal.col);
                        minDesplazamiento.setValor(desplaza.getValor());
                    }
                }
            }
            return minDesplazamiento;
        }
    }


    /**
     * Maximo jugadas de Y
     * @param tablero
     * @param depth numero profundidad
     * @return tablero
     */
    public Tabla max(Conecta4 tablero, int depth) {
        Random r = new Random();
        Desplazamiento aux = new Desplazamiento();
        if((tablero.Final()) || (depth == Depth)) {
            Tabla iniciaDesplaza = new Tabla();
            iniciaDesplaza = aux.desplazamientoPosible(tablero.MovimientoFinal.fila, tablero.MovimientoFinal.col, tablero.utilityFunction());
            return iniciaDesplaza;
        }else{
            LinkedList<Conecta4> hijos = new LinkedList<Conecta4>(tablero.getHijos(cpu));
            Tabla maxDesplaza = new Tabla();
            maxDesplaza = aux.comparaDesplaza(Integer.MIN_VALUE);
            for (int i =0; i < hijos.size();i++) {
                Conecta4 hijo = hijos.get(i);
                Tabla desplaza = min(hijo, depth + 1);
                //Min: se elige el valor mayor de los min
                if(desplaza.getValor() >= maxDesplaza.getValor()) {
                    if ((desplaza.getValor() == maxDesplaza.getValor())) {
                        if (r.nextInt(2) == 0) {
                            maxDesplaza.setFila(hijo.MovimientoFinal.fila);
                            maxDesplaza.setCol(hijo.MovimientoFinal.col);
                            maxDesplaza.setValor(desplaza.getValor());
                        }
                    }
                    else {
                        maxDesplaza.setFila(hijo.MovimientoFinal.fila);
                        maxDesplaza.setCol(hijo.MovimientoFinal.col);
                        maxDesplaza.setValor(desplaza.getValor());
                    }
                }
            }
            return maxDesplaza;
        }
    }
}