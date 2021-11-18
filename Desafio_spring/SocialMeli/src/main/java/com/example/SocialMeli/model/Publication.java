package com.example.SocialMeli.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Publication {

    private int userId;
    private int idPost;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;

    //atributos para publicación con descuento
    private boolean hasPromo;
    private double discount;

}
