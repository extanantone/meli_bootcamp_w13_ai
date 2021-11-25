package com.desafio_spring.principal.dto;

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
public class ProductoDTO {

    @Min(value=1, message = "El id debe ser mayor a cero")
    @NotNull(message = "La id no puede estar vacía.")
    private Integer productId;

    @Size(max=40, message = "La longitud no puede superar los 40 caracteres.")
    @NotNull(message = "El campo no puede estar vacío.")
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Pattern(regexp="[0-9A-Za-zñóíáéúÁÓÉÍÚ|\\s]*$", message = "El campo no puede poseer caracteres especiales.")
    private String productName;

    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @NotNull(message = "El campo no puede estar vacío.")
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Pattern(regexp="[0-9A-Za-zñóíáéúÁÓÉÍÚ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String type;

    @Size(max = 40,message = "La longitud no puede superar los 40 caracteres.")
    @NotNull(message = "El campo no puede estar vacío.")
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Pattern(regexp="[0-9A-Za-zñóíáéúÁÓÉÍÚ|\\s]*$", message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @Size(max = 15,message = "La longitud no puede superar los 15 caracteres.")
    @NotNull(message = "El campo no puede estar vacío.")
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Pattern(regexp="[0-9A-Za-zñóíáéúÁÓÉÍÚ|\\s]*$", message = "El campo no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80,message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp="[0-9A-Za-zñóíáéúÁÓÉÍÚ|\\s]*$", message = "El campo no puede poseer caracteres especiales.")
    private String notes;

}
