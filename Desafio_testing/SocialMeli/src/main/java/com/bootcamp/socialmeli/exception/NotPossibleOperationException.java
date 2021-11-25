package com.bootcamp.socialmeli.exception;

public class NotPossibleOperationException extends Exception{
    public NotPossibleOperationException(){
        super("La operacion no se puede realizar");
    }
    public NotPossibleOperationException(String reason){
        super("La operacion no se puede realizar: " + reason);
    }
}
