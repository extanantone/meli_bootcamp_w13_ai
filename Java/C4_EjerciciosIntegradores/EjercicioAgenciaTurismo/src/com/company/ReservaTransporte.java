package com.company;

public class ReservaTransporte implements Reserva{
    static int  tipoReserva = 4;

    public ReservaTransporte() {
    }

    @Override
    public Integer getTipoReserva() {
        return tipoReserva;
    }

    @Override
    public String getNombreReserva() {
        return "transporte";
    }
}
