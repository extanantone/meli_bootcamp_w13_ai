package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String ciudades[] = {"Londres", "Madrid", "New York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int matrizTemperaturas[][] = new int [10][2];
        matrizTemperaturas[0][0] = -2;
        matrizTemperaturas[0][1] = 33;
        matrizTemperaturas[1][0] = -3;
        matrizTemperaturas[1][1] = 32;
        matrizTemperaturas[2][0] = -8;
        matrizTemperaturas[2][1] = 27;
        matrizTemperaturas[3][0] = 4;
        matrizTemperaturas[3][1] = 37;
        matrizTemperaturas[4][0] = 6;
        matrizTemperaturas[4][1] = 42;
        matrizTemperaturas[5][0] = 5;
        matrizTemperaturas[5][1] = 43;
        matrizTemperaturas[6][0] = 0;
        matrizTemperaturas[6][1] = 39;
        matrizTemperaturas[7][0] = -7;
        matrizTemperaturas[7][1] = 26;
        matrizTemperaturas[8][0] = -1;
        matrizTemperaturas[8][1] = 31;
        matrizTemperaturas[9][0] = -10;
        matrizTemperaturas[9][1] = 35;

        int temperaturaMinima [] = new int[2];
        int temperaturaMaxima [] = new int[2];

        for (int f=0; f<= 9; f++) {
            for (int c=0; c<=1; c++) {
                if (f == 0 && c == 0) {
                    temperaturaMinima[0] = f;
                    temperaturaMinima[1] = matrizTemperaturas[f][c];
                    continue;
                }
                if (f == 0 && c == 1) {
                    temperaturaMaxima[0] = f;
                    temperaturaMaxima[1] = matrizTemperaturas[f][c];
                    continue;
                }
                if (matrizTemperaturas[f][0] < temperaturaMinima[1]) {
                    temperaturaMinima[0] = f;
                    temperaturaMinima[1] = matrizTemperaturas[f][0];
                }
                if (matrizTemperaturas[f][1] > temperaturaMaxima[1]) {
                    temperaturaMaxima[0] = f;
                    temperaturaMaxima[1] = matrizTemperaturas[f][1];
                }
            }
        }
        System.out.println("la ciudad mas fria es " + ciudades[temperaturaMinima[0]] + " con " + temperaturaMinima[1] + " grados.");
        System.out.println("la ciudad mas calurosa es " + ciudades[temperaturaMaxima[0]] + " con " + temperaturaMaxima[1] + " grados.");
    }


}
