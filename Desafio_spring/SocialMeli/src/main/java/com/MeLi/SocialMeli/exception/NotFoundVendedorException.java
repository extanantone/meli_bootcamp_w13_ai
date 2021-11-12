package com.MeLi.SocialMeli.exception;

public class NotFoundVendedorException extends Exception{
    public NotFoundVendedorException(int id){
        super("No se ha encontrado al vendedor " + id);
    }
}
