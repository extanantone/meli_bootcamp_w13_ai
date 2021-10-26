package com.app;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar){
        super(nombre,precio);
        this.diasPorCaducar=diasPorCaducar;
    }

    public int getDiasPorCaducar(){
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar){
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{\nNombre="+getNombre()+"\nPrecio="+getPrecio()+"\nDiasPorCaducar="+diasPorCaducar+"\n}";
    }
    
    @Override
    public double calcular(int cantidadProducto) {
        // TODO Auto-generated method stub
        double precio=  super.calcular(cantidadProducto);
        if(diasPorCaducar==1) return precio/4;
        if(diasPorCaducar==2) return precio/3;
        if(diasPorCaducar==3) return precio/2;
        return precio;
    }
}
