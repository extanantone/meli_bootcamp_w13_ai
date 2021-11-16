package com.bootcamp.SocialMeli.dto;

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
    private int user_id;
    private int id_post;
    private String date;
    private ProductoDTO detail;
    private int category;
    private double price;
}
