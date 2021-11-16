package com.desafiospring.demo.exception;
//esto es una excepcion personalizada
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(int id) {
        super("No se encontro el usaurio " + id);

    }
}
