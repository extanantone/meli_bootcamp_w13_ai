package com.example.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailDTO {
    @JsonProperty("product_id")
    private Long id;
    @JsonProperty("product_name")
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}