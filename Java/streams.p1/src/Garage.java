import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Garage {
    private int id;
    private ArrayList<Vehiculo> vehiculos;

    public Garage(int id, ArrayList<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public void ordenarVehiculos() {
        Comparator<Vehiculo> comparadorMultiple= Comparator
                .comparing(Vehiculo::getCosto)
                .thenComparing(Vehiculo::getMarca);
        this.vehiculos.stream().sorted(comparadorMultiple).forEach(System.out::println);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
