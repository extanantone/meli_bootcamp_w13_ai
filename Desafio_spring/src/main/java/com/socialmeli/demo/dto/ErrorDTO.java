package com.socialmeli.demo.dto;

import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorDTO {

    private final int status;
    private final String message;
    private List<FieldErrorDTO> fieldErrors = new ArrayList<>();

    public ErrorDTO(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public void addFieldErrors(String path, String message){
        FieldErrorDTO error = new FieldErrorDTO(path, message);
        fieldErrors.add(error);
    }
}
