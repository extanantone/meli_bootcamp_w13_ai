package com.MELI.models;

import java.time.LocalDate;

public class Hotel extends Reserva{
    private String tipoDeHabitacion;

    public Hotel(LocalDate fechaReserva, double precio, int cantidadDePersonas, String tipoDeHabitacion) {
        super(fechaReserva, precio, cantidadDePersonas);
        this.tipoDeHabitacion = tipoDeHabitacion;
    }

    public String getTipoDeHabitacion() {
        return tipoDeHabitacion;
    }

    public void setTipoDeHabitacion(String tipoDeHabitacion) {
        this.tipoDeHabitacion = tipoDeHabitacion;
    }
}
