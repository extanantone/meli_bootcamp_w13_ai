package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DetailDTO {

    @Positive(message = "El id debe ser mayor a cero")
    @NotNull(message = "El campo no puede estar vacío.")
    private Integer productId;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(min =4 ,max = 40 ,message = "product name debe tener entre 4 y 40 caracteres")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El campo no puede poseer caracteres especiales.")
    private String product_name;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(min =4 ,max = 15 ,message = "product name debe tener entre 4 y 15 caracteres")
    private String type;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(min =4 ,max = 25 ,message = "product name debe tener entre 4 y 25 caracteres")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(min =4 ,max = 15 ,message = "product name debe tener entre 4 y 15 caracteres")
    private String color;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(min =4 ,max = 80 ,message = "product name debe tener entre 4 y 80 caracteres")
    private String notes;
}
