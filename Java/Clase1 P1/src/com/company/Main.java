package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String [] ciudades = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        short [][] temperaturas = new short[][]{
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        short idxMin = 0;
        short idxMax = 0;

        for (short i = 1; i < temperaturas.length; i++){
            if (temperaturas[i][0] < temperaturas[idxMin][0] ){
                idxMin = i;
            }
            if (temperaturas[i][1] > temperaturas[idxMax][1] ){
                idxMax = i;
            }

        }

        System.out.println("La temperatura mínima la registra la ciudad de " + ciudades[idxMin] + " con " + temperaturas[idxMin][0] + " grados");
        System.out.format("La temperatura máxima la registra la ciudad de %s con %d grados", ciudades[idxMax], temperaturas[idxMax][1]);

    }
}
