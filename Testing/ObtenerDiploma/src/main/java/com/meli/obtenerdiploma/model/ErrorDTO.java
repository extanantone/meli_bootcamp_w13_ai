package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
    String message;

    public ErrorDTO(String inMessage) {
        this.message = inMessage;
    }
}