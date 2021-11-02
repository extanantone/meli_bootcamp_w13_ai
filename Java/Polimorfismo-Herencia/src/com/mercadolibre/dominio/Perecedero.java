package com.mercadolibre.dominio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

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
        return " es un producto Perecedero " +
                " - Fecha Vencimiento: " + this.fVencimiento(this.diasPorCaducar);
    }
    @Override
    public double calcular(int cantidadDeProductos){
        double resultado = super.calcular(cantidadDeProductos);
        if(diasPorCaducar==1){
            resultado/=4;
        } else if (diasPorCaducar==2){
            resultado/=3;
        } else if(diasPorCaducar==3){
            resultado/=2;
        }
        return resultado;
    }

    public Date fVencimiento(int diasPorCaducar){
        Date fecha = new Date();
        return new Date(fecha.getTime() + diasPorCaducar);
    }
}
