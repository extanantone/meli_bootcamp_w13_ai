package com.socialmeli.demo.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ValidacionDTO {
    private String mensaje;
    private Integer statusCode;
    private HashMap<String, List<String>> errors;

    public ValidacionDTO(String mensaje, Integer statusCode) {
        this.mensaje = mensaje;
        this.statusCode = statusCode;
    }
}

