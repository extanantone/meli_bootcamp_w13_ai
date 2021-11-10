package com.bootcamp.EJREPMessengers.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AMensajero implements IMensajero{
    private String mensaje;
    private String mensajeParticular;
    private String tipoMensajero;

    public AMensajero() {
    }

    public AMensajero(String mensaje) {
        this.setMensaje(convertirMensaje(mensaje));
    }

    public abstract String convertirMensaje(String mensaje);
}
