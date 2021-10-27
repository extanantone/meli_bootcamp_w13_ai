import java.util.ArrayList;

public class Garaje {
    private int id;
    private ArrayList<Vehiculo> vehiculos=new ArrayList<>();

    public Garaje(int id) {
        this.id = id;
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

    public void agregar(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }
}
