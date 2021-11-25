package com.bootcamp.SocialMeli.exception;

/**
 * Excepcion lanzada cuando un usuario quiere seguir o dejar de seguir a sí mismo (igual userID de usuario y vendedor)
 */
public class EqualsUserSellerException extends RuntimeException{
    public EqualsUserSellerException(String mensaje) {
        super(mensaje);
    }
}
