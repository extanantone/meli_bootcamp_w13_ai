package com.MeLi.SocialMeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {


    @NotNull(message = "product_id no puede estar vacío")
    @Min(value = 1, message = "El product debe ser mayor a 0")
    private Integer product_id;

    @NotEmpty(message = "product_name no puede estar vacío")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "^([a-z]|[A-Z]|[ñ]|[Ñ])+$",message = "product_name no puede poseer caracteres especiales")
    private String product_name;

    @NotEmpty(message = "type no puede estar vacío")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "^([a-z]|[A-Z]|[ñ]|[Ñ])+$",message = "type no puede poseer caracteres especiales")
    private String type;

    @NotEmpty(message = "brand no puede estar vacío")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp = "^([a-z]|[A-Z]|[ñ]|[Ñ])+$",message = "brand no puede poseer caracteres especiales")
    private String brand;

    @NotEmpty(message = "color no puede estar vacío")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "^([a-z]|[A-Z]|[ñ]|[Ñ])+$",message = "color no puede poseer caracteres especiales")
    private String color;

    @Size(max = 80, message = "longitud no puede superar los 80 caracteres")
    @Pattern(regexp = "^([a-z]|[A-Z]|[ñ]|[Ñ])+$",message = "notes no puede poseer caracteres especiales")
    private String notes;

}