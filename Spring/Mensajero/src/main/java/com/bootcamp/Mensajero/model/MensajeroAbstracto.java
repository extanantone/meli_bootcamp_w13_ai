package com.bootcamp.Mensajero.model;

public abstract class MensajeroAbstracto implements Mensajero{
    String inicMensaje;
    String endMensaje = ">>";
    String plantilla;

    public MensajeroAbstracto(String inicMensaje) {
        this.inicMensaje = inicMensaje;
        this.plantilla =  this.inicMensaje + "%s" + this.endMensaje;
    }

    @Override
    public String emitirMensaje(String msg) {
        return String.format(plantilla, msg);
    }
}
