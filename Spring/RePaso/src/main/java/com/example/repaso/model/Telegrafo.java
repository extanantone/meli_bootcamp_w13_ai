package com.example.repaso.model;

public class Telegrafo extends Mensajero
{
    @Override
    public String getType()
    {
        return "Telegrafo";
    }

    public Telegrafo()
    {
        mensajero = new MensajeTelegrafo();
    }
}
