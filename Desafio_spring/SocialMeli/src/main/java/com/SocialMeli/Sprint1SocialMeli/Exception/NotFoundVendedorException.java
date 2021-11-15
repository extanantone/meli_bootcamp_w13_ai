package com.SocialMeli.Sprint1SocialMeli.Exception;

public class NotFoundVendedorException extends RuntimeException{
    public NotFoundVendedorException(Integer id) {
        super( "ERROR!!! - NO SE ENCONTRO VENDEDOR: " + id );
    }



}