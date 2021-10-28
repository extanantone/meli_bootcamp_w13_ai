package com.company;

public class ReservaTransporte implements Reserva{
    int tipoReserva = 4;

    public ReservaTransporte(int tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    @Override
    public Integer getTipoReserva() {
        return tipoReserva;
    }
}
