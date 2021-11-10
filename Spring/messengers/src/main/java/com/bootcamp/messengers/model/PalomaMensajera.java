package com.bootcamp.messengers.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PalomaMensajera implements Mensajero{
    private Integer id;
    private final String tipo = "Paloma mensajera";

    public PalomaMensajera(Integer id) {
        this.id = id;
    }

    @Override
    public String emitirMensaje(String mensaje) {
        return String.format("Grru Rru Gu (Me agarran a mi patita un papelito) <<%s!>>", mensaje);
    }

    @Override
    public String getTipo(){
        return this.tipo;
    }

    @Override
    public String toString(){
        return String.format("Paloma mensajera - ID: %s", this.id);
    }
}
