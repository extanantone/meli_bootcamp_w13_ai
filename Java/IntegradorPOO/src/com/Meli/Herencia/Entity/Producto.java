package com.Meli.Herencia.Entity;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(){
        nombre= "";
        precio = 0;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public double calcular(int cantidadDeProductos){
        return this.precio*cantidadDeProductos;
    }

    @Override
    public String toString(){
        return "Producto {Nombre: "+getNombre()+",\n"+"Precio: "+getPrecio()+"}";
    }
}
