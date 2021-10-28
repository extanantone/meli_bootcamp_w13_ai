package com.company;

public class ReservaBoletos implements Reserva{
    int tipoReserva = 2;

    public ReservaBoletos(int tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    @Override
    public Integer getTipoReserva() {
        return tipoReserva;
    }
}
