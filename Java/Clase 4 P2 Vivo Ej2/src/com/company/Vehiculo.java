package com.company;

public abstract class Vehiculo {
    double velocidad;
    double aceleracion;
    double anguloDeGiro;
    String patente;
    double peso;
    int ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public double formulaGanadora(){
        return velocidad * 0.5 * (aceleracion / (anguloDeGiro * (peso - ruedas * 100)));
    }

    public abstract String soyUn();
}
