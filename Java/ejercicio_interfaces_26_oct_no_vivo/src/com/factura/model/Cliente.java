package com.factura.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private List<Factura> facturas;
    private String nombre;
    private int dni;

    public Cliente(String nombre,int dni){
        facturas = new ArrayList<>();
        this.nombre = nombre;
        this.dni=dni;
    }

    public void addFactura(Factura factura){
        facturas.add(factura);
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    @Override
    public String toString() {
        return "\nCliente{\nnombre:"+nombre+",\nfacturas:"+facturas.toString()+",\n}\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Cliente)) return false;
        return dni==((Cliente) obj).getDni();
    }
}
