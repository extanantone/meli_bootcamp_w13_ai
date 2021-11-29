package com.socialmeli.demo.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductoDTO {

    @NotNull(message = "Debe introducir un id de producto")
    @Positive(message="El valor minimo es 1")

    private Integer product_id;


    @NotNull()
    @Pattern(regexp = "([A-Z]|[0-9])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del producto no puede contener caracteres especiales")
    @Size(max=40, message = "El nombre del producto no tiene mas de 40 caracteres")
    private String product_name;

    @NotEmpty(message = "El nombre del prodcuto no puede ser vacio")
    @Size(max=15, message = "El tipo de producto no puede tener mas de 15 caracteres")
    @Pattern(regexp = "([A-Z]|[0-9])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El tipo no puede contener caracteres especiales")
    private String product_type;

    @NotEmpty(message = "El nombre del prodcuto no puede ser vacio")
    @Size(max=25, message = "La marca del producto no puedetener mas de 25 caracteres")
    @Pattern(regexp = "([A-Z]|[0-9])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "La marca del producto no puede contener caracteres especiales")
    private String brand;

    @NotEmpty(message = "El nombre del prodcuto no puede ser vacio")
    @Size(max=15, message = "El color del prodcuto no puede tener mas de 15 caracteres")
    @Pattern(regexp = "([A-Z]|[0-9])[\\\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El color del producto no puede contener caracteres especiales")
    private String color;

    @NotEmpty(message = "El nombre del prodcuto no puede ser vacio")
    @Size(max=80, message = "Las notas no pueden tener mas de 15 caracteres")
    private String notes;









}
