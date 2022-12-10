package V1;

import V1.Partida;

import java.util.Scanner;

public class Menu {

    public Menu(){
        Partida conecta4 = new Partida("R","Y");
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("---------Conecta 4---------\n");
        System.out.println("1.Jugar\n2.Salir");
        opcion = sc.nextInt();
        switch (opcion){
            case 0: break;
            case 1: conecta4.Comenzar(); break;
        }
    }
}
