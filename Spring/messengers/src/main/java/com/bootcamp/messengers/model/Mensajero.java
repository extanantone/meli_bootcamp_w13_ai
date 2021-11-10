package com.bootcamp.messengers.model;

public interface Mensajero {
    String emitirMensaje(String mensaje);
    Integer getId();
    String getTipo();
}
