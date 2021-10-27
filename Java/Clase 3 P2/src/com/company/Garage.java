package com.company;

import java.util.ArrayList;
import java.util.List;

public class Garage  {
    String id;
    List<Vehiculo> vehiculos;

    public String getId() {
        return id;
    }

    public List<Vehiculo> getItems() {
        return vehiculos;
    }

    public Garage(String id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public void agregar(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }

    public void eliminar(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }
}
