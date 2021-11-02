package com.ejerciciosIntegradores.Integrador1.modelAgenciaTurismo;

import com.ejerciciosIntegradores.Integrador1.Interfaces.IReserva;

import java.util.List;

public class BoletoViaje implements IReserva {

    protected Double precio;
    private String destino;
    private String origen;
    private double precioTotal;
    protected IReserva reserva;

    public BoletoViaje(double precio, String destino, String origen, IReserva paquetable) {
        this.precio = precio;
        this.destino = destino;
        this.origen = origen;
        this.reserva = paquetable;
        this.precioTotal= precio;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }



    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public IReserva getReserva() {
        return reserva;
    }

    public void setReserva(IReserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public double getPrecio() {
        return reserva.getPrecio() + this.precio;
    }

    @Override
    public String getDetalle() {
        return reserva.getDetalle()+", Su Boleto tiene origen "+origen+" con destino "+destino;
    }
    @Override
    public String getCompra() {
        return  reserva.getCompra() +",Boleto";
    }
}
