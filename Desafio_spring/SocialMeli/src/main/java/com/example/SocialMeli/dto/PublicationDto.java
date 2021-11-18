package com.example.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
//@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")

public class PublicationDto {

    private int userId;
    private int idPost;
    private String date;
    private ProductDto detail;
    private int category;
    private double price;

    //atributos para publicación con descuento
    private boolean hasPromo;
    private double discount;
}
