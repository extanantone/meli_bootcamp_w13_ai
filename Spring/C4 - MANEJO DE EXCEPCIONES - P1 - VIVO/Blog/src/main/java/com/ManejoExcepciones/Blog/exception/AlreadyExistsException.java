package com.ManejoExcepciones.Blog.exception;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException() {}

    public AlreadyExistsException (String mensaje) { super(mensaje); }
}
