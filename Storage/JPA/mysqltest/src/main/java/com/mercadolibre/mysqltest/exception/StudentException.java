package com.mercadolibre.mysqltest.exception;

import com.mercadolibre.mysqltest.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class StudentException extends RuntimeException{

    private final ErrorDTO errorDTO;
    private final HttpStatus httpStatus;

    public StudentException(String error, HttpStatus httpStatus) {
        this.errorDTO = new ErrorDTO(error, this.getClass().getSimpleName());
        this.httpStatus = httpStatus;
    }
}
