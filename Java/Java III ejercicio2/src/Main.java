import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos= new ArrayList<>();
        vehiculos.add(new Vehiculo("fiesta","ford",1000.0));
        vehiculos.add(new Vehiculo("focus","ford",1200.0));
        vehiculos.add(new Vehiculo("uno","fiat",500.0));
        vehiculos.add(new Vehiculo("cronos","fiat",1000.0));
        vehiculos.add(new Vehiculo("spin","chevrolet",2500.0));
        vehiculos.add(new Vehiculo("aveo","chevrolet",1250.0));

        Garaje miGaraje = new Garaje("123",vehiculos);

        System.out.println("----- Ejercicio 1 ------");

        ///
        miGaraje.getListaVehiculos().stream()
                .sorted((x,y) -> x.getCosto().compareTo(y.getCosto()))
                .forEach(System.out::println);

        System.out.println("------ Ejercicio 2 -------");
        /// realizar ordenamiento por Comparator

        miGaraje.getListaVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("----- Ejercicio 3 -------");

        System.out.println("---------   Vehiculos precio menor a 1000 --------");
        miGaraje.getListaVehiculos().stream().filter(x -> x.getCosto() <= 1000)
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("------- vehiculos precio mayor a 1000 -------");
        miGaraje.getListaVehiculos().stream().filter(x -> x.getCosto() >= 1000)
                .collect(Collectors.toList()).forEach(System.out::println);

        double promedio = miGaraje.getListaVehiculos().stream()
                .mapToDouble(x -> x.getCosto())
                .average().getAsDouble();



        System.out.println("Promedio es: " + promedio);
    }
}
