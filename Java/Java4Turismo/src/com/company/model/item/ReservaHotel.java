package com.company.model.item;

public class ReservaHotel implements ItemLocalizador {
    @Override
    public Type getType() {
        return Type.reserva;
    }


    public double getPrecio() {
        return 1000;
    }
}
