package com.SocialMeli.Sprint1SocialMeli.Exception;

public class NotFoundCompradorException extends RuntimeException{
    public NotFoundCompradorException(Integer id) {
        super( "NO SE ENCONTRO COMPRADOR: " + id );
    }
}
