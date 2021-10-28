package com.company;

public class ReservaBoletos implements Reserva{
    static int tipoReserva = 2;

    public ReservaBoletos() {
    }

    @Override
    public Integer getTipoReserva() {
        return tipoReserva;
    }

    @Override
    public String getNombreReserva() {
        return "boletos";
    }
}
