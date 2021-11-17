package com.bootcamp.SocialMeli.exception;

public class ExceptionSellerNotExist extends GenericException {

    public ExceptionSellerNotExist(String msg){
        super("EL usuario  ingresado: "+msg+" como vendedor no existe: ");
    }

}
