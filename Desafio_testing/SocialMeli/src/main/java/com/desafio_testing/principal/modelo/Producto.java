package com.desafio_testing.principal.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto{
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
