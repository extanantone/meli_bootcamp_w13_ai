package com.bootcamp.SocialMeli.exception;

public class NotFoundUserException extends Exception{

    public NotFoundUserException(int id) {

        super(" No se encuentra el usuario: " + id);

    }
}
