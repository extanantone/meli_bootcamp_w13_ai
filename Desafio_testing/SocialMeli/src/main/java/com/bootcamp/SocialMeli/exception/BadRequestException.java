package com.bootcamp.SocialMeli.exception;

public class BadRequestException extends GenericException {

    public BadRequestException(String msg){
        super("Parámetros ingresados incorrectamente "+msg);
    }
}
