package com.company.model.item;

public class Boleto implements ItemLocalizador {
    @Override
    public Type getType() {
        return Type.boleto;
    }

    @Override
    public double getPrecio() {
        return 100;
    }
}
