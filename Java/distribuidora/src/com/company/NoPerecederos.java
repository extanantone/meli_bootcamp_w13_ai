package com.company;

public class NoPerecederos extends Producto{
    String tipo;

    public NoPerecederos(String nombre, double precio,String tipo) {
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
    public String toString() {
        return "NoPerecederos{" +
                "tipo='" + tipo + '\'' +
                '}';
    }

    @Override
    public double calcular(int cantidadProductos){
        return (double)(this.precio*cantidadProductos);
    }
}
