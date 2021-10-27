package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Garage{
    
    private List<Vehicle> vehicles;

    private static double avg =0;


    public Garage(){
        vehicles = List.of(new Vehicle("Ford", "Fiesta", 1000),
        new Vehicle("Ford", "Focus", 1200),new Vehicle("Ford", "Explorer", 2500),
        new Vehicle("Fiat", "Uno", 500)
        );
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }


    public static void main(String[] args) {
        Garage g = new Garage();
        List<Vehicle> vehiclesSortedByPrice = g.getVehicles().stream()
                                    .sorted((x,y)->x.getPrecio()<y.getPrecio()?-1:(x.getPrecio()<y.getPrecio()?x.getMarca().compareToIgnoreCase(y.getMarca()):1)).collect(Collectors.toList());

        System.out.println(vehiclesSortedByPrice);

        List<Vehicle> bigMil = g.getVehicles().stream()
                              .filter(x->x.getPrecio()>=1000).collect(Collectors.toList());      

        List<Vehicle> lessMil = g.getVehicles().stream()
                              .filter(x->x.getPrecio()<1000).collect(Collectors.toList());   

         g.getVehicles().stream()
                              .forEach(x->avg+=x.getPrecio());   
        avg = avg/g.getVehicles().size();

        System.out.println(">= 1000");
        System.out.println(bigMil);
        System.out.println("<1000");
        System.out.println(lessMil);

        System.out.println("Avg: "+avg);
    }

}