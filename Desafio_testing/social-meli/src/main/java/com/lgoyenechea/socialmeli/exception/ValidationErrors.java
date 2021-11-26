package com.lgoyenechea.socialmeli.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationErrors {
    private HttpStatus status;
    private List<ValidationError> details;

    public ValidationErrors() {
        details = new ArrayList<>();
    }
}
