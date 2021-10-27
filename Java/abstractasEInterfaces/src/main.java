import java.util.Comparator;

public class main {
    public static void main (String[] args){
        Garaje nuevoGaraje = new Garaje(1);
        nuevoGaraje.addVehiculo(new Vehiculo("ford", "fiesta", 1000));
        nuevoGaraje.addVehiculo(new Vehiculo("ford", "focus", 1200));
        nuevoGaraje.addVehiculo(new Vehiculo("ford", "explorer", 2500));
        nuevoGaraje.addVehiculo(new Vehiculo("fiat", "uno", 500));
        nuevoGaraje.addVehiculo(new Vehiculo("fiat", "cronos", 1000));
        nuevoGaraje.addVehiculo(new Vehiculo("fiat", "torino", 1250));
        nuevoGaraje.addVehiculo(new Vehiculo("chevrolet", "aveo", 1250));
        nuevoGaraje.addVehiculo(new Vehiculo("chevrolet", "spin", 2500));
        nuevoGaraje.addVehiculo(new Vehiculo("toyota", "corola", 1200));
        nuevoGaraje.addVehiculo(new Vehiculo("toyota", "fortuna", 3000));
        nuevoGaraje.addVehiculo(new Vehiculo("renault", "logan", 950));

        System.out.println("Ordenemos los vehiculos por precio ascendente:");
        nuevoGaraje.getVehiculos().stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("Ordenemos los vehiculos por marca y precio:");
        nuevoGaraje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("Obtener los más baratos que 1000:");
        nuevoGaraje.getVehiculos().stream().filter(v1-> v1.getCosto() <=1000).forEach(System.out::println);
        System.out.println("Obtener los mayores que 1000:");
        nuevoGaraje.getVehiculos().stream().filter(v1-> v1.getCosto() >=1000).forEach(System.out::println);
        System.out.println("Obtener promedio de costos:");
        System.out.println(nuevoGaraje.getVehiculos().stream().mapToDouble(v-> v.getCosto()).average().getAsDouble());

    }
}
