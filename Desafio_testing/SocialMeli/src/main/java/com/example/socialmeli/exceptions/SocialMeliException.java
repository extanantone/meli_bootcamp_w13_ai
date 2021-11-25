package com.example.socialmeli.exceptions;

import com.example.socialmeli.dto.ErrorDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class SocialMeliException extends Exception{

    ErrorDTO error;
    HttpStatus status;

    public SocialMeliException(String messageError, HttpStatus status){

        this.error = new ErrorDTO();
        error.setName(this.getClass().getSimpleName());
        error.setDescription(messageError);
        this.status = status;

    }

}
