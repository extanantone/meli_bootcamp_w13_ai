package com.sprint.SocialMeli.exceptions;

// Indica si el ID de un usuario no se ha encontrado
public class NotFoundException extends Exception{

    public NotFoundException(String message){
        super(message);
    }
}
