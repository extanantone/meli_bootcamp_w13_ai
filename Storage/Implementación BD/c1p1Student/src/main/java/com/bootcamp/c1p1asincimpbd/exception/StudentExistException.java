package com.bootcamp.c1p1asincimpbd.exception;

public class StudentExistException extends RuntimeException {
    public StudentExistException(String dni) {
        super("Estudiante con DNI " + dni + " ya registrado en el sistema.");
    }
}
