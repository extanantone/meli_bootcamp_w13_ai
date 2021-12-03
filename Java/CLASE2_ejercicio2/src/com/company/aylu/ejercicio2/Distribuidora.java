package com.company.aylu.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    List<Producto> listaDeProductos;
    public Distribuidora(List<Producto> listaDeProductos) {
        this.listaDeProductos = new ArrayList<>();
    }

    public List<Producto> getListaDeProductos() {
        return listaDeProductos;
    }

    public void setListaDeProductos(List<Producto> listaDeProductos) {
        this.listaDeProductos = listaDeProductos;
    }

    @Override
    public String toString() {
        return "Distribuidora{" +
                "listaDeProductos=" + listaDeProductos +
                '}';
    }
}
