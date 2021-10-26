package com.Meli.Herencia.Entity;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + getDiasPorCaducar() +
                ", nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        switch (getDiasPorCaducar()){
            case 1: return this.getPrecio()*cantidadDeProductos/4;
            case 2: return this.getPrecio()*cantidadDeProductos/3;
            case 3: return this.getPrecio()*cantidadDeProductos/2;
            default: return this.getPrecio()*cantidadDeProductos;
        }
    }


}
