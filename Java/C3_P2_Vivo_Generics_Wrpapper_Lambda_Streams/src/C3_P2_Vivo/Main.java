package C3_P2_Vivo;

//import java.util.ArrayList;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        listaVehiculos.add(new Vehiculo("Fiesta","ford",1000.00));
        listaVehiculos.add(new Vehiculo("Focus","ford",1200.00));
        listaVehiculos.add(new Vehiculo("Explorer","ford",2500.00));
        listaVehiculos.add(new Vehiculo("Uno","fiat",500.00));
        listaVehiculos.add(new Vehiculo("Cronos","fiat",1000.00));
        listaVehiculos.add(new Vehiculo("Torino","fiat",1250.00));
        listaVehiculos.add(new Vehiculo("Aveo","Chevrolet",1250.00));
        listaVehiculos.add(new Vehiculo("Spin","Chevrolet", 2500.00));
        listaVehiculos.add(new Vehiculo("Corolla","Toyota",1200.00));
        listaVehiculos.add(new Vehiculo("Fortuner","Toyota",3000.00));
        listaVehiculos.add(new Vehiculo("Logan","Renault",950.00));
        int id = 1;
        Garaje garaje = new Garaje(id, listaVehiculos);

        listaVehiculos.stream()
                .sorted((va,vb) -> va.getCosto().compareTo(vb.getCosto()))
                .sorted((va1,vb1) -> va1.getMarca().compareTo(vb1.getMarca()))
                .filter(p -> p.getCosto()<=1000)
                .forEach(System.out :: println);

        listaVehiculos.stream()
                .sorted((va,vb) -> va.getCosto().compareTo(vb.getCosto()))
                .sorted((va1,vb1) -> va1.getMarca().compareTo(vb1.getMarca()))
                .filter(p -> p.getCosto()>=1000)
                .forEach(System.out :: println);

        System.out.println("El promedio es: "+garaje.getVehiculo().stream().
                collect(Collectors.summarizingDouble(v -> v.getCosto())).getAverage());

    }
}
