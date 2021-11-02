package com.ejerciciosIntegradores.Integrador1.Dakar;

public class Auto extends Vehiculo{

    private String patrocinador;
    private int numero;

    public Auto(int velocidad, int aceleracion, double anguloDeGiro, String patente,  String patrocinador,int numero) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
        this.patrocinador = patrocinador;
        this.numero = numero;
    }
}
