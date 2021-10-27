package com.company;

import java.util.ArrayList;

public class Garaje {
    private int id=0;
    ArrayList<Vehiculo> vehiculo=new ArrayList<>();

    public Garaje(int id, ArrayList<Vehiculo> vehiculo) {
        this.id = id;
        this.vehiculo = vehiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(ArrayList<Vehiculo> vehiculo) {
        this.vehiculo = vehiculo;
    }
}
