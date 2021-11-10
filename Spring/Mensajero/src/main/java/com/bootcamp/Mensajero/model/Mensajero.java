package com.bootcamp.Mensajero.model;

public interface Mensajero {
    String emitirMensaje(String msg);
    String getPlantilla();
    boolean condicion();
    void consumo();
}
