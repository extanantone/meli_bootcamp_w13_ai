package com.MeLi.SocialMeli.model;

import com.MeLi.SocialMeli.DTO.PublicacionDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publicacion {

    private int user_id;
    private int id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Producto details;
    private int category;
    private int price;
}
