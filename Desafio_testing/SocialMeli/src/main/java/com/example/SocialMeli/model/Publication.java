package com.example.SocialMeli.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
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
