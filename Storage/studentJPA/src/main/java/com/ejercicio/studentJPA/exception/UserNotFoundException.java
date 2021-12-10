package com.ejercicio.studentJPA.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super(String.format("El usuario no existe"));
    }
}
