package com.c3abstractEinterfac;

public class NaveSimple implements Icordenadas{

    private String nombre;
    private int coordenadaX;
    private int coordenadaY;
    private  int puntuacion;

    public NaveSimple(String nombre, int coordenadaX, int coordenadaY, int puntuacion) {
        this.nombre = nombre;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.puntuacion = puntuacion;
    }

    @Override
    public Integer puntos() {
        return null;
    }

    @Override
    public String nombre() {
        return this.nombre;
    }

    public void setPuntuacion(int puntos){
        this.puntuacion += puntos;
    }

    @Override
    public void print() {
        System.out.println("Nave Simple: "+this.nombre);
    }
}
