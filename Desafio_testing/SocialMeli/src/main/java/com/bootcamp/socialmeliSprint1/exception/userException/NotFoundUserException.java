package com.bootcamp.socialmeliSprint1.exception.userException;

public class NotFoundUserException extends RuntimeException{
    public NotFoundUserException(Integer id) {
        super( "El usuario con id: " + id + ", no existe o posee un rol inválido.");
    }
}