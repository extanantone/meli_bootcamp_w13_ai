package C3.generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garaje objGaraje = new Garaje("123");

        List<Vehiculo> listVehiculos = new ArrayList<>();

       // listVehiculos = objGaraje.getVehiculos();
        listVehiculos.add(new Vehiculo("Fiesta","Ford",1000));
        listVehiculos.add(new Vehiculo("Focus","Ford",1200));
        listVehiculos.add(new Vehiculo("Explorer","Ford",2500));
        listVehiculos.add(new Vehiculo("Aveo","Chevrolet",1250));
        listVehiculos.add(new Vehiculo("Spin","Chevrolet",2500));
        listVehiculos.add(new Vehiculo("Corola","Toyota",1200));

        objGaraje.setVehiculos(listVehiculos);

        //Lista de vehículos ordenada por precio de menor a mayor
        System.out.println("Lista de vehículos ordenada por precio de menor a mayor \n");
        listVehiculos.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println();

        //Imprimir una lista ordenada por marca y a su vez por precio
        System.out.println("Lista de vehículos ordenada por marca y a su vez por precio \n");
        listVehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println();

        //Lista de vehículos con precio no mayor a 1000
        System.out.println("Lista de vehículos con precio no mayor a 1250 \n");
        listVehiculos.stream().filter(vehiculo -> vehiculo.getCosto() < 1250).forEach(System.out::println);
        System.out.println();

        //Lista de vehículos con precio mayor o igual a 1000
        System.out.println("Lista de vehículos con precio mayor o igual a 1250 \n");
        listVehiculos.stream().filter(vehiculo -> vehiculo.getCosto() >= 1250).forEach(System.out::println);
        System.out.println();

        //Promedio total de precios de toda la lista de vehículos
        System.out.println("Lista de promedio de precios de toda la lista de vehículos");
        listVehiculos.stream().mapToInt(Vehiculo::getCosto).average().stream().forEach(System.out::println);
        System.out.println();
    }
}
