import jdk.swing.interop.SwingInterOpUtils;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Garage garage = new Garage(1);

        garage.agregarVehiculo(new Vehiculo("Ford", "Fiesta", 8000));
        garage.agregarVehiculo(new Vehiculo("Ford", "Focus", 1200));
        garage.agregarVehiculo(new Vehiculo("Ford", "Explorer", 2500));
        garage.agregarVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250));
        garage.agregarVehiculo(new Vehiculo("Chevrolet", "Spin", 2500));
        garage.agregarVehiculo(new Vehiculo("Toyota", "Corola", 1200));
        garage.agregarVehiculo(new Vehiculo("Renault", "Logan", 950));


        System.out.println("VEHICULOS ORDENADOS POR MARCA");
        garage.ordenarPorMarca();
        System.out.println("=============================");
        System.out.println("VEHICULOS ORDENADOR POR COSTO");
        garage.ordenarPorCosto();

    }
}
