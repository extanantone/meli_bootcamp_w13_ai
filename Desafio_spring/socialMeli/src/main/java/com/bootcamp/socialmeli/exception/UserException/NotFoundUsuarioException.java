package com.bootcamp.socialmeli.exception.UserException;

public class NotFoundUsuarioException extends RuntimeException{
    public NotFoundUsuarioException(Integer id) {
        super( "El usuario con id: " + id + ", no existe o posee un rol inválido.");
    }
}