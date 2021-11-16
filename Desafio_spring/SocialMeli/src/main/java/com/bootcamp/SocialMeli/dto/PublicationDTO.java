package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.model.Publication;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicationDTO {
    private Integer user_id;
    private Integer id_post;
    private LocalDate date;
    private Integer id_product;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private Integer category;
    private Double price;
}
