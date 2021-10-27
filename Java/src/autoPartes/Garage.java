package autoPartes;

import java.util.ArrayList;

public class Garage {
    private int id;
    private ArrayList<Vehiculo> vehiculos;

    public Garage(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public Garage(int id, ArrayList<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public Vehiculo getVehiculo(int indice) {
        return this.vehiculos.get(indice);
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }

    public void addVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }
}
