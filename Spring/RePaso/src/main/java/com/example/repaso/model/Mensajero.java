package com.example.repaso.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Mensajero
{
    private static Long globId = 0L;
    IMensaje mensajero;

    public Mensajero()
    {
        globId++;
        id = globId;
    }

    private Long id;

    public String send(String mensaje)
    {
        return mensajero.emitirMensaje(mensaje);
    }

    public abstract String getType();
}
