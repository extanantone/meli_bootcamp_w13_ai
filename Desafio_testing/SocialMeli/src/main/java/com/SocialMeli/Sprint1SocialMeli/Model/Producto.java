package com.SocialMeli.Sprint1SocialMeli.Model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    private int productId;
    private String productName, type, brand, color, notes;


}
