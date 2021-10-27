import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Main {
    static Garage garage = new Garage(1L,
            Arrays.asList(
                    new Vehiculo("ford", "Fiesta", 1000),
                    new Vehiculo("ford", "Focus", 1200),
                    new Vehiculo("fiat", "Uno", 500),
                    new Vehiculo("fiat", "Cronos", 1000),
                    new Vehiculo("chevrolet", "Aveo", 1250),
                    new Vehiculo("chevrolet", "Spin", 2500)
            ));

    static void mostrarVehiculosOrdenados() {
        garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
    }

    static Predicate<Vehiculo> filtroCostoMayorAMil = vehiculo -> vehiculo.getCosto() > 1000.0;

    static Predicate<Vehiculo> filtroCostoMenorAMil = vehiculo -> vehiculo.getCosto() < 1000.0;

    static void mostrarVehiculosFiltroCosto(Predicate<Vehiculo> filtro) {
        garage.getVehiculos().stream()
                .filter(filtro)
                .forEach(System.out::println);
    }

    static double obtenerPromedioCostos() {
        return garage.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println("Vehiculos ordenados");
        mostrarVehiculosOrdenados();

        System.out.println("-------------------");
        System.out.println("Vehiculos costo mayor a mil");
        mostrarVehiculosFiltroCosto(filtroCostoMayorAMil);

        System.out.println("-------------------");
        System.out.println("Vehiculos costo menor a mil");
        mostrarVehiculosFiltroCosto(filtroCostoMenorAMil);

        System.out.println("-------------------");
        System.out.println("Promedio costos");
        System.out.printf("%.2f", obtenerPromedioCostos());
    }
}
