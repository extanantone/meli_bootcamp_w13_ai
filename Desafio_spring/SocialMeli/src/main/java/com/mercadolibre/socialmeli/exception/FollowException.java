package com.mercadolibre.socialmeli.exception;

public class FollowException extends Exception{
    public FollowException(){super("Un usuario no puede seguirse a si mismo");}
}
