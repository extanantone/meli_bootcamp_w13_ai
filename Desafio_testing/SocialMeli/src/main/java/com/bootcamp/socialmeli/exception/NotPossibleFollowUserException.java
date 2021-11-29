package com.bootcamp.socialmeli.exception;

public class NotPossibleFollowUserException extends NotPossibleOperationException{
    public NotPossibleFollowUserException(){
        super("El usuario no puede seguirse a si mismo");
    }
}
