package com.example.socialmeli.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetalleProduct {
    Integer product_id;
    String product_name;
    String type;
    String brand;
    String color;
    String notes;
}
