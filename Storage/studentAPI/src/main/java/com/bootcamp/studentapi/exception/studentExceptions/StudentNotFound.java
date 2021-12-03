package com.bootcamp.studentapi.exception.studentExceptions;

public class StudentNotFound extends RuntimeException{

    public StudentNotFound(String email) {
        super("El estudiante con email " + email + " no existe.");
    }
}
