package com.bootcamp.Mensajero.model;

public abstract class MensajeroAbstracto implements Mensajero{
    String inicMensaje;
    String endMensaje = ">>";
    String plantilla =  inicMensaje + "%s" + endMensaje;

    public MensajeroAbstracto(String inicMensaje) {
        this.inicMensaje = inicMensaje;
    }

    @Override
    public String emitirMensaje(String msg) {
        //return "Grru Rru Gu (Me agarran a mi patita un papelito) <<"+msj+">>";
        return String.format(plantilla, msg);
    }
}
