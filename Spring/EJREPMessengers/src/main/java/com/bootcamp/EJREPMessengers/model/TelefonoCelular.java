package com.bootcamp.EJREPMessengers.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefonoCelular extends AMensajero {

    public TelefonoCelular() {
    }

    public TelefonoCelular(String mensaje) {
        super(mensaje);
        super.setMensajeParticular("Enviando por WhatsApp");
        super.setTipoMensajero("Telefono");
    }

    @Override
    public String convertirMensaje(String mensaje) {
        if (getMensajeParticular()==null){
            setMensajeParticular("");
        }
        return this.getMensajeParticular() + " " + mensaje;
    }
}
