package com.company.shop;

public class Perecedero extends Producto{
    int diasXCaducar;

    public Perecedero(String nombre, double precio, int diasXCaducar) {
        super(nombre, precio);
        this.diasXCaducar = diasXCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasXCaducar=" + diasXCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public int getDiasXCaducar() {
        return diasXCaducar;
    }

    public void setDiasXCaducar(int diasXCaducar) {
        this.diasXCaducar = diasXCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        if(this.diasXCaducar==1)
            return this.precio*cantidadDeProductos/4;
        else if(this.diasXCaducar==2)
            return this.precio*cantidadDeProductos/3;
        else if(this.diasXCaducar==3)
            return this.precio*cantidadDeProductos/2;
        else
            return this.precio*cantidadDeProductos;
    }
}
