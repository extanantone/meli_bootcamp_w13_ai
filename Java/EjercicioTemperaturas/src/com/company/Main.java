package com.company;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String ciudades [] = new String[10];
        int temperaturas [][] = new int[10][2];

        for (int i = 0; i < ciudades.length; i++) {
            System.out.print("Ingrese la ciudad para la posición " + (i)  + ": ");
            ciudades[i] = entrada.nextLine();
        }

        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[0].length; j++) {
                System.out.print("Ingrese temperatura minima y luego maxima para la ciudad " +ciudades[i]+": ");
                temperaturas[i][j] = entrada.nextInt();
            }
        }

        for (int i = 0; i < temperaturas.length; i++) {
            System.out.print("\n Ciudad: " + ciudades[i]);
            for (int j = 0; j < 2; j++) {
                System.out.print(" Temperaturas: " +temperaturas[i][j] +"º ");
            }
        }

        int min = 0;
        int max = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[max][1] < temperaturas[i][1]){
                max = i;
            }
            if (temperaturas[min][0] > temperaturas[i][0]) {
                min = i;
            }
        }
        System.out.print("\n Ciudad con temperatura maxima: " + ciudades[max] + " con " + temperaturas[max][1] +"º ");
        System.out.print("\n Ciudad con temperatura minima: " + ciudades[min] + " con " + temperaturas[min][0] +"º ");
    }
}
