package com.bootcamp.demoHibernate.exceptions;

import com.bootcamp.demoHibernate.dto.ErrorDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class StudentException extends Exception {

    ErrorDTO error;
    HttpStatus status;

    public StudentException(String messageError, HttpStatus status) {
        this.error = new ErrorDTO();
        error.setName(this.getClass().getSimpleName());
        error.setDescription(messageError);
        this.status = status;
    }
}