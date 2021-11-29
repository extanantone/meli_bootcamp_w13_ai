package com.example.socialmeli.Models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DetalleProduct {
    Integer product_id;
    String product_name;
    String type;
    String brand;
    String color;
    String notes;
}
