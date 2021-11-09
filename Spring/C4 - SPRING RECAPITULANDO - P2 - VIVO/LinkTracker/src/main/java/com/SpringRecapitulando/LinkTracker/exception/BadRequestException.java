package com.SpringRecapitulando.LinkTracker.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(){}

    public BadRequestException(String mensaje){ super(mensaje); }
}
