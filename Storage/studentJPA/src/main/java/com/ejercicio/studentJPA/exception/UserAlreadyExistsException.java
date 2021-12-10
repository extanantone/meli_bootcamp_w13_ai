package com.ejercicio.studentJPA.exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(){
        super(String.format("El usuario ya existe"));
    }
}
