package com.bootcamp.Mensajero.model;

public class Telégrafo extends MensajeroAbstracto{

    public Telégrafo() {
        super("Pip piripipip pip pip <<");
    }

    @Override
    public String getTipo() {
        return "Telégrafo";
    }
}
