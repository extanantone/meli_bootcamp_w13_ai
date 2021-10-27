import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args){
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Fiesta","Ford",1000.0));
        vehiculos.add(new Vehiculo("Focus","Ford",1200.0));
        vehiculos.add(new Vehiculo("Explorer","Ford",2500.0));
        vehiculos.add(new Vehiculo("Uno","Fiat",500.0));
        vehiculos.add(new Vehiculo("Cronos","Fiat",1000.0));
        vehiculos.add(new Vehiculo("Torino","Fiat",1250.0));
        vehiculos.add(new Vehiculo("Aveo","Chevrolet",1250.0));
        vehiculos.add(new Vehiculo("Spin","Chevrolet",2500.0));
        vehiculos.add(new Vehiculo("Corola","Toyota",1200.0));
        vehiculos.add(new Vehiculo("Fortuner","Toyota",3000.0));
        vehiculos.add(new Vehiculo("Logan","Renault",950.0));
        Garaje garaje = new Garaje(1,vehiculos);
        garaje.getVehiculos().stream()
                .sorted((x,y) -> x.getCosto().compareTo(y.getCosto()))
                .forEach(System.out::println);
        System.out.println("///////////////////////////////////////////////");
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println("///////////////////////////////////////////////");
        garaje.getVehiculos().stream().filter(x -> x.getCosto() < 1000.0)
                .forEach(System.out::println);
        System.out.println("///////////////////////////////////////////////");
        garaje.getVehiculos().stream().filter(x -> x.getCosto() >= 1000.0)
                .forEach(System.out::println);
        System.out.println("///////////////////////////////////////////////");
        System.out.println(garaje.getVehiculos().stream().mapToDouble(x -> x.getCosto()).average().getAsDouble());
    }
}
