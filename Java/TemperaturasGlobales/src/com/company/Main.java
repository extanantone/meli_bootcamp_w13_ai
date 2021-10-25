package com.company;

public class Main {

    public static void main(String[] args) {
        String[] cities = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires",
                "Asunción", "São Paulo", "Lima", "Santiago de Chile",
                "Lisboa", "Tokio"
        };
        int[][] temps = {
                {-2, 33}, {-3, 32},
                {-8, 27}, {4, 37},
                {4, 37}, {6, 42},
                {5, 43}, {0, 39},
                {-7, 26}, {-1, 31},
                {-10, 35}
        };

        int lowest_temp = temps[0][0];
        String lowest_city = cities[0];
        int highest_temp = temps[0][1];
        String highest_city = cities[0];

        for(int i = 1; i < cities.length; i++)
        {
            if(lowest_temp > temps[i][0])
            {
                lowest_temp = temps[i][0];
                lowest_city = cities[i];
            }
            if(highest_temp < temps[i][1])
            {
                highest_temp = temps[i][1];
                highest_city = cities[i];
            }
        }
        System.out.println("La ciudad con la temperatura más baja es " + lowest_city + " con " + lowest_temp + " grados centígrados.");
        System.out.println("La ciudad con la temperatura más alta es " + highest_city + " con " + highest_temp + " grados centígrados.");
    }
}
