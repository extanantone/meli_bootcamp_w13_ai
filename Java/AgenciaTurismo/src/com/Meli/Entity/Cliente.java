package com.Meli.Entity;

public class Cliente {
    private String nombre;
    private String apellido;
    private float descuento;

    public Cliente(String nombre, String apellido, Repositorio<Cliente> repositorio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descuento = 0f;
        repositorio.add(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
