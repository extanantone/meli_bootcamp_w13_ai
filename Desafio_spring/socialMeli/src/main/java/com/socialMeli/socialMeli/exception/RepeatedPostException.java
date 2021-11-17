package com.socialMeli.socialMeli.exception;
public class RepeatedPostException extends RuntimeException{
    public RepeatedPostException(){
        super(String.format("No se puede publicar dos veces la misma publicacion"));
    }
}
