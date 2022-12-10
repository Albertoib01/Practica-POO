package V3;

import V3.Conecta4V3;

import java.util.LinkedList;
import java.util.Random;

public class MiniMaxV3 {
    //Profundidad, cuanto mayor mayor profundidad mayor es su efectividad de decision
    int Depth;
    int cpu;

    public MiniMaxV3(int jugador) {
        Depth = 5;
        cpu = jugador;
    }

    //Inicio MiniMax algoritmo
    public TablaV3 getProxDesplaza(Conecta4V3 tablero) {
        //elegir el valor mayor de los menores
        return max(tablero.TablaCopia(tablero), 0);
    }

    //MIN jugadas de R
    public TablaV3 min(Conecta4V3 tablero, int depth) {
        Random r = new Random();

        if((tablero.Final()) || (depth == Depth)){
            TablaV3 iniciaDesplaza = new TablaV3();
            iniciaDesplaza = iniciaDesplaza.desplazamientoPosible(tablero.MovimientoFinal.fila, tablero.MovimientoFinal.col, tablero.utilityFunction());
            return iniciaDesplaza;
        }else{

            LinkedList<Conecta4V3> hijos = new LinkedList<Conecta4V3>(tablero.getHijos(Conecta4V3.R));
            TablaV3 minDesplazamiento = new TablaV3();
            minDesplazamiento = minDesplazamiento.comparaDesplaza(Integer.MAX_VALUE);
            for (int i =0; i < hijos.size();i++) {
                Conecta4V3 hijo = hijos.get(i);
                //Aumenta la profundidad
                TablaV3 desplaza = max(hijo, depth + 1);
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
    //MAX jugadas de Y
    public TablaV3 max(Conecta4V3 tablero, int depth) {
        Random r = new Random();

        if((tablero.Final()) || (depth == Depth)) {
            TablaV3 iniciaDesplaza = new TablaV3();
            iniciaDesplaza = iniciaDesplaza.desplazamientoPosible(tablero.MovimientoFinal.fila, tablero.MovimientoFinal.col, tablero.utilityFunction());
            return iniciaDesplaza;
        }else{
            LinkedList<Conecta4V3> hijos = new LinkedList<Conecta4V3>(tablero.getHijos(cpu));
            TablaV3 maxDesplaza = new TablaV3();
            maxDesplaza = maxDesplaza.comparaDesplaza(Integer.MIN_VALUE);
            for (int i =0; i < hijos.size();i++) {
                Conecta4V3 hijo = hijos.get(i);
                TablaV3 desplaza = min(hijo, depth + 1);
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
