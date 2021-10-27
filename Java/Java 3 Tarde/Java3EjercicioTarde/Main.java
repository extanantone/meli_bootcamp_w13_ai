package Java3EjercicioTarde;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Fiesta", "Ford", 1000D));
        vehiculos.add(new Vehiculo("Focus", "Ford", 1200D));
        vehiculos.add(new Vehiculo("Explorer", "Ford", 2500D));
        vehiculos.add(new Vehiculo("Uno", "Fiat", 500D));
        vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000D));
        vehiculos.add(new Vehiculo("Torino", "Fiat", 1250D));
        vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250D));
        vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500D));
        vehiculos.add(new Vehiculo("Corola", "Toyota", 1200D));
        vehiculos.add(new Vehiculo("Fortuner", "Toyota", 1200D));
        vehiculos.add(new Vehiculo("Logan", "Renault", 1200D));

        Garage garage = new Garage(vehiculos);
//        garage.getVehiculos()
//                .stream()
//                .sorted((v1,v2) -> v1.getCosto().compareTo(v2.getCosto()))
//                .forEach(p -> System.out.println(p.getCosto()));

        System.out.println("======================================================");

//        garage.getVehiculos()
//                .stream()
//                .sorted((v1,v2) -> v1.getCosto().compareTo(v2.getCosto()))
//                .sorted((v1,v2) -> v1.getMarca().compareTo(v2.getMarca()))
//                .forEach(p -> System.out.println(p.getMarca() + " " +p.getCosto()));

        System.out.println("======================================================");

        garage.getVehiculos()
                .stream()
                .filter(v1 -> v1.getCosto() <= 1000)
                .forEach(p -> System.out.println(p.getMarca() + " " + p.getModelo() + " " + p.getCosto()));

        System.out.println("======================================================");

        garage.getVehiculos()
                .stream()
                .filter(v1 -> v1.getCosto() >= 1000)
                .forEach(p -> System.out.println(p.getMarca() + " " + p.getModelo() + " " + p.getCosto()));

        System.out.println("======================================================");

//        garage.getVehiculos()
//                .stream()
//                .mapToDouble(Vehiculo::getCosto)
//                .average();
        System.out.println("El promedio total de precios es :" + garage.getVehiculos()
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(-1));






    }
    }

