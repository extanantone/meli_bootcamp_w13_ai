package com.c4.p1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Ya existe una entrada de blog con ese id")

public class AlreadyExistsException extends Exception{
    public AlreadyExistsException(String message){
        super(message);
    }
}
