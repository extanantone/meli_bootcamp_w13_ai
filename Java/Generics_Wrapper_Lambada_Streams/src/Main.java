import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Fiesta", "Ford", 1000D));
        vehiculos.add(new Vehiculo("Focus", "Ford", 1200D));
        vehiculos.add(new Vehiculo("Explorer", "Ford", 2500.0));
        vehiculos.add(new Vehiculo("Uno", "Fiat", 500.0));
        vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000.0));
        vehiculos.add(new Vehiculo("Torino", "Fiat", 1250.0));
        vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250.0));
        vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500.0));
        vehiculos.add(new Vehiculo("Corola", "Toyoya", 1200.0));
        vehiculos.add(new Vehiculo("Fortuner", "Toyoya", 3000D));
        vehiculos.add(new Vehiculo("Logan", "Renault", 950D));

        Garaje garaje = new Garaje(vehiculos);

        System.out.println("\nOrden por costo");
        garaje.getListaVehiculo()
                .stream().sorted((v1, v2) -> v1.getCosto().compareTo(v2.getCosto()))
                .forEach(p -> System.out.println(p.getMarca() + " " + p.getCosto()));

        System.out.println("\nOrden por marca y costo");
        garaje.getListaVehiculo()
                .stream().sorted((v1, v2) -> v1.getCosto().compareTo(v2.getCosto()))
                .sorted((v1, v2) -> v1.getMarca().compareTo(v2.getMarca()))
                .forEach(p -> System.out.println(p.getMarca() + " " + p.getCosto()));

        System.out.println("\nmenores a 1000");
        garaje.getListaVehiculo().stream().filter(x -> x.getCosto() < 1000D)
                .forEach(p -> System.out.println(p.getMarca() + " " + p.getCosto()));

        System.out.println("\nmayores e iguales a 1000");
        garaje.getListaVehiculo().stream().filter(x -> x.getCosto() >= 1000D)
                .forEach(p -> System.out.println(p.getMarca() + " " + p.getCosto()));

        System.out.println("\nPromedio de costos");
        System.out.println(garaje.getListaVehiculo().stream()
                .mapToDouble(v -> v.getCosto())
                .average().orElse(-1));
    }
}
