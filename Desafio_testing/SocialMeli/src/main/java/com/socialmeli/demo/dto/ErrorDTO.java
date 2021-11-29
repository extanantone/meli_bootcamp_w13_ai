package com.socialmeli.demo.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ErrorDTO {
    private String mensaje;
    private Integer statusCode;
}
