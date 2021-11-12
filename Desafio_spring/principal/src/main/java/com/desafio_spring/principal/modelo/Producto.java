package com.desafio_spring.principal.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto implements Comparable<String>{
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    @Override
    public int compareTo(String o) {
        return this.productName.compareTo(o);
    }
}
