package com.example.socialmeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDTO {
    private String mensaje;
    private int statusCode;
}
