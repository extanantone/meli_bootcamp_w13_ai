package com.bootcamp.SocialMeli.exception;

public class ExceptionAlreadyFollows extends GenericException{

    public ExceptionAlreadyFollows(String msg){
        super("El usuario: "+msg+" ya sigue el vendedor ingresado");
    }
}
