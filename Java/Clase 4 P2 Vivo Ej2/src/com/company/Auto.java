package com.company;

public class Auto extends Vehiculo{
    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }

    @Override
    public String soyUn() {
        return "Auto";
    }
}
