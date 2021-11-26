package com.bootcamp.socialmeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
@Data
public class Product {

    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
