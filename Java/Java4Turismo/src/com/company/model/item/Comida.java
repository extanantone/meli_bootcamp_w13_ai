package com.company.model.item;

public class Comida implements ItemLocalizador {
    @Override
    public Type getType() {
        return Type.comida;
    }
    @Override
    public double getPrecio() {
        return 1;
    }
}
