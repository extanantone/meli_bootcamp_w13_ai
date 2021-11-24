package com.example.repaso.model;

public class MensajeCelular implements IMensaje
{
    @Override
    public String emitirMensaje(String mensaje)
    {
        return (String.format("Enviando por WhatsApp <<%s>>", mensaje));
    }
}
