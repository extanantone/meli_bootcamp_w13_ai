package com.sprint.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class DetailPostDto {
    int product_id;
    String product_name;
    String type;
    String brand;
    String color;
    String notes;
}
