package com.lgoyenechea.socialmeli.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class Error {
    private HttpStatus status;
    private String message;
}
