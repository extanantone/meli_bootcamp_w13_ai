package com.bootcamp.c1p1asincimpbd.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String dni) {
        super("No existe el usuario con DNI " + dni + ", por lo no es posible actualizarlo.");
    }
}
