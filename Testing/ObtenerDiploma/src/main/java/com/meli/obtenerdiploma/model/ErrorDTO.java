package com.meli.obtenerdiploma.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ErrorDTO {

    String message;
    String code;
}
