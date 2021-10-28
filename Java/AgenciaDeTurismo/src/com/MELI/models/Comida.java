package com.MELI.models;

import java.time.LocalDate;

public class Comida extends Reserva{
    private String localDeComida;

    public Comida(LocalDate fechaReserva, double precio, int cantidadDePersonas, String localDeComida) {
        super(fechaReserva, precio, cantidadDePersonas);
        this.localDeComida = localDeComida;
    }

    public String getLocalDeComida() {
        return localDeComida;
    }

    public void setLocalDeComida(String localDeComida) {
        this.localDeComida = localDeComida;
    }
}
