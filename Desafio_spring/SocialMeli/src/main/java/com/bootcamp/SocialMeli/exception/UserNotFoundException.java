package com.bootcamp.SocialMeli.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(int userId) {
        super("El usuario " + userId + " no se encuentra registrado en el sistema.");
    }
}