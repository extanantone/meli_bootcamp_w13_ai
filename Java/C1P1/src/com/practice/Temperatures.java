package com.practice;

public class Temperatures {
    public static void main(String[] args){
        String[] cities = {"Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };
        int[][] temperatures = {
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
        int[] min = {0,temperatures[0][0]};
        int[] max = {0,temperatures[0][1]};

        for (int i = 1; i < temperatures.length; i++){
            if (temperatures[i][0] < min[1]){
                min[0] = i;
                min[1] = temperatures[i][0];
            }
            if (temperatures[i][1] > max[1]){
                max[0] = i;
                max[1] = temperatures[i][1];
            }
        }
        System.out.printf("La ciudad que tuvo menor temperatura fue %s, con %d ºC\n", cities[min[0]], min[1]);
        System.out.printf("La ciudad que tuvo mayor temperatura fue %s, con %d ºC\n", cities[max[0]], max[1]);
    }
}
