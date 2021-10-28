package com.dakar;

public class Moto extends Vehiculo {
    // es una variable constante que no puede ser modificada (final)
    public static final Double PESO_MOTO = 300.0;
    public static final Integer CANTIDAD_RUEDAS_MOTO = 2;


    public Moto(Double unaVelocidad, Double unaAceleracion, Double unAnguloDeGiro, String unaPatente) {
        super(unaVelocidad, unaAceleracion, unAnguloDeGiro, unaPatente, PESO_MOTO, CANTIDAD_RUEDAS_MOTO);
    }


    @Override
    public String toString() {
        return "Moto: " + super.toString();
    }
}
