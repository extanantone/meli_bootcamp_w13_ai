package com.bootcamp.messengers.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundException extends RuntimeException{
    public NotFoundException(String mensaje){
        super(mensaje);
    }
}
