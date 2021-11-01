package com.mercadolibre.Implementacion;
import com.mercadolibre.Enumeradores.Descuento;
import com.mercadolibre.Interfaz.IDescuento;


import java.util.List;

public class Localizador implements IDescuento {
    private List<Reserva>reservas;
    private int cantidadLocalizadores = 0;
    private double totalDescuentos = 0;
    private double totalAPagar;

    @Override
    public void calcularDescuento(Localizador localizador, Descuento descuento) {
        this.cantidadLocalizadores+=1;
        if(this.getCantidadLocalizadores()>=2){
            this.totalDescuentos = descuento.getPorcentajeDescuento();
        }
        //TODO crear expresion lambda que me devuelva la cantidad de productos
        //ReservaHotel
        // else if(){

        //}

    }
    public Localizador(double total) {
        this.totalAPagar = total;
    }

    public double getTotal() {
        return totalAPagar;
    }

    public void setTotal(double total) {
        this.totalAPagar = total;
    }


    public int getCantidadLocalizadores() {
        return cantidadLocalizadores;
    }

    public void setCantidadLocalizadores(int cantidadLocalizadores) {
        this.cantidadLocalizadores = cantidadLocalizadores;
    }


}

