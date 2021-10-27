package bootcamp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {

    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        listaVehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        listaVehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        listaVehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        listaVehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        listaVehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        listaVehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        listaVehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        listaVehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        listaVehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        listaVehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garage miGarage = new Garage(1, listaVehiculos);

        Comparator<Vehiculo> comparadorCosto = Comparator.comparing(Vehiculo::getCosto);
        Comparator<Vehiculo> comparadorMarcaCosto = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto);

        //Ej 3
        System.out.println("Ordenados segun el precio");
        //miGarage.getVehiculos().stream().sorted((x,y) -> x.getCosto().compareTo(y.getCosto())).forEach(System.out::println);
        miGarage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println("\n-----------------------------\n");

        //Ej 4
        System.out.println("Ordenados segun la marca y costo");
        miGarage.getVehiculos().stream().sorted(comparadorMarcaCosto).forEach(System.out::println);

        System.out.println("\n-----------------------------\n");

        //Ej 5
        System.out.println("Filtra los vehiculos con precio hasta 1000");
        miGarage.getVehiculos().stream().filter(x -> x.getCosto() <= 1000).forEach(System.out::println);
        System.out.print("\n");

        System.out.println("Filtra los vehiculos con precio mayor o igual a 1000");
        miGarage.getVehiculos().stream().filter(x -> x.getCosto() >= 1000).forEach(System.out::println);

        System.out.println("\n-----------------------------\n");
        OptionalDouble promedioPrecios = miGarage.getVehiculos().stream().mapToDouble(x -> x.getCosto()).average();
        //System.out.println("El promedio de todos los precios es: " + promedioPrecios.orElse(-1));
        System.out.printf("El promedio de todos los precios es %.2f", promedioPrecios.orElse(-1));

    }
}
