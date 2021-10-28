package JAVA.C3.P2.EJ1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EjercicioC3P2 {
    public static void main(String[] args) {
        Vehiculo v = new Vehiculo("ford", "focus", 1200);
        Vehiculo v1 = new Vehiculo("ford", "fiesta", 1000);
        Vehiculo v2 = new Vehiculo("ford", "explorer", 2500);
        Vehiculo v3 = new Vehiculo("toyota", "corola", 1200);
        Vehiculo v4 = new Vehiculo("renault", "logan", 950);
        List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        listaVehiculos.add(v);
        listaVehiculos.add(v1);
        listaVehiculos.add(v2);
        listaVehiculos.add(v3);
        listaVehiculos.add(v4);

        Garaje garaje = new Garaje(1, listaVehiculos);

        //ordena por costo
        System.out.println("Lista de vehículos.");
        garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("**********");
        //ordena por marca y luego por costo
        garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("**********");
        //filtra por precios menores a 1000
        System.out.println("Precios menores a 1000.");
        garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto()<1000).forEach(System.out::println);
        System.out.println("**********");
        //filtra por precios mayores o iguales a 1000
        System.out.println("Precios mayores o iguales a 1000.");
        garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto()>=1000).forEach(System.out::println);
        System.out.println("**********");
        //obtiene promedio total de los precios
        System.out.println("Promedio total de precios: ");
        System.out.println(garaje.getVehiculos().stream().collect(Collectors.summarizingDouble(x -> x.getCosto())).getAverage());
    }
}
