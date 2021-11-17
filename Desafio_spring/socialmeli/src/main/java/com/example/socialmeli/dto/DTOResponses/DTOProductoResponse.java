package com.example.socialmeli.dto.DTOResponses;

import com.example.socialmeli.Models.DetalleProduct;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOProductoResponse {
    Integer id_post;
    String date;
    DetalleProduct detail;
    Integer category;
    double price;
    Boolean has_promo;
    double discount;

    public DTOProductoResponse(Integer id_post, String date, DetalleProduct detail, Integer category, double price) {
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}
