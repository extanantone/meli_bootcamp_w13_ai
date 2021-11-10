package com.bootcamp.Mensajero.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Celular extends MensajeroAbstracto{
    private int bateria;
    private int datos;
    public Celular(String tipo) {
        super("Enviando por WhatsApp <<", tipo);
    }
    public void bateria(){

    }
    public void datos(){

    }
}
