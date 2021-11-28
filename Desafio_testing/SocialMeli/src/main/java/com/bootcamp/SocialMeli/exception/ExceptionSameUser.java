package com.bootcamp.SocialMeli.exception;



public class ExceptionSameUser extends GenericException {

    public ExceptionSameUser(String msg){
        super("El usuario "+msg+" no puede seguir a si mismo");
    }
}