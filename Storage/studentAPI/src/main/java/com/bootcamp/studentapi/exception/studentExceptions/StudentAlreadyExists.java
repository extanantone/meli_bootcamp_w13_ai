package com.bootcamp.studentapi.exception.studentExceptions;

public class StudentAlreadyExists extends RuntimeException{

    public StudentAlreadyExists(String email) {
        super("El estudiante con email " + email + " ya existe.");
    }

}
