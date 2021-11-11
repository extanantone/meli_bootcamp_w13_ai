package com.bootcamp.Mensajero.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Long id){
        super("No mensajero"+id);
    }
}
