package com.bootcamp.Mensajero.model;

import com.bootcamp.Mensajero.exception.MensajeroOffException;
import lombok.Getter;

@Getter
public abstract class MensajeroAbstracto implements Mensajero{
    String inicMensaje;
    String endMensaje = ">>";
    String plantilla;

    public MensajeroAbstracto(String inicMensaje) {
        this.inicMensaje = inicMensaje;
        this.plantilla = inicMensaje + "%s" + endMensaje;
    }

    @Override
    public String emitirMensaje(String msg) {
        //return "Grru Rru Gu (Me agarran a mi patita un papelito) <<"+msj+">>";
        if(!condicion()){
            throw new MensajeroOffException("Untracked off messenger");
        };
        consumo();
        return String.format(plantilla, msg);
    }

    public boolean condicion(){
        return true;
    }

    @Override
    public void consumo() {

    }
}
