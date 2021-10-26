package com.company;

public class Perecederos extends Producto{
    int diasPorCaducar;

    public Perecederos(String nombre, double precio,int diasPorCaducar) {
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
        return "Perecederos{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadProductos){
        double precio =(this.precio*cantidadProductos);
        double precioFinal=0.00;
        switch (this.diasPorCaducar){
            case 1:
                precioFinal = precio/4;
            case 2:
                precioFinal = precio/3;
            case 3:
                precioFinal = precio/2;
            default:
                precioFinal = precio;
        }

        return precioFinal;

    }
}
