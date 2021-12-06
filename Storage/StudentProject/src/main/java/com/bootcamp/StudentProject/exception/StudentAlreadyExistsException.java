package com.bootcamp.StudentProject.exception;

public class StudentAlreadyExistsException extends RuntimeException {
    public StudentAlreadyExistsException(String dni) {
        super("El estudiante con el DNI " + dni + " ya se encuestra registrado en el sistema.");
    }
}