package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here


        String[] ciudades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asuncion",
                "Sao Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisbona",
                "Tokyo",

        };

        Integer[][] temperatura = {
                {-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35}

        };
        int menor_temp = temperatura[0][0];
        String ciudad_menor = ciudades[0];
        String ciudad_mayor = ciudades[0];
        int mayor_temp = temperatura[0][1];

        for (int i=0;i< ciudades.length;i++){
            for(int j=0;j<2;j++){

                if(temperatura[i][j] < menor_temp){
                    menor_temp = temperatura[i][j];
                    ciudad_menor = ciudades[i];
                } else if (temperatura[i][j] > mayor_temp) {
                    mayor_temp = temperatura[i][j];
                    ciudad_mayor = ciudades[i];
                }

            }

        }

        System.out.println("la menor temperatura la tuvo "+ ciudad_menor + ", con " + menor_temp + "º");
        System.out.println("la mayor temperatura la tuvo "+ ciudad_mayor + ", con " + mayor_temp + "º");




    }
}
