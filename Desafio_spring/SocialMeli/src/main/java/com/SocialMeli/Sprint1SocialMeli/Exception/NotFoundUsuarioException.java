package com.SocialMeli.Sprint1SocialMeli.Exception;

public class NotFoundUsuarioException extends RuntimeException {
    public NotFoundUsuarioException(Integer id) {
        super("No encontramos Usuario: " + id);
    }
}