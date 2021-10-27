package com.company;

public class Perecedero extends Producto{
    int diasPorCaducar;

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double precioFinal = cantidadDeProductos * this.precio;
        if (this.diasPorCaducar == 1) {
            precioFinal /= 4;
        } else if (this.diasPorCaducar == 2) {
            precioFinal /= 3;
        } else if (this.diasPorCaducar == 3) {
            precioFinal /= 2;
        }
        return precioFinal;
    }
}
