package com.example.Hibernate.PrimerEjercicio.execption;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionStudens {

    public errorDTO get(NotFounExceptionStudent e){

        return new errorDTO(
                e.getMessage(),
                ""
        );
    }
}
