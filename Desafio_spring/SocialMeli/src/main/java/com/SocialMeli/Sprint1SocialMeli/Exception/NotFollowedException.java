package com.SocialMeli.Sprint1SocialMeli.Exception;

public class NotFollowedException extends RuntimeException {
    public NotFollowedException(Integer id) {
        super( "ERROR!!! - EL COMPRADOR "+id+" NO SIGUE A NINGUN VENDEDOR: ");
    }
}