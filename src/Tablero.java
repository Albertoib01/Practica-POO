public class Tablero implements ITablero{
    private final static int filas = 6;
    private final static int columnas = 7;

    Fichas[][] table = new Fichas[filas][columnas];
    public  int getColumnas(){
        return columnas;
    }


    /*revision vertical, horizontal y diagonal*/
    public boolean Ganador(int columna, String ganador){
        boolean ganadorAux= false;
        for(int fila=0; fila<filas;fila++){
            if(table[fila][columna] != null){
                int progreso = 3;

                //vertical
                for(int filaAux = fila + 1; filaAux<filas;filaAux++){
                    if(table[filaAux][columna].getColor() == ganador){
                        progreso--;
                        if(progreso==0){
                            ganadorAux= true;
                        }
                    }
                    else {
                        progreso=3;
                    }
                }
                /*para ser revisado se necesita 4*/
                progreso =4;
                //horizontal
                for(int columnaAux=columna-3;columnaAux<=columna+3;columnaAux++){
                    if(columnaAux<0)
                        continue;

                    if(columnaAux>=columnas)
                        break;

                    if(table[fila][columnaAux]!= null &&table[fila][columnaAux].getColor()==ganador){
                        progreso--;
                        if(progreso==0){
                            ganadorAux= true;
                        }
                    }
                    else {
                        progreso=4;
                    }
                }
                progreso=4;

                //diagonal izq
                for(int filaAux=fila-3, columnaAux=columna-3;filaAux<=fila+3 && columnaAux<=columna+3;filaAux++,columnaAux++){
                    if(filaAux < 0 || columnaAux < 0) continue;
                    if(filaAux >=filas || columnaAux >=columnas) break;
                    if(table[filaAux][columnaAux]!= null &&table[filaAux][columnaAux].getColor()==ganador){

                        progreso--;
                        if(progreso==0){
                            ganadorAux= true;
                        }
                    }
                    else {
                        progreso=4;
                    }
                }
                progreso=4;

                //diagonal drcha
                for(int filaAux=fila-3, columnaAux=columna+3;filaAux<=fila+3 && columnaAux>=columna-3;filaAux++,columnaAux--){
                    if(filaAux < 0 || columnaAux >=columnas) continue;
                    if(filaAux >=filas || columnaAux <0) break;
                    if(table[filaAux][columnaAux]!= null &&table[filaAux][columnaAux].getColor()==ganador){

                        progreso--;
                        if(progreso==0){
                            ganadorAux= true;
                        }
                    }
                    else {
                        progreso=4;
                    }
                }
                break;
            }

        }
        return ganadorAux;
    }

    public boolean insertarFicha(int columna,String color){
        if(columna>=0 && columna < columnas){
            //disponible
            if(table[0][columna]==null){
                boolean inserta = false;
                for(int fila=filas-1;fila>=0;fila--){
                    if(table[fila][columna]==null){
                        table[fila][columna]=new Fichas();
                        table[fila][columna].setColor(color);
                        inserta =true;
                        break;
                    }
                }
                return inserta;
            }
            //fila llena
            else {
                System.out.println("columna llena.");
                return false;
            }
        }
        else{
            System.out.println("Fila incorrecta (fuera del rango[1-7]).");
            return false;
        }
    }
    public void  printTablero(){
        System.out.println("--- Conecta 4 ---");
        for(int columna=0;columna<columnas+2;columna++)
            System.out.print("--");
        System.out.println();
        for(int fila=0; fila<filas;fila++){
            System.out.print("| ");
            for(int columna=0;columna<columnas;columna++){
                if(table[fila][columna]==null)
                {
                    System.out.print(" ");
                }
                else{
                    System.out.print(table[fila][columna].getColor());
                }
                System.out.print(" | ");
            }
            System.out.println();
        }System.out.print("------------------\n");
    }


}
