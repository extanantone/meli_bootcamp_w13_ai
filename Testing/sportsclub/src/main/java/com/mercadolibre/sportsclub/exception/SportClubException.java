package com.mercadolibre.sportsclub.exception;

import com.mercadolibre.sportsclub.model.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SportClubException extends RuntimeException {

    private final ErrorDTO error;
    private final HttpStatus httpStatus;

    public SportClubException(String message, HttpStatus httpStatus) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.httpStatus = httpStatus;
    }

}
