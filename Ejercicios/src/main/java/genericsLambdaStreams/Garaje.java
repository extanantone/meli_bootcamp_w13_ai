package genericsLambdaStreams;

import java.util.ArrayList;

public class Garaje {
    private int id;

    ArrayList<Vehiculo> vehiculo = new ArrayList<>();

    public ArrayList<Vehiculo> getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(ArrayList<Vehiculo> vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Garaje(int id, ArrayList<Vehiculo> vehiculo) {
        this.id = id;
        this.vehiculo = vehiculo;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Garaje{" +
                "id=" + id +
                ", vehiculo=" + vehiculo +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }
}
