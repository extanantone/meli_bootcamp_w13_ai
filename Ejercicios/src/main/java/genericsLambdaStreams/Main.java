package genericsLambdaStreams;

import javax.xml.transform.SourceLocator;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        listaVehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        listaVehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        listaVehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        listaVehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        listaVehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        listaVehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        listaVehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        listaVehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        listaVehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        listaVehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        listaVehiculos.add(new Vehiculo("Logan", "Renault", 950));
        int id = 1;

        Garaje garaje = new Garaje(id, listaVehiculos);
        System.out.println("Lista vehiculos menores a $1000: ");

        listaVehiculos.stream()

                .sorted((vehA, vehB) -> vehA.getCosto().compareTo(vehB.getCosto()))
                .sorted((vehA, vehB) -> vehA.getMarca().compareTo(vehB.getMarca()))
                .filter(p -> p.getCosto() < 1000)
                .forEach(System.out::println);

        System.out.println("\nLista vehiculos igual o mayores a $1000: ");
        listaVehiculos.stream()

                .sorted((vehA, vehB) -> vehA.getCosto().compareTo(vehB.getCosto()))
                .sorted((vehA, vehB) -> vehA.getMarca().compareTo(vehB.getMarca()))
                .filter(p -> p.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println("\nPromedio de costos: ");
        System.out.println(garaje.getVehiculo().stream().
                mapToDouble(v -> v.getCosto()).average().orElse(-1));

    }
}


