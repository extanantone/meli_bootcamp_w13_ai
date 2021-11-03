package com.company;

import com.company.model.City;

public class Main {

    public static void main(String[] args) {

        City Londres = new City("Londres", -2, 33);
        City Madrid = new City("Madrid", -3, 32);
        City NuevaYork = new City("Nueva York", -8, 27);
        City BuenosAires = new City("Buenos Aires", 4, 37);
        City Asunción = new City("Asunción", 6, 42);
        City SãoPaulo = new City("São Paulo", 5, 43);
        City Lima = new City("Lima", 0, 39);
        City SantiagoDeChile = new City("Santiago De Chile", -7, 26);
        City Lisboa = new City("Lisboa", -1, 31);
        City Tokio = new City("Tokio", -10, 22);

        City[] cities = {Londres, Madrid, NuevaYork, BuenosAires, Asunción, SãoPaulo, Lima, SantiagoDeChile, Lisboa, Tokio};

        City cityWithLowestTemp = cities[0];
        int lowestValue = Integer.MAX_VALUE;

        City cityWithHighestTemp = cities[0];
        int highestValue = Integer.MIN_VALUE;

        for (int index = 1; index < cities.length; index++) {
            if (cities[index].getMinTemp()  < lowestValue) {
                lowestValue = cities[index].getMinTemp();
                cityWithLowestTemp = cities[index];
            }
            if (cities[index].getMaxTemp() > highestValue) {
                highestValue = cities[index].getMaxTemp();
                cityWithHighestTemp = cities[index];
            }
        }

        System.out.println("La ciudad con menor temperatura fue " + cityWithLowestTemp.getName() + " con " + lowestValue + "º C");
        System.out.println("La ciudad con mayor temperatura fue " + cityWithHighestTemp.getName() + " con " + highestValue + "º C");
    }
}
