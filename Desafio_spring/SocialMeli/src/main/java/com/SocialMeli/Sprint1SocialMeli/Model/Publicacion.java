package com.SocialMeli.Sprint1SocialMeli.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publicacion {

    private int postId,category;
    private double price;
    private LocalDate date;
    private Producto detail;


}


