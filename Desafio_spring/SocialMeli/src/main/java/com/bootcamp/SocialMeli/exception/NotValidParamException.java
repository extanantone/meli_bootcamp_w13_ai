package com.bootcamp.SocialMeli.exception;

public class NotValidParamException extends RuntimeException{
    public NotValidParamException(String param) {
        super( "ERROR - PARAMETRO INVALIDO: " + param );
    }
}
