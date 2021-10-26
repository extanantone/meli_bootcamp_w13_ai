package com.company;

public class NoPerecedero extends Producto{
    String tipo;

    @Override
    public String toString() {
        return "NoPerecedero >>>" +
                " Tipo : " + tipo +
                ", Nombre : " + nombre +
                ", Precio : $" + precio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }
}
