package com.bootcamp.socialmeli.exception;

public class NotFoundOrderParamException extends NotPossibleOperationException{
    public NotFoundOrderParamException(String param){
        super("El parametro de orden: '" + param + "' no existe");
    }
}
