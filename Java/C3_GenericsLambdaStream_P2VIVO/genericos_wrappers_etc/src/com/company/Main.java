package com.company;

import objetos.Garaje;
import objetos.Vehiculo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args){
        //Ejercicio 2

        List<Vehiculo> listaVehiculos= new ArrayList();

        Vehiculo v = new Vehiculo("ford","Fiesta",1000);
        listaVehiculos.add(v);
        v = new Vehiculo("ford","focus",1200);
        listaVehiculos.add(v);
        v = new Vehiculo("ford","Explorer",2500);
        listaVehiculos.add(v);
        v = new Vehiculo("fiat","Uno",500);
        listaVehiculos.add(v);
        v = new Vehiculo("fiat","Cronos",1000);
        listaVehiculos.add(v);
        v = new Vehiculo("fiat","Toro",1250);
        listaVehiculos.add(v);
        v = new Vehiculo("Chevrolet","Aveo",1250);
        listaVehiculos.add(v);
        v = new Vehiculo("Chevrolet","Spin",2500);
        listaVehiculos.add(v);
        v = new Vehiculo("Toyota","Corola",1200);
        listaVehiculos.add(v);
        v = new Vehiculo("Toyota","Fortuner",3000);
        listaVehiculos.add(v);
        v = new Vehiculo("Renault","Logan",1250);
        listaVehiculos.add(v);

        Garaje g = new Garaje(1,listaVehiculos);

        //Ejercicio 3
        //listaVehiculos = g.getListaVehiculos().stream().sorted((x,y)->Double.compare(x.getCosto(),y.getCosto())).collect(Collectors.toList());

        /* for (Vehiculo l : listaVehiculos) {
            System.out.println(l.getCosto());
        }*/

        //Ejercicio 4
        //listaVehiculos = g.getListaVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).collect(Collectors.toList());
        /*for (Vehiculo l : listaVehiculos) {
            System.out.println(l.getMarca()+", costo: "+l.getCosto());
        }*/

        //Ejercicio 5
        listaVehiculos = g.getListaVehiculos().stream().filter(x->x.getCosto()<1000).collect(Collectors.toList());
        System.out.println("Lista con precios no mayores a 1000");
        for (Vehiculo l : listaVehiculos) {
            System.out.println(l.getMarca()+", costo: "+l.getCosto());
        }
        listaVehiculos = g.getListaVehiculos().stream().filter(x->x.getCosto()>=1000).collect(Collectors.toList());
        System.out.println("Lista con precios mayores o iguales a 1000");
        for (Vehiculo l : listaVehiculos) {
            System.out.println(l.getMarca()+", costo: "+l.getCosto());
        }
        Double promediolistaVehiculos = g.getListaVehiculos().stream().mapToDouble(x->x.getCosto()).average().orElse(-1);// .summaryStatistics().getAverage();

        System.out.println("El promedio es: "+promediolistaVehiculos);
        int[] a = new int[8];
        a = new int[]{1, 5, 3, 2, 1, 4, 3, 56, 4, 555, 333};
        a = burbuja(a);
        for (int n:a
             ) {
            System.out.println(n);
        }

    }

    public static int[] burbuja(int[] array) {
        array = Arrays.stream(array).sorted().toArray();

        return array;
    }
}
