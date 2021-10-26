package com.pooP2;

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
    public void calcular(int cantidadDeProductos) {

        if(this.diasPorCaducar ==1){
           this.setPrecio((getPrecio() * cantidadDeProductos)/4);
        }else if(this.diasPorCaducar ==2){
            this.setPrecio((getPrecio() * cantidadDeProductos)/3);
        }else if(this.diasPorCaducar==3){
            this.setPrecio((getPrecio() * cantidadDeProductos)/2);
        }else{
            this.setPrecio((getPrecio() * cantidadDeProductos));
        }


    }

    @Override
    public String toString() {
        return "Producto " +
                "Nombre="+getNombre() +
                "Precio="+getPrecio() +
                "Dias Por Caducar=" + diasPorCaducar +
                '}';
    }
}
