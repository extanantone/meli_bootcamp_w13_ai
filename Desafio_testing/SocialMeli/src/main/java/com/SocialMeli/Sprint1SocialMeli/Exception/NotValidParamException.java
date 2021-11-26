package com.SocialMeli.Sprint1SocialMeli.Exception;

public class NotValidParamException extends RuntimeException{
    public NotValidParamException(String param) {
        super( "PARAMETRO NO VALIDO: " + param );
    }

}

