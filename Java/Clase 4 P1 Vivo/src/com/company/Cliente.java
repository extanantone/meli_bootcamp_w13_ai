package com.company;

public class Cliente {
    String nombre;
    Long dni;

    public Cliente(String nombre, Long dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", dni=" + dni +
                '}';
    }
}
