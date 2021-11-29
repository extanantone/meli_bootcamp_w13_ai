package com.SocialMeli.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class ProductDTO {
    @NotNull(message = "La id no puede estar vacia")
    @Positive(message = "El id debe ser mayor a cero")
    protected Integer product_id;

    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max = 20, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+", message = "El campo no puede contener caracteres especiales")
    protected String product_name;

    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max=15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+", message = "El campo no puede contener caracteres especiales")
    protected String type;

    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max=25, message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp = "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+", message = "El campo no puede contener caracteres especiales")
    protected String brand;

    @NotBlank(message = "El campo no puede estar vacio")
    @Size(max=15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+", message = "El campo no puede contener caracteres especiales")
    protected String color;

    @Size(max=80, message = "La longitud no puede superar los 80 caracteres")
    @Pattern(regexp = "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+", message = "El campo no puede contener caracteres especiales")
    protected String notes;
}
