package com.mercadolibre.socialmeli.exception;

public class NotFoundException extends Exception{
    public NotFoundException(){super("No se encontró el usuario");}
    public NotFoundException(String msg){super(msg);}
}
