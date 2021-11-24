package com.example.repaso.model;

public class Paloma extends Mensajero
{
    @Override
    public String getType()
    {
        return "Paloma";
    }

    public Paloma()
    {
        mensajero = new MensajePaloma();
    }
}
