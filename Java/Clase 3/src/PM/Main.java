package PM;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Garage elGarageDePablo = new Garage(1);

        elGarageDePablo.addVehiculo(new Vehiculo("Ford", "Fiesta", 1000));
        elGarageDePablo.addVehiculo(new Vehiculo("Ford", "Focus", 1200));
        elGarageDePablo.addVehiculo(new Vehiculo("Ford", "Explorer", 2500));
        elGarageDePablo.addVehiculo(new Vehiculo("Fiat", "Uno", 500));
        elGarageDePablo.addVehiculo(new Vehiculo("Fiat", "Cronos", 1000));
        elGarageDePablo.addVehiculo(new Vehiculo("Fiat", "Torino", 1250));
        elGarageDePablo.addVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250));
        elGarageDePablo.addVehiculo(new Vehiculo("Chevrolet", "Spin", 2500));
        elGarageDePablo.addVehiculo(new Vehiculo("Toyota", "Corola", 1200));
        elGarageDePablo.addVehiculo(new Vehiculo("Toyota", "Fortuner", 3000));
        elGarageDePablo.addVehiculo(new Vehiculo("Renault", "Logan", 950));

        System.out.println("Ordenemos los vehículos por precio ascendente:");
        elGarageDePablo.getVehiculos().stream().
                sorted(Comparator.comparingDouble(Vehiculo::getCosto)).
                forEach(System.out::println);

        System.out.println("Ordenemos ahora por marca y costo:");
        elGarageDePablo.getVehiculos().stream().
                sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto)).
                forEach(System.out::println);

        System.out.println("Vehículos con precio hasta 1000:");
        elGarageDePablo.getVehiculos().stream().
                filter(v -> v.getCosto() <= 1000).
                forEach(System.out::println);

        System.out.println("Vehículos con precio mayor  a 1000:");
        elGarageDePablo.getVehiculos().stream().
                filter(v -> v.getCosto() >= 1000).
                forEach(System.out::println);

        System.out.print("Promedio total de precios: ");
        System.out.printf("%.2f", elGarageDePablo.getVehiculos().stream().
                mapToDouble(v -> v.getCosto()).average().orElse(-1));
    }
}