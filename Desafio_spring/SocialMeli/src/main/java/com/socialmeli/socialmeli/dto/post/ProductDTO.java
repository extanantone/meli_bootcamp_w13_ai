package com.socialmeli.socialmeli.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    int product_id;
    String product_name;
    String type;
    String brand;
    String color;
    String notes;
}
