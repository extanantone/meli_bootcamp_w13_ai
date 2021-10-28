package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Vehículo> listaDeVehículos = new ArrayList();
        listaDeVehículos.add(new Vehículo("Ford", "Fiesta", 1000));
        listaDeVehículos.add(new Vehículo("Ford", "Focus", 1200));
        listaDeVehículos.add(new Vehículo("Ford", "Explorer", 2500));
        listaDeVehículos.add(new Vehículo("Fiat", "Uno", 500));
        listaDeVehículos.add(new Vehículo("Fiat", "Cronos", 1000));
        listaDeVehículos.add(new Vehículo("Fiat", "Torino", 1250));
        listaDeVehículos.add(new Vehículo("Chevrolet", "Aveo", 1250));
        listaDeVehículos.add(new Vehículo("Chevrolet", "Spin", 2500));
        listaDeVehículos.add(new Vehículo("Toyota", "Corola", 1200));
        listaDeVehículos.add(new Vehículo("Toyota", "Fortuner", 3000));
        listaDeVehículos.add(new Vehículo("Renault", "Logan", 950));

	    Garage garage = new Garage(1, listaDeVehículos);

        Stream<Vehículo> listaDeVehículosStream = garage.getListaDeVehículos()
                .stream();


        Stream<Vehículo> listaPorPrecios = listaDeVehículosStream
                .sorted((x, y) -> ((Integer)x.getCosto()).compareTo(y.getCosto()));

        Stream<Vehículo> listaPorMarca = listaDeVehículosStream
                .sorted((x, y) -> (x.getMarca()).compareToIgnoreCase(y.getMarca()));

        Stream<Vehículo> listaBaratos = listaDeVehículosStream
                .filter(x -> x.getCosto() < 1000);

        Stream<Vehículo> listaCaros = listaDeVehículosStream
                .filter(x -> x.getCosto() < 1000);


        listaPorPrecios.map(vehículo -> vehículo.toString())
                .forEach(System.out::println);

        System.out.println("\n---------\n");

        listaPorMarca.map(vehículo -> vehículo.toString())
                .forEach(System.out::println);

        System.out.println("\n---------\n");

        listaBaratos.map(vehículo -> vehículo.toString())
                .forEach(System.out::println);

        System.out.println("\n---------\n");

        listaCaros.map(vehículo -> vehículo.toString())
                .forEach(System.out::println);

        System.out.println("\n---------\n");

        int precioTotal = listaDeVehículosStream.map(v -> v.getCosto()).reduce(0, Integer::sum);

        double promedioPrecios = precioTotal / garage.getListaDeVehículos().size();

        System.out.println("Promedio: " + promedioPrecios);






    }
}
