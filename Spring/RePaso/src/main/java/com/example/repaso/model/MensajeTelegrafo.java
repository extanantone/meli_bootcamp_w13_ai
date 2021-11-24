package com.example.repaso.model;

public class MensajeTelegrafo implements IMensaje
{
    @Override
    public String emitirMensaje(String mensaje)
    {
        return (String.format("Pip piripipip pip pip <<%s>>", mensaje));
    }
}
