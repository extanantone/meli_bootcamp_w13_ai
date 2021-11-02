package Ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola a todos");
        Scanner mScanner= new Scanner(System.in);
        boolean salir= false;
        int opcion= 0;
        int valor= 0;

        System.out.println("\n *** Ingrese el valor de la serie ***");
        valor= mScanner.nextInt();
        Serie mSerie= new Serie(valor);
        mSerie.valorInicial();
        System.out.println(mSerie.getValor());

        while(!salir){
            System.out.println("\n *** MENU DE OPCIONES ***\n1. Valor siguiente.");
            System.out.println("2. Reiniciar serie.");
            System.out.println("3. Salir.");

            System.out.println("Digite una opción");
            opcion= mScanner.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Valor actual de la serie: " + mSerie.getValor());
                    mSerie.establecerValor();
                    System.out.println("Valor siguiente de la serie: " + mSerie.getValor());
                    break;
                case 2:
                    mSerie.reiniciarSerie();
                    System.out.println("Valor actual de la serie: " + mSerie.getValor());
                    break;
                case 3:
                    salir= true;
                    break;
                default:
                    System.out.println("Ingrese un valor permitido.");
            }
        }
    }
}
