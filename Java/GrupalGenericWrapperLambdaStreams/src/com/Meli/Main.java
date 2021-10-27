package com.Meli;

import com.Meli.Entity.Garage;
import com.Meli.Entity.Vehiculo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Vehiculo fordFiesta = new Vehiculo("Ford", "Fiesta", 1000.0);
        Vehiculo fordFocus = new Vehiculo("Ford", "Focus", 1200.0);
        Vehiculo fordExplorer = new Vehiculo("Ford", "Explorer", 2500.0);
        Vehiculo fiatUno = new Vehiculo("Fiat", "Uno", 500.0);
        Vehiculo fiatCronos = new Vehiculo("Fiat", "Cronos", 1000.0);
        Vehiculo fiatTorino = new Vehiculo("Fiat", "Torino", 1250.0);
        Vehiculo chevroletAveo = new Vehiculo("Chevrolet", "Aveo", 1250.0);
        Vehiculo chevroletSpin = new Vehiculo("Chevrolet", "Spin", 2500.0);
        Vehiculo toyotaCorola = new Vehiculo("Toyota", "Corola", 1200.0);
        Vehiculo toyotaFortuner = new Vehiculo("Toyota", "Fortuner", 3000.0);
        Vehiculo renaultLogan = new Vehiculo("Renault", "Logan", 950.0);
        List<Vehiculo> listaVehiculo = new LinkedList<>();
        listaVehiculo.add(fordFiesta);
        listaVehiculo.add(fordFocus);
        listaVehiculo.add(fordExplorer);
        listaVehiculo.add(fiatUno);
        listaVehiculo.add(fiatCronos);
        listaVehiculo.add(fiatTorino);
        listaVehiculo.add(chevroletAveo);
        listaVehiculo.add(chevroletSpin);
        listaVehiculo.add(toyotaCorola);
        listaVehiculo.add(toyotaFortuner);
        listaVehiculo.add(renaultLogan);

        Garage garage = new Garage(1,listaVehiculo);
        System.out.println("Vehiculos ordenados por precio");
        listaVehiculo.stream().sorted((x,y) -> x.getPrecio().compareTo(y.getPrecio())).forEach(x->{System.out.print(x.getModelo());
            System.out.print(" - "+x.getModelo());
            System.out.println(" - "+x.getPrecio());});
        System.out.println();
        System.out.println("Vehiculos ordenados por Marca y precio");
        listaVehiculo.stream().sorted(Comparator.comparing(Vehiculo::getModelo).thenComparing(Vehiculo::getPrecio))
                .forEach(x->{System.out.print(x.getModelo());
            //System.out.print(" - "+x.getMarca());
            System.out.println(" - "+x.getPrecio());});

        System.out.println();
        System.out.println("Vehiculos con precio menor a 1000");
        listaVehiculo.stream().filter(x -> x.getPrecio().compareTo(1000.0)==-1).forEach(x->{System.out.print(x.getModelo());
            System.out.print(" - "+x.getMarca());
            System.out.println(" - "+x.getPrecio());});
        
        System.out.println();
        System.out.println("Vehiculos con precio mayor igual a 1000");
        listaVehiculo.stream().filter(x -> x.getPrecio().compareTo(1000.0)>=0).forEach(System.out::println);
        /*listaVehiculo.stream().filter(x -> x.getPrecio().compareTo(1000.0)>=0).forEach(x->{System.out.print(x.getModelo());
            System.out.print(" - "+x.getMarca());
            System.out.println(" - "+x.getPrecio());});*/
        System.out.println();
        System.out.println("Promedio de precios: "+listaVehiculo.stream().mapToDouble(x->x.getPrecio()).average());

    }
}
