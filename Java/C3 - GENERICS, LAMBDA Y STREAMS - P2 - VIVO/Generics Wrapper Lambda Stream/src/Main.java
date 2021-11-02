import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        vehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        vehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        vehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        vehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        vehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        vehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        vehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garaje garaje = new Garaje(1, vehiculos);

        System.out.println("-------------Vehiculos ordenados por costo---------------");
        garaje.getVehiculos().stream()
                .sorted((a, b) -> a.getCosto() < b.getCosto() ? -1 : 0)
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------");

        System.out.println("-------------Vehiculos ordenados por marca y costo---------------");
        Comparator<Vehiculo> comparator = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto);
        garaje.getVehiculos().stream()
                .sorted(comparator).forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");

        System.out.println("-------------Vehiculos con costo menor a 1000---------------");
        garaje.getVehiculos().stream()
                .filter((a) -> a.getCosto() < 1000)
                .forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");

        System.out.println("-------------Vehiculos con costo mayor o igual a 1000---------------");
        garaje.getVehiculos().stream()
                .filter((a) -> a.getCosto() >= 1000)
                .forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");

        System.out.println("-------------Costo promedio de vehiculos del garaje---------------");
        System.out.println(garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(-1));
        System.out.println("-----------------------------------------------------------------");
    }
}
