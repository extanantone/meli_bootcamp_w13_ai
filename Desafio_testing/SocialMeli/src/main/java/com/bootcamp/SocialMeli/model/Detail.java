package com.bootcamp.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Detail {

    private int productId;
    private String producName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
