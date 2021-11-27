package com.socialmeli.socialmeli.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @Min(value=0, message = "El id de usuario debe ser mayor a cero")
    int product_id;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[a-z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del producto no puede poseer caracteres especiales.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    String product_name;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[a-z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El tipo no puede poseer caracteres especiales.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    String type;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[a-z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "La marca no puede poseer caracteres especiales.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    String brand;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[a-z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El color no puede poseer caracteres especiales.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    String color;
    @Pattern(regexp="([A-Z]|[a-z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "las notas no puede poseer caracteres especiales.")
    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    String notes;
}
