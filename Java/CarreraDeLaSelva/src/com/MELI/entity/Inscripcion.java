package com.MELI.entity;

public class Inscripcion {
    private int nroInscripcion;
    private Persona persona;
    private Circuito circuito;
    private double costo;

    public Inscripcion(int nroInscripcion, Persona persona, Circuito circuito, double costo) {
        this.nroInscripcion = nroInscripcion;
        this.persona = persona;
        this.circuito = circuito;
        this.costo = costo;
    }

    public void setNroInscripcion(int nroInscripcion) {
        this.nroInscripcion = nroInscripcion;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getNroInscripcion() {
        return nroInscripcion;
    }

    public Persona getPersona() {
        return persona;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public double getCosto() {
        return costo;
    }
}
