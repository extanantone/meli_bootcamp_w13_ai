package com.SocialMeli.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class PostListItemDTOResponse {
    protected int id_post;

    @JsonFormat(pattern = "dd-MM-yyyy")
    protected LocalDate date;

    protected ProductDTO detail;

    protected int category;
    protected double price;
}
