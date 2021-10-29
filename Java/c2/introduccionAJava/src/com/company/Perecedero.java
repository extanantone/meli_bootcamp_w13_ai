package com.company;

public class Perecedero extends Producto {

    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal = this.precio * cantidadDeProductos;
        if (this.diasPorCaducar == 1) {
            precioFinal = precioFinal / 4;
        } else if (this.diasPorCaducar == 2) {
            precioFinal = precioFinal /3;
        } else if (this.diasPorCaducar == 3) {
            precioFinal = precioFinal / 2;
        }
        return precioFinal;
    }
}
