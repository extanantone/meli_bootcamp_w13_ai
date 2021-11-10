package com.Bootcamp.C4P1EJ1.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DuplicateException extends RuntimeException {
    private Integer id;
    private String mensajeError;

    public DuplicateException(Integer id, String mensajeError) {
        this.id = id;
        this.mensajeError = mensajeError;
    }
}
