package com.SocialMeli.SocialMeli.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Post {
    protected int sellerId;
    protected int id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    protected LocalDate date;

    protected int category;
    protected double price;
    protected Product detail;
    protected boolean has_promo;
    protected double discount;
}
