package com.SocialMeli.Sprint1SocialMeli.Model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publicacion {

    private int postId, category;
    private double price;
    private LocalDate date;
    private Producto detail;
    private Boolean hasPromo;
    private double discount;






}


