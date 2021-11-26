package com.mercadolibre.socialmeli.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){super("No se encontró el usuario");}
    public NotFoundException(String msg){super(msg);}
}
