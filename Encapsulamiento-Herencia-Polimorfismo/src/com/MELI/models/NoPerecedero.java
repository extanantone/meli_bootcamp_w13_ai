package com.MELI.models;

public class NoPerecedero extends Producto {
    private String tipo;

    public NoPerecedero(String tipo, String nombre, double precio) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public double calcular(int cantDeProductos){
        return super.getPrecio() * cantDeProductos;
    }
}
