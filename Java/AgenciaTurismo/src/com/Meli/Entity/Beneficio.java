package com.Meli.Entity;

public abstract class Beneficio {
    double costo;
    int cantidad;

    public Beneficio(double costo, int cantidad) {
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double totalBeneficio() {
        return costo*cantidad;
    }
}
