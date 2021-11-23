package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ErrorDTO implements Serializable {
    String message;

    public ErrorDTO(String inMessage) {
        this.message = inMessage;
    }
}
