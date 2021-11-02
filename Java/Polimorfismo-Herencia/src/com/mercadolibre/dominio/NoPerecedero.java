package com.mercadolibre.dominio;

public class NoPerecedero extends Producto {
    private String tipo;

    public NoPerecedero(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return " es un producto " + tipo + '\'';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        return super.calcular(cantidadDeProductos);
    }
}
