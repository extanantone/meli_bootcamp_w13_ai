package com.bootcamp.messengers.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefonoCelular implements Mensajero{
    private Integer id;
    private final String tipo = "Telefono Celular";
    private Integer porcentajeBateria;
    private Integer datosInternet; //en KB

    public TelefonoCelular(Integer id, Integer porcentajeBateria, Integer datosInternet) {
        this.id = id;
        this.porcentajeBateria = porcentajeBateria;
        this.datosInternet = datosInternet;
    }

    @Override
    public String emitirMensaje(String mensaje) {
        modificarRecursos();
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

    @Override
    public boolean puedoEnviarMsj() {
        if(this.porcentajeBateria > 0 && this.datosInternet > 0){
            return true;
        }
        return false;
    }
    private void modificarRecursos() {
        this.porcentajeBateria--;
        this.datosInternet--;
    }
}
