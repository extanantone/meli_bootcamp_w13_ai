package ejericiciopractico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> listaFinal = new ArrayList<>();

        listaFinal.add(new Vehiculo("ford", "Fiesta", 1000.0));
        listaFinal.add(new Vehiculo("ford", "Focus", 1200.0));
        listaFinal.add(new Vehiculo("ford", "Explorer", 2500.0));
        listaFinal.add(new Vehiculo("Fiat", "Uno", 500.0));
        listaFinal.add(new Vehiculo("Fiat", "Cronos", 1000.0));
        listaFinal.add(new Vehiculo("Fiat", "Torio", 1250.0));
        listaFinal.add(new Vehiculo("Chevrolet", "Aveo", 1250.0));
        listaFinal.add(new Vehiculo("Chevrolet", "Spin", 2500.0));
        listaFinal.add(new Vehiculo("Toyota", "Corola", 1200.0));
        listaFinal.add(new Vehiculo("Toyota", "Fortuner", 3000.0));
        listaFinal.add(new Vehiculo("Renault", "Logan", 950.0));

        Garaje miGaraje = new Garaje((long) 1, listaFinal);

        miGaraje.getListaVehiculos().stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .sorted((o1, o2) -> o1.getMarca().compareToIgnoreCase(o2.getMarca()))
                .forEach(System.out::println);

        List<Vehiculo> baratos = miGaraje.getListaVehiculos().stream()
                .filter(x -> x.getCosto() <= 1000)
                .collect(Collectors.toList());

        List<Vehiculo> caros = miGaraje.getListaVehiculos().stream()
                .filter(x -> x.getCosto() > 1000)
                .collect(Collectors.toList());


        Double sumaTotal = miGaraje.getListaVehiculos().stream().reduce(0.0, (acumulador, vh) -> acumulador + vh.getCosto(), Double::sum);
        Double promedio = sumaTotal / miGaraje.getListaVehiculos().size();

        System.out.printf("el promedio total es: %.2f\n", promedio);

        System.out.println("los baratos: ");
        baratos.stream().forEach(System.out::println);
        System.out.println("los caros: ");
        caros.stream().forEach(System.out::println);


    }
}
