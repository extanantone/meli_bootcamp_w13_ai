package com.example.socialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ErrorValidacionDTO {
    private String mensaje;
    private int statusCode;
    private HashMap<String, List<String>> errors;

    public ErrorValidacionDTO(String mensaje, int statusCode) {
        this.mensaje = mensaje;
        this.statusCode = statusCode;
    }
}