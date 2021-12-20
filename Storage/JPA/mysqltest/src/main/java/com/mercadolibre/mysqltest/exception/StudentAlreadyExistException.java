package com.mercadolibre.mysqltest.exception;

import com.mercadolibre.mysqltest.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class StudentAlreadyExistException extends StudentException{
    public StudentAlreadyExistException(Long id) {
        super("El estudiante ya existe con ID: " + id, HttpStatus.BAD_REQUEST);
    }
}
