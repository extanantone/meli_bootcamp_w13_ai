package com.bootcamp.Mensajero.model;

import com.bootcamp.Mensajero.exception.MensajeroOffException;

public class Celular extends MensajeroAbstracto{
    int bateria = 0;
    int datos = 0;
    public Celular() {
        super("Enviando por WhatsApp <<");
    }

    @Override
    public boolean condicion() {
        if(bateria < 1){
            throw new MensajeroOffException("Celular descargado");
        }
        if(datos < 1){
            throw new MensajeroOffException("Celular sin datos");
        }
        return true;
    }

    @Override
    public void consumo() {
        bateria -= 1;
        datos -= 1;
    }
}
