package com.company;

public class ReservaComida implements Reserva{
    static int tipoReserva = 3;

    public ReservaComida() {
    }

    @Override
    public Integer getTipoReserva() {
        return tipoReserva;
    }

    @Override
    public String getNombreReserva() {
        return "comida";
    }
}
