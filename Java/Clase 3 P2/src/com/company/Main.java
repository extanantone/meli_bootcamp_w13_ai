package com.company;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Garage garage = new Garage("gu193");
        garage.agregar(new Vehiculo("Ford", "Fiesta", 1000));
        garage.agregar(new Vehiculo("Ford", "Focus", 1200));
        garage.agregar(new Vehiculo("Ford", "Explorer", 2500));
        garage.agregar(new Vehiculo("Fiat", "Uno", 500));
        garage.agregar(new Vehiculo("Fiat", "Cronos", 1000));
        garage.agregar(new Vehiculo("Fiat", "Torino", 1250));
        garage.agregar(new Vehiculo("Chevrolet", "Aveo", 1250));
        garage.agregar(new Vehiculo("Chevrolet", "Spin", 2500));
        garage.agregar(new Vehiculo("Toyota", "Corola", 1200));
        garage.agregar(new Vehiculo("Toyota", "Fortuner", 3000));
        garage.agregar(new Vehiculo("Logan", "Logan", 950));

        System.out.println("--------Precios de mayor a menor--------");
        garage.getItems().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println("\n --------Por marca y por precios--------");
        garage.getItems().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println("\n --------Precios menores a 1000--------");
        garage.getItems().stream().filter(a -> a.getCosto() < 1000).forEach(System.out::println);

        System.out.println("\n --------Precios mayores o iguales a 1000--------");
        garage.getItems().stream().filter(a -> a.getCosto() >= 1000).forEach(System.out::println);

        System.out.println("\n --------Promedio de precios--------");
        System.out.println(garage.getItems().stream().mapToInt (a -> a.costo).average().getAsDouble());

    }
}
