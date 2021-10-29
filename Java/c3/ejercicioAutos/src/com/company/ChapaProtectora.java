package com.company;

public class ChapaProtectora implements Vehiculo{
    protected Vehiculo vehiculo;

    public ChapaProtectora(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public double getPrecio() {
        return vehiculo.getPrecio() + 15.0;
    }

    @Override
    public String getAccesorios() {
        return vehiculo.getAccesorios() + " Chapa protectora";
    }
}
