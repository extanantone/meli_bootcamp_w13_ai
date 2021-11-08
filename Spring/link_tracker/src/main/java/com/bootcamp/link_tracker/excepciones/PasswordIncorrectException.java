package com.bootcamp.link_tracker.excepciones;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PasswordIncorrectException extends RuntimeException{

    public PasswordIncorrectException(String mensaje){
        super(mensaje);
    }

}
