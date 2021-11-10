package com.bootcamp.messengers.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Telegrafo implements Mensajero{
    private Integer id;
    private final String tipo = "Telegrafo";

    public Telegrafo(Integer id) {
        this.id = id;
    }

    @Override
    public String emitirMensaje(String mensaje) {
        return String.format("Pip piripipip pip pip <<%s!>>", mensaje);
    }

    @Override
    public String getTipo(){
        return this.tipo;
    }

    @Override
    public String toString(){
        return String.format("Telegrafo - ID: %s", this.id);
    }
}
