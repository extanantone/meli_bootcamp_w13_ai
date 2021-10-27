package Ejercicio1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Garaje {
    int id;
    ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

    public Garaje(int id, ArrayList<Vehiculo> listaVehiculos) {
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }


    public void sort(){
        listaVehiculos.stream().sorted(Comparator.comparing(Vehiculo::getCosto).reversed()).forEach(System.out::println);
    }

    public void sortMarcaAndPrice(){
        listaVehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);
    }


    public void getPromedio (){

        listaVehiculos.stream().filter(x -> x.getCosto() < 1000).forEach(System.out::println);
        listaVehiculos.stream().filter(x -> x.getCosto() > 1000).forEach(System.out::println);
        System.out.println("El promedio es " + listaVehiculos.stream().mapToDouble( x -> x.getCosto()).average().orElse(-1));
    }
}
