package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@Getter
public class BasicUserDTO {

    @NotNull(message = "La id no puede estar vacía.")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    private final Integer userId;

    @Size(max = 15, message = "El nombre no puede contener más de 15 letras.")
    private final String userName;
}
