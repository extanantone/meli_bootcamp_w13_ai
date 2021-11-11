package com.bootcamp.Mensajero.model;

public abstract class MensajeroAbstracto implements Mensajero{
    String inicMensaje;
    String endMensaje = ">>";
    String plantilla;// =  inicMensaje + "%s" + endMensaje;
    String tipo;

    public MensajeroAbstracto(String tipo, String inicMensaje) {
        this.tipo = tipo;
        this.inicMensaje = inicMensaje;
        this.plantilla =  this.inicMensaje + "%s" + endMensaje;
    }

    @Override
    public String emitirMensaje(String msg) {
        //return "Grru Rru Gu (Me agarran a mi patita un papelito) <<"+msj+">>";
        return String.format(plantilla, msg);
    }

    @Override
    public String getType() {
        return this.tipo;
    }
}
