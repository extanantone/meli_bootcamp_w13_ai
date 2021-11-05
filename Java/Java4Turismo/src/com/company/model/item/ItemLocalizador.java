package com.company.model.item;

public interface ItemLocalizador {
    enum Type {reserva, comida, boleto, transporte};
    Type getType();
    double getPrecio();
}
