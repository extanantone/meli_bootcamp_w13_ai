package com.example.repaso.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Mensaje
{
    IMensaje mensajero;

    public String send(String mensaje)
    {
        return mensajero.emitirMensaje(mensaje);
    }
}
