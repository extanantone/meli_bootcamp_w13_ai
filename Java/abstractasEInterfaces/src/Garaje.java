import java.util.ArrayList;
import java.util.List;

public class Garaje{
    int id;
    ArrayList<Vehiculo> vehiculos;

    public Garaje(int id, ArrayList<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }
    public Garaje(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
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

    public Vehiculo getVehiculo(int index){
        return this.vehiculos.get(index);
    }
    public void addVehiculo(Vehiculo vehiculo){
        this.vehiculos.add(vehiculo);
    }
    public void removeVehiculo(int index){
        this.vehiculos.remove(index);
    }
}
