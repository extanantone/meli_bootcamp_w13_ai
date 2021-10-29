package com.company;

public class ManillasCromadas implements Vehiculo{
    protected Vehiculo vehiculo;

    public ManillasCromadas(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public double getPrecio() {
        return vehiculo.getPrecio() + 12.5;
    }

    @Override
    public String getAccesorios() {
        return vehiculo.getAccesorios() + " Manillas cromadas";
    }
}
