package com.app;

public class Vehiculo{

    private double velocidad;
    private double aceleracion;
    private double anguloGiro;
    private double peso;
    private int ruedas;
    private String patente;

    public Vehiculo(double velocidad,double aceleracion, double anguloGiro, double peso,int ruedas,String patente){
        this.velocidad = velocidad;
        this.aceleracion=aceleracion;
        this.anguloGiro=anguloGiro;
        this.peso=peso;
        this.ruedas=ruedas;
        this.patente = patente;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public double getAnguloGiro() {
        return anguloGiro;
    }

    public double getPeso() {
        return peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public String getPatente() {
        return patente;
    }

    public double evaluate(){
        return (double) (velocidad*(1/2)*aceleracion)/(anguloGiro*(peso-ruedas*100));
    }

}