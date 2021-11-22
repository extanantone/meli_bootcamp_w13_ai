package com.meli.obtenerdiploma.dto.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
@Setter
public class ErrorDTO
{
    private String custom_exception;
    private String message;
    private List<String> errors;

    public ErrorDTO(String custom_exception, String message, List<String> errors)
    {
        this.custom_exception = custom_exception;
        this.message = message;
        this.errors = errors;
    }

    public ErrorDTO(String custom_exception, String message)
    {
        this.custom_exception = custom_exception;
        this.message = message;
    }
}
