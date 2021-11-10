package com.bootcamp.messengers.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class PalomaMensajera implements Mensajero{
    private Integer id;
    private final String tipo = "Paloma mensajera";
    private Integer cantComida; //en gramos
    private Instant proximoViaje; //timestamp del proximo viaje

    public PalomaMensajera(Integer id, Integer cantComida, Instant proximoViaje) {
        this.id = id;
        this.cantComida = cantComida;
        this.proximoViaje = proximoViaje;
    }

    @Override
    public String emitirMensaje(String mensaje) {
        modificarRecursos();
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

    @Override
    public boolean puedoEnviarMsj() {
        if((this.cantComida > 0) && (Instant.now().compareTo(this.proximoViaje) > 0)){
            return true;
        }
        return false;
    }

    private void modificarRecursos() {
        this.cantComida--;
        this.proximoViaje = Instant.now().plusSeconds(10); //el proximo es 1 hs despues (10 seg en el ejemplo)
    }
}
