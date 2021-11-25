package com.socialMeli.SocialMeli.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class ProductDetails {
    @NotNull(message = "no se acepta product_id null")
    @Positive(message = "el product_id debe ser mayor a 0")
    private Integer product_id;

    @NotEmpty(message = "no se acepta un product_name vacio")
    @Size(max = 40, message = "la longitud maxima del product_name debe ser de 40 caracteres")
    @Pattern(regexp="[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El product_name no debe tener caracteres especiales.")
    private String product_name;

    @NotEmpty(message = "no se acepta un type vacio")
    @Size(max = 15, message = "la longitud maxima del type debe ser de 15 caracteres")
    @Pattern(regexp="[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El type no debe tener caracteres especiales.")
    private String type;

    @NotEmpty(message = "no se acepta una brand vacia")
    @Size(max = 25, message = "la longitud maxima de la brand debe ser de 25 caracteres")
    @Pattern(regexp="[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "La brand no debe tener caracteres especiales.")
    private String brand;

    @NotEmpty(message = "no se acepta un color vacio")
    @Size(max = 15, message = "la longitud maxima del color debe ser de 15 caracteres")
    @Pattern(regexp="[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El color no debe tener caracteres especiales.")
    private String color;

    @Size(max = 80, message = "la longitud maxima de las notes debe ser de 80 caracteres")
    @Pattern(regexp="[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "Las notes no deben tener caracteres especiales.")
    private String notes;

    public ProductDetails(Integer product_id, String product_name, String type, String brand, String color, String notes) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

}
