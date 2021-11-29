package com.example.SocialMeli.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail {
    private Long id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
