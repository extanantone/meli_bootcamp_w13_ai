import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = List.of(
                new Vehiculo("Fiesta", "Ford", 1000.0),
                new Vehiculo("Focus", "Ford", 1200.0),
                new Vehiculo("Explorer", "Ford", 2500.0),
                new Vehiculo("Uno", "Fiat", 500.0),
                new Vehiculo("Cronos", "Fiat", 1000.0),
                new Vehiculo("Torino", "Fiat", 1250.0),
                new Vehiculo("Aveo", "Chevrolet", 1250.0),
                new Vehiculo("Spin", "Chevrolet", 2500.0),
                new Vehiculo("Corola", "Toyota", 1200.0),
                new Vehiculo("Fortuner", "Toyota", 3000.0),
                new Vehiculo("Renault", "Logan", 1250.0)
        );

        Garaje garaje = new Garaje(1, vehiculos);

        System.out.println("Vehiculos ordenados por precio de menor a mayor:");

        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getCosto))
                          .forEach(System.out::println);

        System.out.println("Vehiculos ordenas por marca y precio:");

        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca)
                          .thenComparing(Vehiculo::getCosto))
                          .forEach(System.out::println);

        System.out.println("Vehiculos con precio < 1000");

        vehiculos.stream().filter(x -> x.getCosto() < 1000.0)
                          .forEach(System.out::println);

        System.out.println("Vehiculos con precio >= 1000");

        vehiculos.stream().filter(x -> x.getCosto() >= 1000.0)
                .forEach(System.out::println);

        System.out.println("Precio promedio de la lista de vehiculos");

        System.out.println(vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble());
    }
}
