import java.util.Comparator;

public class Main {

    public static void main(String args[]){
        Garaje garage = new Garaje(1);
        garage.agregar(new Vehiculo("Ford", "Fiesta", 1000));
        garage.agregar(new Vehiculo("Ford", "Focus", 1200));
        garage.agregar(new Vehiculo("Ford", "Explorer", 2500));
        garage.agregar(new Vehiculo("Fiat", "Uno", 500));
        garage.agregar(new Vehiculo("Fiat", "Cronos", 1000));
        garage.agregar(new Vehiculo("Fiat", "Torino", 1250));
        garage.agregar(new Vehiculo("Chevrolet", "Aveo", 1250));
        garage.agregar(new Vehiculo("Chevrolet", "Spin", 2500));
        garage.agregar(new Vehiculo("Toyota", "Corola ", 1200));
        garage.agregar(new Vehiculo("Toyota", "Fortuner", 3000));
        garage.agregar(new Vehiculo("Renault", "Logan", 950));

        garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);
        garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);
        garage.getVehiculos().stream().filter(x -> x.getCosto()<1000).forEach(System.out::println);
        garage.getVehiculos().stream().filter(x -> x.getCosto()>=1000).forEach(System.out::println);
        System.out.println(garage.getVehiculos().stream().mapToDouble( (x)-> x.getCosto()).average().getAsDouble());

    }
}
