package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductDTO {

    @NotNull(message = "el product_id no puede ser nulo,negativo o 0")
    @Positive(message = "el product_id no puede ser nulo,negativo o 0")
    private Integer productId;

    @NotBlank(message = "product_name no puede ser nulo o vacio")
    @Size(max = 40, message = "prodcut_name no puede tener mas de 40 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "product_name no puede tener caracteres especiales")
    private String productName;

    @NotBlank(message = "product_type no puede ser nulo o vacio")
    @Size(max = 15, message = "product_type no puede tener mas de 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "product_type no puede tener caracteres especiales")
    private String type;

    @NotBlank(message = "brand no puede ser nulo o vacio")
    @Size(max = 15, message = "brand no puede tener mas de 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "brand no puede tener caracteres especiales")
    private String brand;

    @NotBlank(message = "color no puede ser nulo o vacio")
    @Size(max = 15, message = "color no puede tener mas de 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "color no puede tener caracteres especiales")
    private String color;

    @Size(max = 80, message = "notes no puede tener mas de 80 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "notes no puede tener caracteres especiales")
    private String notes;
}
