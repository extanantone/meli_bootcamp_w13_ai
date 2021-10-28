package com.company;

public class Reserva {
    double precio;
    TipoReserva tipoReserva;

    public Reserva(double precio, TipoReserva tipoReserva) {
        this.precio = precio;
        this.tipoReserva = tipoReserva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "precio=" + precio +
                ", tipoReserva=" + tipoReserva.toString() +
                '}';
    }
}
