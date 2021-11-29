package com.example.SocialMeli.exceptions.handler;

import com.example.SocialMeli.dto.error.ErrorDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class SocialMeliException extends RuntimeException{

    ErrorDto error;
    HttpStatus status;

    public SocialMeliException(String message, HttpStatus stats) {
        //super(message);
        this.error = new ErrorDto();
        error.setName(this.getClass().getSimpleName());
        error.setDescription(message);
        this.status = stats;
    }
}
