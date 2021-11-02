package com.ejerciciosIntegradores.Integrador1.modelAgenciaTurismo;

import com.ejerciciosIntegradores.Integrador1.Interfaces.IReserva;

public class Comida implements IReserva {

    protected double precio;
    protected IReserva reserva;

    public Comida(double precio, IReserva reserva) {
        this.precio = precio;
        this.reserva = reserva;
    }

    @Override
    public double getPrecio() {
        return reserva.getPrecio() + this.precio;

    }

    @Override
    public String getDetalle() {
        return reserva.getDetalle()+", Tiene Comida incluida";
    }

    @Override
    public String getCompra() {
        return reserva.getCompra() +",Comida";
    }

}
