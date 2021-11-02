package com.ejerciciosIntegradores.Integrador1.modelAgenciaTurismo;

import com.ejerciciosIntegradores.Integrador1.Interfaces.IReserva;

public class ReservaHotel implements  IReserva{

    private double precio;
    private String hotel;
    private IReserva reserva;
    public ReservaHotel(double precio, String hotel,IReserva iReserva) {
        this.precio = precio;
        this.hotel = hotel;
        this.reserva = iReserva;
    }
    @Override
    public double getPrecio() {
        return reserva.getPrecio()+ precio;
    }

    @Override
    public String getDetalle() {
        return reserva.getDetalle()+ ", Tiene reserva en "+hotel;
    }

    @Override
    public String getCompra() {
        return  reserva.getCompra() +",Hotel";
    }


    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public IReserva getReserva() {
        return reserva;
    }

    public void setReserva(IReserva reserva) {
        this.reserva = reserva;
    }


}
