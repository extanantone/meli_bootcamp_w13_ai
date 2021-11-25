package com.SocialMeli.SocialMeli.exception;

import com.SocialMeli.SocialMeli.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserException extends RuntimeException{

    private final ErrorDTO errorDTO;
    private final HttpStatus status;

    public UserException(String message, HttpStatus status){
        this.errorDTO = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}
