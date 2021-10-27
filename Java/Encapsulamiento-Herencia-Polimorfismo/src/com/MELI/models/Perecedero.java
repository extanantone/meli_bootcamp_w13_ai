package com.MELI.models;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(int diasPorCaducar, String nombre, double precio) {
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
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantDeProductos){
        double resultado =  super.getPrecio() * cantDeProductos;
        if(diasPorCaducar == 1) {
            resultado /=4;
        }
        else if(diasPorCaducar == 2){
            resultado /=3;
        } else if (diasPorCaducar == 3){
            resultado/=2;
        }
        return resultado;
    }
}
