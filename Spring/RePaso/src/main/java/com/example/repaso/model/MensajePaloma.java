package com.example.repaso.model;

public class MensajePaloma implements IMensaje
{
    @Override
    public String emitirMensaje(String mensaje)
    {
        return (String.format("Grru Rru Gu (Me agarran a mi patita un papelito) <<%s>>", mensaje));
    }

}
