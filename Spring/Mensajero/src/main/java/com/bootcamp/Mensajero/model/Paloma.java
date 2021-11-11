package com.bootcamp.Mensajero.model;

public class Paloma extends MensajeroAbstracto{

    public Paloma() {
        super("Grru Rru Gu (Me agarran a mi patita un papelito) <<");
    }

    @Override
    public String getTipo() {
        return "Paloma";
    }
}
