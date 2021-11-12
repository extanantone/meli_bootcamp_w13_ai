package com.bootcamp.socialmeli.DTO;

import com.bootcamp.socialmeli.model.Product;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DTOProduct {

    private int productId;
    private String productName;
    private String Type;
    private String brand;
    private String color;
    private String notes;

}
