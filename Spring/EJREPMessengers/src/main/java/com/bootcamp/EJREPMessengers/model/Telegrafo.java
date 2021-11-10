package com.bootcamp.EJREPMessengers.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Telegrafo extends AMensajero {
    public Telegrafo() {
    }

    public Telegrafo(String mensaje) {
        super(mensaje);
        super.setMensajeParticular("Pip piripipip pip pip");
        super.setTipoMensajero("Telegrafo");
    }

    @Override
    public String convertirMensaje(String mensaje) {
        if (getMensajeParticular()==null){
            setMensajeParticular("");
        }
        return this.getMensajeParticular() + " " + mensaje;
    }
}
