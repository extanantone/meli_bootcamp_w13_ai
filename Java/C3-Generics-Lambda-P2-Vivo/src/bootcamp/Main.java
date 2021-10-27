package bootcamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List <Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();

        listaVehiculos.add(new Vehiculo("Fiesta","Ford",1000));
        listaVehiculos.add(new Vehiculo("Focus","Ford",1200));
        listaVehiculos.add(new Vehiculo("Explorer","Ford",2500));
        listaVehiculos.add(new Vehiculo("Uno","Fiat",500));
        listaVehiculos.add(new Vehiculo("Cronos","Fiat",1000));
        listaVehiculos.add(new Vehiculo("Torino","Fiat",1250));
        listaVehiculos.add(new Vehiculo("Aveo","Chevrolet",1250));
        listaVehiculos.add(new Vehiculo("Spin","Chevrolet",2500));
        listaVehiculos.add(new Vehiculo("Corolla","Toyota",1200));
        listaVehiculos.add(new Vehiculo("Fortuner","Toyota",3000));
        listaVehiculos.add(new Vehiculo("Logan","Renault",950));

        Garage garage = new Garage (1,listaVehiculos);

        //Ejercicio 3
       // Collections.sort(listaVehiculos, (Vehiculo p1, Vehiculo p2) -> p1.getCosto().compareTo(p2.getCosto()));
        //listaVehiculos.stream().sorted((v1,v2) -> v1.getCosto().compareTo(v2.getCosto()))
                                //.forEach(System.out::println);

        //Ejercicio 4
      /*  listaVehiculos.stream().sorted((v1,v2) -> v1.getCosto().compareTo(v2.getCosto()))
                .sorted((v1,v2) -> v1.getMarca().compareTo(v2.getMarca()))
                .forEach(System.out::println);*/

        //Ejercicio 5
        listaVehiculos.stream().filter(x -> x.getCosto() <= 1000)
                                .forEach(System.out::println);

        listaVehiculos.stream().filter(x -> x.getCosto() > 1000)
                .forEach(System.out::println);

        int a = 0;
        System.out.println("El promedio es: " + listaVehiculos.stream().mapToDouble(v -> v.getCosto()).average().getAsDouble());
    }

}
