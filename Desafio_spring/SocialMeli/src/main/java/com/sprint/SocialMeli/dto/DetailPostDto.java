package com.sprint.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Getter
public class DetailPostDto {
    int product_id;
    String product_name;
    String type;
    String brand;
    String color;
    String notes;
}
