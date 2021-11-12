package com.bootcamp.socialmeli.entitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    private int product_id;
    private String product_name, type, brand, color, notes;


}
