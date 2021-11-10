package com.bootcamp.Mensajero.exception;

public class NotFoundMensajero extends RuntimeException {
    public NotFoundMensajero(Long id) {
        super("No encontramos mensajero: "+id);
    }
}
