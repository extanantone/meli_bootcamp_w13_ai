package com.SocialMeli.Sprint1SocialMeli.Exception;

public class NotValidParamException extends RuntimeException{
    public NotValidParamException(String param) {
        super( "ERROR!!! - PARAMETRO NO VALIDO: " + param );
    }

}

