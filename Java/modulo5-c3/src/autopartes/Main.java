package autopartes;

import java.util.Comparator;
import java.util.stream.DoubleStream;

public class Main {
    public static void main (String[] args) {
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
        elGarageDePablo.addVehiculo(new Vehiculo("Toyota", "Fortuna", 3000));
        elGarageDePablo.addVehiculo(new Vehiculo("Renault", "Logan", 950));

        System.out.println("Ordenemos los vehículos por precio ascendente:");
        elGarageDePablo.getVehiculos().stream().
                sorted(Comparator.comparingDouble(Vehiculo::getCosto)).
                forEach(System.out::println);

        System.out.println("Ordenemos ahora por marca y costo:");
        elGarageDePablo.getVehiculos().stream().
                sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto)).
                forEach(System.out::println);

        System.out.println("Obtengamos los que no superan los 1000 australes:");
        elGarageDePablo.getVehiculos().stream().filter(v -> v.getCosto()<=1000).
                forEach(System.out::println);

        System.out.println("¿Y los de al menos 1000 australes? Veamos:");
        elGarageDePablo.getVehiculos().stream().filter(v -> v.getCosto()>=1000).
                forEach(System.out::println);

        System.out.print("Terminemos con el promedio de costos: ");
        System.out.println(elGarageDePablo.getVehiculos().stream().
                mapToDouble(v -> v.getCosto()).average().orElse(-1));
    }
}
