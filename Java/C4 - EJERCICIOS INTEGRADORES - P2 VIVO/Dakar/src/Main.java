import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculoList = new ArrayList<>();
        vehiculoList.add(new Auto(1000, 10, 5, "AB01"));
        vehiculoList.add(new Auto(20, 10, 5, "AB02"));
        vehiculoList.add(new Moto(30, 10, 5, "AB03"));
        vehiculoList.add(new Moto(40, 10, 5, "AB04"));
        Carrera carrera = new Carrera(1000, 50000, "Dakar", vehiculoList);

        carrera.darDeAltaAuto(50, 10, 5, "AB05");
        carrera.darDeAltaMoto(60, 10, 5, "AB06");

        carrera.socorrerAuto("AB01");
        carrera.socorrerMoto("AB03");

        Vehiculo ganador = carrera.ganador();
        System.out.println("-------------------------------");
        System.out.println("El vehiculo ganador es "+ ganador.getPatente());
        carrera.eliminarVehiculoConPatente(ganador.getPatente());
        System.out.println("Eliminado ganador");
        System.out.println("-------------------------------");

        System.out.println("-------------------------------");
        ganador = carrera.ganador();
        System.out.println("El vehiculo ganador ahora es "+ ganador.getPatente());
        carrera.eliminarVehiculo(ganador);
        System.out.println("Eliminado ganador");
        System.out.println("-------------------------------");

        System.out.println("-------------------------------");
        ganador = carrera.ganador();
        System.out.println("El vehiculo ganador ahora es "+ ganador.getPatente());
        System.out.println("-------------------------------");

    }
}
