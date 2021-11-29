package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductDTO {
    @Valid
    @NotNull(message = "El ID no puede estar vacio")
    @Positive(message = "El ID tiene que ser mayor a 0")
    private Integer productId;
    @NotEmpty(message = "El campo productName no puede estar vacio")
    @Size(max= 40, message = "La longitud del campo productName no puede superar los 40 caracteres")
    @Pattern(regexp ="\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú|\\s)*$", message = "El campo no puede poseer caracteres especiales")
    private String productName;
    @NotEmpty(message = "El campo type no puede estar vacio")
    @Size(max = 15, message = "La longitud del campo type no puede superar los 15 caracteres")
    @Pattern(regexp = "\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú|\\s)*$", message ="El campo no puede poseer caracteres especiales")
    private String type;
    @NotEmpty(message = "El campo brand no puede estar vacio")
    @Size(max = 25, message = "La longitud del campo brand no puede superar los 25 caracteres")
    @Pattern(regexp = "\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú|\\s)*$", message = "El campo no puede poseer caractreres especiales")
    private String brand;
    @NotEmpty(message = "El campo color no puede estar vacio")
    @Size(max = 15, message = "La longitud del campo color no puede superar los 15 caracteres")
    @Pattern(regexp = "\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú|\\s)*$", message = "El campo no puede poseer caracteres especiales")
    private String color;
    @Size(max = 80, message = "La longitud del campo notes no puede superar los 80 caracteres")
    @Pattern(regexp = "\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú|\\s)*$", message = "El campo no puede poseer caracteres especiales")
    private String notes;
}
