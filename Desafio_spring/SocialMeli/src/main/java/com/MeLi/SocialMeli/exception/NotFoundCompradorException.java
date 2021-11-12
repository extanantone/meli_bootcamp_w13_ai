package com.MeLi.SocialMeli.exception;

public class NotFoundCompradorException extends Exception{

    public NotFoundCompradorException(int id){
        super("No se ha encontrado al comprador " + id);
    }
}
