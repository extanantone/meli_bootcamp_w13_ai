package com.bootcamp.socialmeliSprint1.exception.userException;

public class NotFoundUsuarioException extends RuntimeException{
    public NotFoundUsuarioException(Integer id) {
        super( "El usuario con id: " + id + ", no existe o posee un rol inválido.");
    }
}