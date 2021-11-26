package com.bootcamp.socialmeli.exception;

public class NotFoundUserException extends NotPossibleOperationException{
    public NotFoundUserException() {
        super("El usuario no existe");
    }

    public NotFoundUserException(int id) {
        super("No se encuentra el usuario " + id);
    }
}
