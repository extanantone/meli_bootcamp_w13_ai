package com.lgoyenechea.socialmeli.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
