package com.company;

public class ReservaHotel implements Reserva{
    static Integer tipoReserva = 1;

    public ReservaHotel() {
    }

    @Override
    public Integer getTipoReserva() {
        return tipoReserva;
    }

    @Override
    public String getNombreReserva() {
        return "hotel";
    }
}
