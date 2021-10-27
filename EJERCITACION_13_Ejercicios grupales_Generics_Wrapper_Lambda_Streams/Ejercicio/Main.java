package Ejercicio;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("ford","Fiesta",1000));
        vehiculos.add(new Vehiculo("ford","Focus",1200));
        vehiculos.add(new Vehiculo("ford","Explorer",2500));
        vehiculos.add(new Vehiculo("Fiat","uno",500));
        vehiculos.add(new Vehiculo("Fiat","Cronos",1000));
        vehiculos.add(new Vehiculo("Fiat","Torino",1250));
        vehiculos.add(new Vehiculo("Chevrolet","Aveo",1250));
        vehiculos.add(new Vehiculo("Chevrolet","Spin",2500));
        vehiculos.add(new Vehiculo("Toyota","Corola",1200));
        vehiculos.add(new Vehiculo("Toyota","Fortuner",3000));
        vehiculos.add(new Vehiculo("Logan","Spin",950));

        Garaje garaje = new Garaje(1,vehiculos);

        System.out.println("==========LISTA ORDENADA POR PRECIO==================\n");
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println("\n ===LISTA OREDENADA POR MARCA Y PRECIO===\n");
        garaje.getVehiculos().stream()
                 .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println("\n ===LISTA VEHICULOS CON PRECIOS MENOR A 1000===\n");
        garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .forEach(System.out::println);
        System.out.println("\n ===LISTA VEHICULOS CON PRECIOS MAYOR O IGUAL A 1000===\n");
        garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .forEach(System.out::println);

        //calculo de promedio
        double promedio =garaje.getVehiculos().stream()
                .collect(Collectors.summarizingDouble(v-> v.getCosto())).getAverage();
        System.out.println("\n ===PROMEDIO DE PRECIOS DE VEHICULOS===\n");
        System.out.println("EL PROMEDIO ES :"+promedio);


    }
}
