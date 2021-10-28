package com.company;

public class ReservaHotel implements Reserva{
    Integer tipoReserva = 1;

    public ReservaHotel(int tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    @Override
    public Integer getTipoReserva() {
        return tipoReserva;
    }
}
