package com.bootcamp.SocialMeli.exception;

/**
 * Excepcion lanzada cuando se quieren hacer operaciones sobre un usuario que no existe.
 */
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String mensaje){
        super(mensaje);
    }
}
