package Java_III_b;

import java.util.ArrayList;


public class Garage {
    int id;
    ArrayList<Vehiculo> listaVehiculos;

    public Garage(int id) {
        this.id = id;
    }

    public Garage(int id, ArrayList<Vehiculo> listaVehiculos) {
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}
