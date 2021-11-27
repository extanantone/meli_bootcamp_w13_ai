package com.example.SocialMeli.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
