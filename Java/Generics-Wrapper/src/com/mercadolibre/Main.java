package com.mercadolibre;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static double av = 0;
    public static void main(String[] args) {
        Garage garage = new Garage();
        List<Vehiculo>vehiculos;
        garage.vehiculos = new ArrayList<>();
        garage.vehiculos.add(new Vehiculo("ford","Fiesta",1000));
        garage.vehiculos.add(new Vehiculo("ford","Focus",1200));
        garage.vehiculos.add(new Vehiculo("ford","Explorer",2500));
        garage.vehiculos.add(new Vehiculo("Fiat","Uno",500));
        garage.vehiculos.add(new Vehiculo("Fiat","Cronos",1000));
        garage.vehiculos.add(new Vehiculo("Fiat","Torino",1250));
        garage.vehiculos.add(new Vehiculo("Chevrolet","Ayeo",1250));
        garage.vehiculos.add(new Vehiculo("Chevrolet","Spin",2500));
        garage.vehiculos.add(new Vehiculo("Toyota","Corola",1200));
        garage.vehiculos.add(new Vehiculo("Toyota","Fortuner",3000));
        garage.vehiculos.add(new Vehiculo("Renault","Logan",950));
	    //Creando la lista de vehiculos

        System.out.println("Lista ordenada por costo de mayor a menor");
        vehiculos = garage.getVehiculos()
                            .stream()
                            .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                            .collect(Collectors.toList());
        System.out.println(vehiculos + "\n");

        System.out.println("Lista con vehiculos con precios menor a 1000");
        List<Vehiculo>vehiculos2 = vehiculos;
        vehiculos2 = garage.getVehiculos()
                .stream()
                .filter(x -> x.getCosto() < 1000)
                .collect(Collectors.toList());
        System.out.println(vehiculos2);

        System.out.println("Lista con precios mayor igual a 1000");
        List<Vehiculo>vehiculos3 = vehiculos;
        vehiculos3 = garage.getVehiculos()
                .stream()
                .filter(x -> x.getCosto() >= 1000.0)
                .collect(Collectors.toList());
        System.out.println(vehiculos3);

        //Otra forma de obtener el promedio
        garage.getVehiculos()
                .forEach(vehiculo -> av+=vehiculo.getCosto());
        av/=garage.vehiculos.size();
        //

        //Obtener promedio forma 2
        System.out.println("Promedio total de costos de vehiculos");
        double promedio =garage.getVehiculos().stream().mapToDouble((Vehiculo::getCosto)).average().orElse(-1);
        System.out.printf("%.2f", promedio);
        System.out.println("\n");

        System.out.println("Lista ordenada por marca y costo");
        List<Vehiculo>vehiculos4 = vehiculos;
        Comparator<Vehiculo> com = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto);
        vehiculos4 = garage.getVehiculos().stream().sorted(com).collect(Collectors.toList());
        System.out.println(vehiculos4);


    }

}
