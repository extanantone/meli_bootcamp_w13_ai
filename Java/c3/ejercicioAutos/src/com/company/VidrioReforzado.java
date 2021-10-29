package com.company;

public class VidrioReforzado implements Vehiculo{
    protected Vehiculo vehiculo;

    public VidrioReforzado(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public double getPrecio() {
        return vehiculo.getPrecio() + 20.0;
    }

    @Override
    public String getAccesorios() {
        return vehiculo.getAccesorios() + " Vidrios reforzados";
    }
}
