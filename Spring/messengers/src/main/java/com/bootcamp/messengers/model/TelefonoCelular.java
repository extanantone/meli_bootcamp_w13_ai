package com.bootcamp.messengers.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefonoCelular implements Mensajero{
    private Integer id;
    private final String tipo = "Telefono Celular";

    public TelefonoCelular(Integer id) {
        this.id = id;
    }

    @Override
    public String emitirMensaje(String mensaje) {
        return String.format("Enviando por WhatsApp <<%s!>>", mensaje);
    }

    @Override
    public String getTipo(){
        return this.tipo;
    }

    @Override
    public String toString(){
        return String.format("Telefono Celular - ID: %s", this.id);
    }
}
