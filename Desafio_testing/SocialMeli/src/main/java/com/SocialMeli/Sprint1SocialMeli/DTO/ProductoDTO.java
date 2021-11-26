package com.SocialMeli.Sprint1SocialMeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {

    @NotNull(message = "La id no puede estar vacia")
    //@Min(value = 0, message = "El id debe ser mayor a 0")
    @Positive(message = "El id debe ser mayor a 0")
    private Integer product_id;
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$", message ="El campo no puede poseer caracteres especiales.")
    private String product_name;
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$", message ="El campo no puede poseer caracteres especiales.")
    private String type;
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$", message ="El campo no puede poseer caracteres especiales.")
    private String brand;
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$", message ="El campo no puede poseer caracteres especiales.")
    private String color;
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$", message ="El campo no puede poseer caracteres especiales.")
    private String notes;
}
