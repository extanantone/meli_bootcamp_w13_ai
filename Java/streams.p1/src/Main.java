import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        //
        Vehiculo v1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo v2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo v3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo v4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo v5 = new Vehiculo("Chronos", "Fiat", 1000);
        Vehiculo v6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo v7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo v8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo v9 = new Vehiculo("Corolla", "Toyota", 1200);
        Vehiculo v10 = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo v11 = new Vehiculo("Logan", "Renault", 950);

        //
        vehiculos.add(v1);
        vehiculos.add(v2);
        vehiculos.add(v3);
        vehiculos.add(v4);
        vehiculos.add(v5);
        vehiculos.add(v6);
        vehiculos.add(v7);
        vehiculos.add(v8);
        vehiculos.add(v9);
        vehiculos.add(v10);
        vehiculos.add(v11);

        /*Garage garage = new Garage(1, vehiculos);
        ArrayList<Vehiculo> vehiculosList = garage.ordenarPorPrecio();
        System.out.println("Vehiculos ordenados por costo: ");
        for (int i = 0; i < vehiculosList.size(); i++) {
            System.out.println(vehiculosList.get(i).toString());
        }
        vehiculosList.stream().forEach(System.out::println);
         */
        Garage garage = new Garage(1, vehiculos);
        System.out.println("----------------------------------");
        System.out.println("Vehiculos ordenados por precio y marca");
        garage.ordenarVehiculos();
        System.out.println("----------------------------------");
        System.out.println("Vehiculos con costo menor de 1000");
        garage.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() < 1000).forEach(System.out::println);
        System.out.println("----------------------------------");
        System.out.println("Promedio de la lista anterior: ");
        System.out.println(garage.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() < 1000).mapToDouble(Vehiculo::getCosto).average().orElse(0));

    }
}
