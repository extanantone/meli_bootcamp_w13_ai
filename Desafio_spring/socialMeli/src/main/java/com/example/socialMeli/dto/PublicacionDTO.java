package com.example.socialMeli.dto;

import com.example.socialMeli.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicacionDTO {
    private int user_id;
    private int id_post;
    private String date;
    private ProductoDTO detail;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;


}
