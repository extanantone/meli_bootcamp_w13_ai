package com.SocialMeli.Sprint1SocialMeli.Exception;

public class NotFollowException extends RuntimeException {
    public NotFollowException(Integer id) {
        super( "ERROR!!! - EL COMPRADOR NO SIGUE A VENDEDOR: " + id );
    }
}