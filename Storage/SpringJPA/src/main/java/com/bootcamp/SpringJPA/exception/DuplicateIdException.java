package com.bootcamp.SpringJPA.exception;

public class DuplicateIdException extends RuntimeException{

    public DuplicateIdException(Long id) {
        super("Ya existe un estudiante con ID " + id);
    }
}
