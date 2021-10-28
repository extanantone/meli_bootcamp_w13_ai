package com.company;

public class ReservaComida implements Reserva{
    int tipoReserva = 3;

    public ReservaComida(int tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    @Override
    public Integer getTipoReserva() {
        return tipoReserva;
    }
}
