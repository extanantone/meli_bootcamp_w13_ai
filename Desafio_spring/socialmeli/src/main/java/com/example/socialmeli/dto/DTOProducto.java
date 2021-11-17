package com.example.socialmeli.dto;

import com.example.socialmeli.Models.DetalleProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@Setter
@Getter
public class DTOProducto {
    Integer id_post;
    String date;
    DetalleProduct detail;
    Integer category;
    double price;
}
