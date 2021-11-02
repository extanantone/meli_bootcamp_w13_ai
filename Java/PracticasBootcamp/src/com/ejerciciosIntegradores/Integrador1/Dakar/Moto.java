package com.ejerciciosIntegradores.Integrador1.Dakar;

public class Moto extends Vehiculo {

    private int numero;

    public Moto(int velocidad, int aceleracion, double anguloDeGiro, String patente, int numero) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 300, 2);
        this.numero = numero;
    }




}
