package com.example.socialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductoDTO {
    @NotNull(message = "Debe introducir un id de producto")
    @Pattern(regexp = "^[0-9_ ]*$", message = "El id del producto debe ser un dato numérico")
    private int product_id;
    @NotNull(message = "Debe introducir el nombre del producto")
    @Size(max=40, message = "El nombre del producto no puede tener una longitur mayor a cuarenta")
    @Pattern(regexp = "^[a-zA-Z0-9_ ]*$", message = "El nombre del producto no puede contener caracteres especiales")
    private String product_name;
    @NotNull(message = "Debe introducir el tipo de producto")
    @Size(max=15, message = "El tipo no puede tener una longitud mayor a quince")
    @Pattern(regexp = "^[a-zA-Z0-9_ ]*$", message = "El tipo no puede contener caracteres especiales")
    private String type;
    @NotNull(message = "Debe introducir la marca del producto")
    @Size(max=25, message = "La marca no puede tener una longitud mayor a veinticinco")
    @Pattern(regexp = "^[a-zA-Z0-9_ ]*$", message = "La marca no puede contener caracteres especiales")
    private String brand;
    @NotNull(message = "Debe introducir el color del producto")
    @Size(max=15, message = "El color no puede tener una longitud mayor a quince")
    @Pattern(regexp = "^[a-zA-Z0-9_ ]*$", message = "El color no puede contener caracteres especiales")
    private String color;
    @NotNull(message = "Debe añadir notas")
    @Size(max=80, message = "Las notas no pueden tener una longitud mayor a quince")
    private String notes;
}
