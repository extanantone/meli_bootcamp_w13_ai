package com.MELI.models;

public class AutoVehiculo extends Vehiculo{


    public AutoVehiculo(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.ruedas = 4;
        this.peso = 1000;
    }

    @Override
    public String toString() {
        return "AutoVehiculo{" +
                "peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}
