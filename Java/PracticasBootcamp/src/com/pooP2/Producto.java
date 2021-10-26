package com.pooP2;

public class Producto {

    private String nombre;
    private double precio;

    public String getNombre() {
        return nombre;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto " +
                "Nombre='" + nombre + '\'' +
                ", Precio=" + precio +
                '}';
    }

    public void calcular(int cantidadDeProductos){

       this.precio = this.precio * cantidadDeProductos;
    }
}
