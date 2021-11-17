package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.model.Producto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicationDTO implements Serializable {
    private int user_id;
    private int id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductoDTO detail;
    private int category;
    private double price;
}
