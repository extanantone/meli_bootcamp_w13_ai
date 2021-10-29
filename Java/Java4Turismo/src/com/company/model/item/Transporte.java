package com.company.model.item;

public class Transporte  implements ItemLocalizador {
    @Override
    public Type getType() {
        return Type.transporte;
    }

    @Override
    public double getPrecio() {
        return 10;
    }
}
