package com.MELI.models;

import java.time.LocalDate;

public class PaqueteTuristico extends Reserva{
    private Hotel hotel;
    private Comida comida;
    private BoletoDeViaje boletoDeViaje;
    private Transporte transporte;


    public PaqueteTuristico(LocalDate fechaReserva, int cantidadDePersonas, Hotel hotel, Comida comida, BoletoDeViaje boletoDeViaje, Transporte transporte) {
        super(fechaReserva, cantidadDePersonas);
        this.transporte = transporte;
        this.boletoDeViaje = boletoDeViaje;
        this.comida = comida;
        this.hotel = hotel;
        this.precio = calcularValorTotal();
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public BoletoDeViaje getBoletoDeViaje() {
        return boletoDeViaje;
    }

    public void setBoletoDeViaje(BoletoDeViaje boletoDeViaje) {
        this.boletoDeViaje = boletoDeViaje;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public double calcularValorTotal() {
        return this.hotel.getPrecio() + this.comida.getPrecio() + this.boletoDeViaje.getPrecio() + this.transporte.getPrecio();
    }
}
