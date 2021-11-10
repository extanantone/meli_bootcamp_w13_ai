package com.bootcamp.EJREPMessengers.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefonoCelular extends AMensajero {

    int bateria = 0;
    int cantDatos = 0;

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
        }else{
        if(bateria > 1 && cantDatos > 1){
            return "descansando";
        }
        this.bateria--;
        this.cantDatos--;
        }
        return this.getMensajeParticular() + " " + mensaje;
    }
}
