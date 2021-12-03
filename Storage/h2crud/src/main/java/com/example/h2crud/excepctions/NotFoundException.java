package com.example.h2crud.excepctions;

import lombok.Data;

@Data
public class NotFoundException extends RuntimeException {
    private String message;

    public NotFoundException (String message){
        this.message = message;
    }

}
