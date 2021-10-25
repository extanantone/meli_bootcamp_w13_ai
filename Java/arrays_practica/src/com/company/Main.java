package com.company;

public class Main {

    public static void main(String[] args) {

        int lowestIndex = 0;
        int lowestValue = 50;
        int highestIndex = 0;
        int highestValue = -30;

        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 22}};

        for (int index = 0; index < cities.length; index++) {
            if (temperatures[index][0] < lowestValue) {
                lowestValue = temperatures[index][0];
                lowestIndex = index;
            }
            if (temperatures[index][1] > highestValue) {
                highestValue = temperatures[index][1];
                highestIndex = index;
            }
        }

        System.out.println("La ciudad con menor temperatura fue " + cities[lowestIndex] + " con " + lowestValue + "º C");
        System.out.println("La ciudad con mayor temperatura fue " + cities[highestIndex] + " con " + highestValue + "º C");
    }
}
