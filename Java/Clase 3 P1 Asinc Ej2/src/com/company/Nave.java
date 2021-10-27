package com.company;

public class Nave implements Rastreable {
    double coordenadaX;
    double coordenadaY;
    String nombre;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Nave(double coordenadaX, double coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    @Override
    public double CalcularCercania(double x, double y) {
        return Math.sqrt(Math.pow(x - coordenadaX, 2) + Math.pow(y - coordenadaY, 2));
    }
}
