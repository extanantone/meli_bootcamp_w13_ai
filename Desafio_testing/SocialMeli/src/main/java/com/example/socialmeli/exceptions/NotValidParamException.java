package com.example.socialmeli.exceptions;
import org.springframework.http.HttpStatus;

public class NotValidParamException extends SocialMeliException{

    public NotValidParamException(String param) {
            super( "PARAMETRO NO VALIDO: " + param, HttpStatus.BAD_REQUEST );
        }
}
