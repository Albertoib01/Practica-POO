public class Tablero {

    protected int filas;

    protected int columnas;

    protected String[][] tabl;


    public Tablero() {
        tabl= new String[6][7];
        inicializar();
    }

    public String getPosicion(int x, int y) {
        return tabl[x][y];
    }


    public void setFicha(int x, int y, String ficha) {
        tabl[x][y] = ficha;
    }


    public void inicializar() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < filas; j++) {
                tabl[i][j] = "";
            }
        }
    }

    public boolean lleno(){
        int lleno= filas*columnas;
        int ocupadas=0;
        boolean acabado= false;
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                if(tabl[i][j]!=""){
                    ocupadas++;
                }
            }
        }
        if(ocupadas==lleno){
            acabado=true;
        }
        return acabado;
    }


    @Override
    public String toString() {
        String resultado="---------------------------------\n";

        for (int y=0;y<filas;y++) {
            for (int x=0;x<filas;x++) {
                if(x==0){
                    resultado  = resultado + "| ";
                }
                resultado = resultado + tabl[x][y] + " | ";

            }
            resultado=resultado+"\n";
        }
        resultado = resultado + "---------------------------------\n";
        return resultado;
    }
}
