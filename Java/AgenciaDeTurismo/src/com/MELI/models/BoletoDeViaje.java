package com.MELI.models;

import java.time.LocalDate;

public class BoletoDeViaje extends Reserva{
    private String compania;
    private String lugarDestino;
    private String lugarOrigen;

    public BoletoDeViaje(LocalDate fechaReserva, double precio, int cantidadDePersonas, String compania, String lugarDestino, String lugarOrigen) {
        super(fechaReserva, precio, cantidadDePersonas);
        this.compania = compania;
        this.lugarDestino = lugarDestino;
        this.lugarOrigen = lugarOrigen;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getLugarDestino() {
        return lugarDestino;
    }

    public void setLugarDestino(String lugarDestino) {
        this.lugarDestino = lugarDestino;
    }

    public String getLugarOrigen() {
        return lugarOrigen;
    }

    public void setLugarOrigen(String lugarOrigen) {
        this.lugarOrigen = lugarOrigen;
    }
}
