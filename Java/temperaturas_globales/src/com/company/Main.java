package com.company;

public class Main {

    public static void main(String[] args) {
        String ciudades[] = { "Londres",
                            "Madrid",
                            "Nueva York",
                            "Buenos Aires",
                            "Asunción",
                            "São Paulo",
                            "Lima",
                            "Santiago de Chile",
                            "Lisboa",
                            "Tokio",
        };
        float temperaturas[][] = {  {-2, 33}, {-3, 32}, {-8, 27},
                                    {4, 37}, {6, 42}, {5, 43},
                                    {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        float maxTemp = -100000, minTemp = 100000;
        String lugarMin = "", lugarMax = "";

        for(int f = 0; f < temperaturas.length; f++){
            if(temperaturas[f][0] < minTemp){ //busco el min
                minTemp = temperaturas[f][0];
                lugarMin = ciudades[f];  //tomo el nombre de la ciudad
            }
            if(temperaturas[f][1] > maxTemp){ //busco el max
                maxTemp = temperaturas[f][1];
                lugarMax = ciudades[f];
            }

        }

        System.out.println("La menor temperatura la tuvo " + lugarMin + ", con " + minTemp + "ºC.");
        System.out.println("La mayor temperatura la tuvo " + lugarMax + ", con " + maxTemp + "ºC.");

    }
}
