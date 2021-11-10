package com.bootcamp.Mensajero.model;

import com.bootcamp.Mensajero.exception.MensajeroOffException;

public class Telegrafo implements Mensajero {

    boolean enchufado = false;

    String convertirAMorse(String msg) {
        return "Piripi";
    }

    @Override
    public String emitirMensaje(String msg) {
        return convertirAMorse(msg);
    }

    @Override
    public String getPlantilla() {
        return convertirAMorse("");
    }

    @Override
    public boolean condicion() {
        if(!enchufado){
            throw new MensajeroOffException("Telégrafo desenchufado");
        }
        return true;
    }

    @Override
    public void consumo() {

    }
}
