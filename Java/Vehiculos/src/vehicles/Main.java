package vehicles;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Vehicle> vehicles = new LinkedList<>();

        vehicles.add(new Vehicle("Ford", "Fiesta", 1000));
        vehicles.add(new Vehicle("Ford", "Focus", 1200));
        vehicles.add(new Vehicle("Ford", "Explorer", 2500));
        vehicles.add(new Vehicle("Fiat", "Uno", 500));
        vehicles.add(new Vehicle("Fiat", "Cronos", 1000));
        vehicles.add(new Vehicle("Fiat", "Torino", 1250));
        vehicles.add(new Vehicle("Chevrolet", "Aveo", 1250));
        vehicles.add(new Vehicle("Chevrolet", "Spin", 2500));
        vehicles.add(new Vehicle("Toyota", "Corolla", 1200));
        vehicles.add(new Vehicle("Toyota", "Fortuner", 3000));
        vehicles.add(new Vehicle("Renault", "Logan", 950));

        System.out.println("Lista original:");
        System.out.println(vehicles);

        vehicles.sort((v1, v2) -> {
            return Double.compare(v1.price, v2.price);
        });

        System.out.println("Lista ordenada por precio:");
        System.out.println(vehicles);

        vehicles.sort((v1, v2) -> {
            int o = v1.brand.compareTo(v2.brand);
            if (o == 0) {
                 o = Double.compare(v1.price, v2.price);
            }
            return o;
        });

        System.out.println("Lista ordenada por marca y precio:");
        System.out.println(vehicles);

        List<Vehicle> vehiclesUnder1000 = vehicles.stream().filter(v -> v.price<=1000).collect(Collectors.toList());

        System.out.println("Lista por debajo de 1000:");
        System.out.println(vehiclesUnder1000);

        List<Vehicle> vehiclesOver1000 = vehicles.stream().filter(v -> v.price>=1000).collect(Collectors.toList());

        System.out.println("Lista por encima de 1000:");
        System.out.println(vehiclesOver1000);

        double avgVehiclePrice = vehicles.stream().mapToDouble(v -> v.price).average().orElse(-1);

        System.out.println("Precio promedio:");
        System.out.println(avgVehiclePrice);
    }
}
