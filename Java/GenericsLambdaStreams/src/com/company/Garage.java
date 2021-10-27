package com.company;

import java.util.List;

public class Garage {
    int id;
    List<Vehículo> listaDeVehículos;

    public Garage(int id, List<Vehículo> listaDeVehículos) {
        this.id = id;
        this.listaDeVehículos = listaDeVehículos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehículo> getListaDeVehículos() {
        return listaDeVehículos;
    }

    public void setListaDeVehículos(List<Vehículo> listaDeVehículos) {
        this.listaDeVehículos = listaDeVehículos;
    }
}
