package com.bootcamp.SpringJPA.exception;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(Long id) {
        super("No existe un estudiante con ID " + id);
    }
}
