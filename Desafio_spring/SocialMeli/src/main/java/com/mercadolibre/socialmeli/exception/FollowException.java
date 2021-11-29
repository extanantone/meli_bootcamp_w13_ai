package com.mercadolibre.socialmeli.exception;

public class FollowException extends RuntimeException{
    public FollowException(){super("Un usuario no puede seguirse a si mismo");}
    public FollowException(String msg){super(msg);}
}
