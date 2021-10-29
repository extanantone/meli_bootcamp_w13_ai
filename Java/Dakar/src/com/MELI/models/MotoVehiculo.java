package com.MELI.models;

public class MotoVehiculo extends Vehiculo{

    public MotoVehiculo(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.ruedas = 2;
        this.peso = 300;
    }

    @Override
    public String toString() {
        return "MotoVehiculo{" +
                "peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}
