package com.MELI.entity;

public class Circuito {

    private String nombre;
    private int kilometros;
    private double costoMenor;
    private double costoMayor;

    public Circuito(String nombre, int kilometros, double costoMenor, double costoMayor) {
        this.nombre = nombre;
        this.kilometros = kilometros;
        this.costoMenor = costoMenor;
        this.costoMayor = costoMayor;
    }

    public Circuito(){}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public void setCostoMenor(double costoMenor) {
        this.costoMenor = costoMenor;
    }

    public void setCostoMayor(double costoMayor) {
        this.costoMayor = costoMayor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getKilometros() {
        return kilometros;
    }

    public double getCostoMenor() {
        return costoMenor;
    }

    public double getCostoMayor() {
        return costoMayor;
    }
}
