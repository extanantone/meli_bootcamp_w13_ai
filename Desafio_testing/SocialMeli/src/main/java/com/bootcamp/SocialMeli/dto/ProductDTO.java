package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductDTO {

    int product_id;
    String product_name;
    String type;
    String brand;
    String color;
    String notes;
}
