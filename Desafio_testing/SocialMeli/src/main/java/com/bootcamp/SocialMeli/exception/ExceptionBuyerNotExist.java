package com.bootcamp.SocialMeli.exception;

public class ExceptionBuyerNotExist extends GenericException {

    public ExceptionBuyerNotExist(String msg){
        super("EL usuario  ingresado: "+msg+" como Comprador no existe: ");
    }

}
