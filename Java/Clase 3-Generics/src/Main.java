import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        Vehiculo v1 = new Vehiculo("Fiesta", "ford", 1000);
        Vehiculo v2 = new Vehiculo("Focus", "ford", 1200);
        Vehiculo v3 = new Vehiculo("Explorer", "ford", 2500);
        Vehiculo v4 = new Vehiculo("Uno", "fiat", 500);
        Vehiculo v5 = new Vehiculo("Cronos", "fiat", 1000);
        Vehiculo v6 = new Vehiculo("Torino", "fiat", 1500);

        vehiculos.add(v1);
        vehiculos.add(v2);
        vehiculos.add(v3);
        vehiculos.add(v4);
        vehiculos.add(v5);
        vehiculos.add(v6);

        Garage garage = new Garage(1,vehiculos);
        System.out.println(garage.getGarage());

    }
}

