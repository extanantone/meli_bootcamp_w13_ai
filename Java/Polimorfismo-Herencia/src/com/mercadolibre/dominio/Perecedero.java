package com.mercadolibre.dominio;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(int diasPorCaducar, String nombre, double precio) {
        this.diasPorCaducar = diasPorCaducar;
        super.setNombre(nombre);
        super.setPrecio(precio);
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
    public double calcular(int cantidadDeProductos){
        double resultado = super.getPrecio() * cantidadDeProductos;
        if(diasPorCaducar==1){
            resultado/=4;
        } else if (diasPorCaducar==2){
            resultado/=3;
        } else if(diasPorCaducar==3){
            resultado/=2;
        }
        return resultado;
    }
}
