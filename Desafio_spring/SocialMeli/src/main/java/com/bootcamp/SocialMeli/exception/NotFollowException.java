package com.bootcamp.SocialMeli.exception;

/**
 * Excepcion lanzada cuando un usuario quiere dejar de seguir a un usuario que no sigue.
 */
public class NotFollowException extends RuntimeException{
    public NotFollowException(String mensaje) {
        super(mensaje);
    }
}
