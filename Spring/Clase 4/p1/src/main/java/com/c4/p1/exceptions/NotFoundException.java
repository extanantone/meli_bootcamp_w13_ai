package com.c4.p1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entrada de blog no encontrada")
public class NotFoundException extends Exception{
    public NotFoundException(String message){
        super(message);
    }
}
