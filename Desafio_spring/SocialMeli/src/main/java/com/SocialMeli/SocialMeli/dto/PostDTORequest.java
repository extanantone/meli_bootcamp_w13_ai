package com.SocialMeli.SocialMeli.dto;

import com.SocialMeli.SocialMeli.entity.Product;
import com.SocialMeli.SocialMeli.entity.Seller;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class PostDTORequest {
    protected int user_id;
    protected int id_post;

    @JsonFormat(pattern = "dd-MM-yyyy")
    protected LocalDate date;

    protected ProductDTO detail;

    protected int category;
    protected double price;

}
