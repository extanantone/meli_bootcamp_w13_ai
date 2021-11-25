package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductDTO {

    private long productId;

    @Size(max = 40, message = "Max size 40")
    private String productName;

    @Size(max = 15, message = "Max size 15")
    private String type;

    @Size(max = 25, message = "Max size 25")
    private String brand;

    @Size(max = 15, message = "Max size 15")
    private String color;

    @Size(max = 80, message = "Max size 80")
    private String notes;
}
