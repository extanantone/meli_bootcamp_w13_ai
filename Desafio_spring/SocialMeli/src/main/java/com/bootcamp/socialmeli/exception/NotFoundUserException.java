package com.bootcamp.socialmeli.exception;

public class NotFoundUserException extends NotPossibleOperationException{
    public NotFoundUserException(int id) {
        super("No se encuentra el usuario " + id);
    }
}
