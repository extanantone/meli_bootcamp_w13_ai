package com.company;

public class Main {

    public static void citiesTemp() {
        String[] cities = {
                "Londres",
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
        int minTemp = temperatures[0][0];
        String minTempCity = cities[0];
        int maxTemp = temperatures[0][1];
        String maxTempCity = cities[0];
        for (int i=0; i<cities.length; i++) {
            if (temperatures[i][0] < minTemp) {
                minTemp = temperatures[i][0];
                minTempCity = cities[i];
            }
            if (temperatures[i][1] > maxTemp) {
                maxTemp = temperatures[i][1];
                maxTempCity = cities[i];
            }
        }
        System.out.println("La menor temperatura la tuvo " + minTempCity + ", con " + minTemp + "°C");
        System.out.println("La mayor temperatura la tuvo " + maxTempCity + ", con " + maxTemp + "°C");
    }

    public static void main(String[] args) {
        citiesTemp();
    }
}
