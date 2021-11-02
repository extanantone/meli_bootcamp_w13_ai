package com.ejerciciosIntegradores.Integrador1.modelAgenciaTurismo;

public class Viajero {

    private String nombre;
    private long dni;

    public Viajero(String nombre, long dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }
}
