package autoPartes;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage(1);
        garage.addVehiculo(new Vehiculo("Ford", "Fiesta", 1000));
        garage.addVehiculo(new Vehiculo("Ford", "Focus", 1200));
        garage.addVehiculo(new Vehiculo("Ford", "Explorer", 2500));
        garage.addVehiculo(new Vehiculo("Fiat", "Uno", 500));
        garage.addVehiculo(new Vehiculo("Fiat", "Cronos", 1000));
        garage.addVehiculo(new Vehiculo("Fiat", "Torino", 1250));
        garage.addVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250));
        garage.addVehiculo(new Vehiculo("Chevrolet", "Spin", 2500));
        garage.addVehiculo(new Vehiculo("Toyota", "Corola", 1200));
        garage.addVehiculo(new Vehiculo("Toyota", "Fortuner", 3000));
        garage.addVehiculo(new Vehiculo("Renault", "Logan", 950));

        System.out.println("Vehiculos por orden de precio ascendente:\n");
        garage.getVehiculos().stream().
                sorted(Comparator.comparingDouble(Vehiculo::getCosto)).
                forEach(System.out::println);

        System.out.println("\nVehiculos por orden de marca y luego precio ascendentes:\n");
        garage.getVehiculos().stream().
                sorted(Comparator.comparing(Vehiculo::getMarca).
                        thenComparingDouble(Vehiculo::getCosto)).
                        forEach(System.out::println);

        System.out.println("\nVehiculos con costo no mayor a 1000:\n");
        garage.getVehiculos().stream().filter(v -> v.getCosto()<=1000).
                forEach(System.out::println);

        System.out.println("\nVehiculos con costo de al menos 1000:\n");
        garage.getVehiculos().stream().filter(v -> v.getCosto()>=1000).
                forEach(System.out::println);

        System.out.println("\nPromedio de costos de todos los vehículos\n");
        garage.getVehiculos().stream().mapToDouble(v -> v.getCosto()).average().getAsDouble();
    }
}
