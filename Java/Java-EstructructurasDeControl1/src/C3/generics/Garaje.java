package C3.generics;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private String id;

    List<Vehiculo> vehiculos = new ArrayList<>();

    public Garaje(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
