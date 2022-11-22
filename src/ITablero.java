public interface ITablero {

        boolean Ganador(int columna, String ganador);

        boolean insertarFicha(int columna,String color);

        void  printTablero();
}
