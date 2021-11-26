package com.SocialMeli.Sprint1SocialMeli.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publicacion {

    private int user_id,id_post,category;
    private double price;
    private LocalDate date;
    private Producto detail;



}


