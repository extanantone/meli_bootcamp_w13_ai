package com.bootcamp.SocialMeli.exception;

/**
 * Excepcion lanzada cuando un usuario quiere seguir a otro usuario que ya seguía.
 */
public class AlreadyFollowException extends RuntimeException{
    public AlreadyFollowException(String mensaje){
        super(mensaje);
    }
}
