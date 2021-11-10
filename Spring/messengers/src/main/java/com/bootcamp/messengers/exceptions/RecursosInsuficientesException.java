package com.bootcamp.messengers.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RecursosInsuficientesException extends RuntimeException{
    public RecursosInsuficientesException(String mensaje){
        super(mensaje);
    }
}
