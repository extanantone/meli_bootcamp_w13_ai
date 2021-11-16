package com.bootcamp.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostProduct {
    private Long id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
