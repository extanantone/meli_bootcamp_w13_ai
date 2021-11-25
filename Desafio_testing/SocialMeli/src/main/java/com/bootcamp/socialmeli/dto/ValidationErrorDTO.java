package com.bootcamp.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationErrorDTO {
    Integer status;
    String message;
    private List<FieldErrorDTO> fieldErrors = new ArrayList<>();

    public ValidationErrorDTO(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public void addFieldError(String path, String message) {
        FieldErrorDTO error = new FieldErrorDTO(path, message);
        fieldErrors.add(error);
    }
}
