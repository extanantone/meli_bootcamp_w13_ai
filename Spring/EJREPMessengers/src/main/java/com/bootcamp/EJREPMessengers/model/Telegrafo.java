package com.bootcamp.EJREPMessengers.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Telegrafo extends AMensajero {

    boolean enchufado = true;

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
        }else {
            if (enchufado) {
                return "descansando";
            }
        }
        return this.getMensajeParticular() + " " + mensaje;
    }
}
