package com.company;

public class VehiculoBase implements Vehiculo{
    private double precio;
    private String modelo;
    private String accesorios;

    public VehiculoBase(double precio, String modelo, String accesorios) {
        this.precio = precio;
        this.modelo = modelo;
        this.accesorios = accesorios;
    }

    @Override
    public double getPrecio() {
        return this.precio;
    }

    @Override
    public String getAccesorios() {
        return this.accesorios;
    }
}
