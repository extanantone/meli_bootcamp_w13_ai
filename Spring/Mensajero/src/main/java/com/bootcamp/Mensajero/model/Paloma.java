package com.bootcamp.Mensajero.model;

import com.bootcamp.Mensajero.exception.MensajeroOffException;
import lombok.Getter;

@Getter
public class Paloma extends MensajeroAbstracto{

    int comida;
    int descanso;
    public Paloma() {
        super("Grru Rru Gu (Me agarran a mi patita un papelito) <<");
    }

    @Override
    public boolean condicion() {
        if(comida < 1){
            throw new MensajeroOffException("Paloma hambrienta");
        }
        if(descanso < 1){
            throw new MensajeroOffException("Paloma cansada");
        }
        return true;
    }

    @Override
    public void consumo() {
        comida -= 1;
        descanso -= 1;
    }
}
