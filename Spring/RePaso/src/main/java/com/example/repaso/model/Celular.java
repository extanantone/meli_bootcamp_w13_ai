package com.example.repaso.model;

public class Celular extends Mensajero
{
    @Override
    public String getType()
    {
        return "Celular";
    }

    public Celular()
    {
        mensajero = new MensajeCelular();
    }
}
