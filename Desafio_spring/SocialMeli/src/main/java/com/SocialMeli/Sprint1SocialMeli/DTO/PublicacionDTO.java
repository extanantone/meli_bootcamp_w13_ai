package com.SocialMeli.Sprint1SocialMeli.DTO;

import com.SocialMeli.Sprint1SocialMeli.Model.Producto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicacionDTO {

    private int userId ;
    private int idPost,category;
    private double price;
    //private LocalDate date;
    private String date;
    private ProductoDTO detail;

}
