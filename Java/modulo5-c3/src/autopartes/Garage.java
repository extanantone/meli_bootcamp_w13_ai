package autopartes;

import java.util.ArrayList;

public class Garage {
    int id;
    ArrayList<Vehiculo> vehiculos;

    public Garage(int inId) {
        this.id = inId;
        this.vehiculos = new ArrayList<>();
    }

    public Garage(int inId, ArrayList<Vehiculo> inVehiculos) {
        this.id = inId;
        this.vehiculos = inVehiculos;
    }

    public Vehiculo getVehiculo(int inIndice) {
        return this.vehiculos.get(inIndice);
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }

    public void addVehiculo(Vehiculo inVehiculo) {
        this.vehiculos.add(inVehiculo);
    }

    public void setVehiculos(ArrayList<Vehiculo> inVehiculos) {
        this.vehiculos = inVehiculos;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int inId) {
        this.id = inId;
    }
}
