package com.example.socialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductoDTO {
    @NotNull(message = "Debe introducir un id de producto")
    private int product_id;
    @NotNull(message = "Debe introducir el nombre del producto")
    private String product_name;
    @NotNull(message = "Debe introducir el tipo de producto")
    private String type;
    @NotNull(message = "Debe introducir la marca del producto")
    private String brand;
    @NotNull(message = "Debe introducir el color del producto")
    private String color;
    @NotNull(message = "Debe añadir notas")
    private String notes;
}
