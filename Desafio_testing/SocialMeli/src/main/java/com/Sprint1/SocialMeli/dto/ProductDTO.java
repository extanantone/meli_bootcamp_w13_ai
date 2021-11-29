package com.Sprint1.SocialMeli.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ProductDTO {
    @Valid

    @NotNull(message = "La id PRODUCT_ID no puede estar vacía.")
    @Positive(message = "La id PRODUCT_ID debe ser mayor a cero.")
    private Integer product_id;

    @NotBlank(message = "El campo PRODUCT_NAME no puede estar vacío.")
    @Size(min = 1, max = 40, message = "La longitud de PRODUCT_NAME no puede superar los 40 caracteres.")
    @Pattern(regexp = "\\A[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$" , message
            = "El campo PRODUCT_NAME no puede poseer caracteres especiales.\n" )
    private String product_name;

    @NotBlank(message = "El campo TYPE no puede estar vacío.")
    @Size(min = 1, max = 15, message = "La longitud de TYPE no puede superar los 15 caracteres.")
    @Pattern(regexp = "\\A[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|]*$" , message
            = "El campo TYPE no puede poseer caracteres especiales.\n" )
    private String type;

    @NotBlank(message = "El campo BRAND no puede estar vacío.")
    @Size(min = 1, max = 25, message = "La longitud de BRAND no puede superar los 25 caracteres.")
    @Pattern(regexp = "\\A[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|]*$" , message
            = "El campo BRAND no puede poseer caracteres especiales.\n" )
    private String brand;

    @NotBlank(message = "El campo COLOR no puede estar vacío.")
    @Size(min = 1, max = 15, message = "La longitud no COLOR puede superar los 15 caracteres.")
    @Pattern(regexp = "\\A[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú|]*$" , message
            = "El campo COLOR no puede poseer caracteres especiales.\n" )
    private String color;

    @Size(min = 1, max = 80, message = "La longitud de NOTES no puede superar los 80 caracteres.")
    @Pattern(regexp = "\\A[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$" , message
            = "El campo NOTES no puede poseer caracteres especiales.\n" )
    private String notes;

    @Override
    public String toString() {
        return "{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
