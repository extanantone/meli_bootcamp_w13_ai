package com.bootcamp.Mensajero.model;

import lombok.Getter;

@Getter

public abstract class MensajeroAbstracto implements Mensajero{
    String tipo;
    String inicMensaje;
    String endMensaje = ">>";
    String plantilla;

    public MensajeroAbstracto(String inicMensaje, String tipo) {
        this.tipo = tipo;
        this.inicMensaje = inicMensaje;
        this.plantilla = inicMensaje + "%s" + this.endMensaje;
    }

    @Override
    public String emitirMensaje(String msg) {
        return String.format(plantilla, msg);
    }
}
