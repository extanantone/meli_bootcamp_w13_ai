package com.bootcamp.Mensajero.exception;

public class NotFoundMensajeroException extends Exception{
    public NotFoundMensajeroException(Long id) {
        super( "No encontramos Mensajero: " + id );
    }
}
