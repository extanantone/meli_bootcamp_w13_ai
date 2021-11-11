package com.bootcamp.Mensajero.exception;

public class MensajeroNotFoundException extends RuntimeException {
    public MensajeroNotFoundException(Long idMensajero) {
        super("Mensajero no encontrado, id: " + idMensajero);
    }
}
