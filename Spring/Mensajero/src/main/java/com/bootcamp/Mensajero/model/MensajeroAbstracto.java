package com.bootcamp.Mensajero.model;

import lombok.Getter;

@Getter

public abstract class MensajeroAbstracto implements Mensajero{
    String inicMensaje;
    String endMensaje = ">>";
    String plantilla;

    public MensajeroAbstracto(String inicMensaje) {
        this.inicMensaje = inicMensaje;
        this.plantilla = inicMensaje + "%s" + this.endMensaje;
    }

    @Override
    public String emitirMensaje(String msg) {
        //return "Grru Rru Gu (Me agarran a mi patita un papelito) <<"+msj+">>";
        return String.format(plantilla, msg);
    }
}
