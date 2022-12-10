package V3;

import java.util.LinkedList;

public class Conecta4V3 {
    //Usuarios
    static final int R = 1;

    static final int Y = -1;

    int valorAux = 0;

    TablaV3 MovimientoFinal;
    int ultimoJugador;
    int ganadorAux;
    int [][] Tablero;
    int filas=6,columnas=7;
    String Ganador;


    //Inicializar tablero
    public Conecta4V3() {
        MovimientoFinal = new TablaV3();
        ultimoJugador = Y; //The user starts first
        ganadorAux = 0;
        Tablero = new int[filas][columnas];
        for(int i=0; i<filas; i++) {
            for(int j=0; j<columnas; j++) {
                Tablero[i][j] = valorAux;
            }
        }
    }

    //Ganador
    public void setGanador(int ganador) {
        this.ganadorAux = ganador;
    }

    //Posicion: vertical, horizontal, diagonal.
    public void Posicion(String PosicionGanador) {
        this.Ganador = PosicionGanador;
    }

    //Desplazamiento por columna
    public void desplazaColumna(int col, int letra) {
        MovimientoFinal = MovimientoFinal.desplazamiento(FilaLlena(col), col);
        Tablero[FilaLlena(col)][col] = letra;
        ultimoJugador = letra;
    }

    //Validar: vacia, movimiento correcto
    public boolean Validar(int col) {
        int fila = FilaLlena(col);
        if ((fila == -1) || (col == -1) || (fila > 5) || (col > 6)) {
            return false;
        }
        if(Tablero[fila][col] != valorAux) {
            return false;
        }
        return true;
    }

    //Se puede hacer un movimiento de ficha?
    public boolean Movimiento(int fila, int col) {

        if ((fila <= -1) || (col <= -1) || (fila > 5) || (col > 6)) {
            return false;
        }
        return true;
    }//end CanMove

    //
    public boolean ColumnaLlena(int col) {
        //ultima columna
        int columnaMax=col + 1;
        //Se llena, si la posicion de cada columna es vacia
        if (Tablero[0][col] == valorAux) {
            return false;
        }

        else{
            System.out.println("La columna " + columnaMax +" llena. Introduce otra columna.");
            return true;
        }
    }

    //Se observan los sitios vacios de las filas
    public int FilaLlena(int column) {
        int filaAux = -1;
        for (int fila=0; fila<filas; fila++) {
            if(Tablero[fila][column] == valorAux) {
                filaAux = fila;
            }
        }
        return filaAux;
    }

    //Minimax
    //TableroAUX (copia)
    public Conecta4V3 TablaCopia(Conecta4V3 table) {
        Conecta4V3 expansion = new Conecta4V3();
        expansion.MovimientoFinal = table.MovimientoFinal;
        expansion.ultimoJugador = table.ultimoJugador;
        expansion.ganadorAux = table.ganadorAux;
        expansion.Tablero = new int[filas][columnas];
        for(int i=0; i<filas; i++) {
            for(int j=0; j<columnas; j++) {
                expansion.Tablero[i][j] = table.Tablero[i][j];
            }
        }
        return expansion;
    }

    //Maximo numero de hijos es 7 debido a que hay 7 columnas
    public LinkedList<Conecta4V3> getHijos(int letra) {
        LinkedList<Conecta4V3> hijos = new LinkedList<Conecta4V3>();
        for(int col=0; col<7; col++) {
            if(Validar(col)) {
                Conecta4V3 hijo = TablaCopia(this);
                hijo.desplazaColumna(col, letra);
                hijos.add(hijo);
            }
        }
        return hijos;
    }

    public int utilityFunction() {
        //MAX jugadas de  'Y'
        // +90 si 'Y' gana, -90 'R' pierde,
        // +10 si 'Y' estan en una fila, -5 si 3 'R' en una fila,
        // +4 si 3 'Y' en una fila, -1 si 2 'R' en una fila
        int Xlines = 0;
        int Olines = 0;
        if (PosicionGanador()) {
            if(ganadorAux == R) {
                Xlines = Xlines + 90;
            } else {
                Olines = Olines + 90;
            }
        }
        Xlines  = Xlines + TresSeguidas(R)*10 + DosSeguidas(R)*4;
        Olines  = Olines + TresSeguidas(Y)*5 + DosSeguidas(Y);
        return Olines - Xlines;
    }


    public boolean PosicionGanador() {
        //Ganador por Horizontal
        for (int i=5; i>=0; i--) {
            for (int j=0; j<4; j++) {
                if (Tablero[i][j] == Tablero[i][j+1] && Tablero[i][j] == Tablero[i][j+2] && Tablero[i][j] == Tablero[i][j+3] && Tablero[i][j] != valorAux) {
                    setGanador(Tablero[i][j]);
                    Posicion("Posicion: fila.");
                    return true;
                }
            }
        }

        //Ganador por Vertical
        for (int i=5; i>=3; i--) {
            for (int j=0; j<7; j++) {
                if (Tablero[i][j] == Tablero[i-1][j] && Tablero[i][j] == Tablero[i-2][j] && Tablero[i][j] == Tablero[i-3][j] && Tablero[i][j] != valorAux) {
                    setGanador(Tablero[i][j]);
                    Posicion("Posicion: columna.");
                    return true;
                }
            }
        }

        //diagonal
        for (int i=0; i<3; i++) {
            for (int j=0; j<4; j++) {
                if (Tablero[i][j] == Tablero[i+1][j+1] && Tablero[i][j] == Tablero[i+2][j+2] && Tablero[i][j] == Tablero[i+3][j+3] && Tablero[i][j] != valorAux) {
                    setGanador(Tablero[i][j]);
                    Posicion("Posicion: diagonal.");
                    return true;
                }
            }
        }

        //Ganador por diagonal
        for (int i=0; i<6; i++) {
            for (int j=0; j<7; j++) {
                if (Movimiento(i-3,j+3)) {
                    if (Tablero[i][j] == Tablero[i-1][j+1] && Tablero[i][j] == Tablero[i-2][j+2] && Tablero[i][j] == Tablero[i-3][j+3]  && Tablero[i][j] != valorAux) {
                        setGanador(Tablero[i][j]);
                        Posicion("Posicion: diagonal.");
                        return true;
                    }
                }
            }
        }
        setGanador(0);
        return false;
    }

    //Fichas de el mismo jugador
    public int TresSeguidas(int jugador) {
        int contador = 0;
        //fila
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < columnas; j++) {
                if (Movimiento(i, j + 2)) {
                    if (Tablero[i][j] == Tablero[i][j + 1] && Tablero[i][j] == Tablero[i][j + 2] && Tablero[i][j] == jugador) {
                        contador++;
                    }
                }
            }
        }

        //columna
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < columnas; j++) {
                if (Movimiento(i - 2, j)) {
                    if (Tablero[i][j] == Tablero[i - 1][j] && Tablero[i][j] == Tablero[i - 2][j] && Tablero[i][j] == jugador) {
                        contador++;
                    }
                }
            }
        }

        //diagonal
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (Movimiento(i + 2, j + 2)) {
                    if (Tablero[i][j] == Tablero[i + 1][j + 1] && Tablero[i][j] == Tablero[i + 2][j + 2] && Tablero[i][j] == jugador) {
                        contador++;
                    }
                }
            }
        }

        //diagonal
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (Movimiento(i - 2, j + 2)) {
                    if (Tablero[i][j] == Tablero[i - 1][j + 1] && Tablero[i][j] == Tablero[i - 2][j + 2] && Tablero[i][j] == jugador) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    //Dos fichas de un mismo jugador
    public int DosSeguidas(int jugador) {
        int contador = 0;
        //fila
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < columnas; j++) {
                if (Movimiento(i, j + 1)) {
                    if (Tablero[i][j] == Tablero[i][j + 1] && Tablero[i][j] == jugador) {
                        contador++;
                    }
                }
            }
        }

        //columna
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < columnas; j++) {
                if (Movimiento(i - 1, j)) {
                    if (Tablero[i][j] == Tablero[i - 1][j] && Tablero[i][j] == jugador) {
                        contador++;
                    }
                }
            }
        }

        //diagonal
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (Movimiento(i + 1, j + 1)) {
                    if (Tablero[i][j] == Tablero[i + 1][j + 1] && Tablero[i][j] == jugador) {
                        contador++;
                    }
                }
            }
        }

        //diagonal
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (Movimiento(i - 1, j + 1)) {
                    if (Tablero[i][j] == Tablero[i - 1][j + 1] && Tablero[i][j] == jugador) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    public boolean Final() {
        //Si hay posicion horizontal vertical, diagonal
        if (PosicionGanador()) {
            return true;
        }
        //Vacio
        for(int fila=0; fila<filas; fila++) {
            for(int column=0; column<columnas; column++) {
                if(Tablero[fila][column] == valorAux) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printTablero() {
        for(int columna=0;columna<8+2;columna++)
            System.out.print("---");
        System.out.println();
        //Segun el valor se otorga el signo al usuario
        for (int i=0; i<filas; i++) {
            for (int j=0; j<columnas; j++) {
                if (Tablero[i][j] == 1) {
                    System.out.print("| " + "R ");
                } else if (Tablero[i][j] == -1) {
                    System.out.print("| " + "Y ");
                } else {
                    System.out.print("| " + " " + " ");
                }
            }
            System.out.println("|");
        }  for(int columna=0;columna<8+2;columna++)
            System.out.print("---");
    }
}
