package com.bootcamp.demoHibernate.exceptions;

import org.springframework.http.HttpStatus;

public class StudentExistException extends StudentException {
    public StudentExistException(String dni) {
        super("El usuario con id " + dni + " ya se encuentra registrado en el sistema", HttpStatus.BAD_REQUEST);
    }
}
