package com.bootcamp.SocialMeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Detail {
    Integer productId;
    String productName;
    String type;
    String brand;
    String color;
    String notes;

    public Detail(Integer productId, String productName, String type, String brand, String color, String notes) {
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

}