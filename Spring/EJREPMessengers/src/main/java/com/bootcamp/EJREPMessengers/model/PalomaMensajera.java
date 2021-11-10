package com.bootcamp.EJREPMessengers.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PalomaMensajera extends AMensajero {

    public PalomaMensajera() {
    }

    public PalomaMensajera(String mensaje) {
        super(mensaje);
        super.setMensajeParticular("Grru Rru Gu (Me agarran a mi patita un papelito)");
        super.setTipoMensajero("Paloma");
    }

    @Override
    public String convertirMensaje(String mensaje) {
        if (getMensajeParticular()==null){
            setMensajeParticular("");
        }
        return this.getMensajeParticular() + " " + "<<" + mensaje+">>";
    }
}
