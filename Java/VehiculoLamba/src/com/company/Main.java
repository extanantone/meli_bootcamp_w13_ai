package com.company;

import java.util.*;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {
        ArrayList <Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        listaVehiculos.add(new Vehiculo("Fiesta","ford",1000.00));
        listaVehiculos.add(new Vehiculo("Focus","ford",1200.00));
        listaVehiculos.add(new Vehiculo("Explorer","ford",2500.00));
        listaVehiculos.add(new Vehiculo("Uno","fiat",500.00));
        listaVehiculos.add(new Vehiculo("Cronos","fiat",1000.00));
        listaVehiculos.add(new Vehiculo("Torino","fiat",1250.00));
        listaVehiculos.add(new Vehiculo("Aveo","Chevrolet",1250.00));
        listaVehiculos.add(new Vehiculo("Spin","Chevrolet", 2500.00));
        listaVehiculos.add(new Vehiculo("Corolla","Toyota",1200.00));
        listaVehiculos.add(new Vehiculo("Fortuner","Toyota",3000.00));
        listaVehiculos.add(new Vehiculo("Logan","Renault",950.00));

        int id=1;
        Garaje garaje = new Garaje(id, listaVehiculos);

        System.out.println("Lista vehiculos menores a $ 1000: \n");
        garaje.getVehiculo().stream()
                .sorted((va,vb) -> va.getCosto().compareTo(vb.getCosto()))
                .sorted((va1,vb1) -> va1.getMarca().compareTo(vb1.getMarca()))
                .filter(p -> p.getCosto() < 1000)
                .forEach(System.out::println);

        System.out.println("\nLista vehiculos mayores a $ 1000: \n");
        garaje.getVehiculo().stream()
                .sorted((va,vb) -> va.getCosto().compareTo(vb.getCosto()))
                .sorted((va1,vb1) -> va1.getMarca().compareTo(vb1.getMarca()))
                .filter(p -> p.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println("\nEl promedio de costo es $ "+Math.round(garaje.getVehiculo().stream().
                        mapToDouble(v -> v.getCosto()).average().orElse(-1)));
    }
}
