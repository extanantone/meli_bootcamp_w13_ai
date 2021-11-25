package com.bootcamp.socialmeli.exception;

public class NotPostProductException extends NotPossibleOperationException{
    public NotPostProductException() {
        super("Los campos se ingresaron incorrectamente");
    }
}
