import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        Vehiculo ford1 = new Vehiculo("ford", "Fiesta", 1000d);
        Vehiculo ford2 = new Vehiculo("ford", "Focus", 1200d);
        Vehiculo ford3 = new Vehiculo("ford", "Explorer", 2500d);
        Vehiculo ford4 = new Vehiculo("Fiat", "Uno", 500d);
        Vehiculo ford5 = new Vehiculo("Fiat", "Cronos", 1000d);
        Vehiculo ford6 = new Vehiculo("Fiat", "Torino", 1250d);
        Vehiculo ford7 = new Vehiculo("Chevrolet", "Aveo", 1250d);
        Vehiculo ford8 = new Vehiculo("Chevrolet", "Spin", 2500d);
        Vehiculo ford9 = new Vehiculo("Toyota", "Corola", 1200d);
        Vehiculo ford10 = new Vehiculo("Toyota", "Fortuner", 3000d);
        Vehiculo ford11 = new Vehiculo("Renault", "Logan", 950d);

        List<Vehiculo> vehiculoList = List.of(ford1, ford2, ford3, ford4, ford5,
                ford6, ford7, ford8, ford9, ford10, ford11);
        Garaje miGaraje = new Garaje(12, vehiculoList);

        System.out.println("Ordenado por costo");
        miGaraje.getVehiculosList().stream().
                sorted((x, y) -> (int) (x.getCosto() - y.getCosto())).
                forEach(System.out::println);
        System.out.println();

        System.out.println("Ordenado por marca y luego por costo");
        miGaraje.getVehiculosList().stream().
                sorted((x, y) -> (int) (x.getCosto() - y.getCosto())).
                sorted((x, y) -> x.getMarca().compareToIgnoreCase(y.getMarca())).
                forEach(System.out::println);
        System.out.println();

        System.out.println("Vehiculos con un costo menor a mil");
        List<Vehiculo> vehiculosMenorAMil = miGaraje.getVehiculosList().stream().filter((x) -> x.getCosto() < 1000).collect(Collectors.toList());
        vehiculosMenorAMil.forEach(System.out::println);
        System.out.println();

        System.out.println("Vehiculos con un costo mayor o igual a mil");
        List<Vehiculo> vehiculosMayorIgualAMil = miGaraje.getVehiculosList().stream().filter((x) -> x.getCosto() >= 1000).collect(Collectors.toList());
        vehiculosMayorIgualAMil.forEach(System.out::println);
        System.out.println();

        System.out.println("Promedio de costos");
        double promedio = miGaraje.getVehiculosList().stream().collect(Collectors.averagingDouble(Vehiculo::getCosto));
        double sumaDatos = miGaraje.getVehiculosList().stream().reduce(0.0, (acum , val) -> acum + val.getCosto(), Double::sum);
        long cantidadVehiculos = miGaraje.getVehiculosList().size();
        //double promedio = (double) sumaDatos / cantidadVehiculos;
        System.out.printf("Cantidad de vehiculos %d\nSumatoria de costos %f\nPromedio de costos: %.2f\n",
                cantidadVehiculos, sumaDatos, promedio);
    }
}
