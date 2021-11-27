package com.example.SocialMeli.exception;

import com.example.SocialMeli.dto.ErrorDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class SocialMeliException extends RuntimeException{

    private final ErrorDTO error;
    private final HttpStatus status;

    public SocialMeliException(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}
