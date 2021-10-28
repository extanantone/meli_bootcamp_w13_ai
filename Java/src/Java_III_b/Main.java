package Java_III_b;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage(1, new ArrayList<>());
        garage.getListaVehiculos().add(new Vehiculo("ford", "Fiesta", 1000));
        garage.getListaVehiculos().add(new Vehiculo("ford", "Focus", 1200));
        garage.getListaVehiculos().add(new Vehiculo("ford", "Explorer", 2500));
        garage.getListaVehiculos().add(new Vehiculo("Fiat", "Uno", 500));
        garage.getListaVehiculos().add(new Vehiculo("Fiat", "Cronos", 1000));
        garage.getListaVehiculos().add(new Vehiculo("Fiat", "Torino", 1250));
        garage.getListaVehiculos().add(new Vehiculo("Chevrolet", "Aveo", 1250));
        garage.getListaVehiculos().add(new Vehiculo("Chevrolet", "Spin", 2500));
        garage.getListaVehiculos().add(new Vehiculo("Toyota", "Coroia", 1200));
        garage.getListaVehiculos().add(new Vehiculo("Toyota", "Fortuner", 3000));
        garage.getListaVehiculos().add(new Vehiculo("Renault", "Logan", 950));
        garage.getListaVehiculos().sort((x, y) -> x.getCosto() - y.getCosto());
        System.out.println("Lista creada: " + garage.getListaVehiculos());
        System.out.println("Lista ordenada por costo: " + garage.getListaVehiculos());
        garage.getListaVehiculos().sort(
                new Comparator<Vehiculo>() {
                    @Override
                    public int compare(Vehiculo o1, Vehiculo o2) {
                        return o1.getMarca().compareTo(o2.getMarca());
                    }
                });
        System.out.println("Lista ordenada por marca y costo: " + garage.getListaVehiculos());

        System.out.println("Lista hasta 1000: " +
                garage.getListaVehiculos().stream().filter(v -> v.getCosto() <= 1000).collect(Collectors.toList()));
        System.out.println("Lista mayores a 1000: " +
                garage.getListaVehiculos().stream().filter(v -> v.getCosto() > 1000).collect(Collectors.toList()));
        System.out.println("Promedio: " +
                (double) garage.getListaVehiculos().stream().reduce(0, (acc, v) -> acc + v.getCosto(), Integer::sum)
                        / garage.getListaVehiculos().size());
    }
}


