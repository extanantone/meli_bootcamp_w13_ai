package com.C4P1PG.ManejoExcepciones.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){

    }

    public NotFoundException(String message){
        super(message);
    }
}
