package com.bootcamp.SocialMeli.exception;

public class UserNotSellerException extends RuntimeException{
    public UserNotSellerException(String mensaje) {
        super(mensaje);
    }
}
